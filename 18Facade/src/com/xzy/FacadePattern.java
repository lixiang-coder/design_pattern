package com.xzy;

/**
 * 外观模式
 * <p>
 * 意图：为子系统中的一组接口提供一个一致的界面，Facade 模式定义了一个高层接口，这个接口使得这一子系统更加容易使用
 * <p>
 * 适用性：
 * 1. 要为一个复杂子系统提供一个简单接口时。
 * 2. 客户程序与抽象类的实现部分之间存在着很大的依赖性。
 * 3. 当需要构建一个层次结构的子系统时，使用 Facade 模式定义子系统中每层的入口点
 */
public class FacadePattern {
    public static void main(String[] args) {
        Facade facade = new Facade();

        facade.methodA();
        facade.methodB();
        facade.methodC();
    }
}

class Facade {
    SubSystemOne subSystemOne;
    SubSystemTwo subSystemTwo;
    SubSystemThree subSystemThree;

    public Facade() {
        subSystemOne = new SubSystemOne();
        subSystemTwo = new SubSystemTwo();
        subSystemThree = new SubSystemThree();
    }

    public void methodA() {
        subSystemOne.methodOne();
    }

    public void methodB() {
        subSystemTwo.methodTwo();
    }

    public void methodC() {
        subSystemThree.methodThree();
    }
}

class SubSystemOne {
    public void methodOne() {
        System.out.println("执行子系统一的功能~");
    }
}

class SubSystemTwo {
    public void methodTwo() {
        System.out.println("执行子系统二的功能~");
    }
}

class SubSystemThree {
    public void methodThree() {
        System.out.println("执行子系统三的功能~");
    }
}