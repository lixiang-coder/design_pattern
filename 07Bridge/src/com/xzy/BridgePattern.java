package com.xzy;

/**
 * 桥接模式
 */
public class BridgePattern {
    public static void main(String[] args) {
        Product productA = new ProductA();
        Product productB = new ProductA();

        Color red = new Red();
        productA.setName("产品A");
        productA.setColor(red);
        productA.Operation();

        Blue blue = new Blue();
        productB.setName("产品B");
        productB.setColor(blue);
        productB.Operation();
    }
}


abstract class Product {
    private String name;
    protected Color color;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void Operation();
}


interface Color {
    void OperationImpl(String name);
}


class ProductA extends Product {
    @Override
    public void Operation() {
        color.OperationImpl(this.getName());
    }
}


class Red implements Color {
    @Override
    public void OperationImpl(String name) {
        System.out.println(name + ": 红色");
    }
}


class Blue implements Color {
    @Override
    public void OperationImpl(String name) {
        System.out.println(name + ": 蓝色");
    }
}