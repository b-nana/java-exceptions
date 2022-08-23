package ru.netology.javaqa.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlreadyExistsExceptionTest {

    Product item1 = new Product(1, "Не книга", 100);
    Product item2 = new Product(2, "Не смартфон", 1000);


    @Test

    public void shouldSaveProduct() {

        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);

        Product[] expected = {item1, item2};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void shouldThrowAlreadyExistsExceptionIfIdExists() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);

        Product item3 = new Book(2, "Поющие в терновнике", 600, "Колин Маккалоу");

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(item3);
        });
    }
}
