package com.xzy;

/**
 * 原型模式
 *
 * 意图：用原型实例指定创建对象的种类，并且通过复制这些原型创建新的对象。
 *
 * 适用性：
 * 1.当一个系统应该独立于它的产品创建、构成和表示时。
 * 2.当要实例化的类是在运行时刻指定时，例如，通过动态装载。
 * 3.为了避免创建一个与产品类层次平行的工厂类层次时。
 * 4.当一个类的实例只能有几个不同状态组合中的一种时。建立相应数目的原型并克隆它们，可能比每次用合适的状态手工实例化该类更方便一些。
 */
public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(2024, 5.26);
        System.out.println(product1.getId() + " " + product1.getPrice());

        //Product product2 = new Product(2024, 5.26);
        Product product2 = (Product) product1.Chlone();
        System.out.println(product2.getId() + " " + product2.getPrice());

    }
}


interface Prototype {
    Object Chlone();
}


class Product implements Prototype {
    private int id;
    private double price;

    public Product() {
    }

    public Product(int id, double price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public Object Chlone() {
        Product object = new Product();
        object.id = this.id;
        object.price = this.price;

        return object;
    }
}