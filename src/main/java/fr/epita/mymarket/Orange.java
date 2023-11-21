package fr.epita.mymarket;

public record Orange(double weightInKilogram, Type type, double priceByKilogram) implements Fruit {

    public double price() {
        return weightInKilogram * priceByKilogram;
    }

    public enum Type {
        NORMAL, BLOOD;
    }
}
