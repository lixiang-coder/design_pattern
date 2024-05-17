package com.xzy;

/**
 * 适配器模式
 */
public class AdapterPattern {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.Request();
    }
}


class Target {
    public void Request() {
        System.out.println("普通请求~");
    }
}


/**
 * 适配器
 */
class Adapter extends Target {
    private Adaptee adaptee = new Adaptee();

    @Override
    public void Request() {
        adaptee.SpecificRequest();
    }
}


class Adaptee {
    public void SpecificRequest() {
        System.out.println("特殊请求~");
    }
}