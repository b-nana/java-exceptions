package ru.netology.javaqa.java;

public class ProductRepository {

    private Product[] items = new Product[0];

    public void save(Product item) {
        Product[] tmp = new Product[items.length + 1];

        Product result = findById(items, item.getId());
        if (result != null) {
            throw new AlreadyExistsException(
                    "Element with id:" + item.getId() + " already exists."
            );
        }

        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Product findById(Product items[], int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        Product[] tmp = new Product[items.length - 1];
        Product result = findById(items, id);
        if (result == null) {
            throw new NotFoundException(
                    "Element with id:" + id + " not found"
            );
        }
        int copyToIndex = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    public Product[] getProducts() {
        return items;
    }

    public Product[] findAll() {
        Product[] result = new Product[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }


}
