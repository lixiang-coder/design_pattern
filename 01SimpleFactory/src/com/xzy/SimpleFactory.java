package com.xzy;

/**
 * 简单工厂模式（静态工厂方法）
 * <p>
 * 缺点：违反了开放-封闭原则，即对扩展开放对修改也开放
 */
public class SimpleFactory {
    public static void main(String[] args) {
        Product productA = Factory.createProduct("A");
        productA.info();

        Product productB = Factory.createProduct("B");
        productB.info();

        Product productC = Factory.createProduct("C");
        productC.info();

        Product productD = Factory.createProduct("D");
        productD.info();
    }
}

class Factory {
    public static Product createProduct(String type) {
        Product product = null;

        switch (type) {
            case "A":
                product = new ProductA();
                break;
            case "B":
                product = new ProductB();
                break;
            case "C":
                product = new ProductC();
                break;
            default:
                System.out.println("没有 " + type + " 类型的产品！");
                return null;
        }
        return product;
    }
}

abstract class Product {
    public abstract void info();
}


class ProductA extends Product {
    @Override
    public void info() {
        System.out.println("产品的信息：A");
    }
}


class ProductB extends Product {
    @Override
    public void info() {
        System.out.println("产品的信息：B");
    }
}


class ProductC extends Product {
    @Override
    public void info() {
        System.out.println("产品的信息：C");
    }
}
