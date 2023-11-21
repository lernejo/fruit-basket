package fr.epita.mymarket;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class FruitBasketTests {
    @Test
    void a_fruit_basket_can_be_created() {
        new FruitBasket();
    }

    @Test
    void a_fruit_can_be_added() {
        FruitBasket basket = new FruitBasket();

        boolean added = basket.add(new Orange(0.2D, Orange.Type.NORMAL, 5.0D));

        assertThat(added)
                .as("The orange is added")
                .isTrue();
        assertThat(basket.size())
                .as("the size of the basket")
                .isEqualTo(1);
        assertThat(basket.price())
                .as("the price of the basket")
                .isEqualTo(1.0D);
    }

    @Test
    void price_of_3_fruits() {
        FruitBasket basket = new FruitBasket();

        List<Boolean> added = IntStream.of(1, 2, 3)
                .mapToObj(i -> basket.add(new Orange(0.2D, Orange.Type.NORMAL, 5.0D)))
                .toList();

        assertThat(added)
                .as("All fruits are added")
                .containsExactly(true, true, true);
        assertThat(basket.size())
                .as("the size of the basket")
                .isEqualTo(3);
        assertThat(basket.price())
                .as("the price of the basket")
                .isEqualTo(3.0D);
    }

    @Test
    void add_various_types_of_fruits() {
        FruitBasket basket = new FruitBasket();

        basket.add(new Orange(0.150D, Orange.Type.BLOOD, 11.5D));
        basket.add(new Pineapple(7.0D));

        assertThat(basket.price())
                .as("the price of the basket")
                .isEqualTo(8.725D);
    }


    @Test
    void add_a_fuit_with_finite_stock() {
        Stock stock = new FiniteStock();
        stock.add(Orange.class, 10);
        FruitBasket basket = new FruitBasket(stock);
        IntStream.range(0, 10)
                .mapToObj(i -> basket.add(new Orange(0.2D, Orange.Type.NORMAL, 5.0D)))
                .toList();

        assertThat(basket.add(new Orange(0.2D, Orange.Type.NORMAL, 5.0D)))
                .as("An orange that is not in stock is added")
                .isFalse();

        assertThat(basket.size())
                .as("the size of the basket")
                .isEqualTo(10);
        assertThat(basket.price())
                .as("the price of the basket")
                .isEqualTo(10.0D);
    }
}
