package dev.helloworld.springcorebasic.singletone;

import org.junit.jupiter.api.Test;

public class StatefulService {

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;
    }

}
