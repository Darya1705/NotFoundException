package ru.netology.manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();
    private Smartphone coreJava1 = new Smartphone();
    private ru.netology.manager.Product product = new ru.netology.manager.Product();
    private Smartphone Galaxy = new Smartphone(1, "SamsungGalaxyS", 15000, "Samsung");
    private Book PetCemetery = new Book(4, "PetCemetery", 350,"StephenKing");
    private ru.netology.manager.Product Coffee = new ru.netology.manager.Product(9, "С1", 50);

    @Test
    public void shouldSaveOneProduct() {
        repository.save(coreJava);

        ru.netology.manager.Product[] expected = new ru.netology.manager.Product[]{coreJava};
        ru.netology.manager.Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
        repository.save(Galaxy);
        repository.save(PetCemetery);
        repository.save(Coffee);

        ru.netology.manager.Product[] expected = { Galaxy, PetCemetery, Coffee };
        ru.netology.manager.Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        //int idToRemove = 9;
        repository.save(Galaxy);
        repository.save(PetCemetery);
        repository.save(Coffee);

        repository.removeById(9);

        ru.netology.manager.Product[] actual = repository.findAll();
        ru.netology.manager.Product[] expected = {Galaxy, PetCemetery};

        assertArrayEquals(expected, actual);
    }
     @Test
    void add() {
        repository.save(Galaxy);
        repository.save(PetCemetery);
        repository.save(Coffee);

        ru.netology.manager.Product[] actual = repository.findAll();
        ru.netology.manager.Product[] expected = { Galaxy, PetCemetery, Coffee };

        assertArrayEquals(expected, actual);
    }

    @Test
    void add2() {
        repository.save(Galaxy);

        ru.netology.manager.Product[] actual = repository.findAll();
        ru.netology.manager.Product[] expected = { Galaxy };

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByIdNull() {
        //int idToRemove = 9;
        repository.save(Galaxy);
        repository.save(PetCemetery);
        repository.save(Coffee);

        repository.removeById(1);

        ru.netology.manager.Product[] actual = repository.findAll();
        ru.netology.manager.Product[] expected = {PetCemetery, Coffee};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void should15Id() {
        assertThrows(NotFoundException.class, () -> repository.removeById(17));
    }
}

