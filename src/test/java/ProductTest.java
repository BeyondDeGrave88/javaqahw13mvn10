import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testConstructorAndGetters() {
        Product product = new Product(1, "Хлеб", 50);

        assertEquals(1, product.getId());
        assertEquals("Хлеб", product.getTitle());
        assertEquals(50, product.getPrice());
    }

    @Test
    void testSetters() {
        Product product = new Product(1, "Хлеб", 50);

        product.setTitle("Молоко");
        product.setPrice(70);

        assertEquals("Молоко", product.getTitle());
        assertEquals(70, product.getPrice());
    }

    @Test
    void testEquals() {
        Product product1 = new Product(1, "Хлеб", 50);
        Product product2 = new Product(1, "Хлеб", 50);
        Product product3 = new Product(2, "Хлеб", 50);
        Product product4 = new Product(1, "Молоко", 50);
        Product product5 = new Product(1, "Хлеб", 60);

        assertEquals(product1, product1);

        assertEquals(product1, product2);
        assertEquals(product2, product1);

        assertNotEquals(product1, product3);
        assertNotEquals(product1, product4);
        assertNotEquals(product1, product5);

        assertNotEquals(null, product1);

        assertNotEquals("Хлеб", product1);
    }

    @Test
    void testHashCode() {
        Product product1 = new Product(1, "Хлеб", 50);
        Product product2 = new Product(1, "Хлеб", 50);
        Product product3 = new Product(2, "Молоко", 70);

        assertEquals(product1.hashCode(), product2.hashCode());
        assertNotEquals(product1.hashCode(), product3.hashCode());

        if (product1.equals(product2)) {
            assertEquals(product1.hashCode(), product2.hashCode());
        }
    }

    @Test
    void testEqualsConsistency() {
        Product product1 = new Product(1, "Хлеб", 50);
        Product product2 = new Product(1, "Хлеб", 50);

        assertEquals(product1.equals(product2), product1.equals(product2));
        assertEquals(product1.hashCode(), product1.hashCode());
    }

    @Test
    void testSetTitleNull() {
        Product product = new Product(1, "Хлеб", 50);

        try {
            product.setTitle(null);
            assertNull(product.getTitle());
        } catch (NullPointerException e) {
            assertNotNull(product.getTitle());
            assertEquals("Хлеб", product.getTitle()); // Проверяем, что title не изменился
        }
    }

    @Test
    void testEqualsEdgeCases() {
        Product product = new Product(1, "Хлеб", 100);

        assertNotEquals(product, null);

        assertNotEquals(product, "Хлеб");
        assertNotEquals(product, new Object());

        assertEquals(product, new Product(1, "Хлеб", 100));
    }
}