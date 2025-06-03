import java.math.BigDecimal;

    void main() {
        Product product = new Product("100000", "Notebook", BigDecimal.valueOf(3000.0), 5);
        Product product2 = new Product("100001", "Laptop", BigDecimal.valueOf(2000.0), 10);
        ProductDAO dao = new SqliteProductDAO();
        dao.save(toDTO(product));
        dao.findByCode("100000").map(this::fromDTO).ifPresentOrElse(System.out::println, () -> System.out.println("Not Found!"));
        product.setQuantity(2);
        dao.update(toDTO(product));
        dao.findByCode("100000").map(this::fromDTO).ifPresentOrElse(System.out::println, () -> System.out.println("Not Found!"));
        dao.save(toDTO(product2));
        dao.findAll().stream()
                .map(obj -> obj.orElse(null))
                .filter(Objects::nonNull)
                .map(this::fromDTO)
                .forEach(System.out::println);
        dao.delete("100000");
        dao.delete("100001");
    }
    private ProductDTO toDTO(Product prod){
        return new ProductDTO(prod.getCode(), prod.getName(), prod.getQuantity(), prod.getPrice().doubleValue());
    }
    private Product fromDTO(ProductDTO dto){
        return new Product(dto.code(), dto.name(), BigDecimal.valueOf(dto.price()), dto.quantity());
    }
