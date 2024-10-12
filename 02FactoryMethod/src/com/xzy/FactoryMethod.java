package com.xzy;

/**
 * 工厂方法模式
 *
 * 意图：定义一个用于创建对象的接口，让子类决定实例化哪一个类（使一个类的实例化延迟到其子类）。
 *
 * 适用性：
 *      1.当一个类不知道它所必须创建的对象的类的时候。
 *      2.当一个类希望由它的子类来指定它所创建的对象的时候。
 *      3.当类将创建对象的职责委托给多个帮助子类中的某一个，并且你希望将哪一个帮助子类是代理者这一信息局部化的时候。
 */
public class FactoryMethod {
    public static void main(String[] args) {
        // 多态：父类 对象名 = new 子类();
        Factory factoryA = new FactoryA();
        //编译看左边，方法调用看右边
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