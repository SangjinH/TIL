package chapter1.item2_Builder;

public class Exercise {

    NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                                .addTopping(Pizza.Topping.SAUSAGE)
                                .addTopping(Pizza.Topping.ONION)
                                .build();

    Calzone calzone = new Calzone.Builder()
                                .addTopping(Pizza.Topping.HAM)
                                .sauceInside()
                                .build();
}
