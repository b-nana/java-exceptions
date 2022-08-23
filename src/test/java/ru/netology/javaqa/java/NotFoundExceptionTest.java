package ru.netology.javaqa.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class NotFoundExceptionTest {
    @Test

    public void shouldRemoveById() {

        Product item1 = new Product(1, "Не книга", 100);
        Product item2 = new Smartphone(2, "Samsung Galaxy S22", 90_000, "Samsung");
        Product item3 = new Book(3, "Поющие в терновнике", 600, "Колин Маккалоу");

        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.removeById(item2.getId());

        Product[] expected = {item1, item3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void shouldThrowExceptionIfIdIsMissing() {

        Product item1 = new Product(1, "Не книга", 100);
        Product item2 = new Smartphone(2, "Samsung Galaxy S22", 90_000, "Samsung");
        Product item3 = new Book(3, "Поющие в терновнике", 600, "Колин Маккалоу");

        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);


        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(4);
        });

    }
}
