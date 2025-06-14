package persistency;

import model.Product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAO {
    public void insert(Product p){
        String sql = "INSERT INTO Product (name, price) VALUES (?, ?)";
        try (var stmt = DatabaseUtils.createPreparedStatement(sql)){
            stmt.setString(1, p.getName());
            stmt.setBigDecimal(2, p.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Product> findById(int id){
        String sql = "SELECT * FROM product WHERE id = ?";
        try (var stmt = DatabaseUtils.createPreparedStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) return Optional.of(new Product(rs.getInt("id"), rs.getString("name"),
                            rs.getBigDecimal("price")
                    )
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    public List<Product> findAll(){
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try (var stmt = DatabaseUtils.createPreparedStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                products.add(new Product(rs.getInt("id"), rs.getString("name"),
                        rs.getBigDecimal("price")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public void updatePrice(int id, BigDecimal newPrice){
        String sql = "UPDATE product SET price = ? WHERE id = ?";
        try (var stmt = DatabaseUtils.createPreparedStatement(sql)){
            stmt.setBigDecimal(1, newPrice);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id){
        String sql = "DELETE FROM product WHERE id = ?";
        try(var stmt = DatabaseUtils.createPreparedStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
