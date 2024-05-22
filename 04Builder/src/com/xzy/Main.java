package com.xzy;

import java.util.ArrayList;
import java.util.List;


/**
 * 生成器模式
 *
 * 意图：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 *
 * 适用性：
 * 1.当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式时。
 * 2.当构造过程必须允许被构造的对象有不同的表示时。
 */
public class Main {
    public static void main(String[] args) {
        Director director = new Director();

        Builder builder1 = new Builder1();
        director.Construct(builder1);
        Product product1 = builder1.getResult();
        product1.show();

        Builder builder2 = new Builder2();
        director.Construct(builder2);
        Product product2 = builder2.getResult();
        product2.show();
    }
}

class Director {
    public void Construct(Builder builder) {
        builder.BuildPart();
    }
}


abstract class Builder {
    public abstract void BuildPart();

    public abstract Product getResult();
}


class Builder1 extends Builder {
    Product product = new Product();

    @Override
    public void BuildPart() {
        product.add("A");
        product.add("B");
        product.add("C");
        product.add("D");
        product.add("E");
        product.add("F");
    }

    @Override
    public Product getResult() {
        return product;
    }
}


class Builder2 extends Builder {
    Product product = new Product();

    @Override
    public void BuildPart() {
        product.add("A");
        product.add("B");
        product.add("C");
    }

    @Override
    public Product getResult() {
        return product;
    }
}


class Product {
    List<String> parts = new ArrayList<String>();

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        System.out.print("产品的组成：");
        for (String part : parts) {
            System.out.print(part + " ");
        }
        System.out.println();
    }
}
