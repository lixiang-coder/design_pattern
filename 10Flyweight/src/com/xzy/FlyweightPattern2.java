package com.xzy;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 享元模式
 * <p>
 * 意图：运用共享技术有效地支持大量细粒度的对象。
 * <p>
 * 适用性：
 * 1. 一个应用程序使用了大量的对象。
 * 2. 完全由于使用大量的对象，造成很大的存储开销。
 * 3. 对象的大多数状态都可变为外部状态。
 * 4. 如果删除对象的外部状态，那么可以用相对较少的共享对象取代很多组对象。
 * 5. 应用程序不依赖于对象标识。由于Flyweight对象可以被共享，所以对于概念上明显有别的对象，标识测试将返回真值。
 */

public class FlyweightPattern2 {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Random random = new Random();
        String[] colors = {"red", "blue", "green", "whilte", "black"};

        for (int i = 1; i <= 10; i++) {
            int x = random.nextInt(colors.length);
            Shape shape = factory.getShape(colors[x]);
            System.out.print("第" + i + "个圆：");
            shape.draw(random.nextInt(2022), random.nextInt(528));
        }
    }
}


class ShapeFactory {
    private Map<String, Shape> map = new HashMap<>();

    public Shape getShape(String key) {
        if (!map.containsKey(key)) {
            map.put(key, new Circle(key));
            System.out.println("create color: " + key + " circle");
        }
        return map.get(key);
    }
}


abstract class Shape {
    protected String color;

    public abstract void draw(int x, int y);
}

class Circle extends Shape {
    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("draw a color: " + color + " circle x：" + x + " y：" + y);
    }
}

