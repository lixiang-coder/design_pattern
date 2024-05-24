package com.xzy;

/**
 * 责任链模式
 * 意图：使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。
 *
 * 适用性：
 * 1. 有多个的对象可以处理一个请求，哪个对象处理该请求运行时刻自动确定。
 * 2. 想在不明确指定接收者的情况下向多个对象中的一个提交一个请求。
 * 3. 可处理一个请求的对象集合应被动态指定。
 */
public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        Handler counsellor = new Counsellor();
        Handler dean = new Dean();
        Handler headmaster = new Headmaster();

        counsellor.setNext(dean);
        dean.setNext(headmaster);

        counsellor.HandRequest(25);
    }

}


abstract class Handler {
    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void HandRequest(int request);
}


class Counsellor extends Handler {
    @Override
    public void HandRequest(int request) {
        if (request <= 7) {
            System.out.println("辅导员审批通过~");
        } else {
            if (next != null) {
                next.HandRequest(request);
            } else {
                System.out.println("无法审批");
            }
        }
    }
}


class Dean extends Handler {
    @Override
    public void HandRequest(int request) {
        if (request <= 15) {
            System.out.println("院长审批通过~");
        } else {
            if (next != null) {
                next.HandRequest(request);
            } else {
                System.out.println("无法审批");
            }
        }
    }
}


class Headmaster extends Handler {
    @Override
    public void HandRequest(int request) {
        if (request <= 30) {
            System.out.println("校长审批通过~");
        } else {
            if (next != null) {
                next.HandRequest(request);
            } else {
                System.out.println("无法审批");
            }
        }
    }
}
