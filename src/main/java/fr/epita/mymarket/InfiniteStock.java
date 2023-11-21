package fr.epita.mymarket;

public class InfiniteStock implements Stock {
    @Override
    public void add(Class<? extends Fruit> fruitType, int quantity) {
        throw new IllegalStateException("should not be called, stock in already infinite");
    }

    @Override
    public Fruit get(Fruit fruit) {
        return fruit;
    }
}
