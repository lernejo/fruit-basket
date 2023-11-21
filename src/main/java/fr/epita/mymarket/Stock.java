package fr.epita.mymarket;

public interface Stock {
    void add(Class<? extends Fruit> fruitType, int quantity);

    Fruit get(Fruit fruit);
}
