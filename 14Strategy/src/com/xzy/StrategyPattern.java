package com.xzy;

/**
 * 策略模式
 */
public class StrategyPattern {
    public static void main(String[] args) {
        OperationContext context = new OperationContext(new Addstrategy());
        context.Operation(20, 17);  //加法

        context = new OperationContext(new Substrategy());
        context.Operation(20, 17);  //减法

        context = new OperationContext(new Multstrategy());
        context.Operation(20, 17);  //乘法
    }
}


class OperationContext {
    private Strategy strategy;

    public OperationContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public void Operation(int a, int b) {
        strategy.TwoNumberOperation(a, b);
    }
}


interface Strategy {
    void TwoNumberOperation(int a, int b);
}


class Addstrategy implements Strategy {
    @Override
    public void TwoNumberOperation(int a, int b) {
        System.out.println(a + b);
    }
}


class Substrategy implements Strategy {
    @Override
    public void TwoNumberOperation(int a, int b) {
        System.out.println(a - b);
    }
}


class Multstrategy implements Strategy {
    @Override
    public void TwoNumberOperation(int a, int b) {
        System.out.println(a * b);
    }
}