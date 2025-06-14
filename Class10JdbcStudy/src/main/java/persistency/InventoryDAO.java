package persistency;

import java.sql.SQLException;

public class InventoryDAO {
    public void transfer(int fromProductId, int toProductId, int amount) throws SQLException {
        String sqlFrom = "UPDATE inventory SET quantity = quantity-? WHERE productId = ? AND quantity >= ?";
        String sqlTo = "UPDATE inventory SET quantity = quantity+? WHERE productId = ?";
        try (var stmtFrom = DatabaseUtils.createPreparedStatement(sqlFrom);
            var stmtTo = DatabaseUtils.createPreparedStatement(sqlTo)){
            DatabaseUtils.disableAutoCommit();
            stmtFrom.setInt(1, amount);
            stmtFrom.setInt(2, fromProductId);
            stmtFrom.setInt(3, amount);
            int rows = stmtFrom.executeUpdate();
            if (rows == 0){
                throw new IllegalStateException("Insufficient quantity");
            }
            stmtTo.setInt(11, amount);
            stmtTo.setInt(2, toProductId);
            stmtTo.executeUpdate();
            DatabaseUtils.commitChanges();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println("Undoing changes");
            DatabaseUtils.rollback();
        } finally {
            DatabaseUtils.ableAutoCommit();
        }
    }
}
