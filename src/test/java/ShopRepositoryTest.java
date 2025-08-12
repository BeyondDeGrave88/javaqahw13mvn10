import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Хлеб", 50);
        Product product2 = new Product(2, "Молоко", 70);
        Product product3 = new Product(3, "Яйца", 90);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.removeById(2);

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowWhenRemovingNonExistentProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Хлеб", 50);
        repo.add(product1);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(5);
        });
    }

    @Test
    public void shouldAddNewProductSuccessfully() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Хлеб", 50);
        Product product2 = new Product(2, "Молоко", 70);

        repo.add(product1);
        repo.add(product2);

        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowWhenAddingProductWithExistingId() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Хлеб", 50);
        Product product2 = new Product(1, "Молоко", 70);

        repo.add(product1);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product2);
        });
    }
}