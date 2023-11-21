package fr.epita.mymarket;

import java.util.HashMap;
import java.util.Map;

public class FiniteStock implements Stock {

    private final Map<Class<? extends Fruit>, Integer> quantitiesByFruitType = new HashMap<>();

    @Override
    public void add(Class<? extends Fruit> fruitType, int quantity) {
        quantitiesByFruitType.put(fruitType, quantity);
    }

    @Override
    public Fruit get(Fruit fruit) {
        Class<? extends Fruit> fruitType = fruit.getClass();
        Integer quantity = quantitiesByFruitType.get(fruitType);
        if (quantity == null || quantity < 1) {
            return null;
        } else {
            quantitiesByFruitType.put(fruitType, quantity - 1);
            return fruit;
        }
    }
}
