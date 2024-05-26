package com.xzy;

/**
 * 中介者模式
 *
 * 意图：用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显式的相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
 *
 * 适用性：
 * 1.一组对象以定义良好但是复杂的方式进行通信，产生的相互依赖关系结构混乱且难以理解。
 * 2.一个对象引用其他很多对象并且直接与这些对象通信，导致难以复用该对象。
 * 3.想定制一个分布在多个类中的行为，而又不想生成太多的子类。
 */
public class MediatorPattern {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        Colleague1 colleague1 = new Colleague1(mediator);
        Colleague2 colleague2 = new Colleague2(mediator);

        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        colleague1.sendMessage("软考加油~");
        colleague2.sendMessage("祝你上岸~");
    }
}


abstract class Colleague {
    protected Mediator mediator;
}


class Colleague1 extends Colleague {
    public Colleague1(Mediator mediator) {
        this.mediator = mediator;
    }

    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    public void Notify(String message) {
        System.out.println("同事1收到消息：" + message);
    }
}


class Colleague2 extends Colleague {
    public Colleague2(Mediator mediator) {
        this.mediator = mediator;
    }

    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    public void Notify(String message) {
        System.out.println("同事2收到消息：" + message);
    }
}


abstract class Mediator {
    public abstract void sendMessage(String message, Colleague colleague);
}


class ConcreteMediator extends Mediator {
    private Colleague1 colleague1;
    private Colleague2 colleague2;

    public void setColleague1(Colleague1 colleague1) {
        this.colleague1 = colleague1;
    }

    public void setColleague2(Colleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    @Override
    public void sendMessage(String message, Colleague colleague) {
        if (colleague == colleague1) {
            // 让同事2收到消息
            colleague2.Notify(message);
        } else {
            // 让同事1收到消息
            colleague1.Notify(message);
        }
    }
}