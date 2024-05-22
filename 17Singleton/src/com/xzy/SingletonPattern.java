package com.xzy;

/**
 * 单例模式
 * <p>
 * 意图：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * <p>
 * 适用性：
 * 1.当类只能有一个实例而且客户可以从一个众所周知的访问点访问它时。
 * 2.当这个唯一实例应该是通过子类化可扩展的，并且客户无须更改代码就能使用一个扩展的实例时
 */
public class SingletonPattern {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        Singleton instance3 = Singleton.getInstance();

        System.out.println("instance1: " + instance1);
        System.out.println("instance2: " + instance2);
        System.out.println("instance3: " + instance3);
    }
}

class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}