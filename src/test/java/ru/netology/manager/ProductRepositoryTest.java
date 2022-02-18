package ru.netology.manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private final ProductRepository repository = new ProductRepository();
    private final Book coreJava = new Book();
    //private final Smartphone coreJava1 = new Smartphone();
    // private final Product product = new Product();
    private final Smartphone Galaxy = new Smartphone(1, "SamsungGalaxyS", 15000, "Samsung");
    private final Book PetCemetery = new Book(4, "PetCemetery", 350, "StephenKing");
    private final Product Coffee = new Product(9, "С1", 50);

    @Test
    public void shouldSaveOneProduct() {
        repository.save(coreJava);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
        repository.save(Galaxy);
        repository.save(PetCemetery);
        repository.save(Coffee);

        Product[] expected = {Galaxy, PetCemetery, Coffee};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        //int idToRemove = 9;
        repository.save(Galaxy);
        repository.save(PetCemetery);
        repository.save(Coffee);

        repository.removeById(9);

        Product[] actual = repository.findAll();
        Product[] expected = {Galaxy, PetCemetery};

        assertArrayEquals(expected, actual);
    }

    @Test
    void add() {
        repository.save(Galaxy);
        repository.save(PetCemetery);
        repository.save(Coffee);

        Product[] actual = repository.findAll();
        Product[] expected = {Galaxy, PetCemetery, Coffee};

        assertArrayEquals(expected, actual);
    }

    @Test
    void add2() {
        repository.save(Galaxy);

        Product[] actual = repository.findAll();
        Product[] expected = {Galaxy};

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByIdNull() {
        //int idToRemove = 9;
        repository.save(Galaxy);
        repository.save(PetCemetery);
        repository.save(Coffee);

        repository.removeById(1);

        Product[] actual = repository.findAll();
        Product[] expected = {PetCemetery, Coffee};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void should15Id() {
        assertThrows(NotFoundException.class, () -> repository.removeById(17));
    }
}

