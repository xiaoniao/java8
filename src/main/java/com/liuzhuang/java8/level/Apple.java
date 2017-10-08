package com.liuzhuang.java8.level;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by liuzhuang on 2017/10/8.
 */
public class Apple {

    private String color;

    private int weight;

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public static boolean isGreenApple(Apple apple) {
        return apple.getColor().equals("green");
    }

    public static boolean isHeaveyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterApple(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        Apple apple = new Apple("green", 151);
        inventory.add(apple);

        /**
         * 使用方法引用 （把函数作为一等公民使用）
         */
        List<Apple> greenApples = filterApple(inventory, Apple::isGreenApple);
        List<Apple> heavyApples = filterApple(inventory, Apple::isHeaveyApple);

        greenApples.forEach(a -> System.out.println(a.getColor()));
        heavyApples.forEach(a -> System.out.println(a.getWeight()));

        /**
         * 使用lambda （把函数作为一等公民使用）
         */
        greenApples = filterApple(inventory, a -> a.getColor().equals("green"));
        heavyApples = filterApple(inventory, a -> a.getWeight() > 150);

        greenApples.forEach(a -> System.out.println(a.getColor()));
        heavyApples.forEach(a -> System.out.println(a.getWeight()));

        /**
         * 新增的流处理
         */
        List<Apple> greenHeavyApples = inventory.stream().filter(Apple::isGreenApple).filter(Apple::isHeaveyApple).collect(Collectors.toList());
        greenHeavyApples.forEach(a -> System.out.println(a.getColor() + "-" + a.getWeight()));
    }

}
