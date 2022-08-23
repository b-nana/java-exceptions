package ru.netology.javaqa.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class ProductRepositoryTest {

    @Test

    public void shouldSaveProduct() {

        Product item1 = new Product(1, "Не книга", 100);
        Product item2 = new Product(2, "Не смартфон", 1000);

        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);

        Product[] expected = {item1, item2};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void shouldSaveBook() {

        Product book1 = new Book(1, "Грозовой перевал", 450, "Эмили Бронте");
        Product book2 = new Book(2, "Поющие в терновнике", 600, "Колин Маккалоу");

        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);

        Product[] expected = {book1, book2};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void shouldSaveSmartphone() {

        Product smartphone1 = new Smartphone(1, "IPhone 13 Pro", 100_000, "Apple");
        Product smartphone2 = new Smartphone(2, "Samsung Galaxy S22", 90_000, "Samsung");

        ProductRepository repo = new ProductRepository();
        repo.save(smartphone1);
        repo.save(smartphone2);

        Product[] expected = {smartphone1, smartphone2};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void shouldGetAllProducts() {

        Product item1 = new Product(1, "Не книга", 100);
        Product item2 = new Smartphone(2, "Samsung Galaxy S22", 90_000, "Samsung");
        Product item3 = new Book(3, "Поющие в терновнике", 600, "Колин Маккалоу");

        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        Product[] expected = {item1, item2, item3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }

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


}
