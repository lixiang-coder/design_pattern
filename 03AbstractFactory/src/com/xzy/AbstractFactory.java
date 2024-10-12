package com.xzy;

/**
 * 抽象工厂模式
 *
 * 意图：提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。
 *
 * 适用性：
 *      1. 一个系统要独立于它的产品的创建、组合和表示时。
 *      2. 一个系统要由多个产品系列中的一个来配置时。
 *      3. 当要强调一系列相关的产品对象的设计以便进行联合使用时。
 *      4. 当提供一个产品类库，只想显示它们的接口而不是实现时。
 */
public class AbstractFactory {
    public static void main(String[] args) {
        Factory factory1 = new Factory1();
        ProductA productA1 = factory1.createProductA();
        productA1.info();
        ProductB productB1 = factory1.createProductB();
        productB1.info();

        Factory factory2 = new Factory2();
        ProductA productA2 = factory2.createProductA();
        productA2.info();
        ProductB productB2 = factory2.createProductB();
        productB2.info();
    }
}


// 声明一个创建抽象产品对象的操作接口
interface Factory {
    ProductA createProductA();

    ProductB createProductB();
}


// 实现创建具体产品对象的操作
class Factory1 implements Factory {
    @Override
    public ProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public ProductB createProductB() {
        return new ProductB1();
    }
}


class Factory2 implements Factory {
    @Override
    public ProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new ProductB2();
    }
}


// 为一类产品对象声明一个接口
interface ProductA {
    void info();
}


interface ProductB {
    void info();
}


// 定义一将被相应的具体工厂创建的产品对象
class ProductA1 implements ProductA {
    @Override
    public void info() {
        System.out.println("产品的信息：A1");
    }
}


class ProductA2 implements ProductA {
    @Override
    public void info() {
        System.out.println("产品的信息：A2");
    }
}


class ProductB1 implements ProductB {
    @Override
    public void info() {
        System.out.println("产品的信息：B1");
    }
}


class ProductB2 implements ProductB {
    @Override
    public void info() {
        System.out.println("产品的信息：B2");
    }
}