import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqliteProductDAO implements ProductDAO{

    @Override
    public void save(ProductDTO productDTO) {
        String sql = "INSERT INTO products VALUES(?, ?, ?, ?)";

        try (var stmt = ConnectionFactory.getPreparedStatement(sql)){
            stmt.setString(1, productDTO.code());
            stmt.setString(2, productDTO.name());
            stmt.setDouble(3, productDTO.price());
            stmt.setInt(4, productDTO.quantity());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<ProductDTO> findByCode(String s) {
        String sql = "SELECT * FROM products WHERE code = ?";

        try (var stmt = ConnectionFactory.getPreparedStatement(sql)){
            stmt.setString(1, s);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return Optional.of(new ProductDTO(
                        rs.getString("code"), rs.getString("name"),
                        rs.getInt("quantity"), rs.getDouble("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Optional<ProductDTO>> findAll() {
        List<Optional<ProductDTO>> list = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (var stmt = ConnectionFactory.getPreparedStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                list.add(Optional.of(new ProductDTO(rs.getString("code"),rs.getString("name"),
                        rs.getInt("quantity"), rs.getDouble("price"))));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public void update(ProductDTO productDTO) {
        String sql = "UPDATE products SET name = ?, quantity = ?, price = ? WHERE code = ?";
        try(var stmt = ConnectionFactory.getPreparedStatement(sql)){
            stmt.setString(1, productDTO.name());
            stmt.setInt(2, productDTO.quantity());
            stmt.setDouble(3, productDTO.price());
            stmt.setString(4, productDTO.code());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String s) {
        String sql = "DELETE FROM products WHERE code = ?";
        try (var stmt = ConnectionFactory.getPreparedStatement(sql)){
            stmt.setString(1, s);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
