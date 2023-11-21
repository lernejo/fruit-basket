package fr.epita.mymarket;

import java.util.ArrayList;
import java.util.List;

public class FruitBasket {

    private final List<Fruit> fruits = new ArrayList<>();
    private final Stock stock;

    public FruitBasket() {
        this(new InfiniteStock());
    }

    public FruitBasket(Stock stock) {
        this.stock = stock;
    }

    public boolean add(Fruit orange) {
        Fruit fruitFromStock = stock.get(orange);
        boolean fruitPresentInStock = fruitFromStock != null;
        if (fruitPresentInStock) {
            fruits.add(fruitFromStock);
        }
        return fruitPresentInStock;
    }

    public int size() {
        return fruits.size();
    }

    public double price() {
        return fruits.stream().mapToDouble(Fruit::price).sum();
    }
}
