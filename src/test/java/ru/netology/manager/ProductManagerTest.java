package ru.netology.manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private final ProductRepository repository = new ProductRepository();
    ProductManager managers = new ProductManager(repository);
    private ru.netology.manager.Product product = new ru.netology.manager.Product();
    private final Smartphone Galaxy = new Smartphone(1, "SamsungGalaxyS", 15000, "Samsung");
    private final Book PetCemetery = new Book(4, "PetCemetery", 350, "StephenKing");
    private final ru.netology.manager.Product Coffee = new ru.netology.manager.Product(9, "С1", 50);

    @Test
    public void add() {
        managers.add(Galaxy);
        managers.add(PetCemetery);
        managers.add(Coffee);

        ru.netology.manager.Product[] expected = {Galaxy, PetCemetery, Coffee};
        ru.netology.manager.Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void add2() {
        managers.add(PetCemetery);
        managers.add(Coffee);

        ru.netology.manager.Product[] expected = {PetCemetery, Coffee};
        ru.netology.manager.Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    void searchBy() {
        managers.add(Galaxy);

        ru.netology.manager.Product[] actual = managers.searchBy("SamsungGalaxyS");
        ru.netology.manager.Product[] expected = new ru.netology.manager.Product[]{Galaxy};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByPetCemetery() {
        managers.add(PetCemetery);

        ru.netology.manager.Product[] expected = new ru.netology.manager.Product[]{PetCemetery};
        ru.netology.manager.Product[] actual = managers.searchBy("PetCemetery");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByCoffeePetCemetery() {
        managers.add(Coffee);

        ru.netology.manager.Product[] expected = new ru.netology.manager.Product[]{Coffee};
        ru.netology.manager.Product[] actual = managers.searchBy("С1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByAuthorPetCemetery() {

        ru.netology.manager.Product[] expected = new ru.netology.manager.Product[]{};
        ru.netology.manager.Product[] actual = managers.searchBy("StephenKing");
        assertArrayEquals(expected, actual);
    }

}