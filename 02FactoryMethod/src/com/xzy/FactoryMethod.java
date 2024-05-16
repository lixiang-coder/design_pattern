package com.xzy;

/**
 * 工厂方法模式
 */
public class FactoryMethod {
    public static void main(String[] args) {

        // 父类 对象名 = new 子类();
        Factory factoryA = new FactoryA();
        Product productA = factoryA.createProduct();
        productA.info();

        Factory factoryB = new FactoryB();
        Product productB = factoryB.createProduct();
        productB.info();

    }
}


interface Factory {
    Product createProduct();
}


class FactoryA implements Factory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}


class FactoryB implements Factory {
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}

interface Product {
    void info();
}


class ProductA implements Product {
    @Override
    public void info() {
        System.out.println("产品的信息：A");
    }
}


class ProductB implements Product {
    @Override
    public void info() {
        System.out.println("产品的信息：B");
    }
}