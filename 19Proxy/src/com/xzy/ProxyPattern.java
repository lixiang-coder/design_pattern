package com.xzy;

/**
 * 代理模式
 * <p>
 * 意图：为其他对象提供一种代理以控制对这个对象的访问。
 * <p>
 * 适用性：
 * Proxy模式适用于在需要比较通用和复杂的对象指针代替简单的指针的时候
 */
public class ProxyPattern {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Proxy proxy = new Proxy(realSubject);

        proxy.buy();
    }
}


interface Subject {
    void buy();
}


class Proxy implements Subject {
    protected RealSubject realSubject;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void buy() {
        System.out.println("办理购买前的手续~");
        realSubject.buy(); // 付钱
        System.out.println("办理购买后的手续~");
    }
}


class RealSubject implements Subject {
    @Override
    public void buy() {
        System.out.println("付钱~");
    }
}