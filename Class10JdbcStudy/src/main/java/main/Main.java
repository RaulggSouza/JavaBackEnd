package main;

import model.Inventory;
import model.Product;
import persistency.InventoryDAO;
import persistency.ProductDAO;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
//        dao.insert(new Product(1, "Bolsa", BigDecimal.valueOf(50.0)));
//        dao.insert(new Product(1, "Livro", BigDecimal.valueOf(100.0)));
//        Optional<Product> product = dao.findById(1);
//        product.ifPresentOrElse(System.out::println, () -> System.out.println("Not found!"));
//        dao.findAll().forEach(System.out::println);
//        for (int i = 2; i < 13; i++){
//            dao.delete(i);
//        }
//        dao.findAll().forEach(System.out::println);
//        dao.updatePrice(1, BigDecimal.valueOf(4000.0));
        InventoryDAO iDao = new InventoryDAO();
        try {
            iDao.transfer(13, 1, 1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
