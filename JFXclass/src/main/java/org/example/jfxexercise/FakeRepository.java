package org.example.jfxexercise;

import java.util.List;

public class FakeRepository implements ProductRepository{
    @Override
    public List<Product> findAll() {
        return List.of(
                new Product("SKU01", "Cerveja", 3, 8),
                new Product("SKU02", "Pinga", 10, 4)
        );
    }
}
