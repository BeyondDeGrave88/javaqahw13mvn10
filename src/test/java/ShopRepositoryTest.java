import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Product1", 100);
        Product product2 = new Product(2, "Product2", 200);
        Product product3 = new Product(3, "Product3", 300);

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
        Product product1 = new Product(1, "Product1", 100);
        repo.add(product1);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(5);
        });
    }

    @Test
    public void add() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void removeById() {
    }
}
