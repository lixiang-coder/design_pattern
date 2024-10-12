package com.xzy;

/**
 * 享元模式
 * <p>
 * 意图：运用共享技术有效地支持大量细粒度的对象。
 * <p>
 * 适用性：
 *      1. 一个应用程序使用了大量的对象。
 *      2. 完全由于使用大量的对象，造成很大的存储开销。
 *      3. 对象的大多数状态都可变为外部状态。
 *      4. 如果删除对象的外部状态，那么可以用相对较少的共享对象取代很多组对象。
 *      5. 应用程序不依赖于对象标识。由于Flyweight对象可以被共享，所以对于概念上明显有别的对象，标识测试将返回真值。
 */
public class FlyweightPattern1 {
    public static void main(String[] args) {
        PieceFactory factory = new PieceFactory();

        Piece whitePiece1 = factory.getPiece(0);
        whitePiece1.draw(66, 87);
        System.out.println(whitePiece1);

        Piece blackPiece1 = factory.getPiece(1);
        blackPiece1.draw(20, 11);
        System.out.println(blackPiece1);

        Piece whitePiece2 = factory.getPiece(0);
        whitePiece1.draw(26, 54);
        System.out.println(whitePiece2);

        Piece blackPiece2 = factory.getPiece(1);
        blackPiece2.draw(12, 34);
        System.out.println(blackPiece2);
    }
}


class PieceFactory {
    private Piece[] pieces = {new WhitePiece(), new BlackPiece()};

    public Piece getPiece(int key) {
        if (key == 0) return pieces[0];
        else return pieces[1];
    }
}


abstract class Piece {
    protected String color;

    public abstract void draw(int x, int y);
}


class WhitePiece extends Piece {
    public WhitePiece() {
        this.color = "white";
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("draw a color: " + color + " piece x: " + x + " y:　" + y);
    }
}


class BlackPiece extends Piece {
    public BlackPiece() {
        this.color = "black";
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("draw a color: " + color + " piece x: " + x + " y:　" + y);
    }
}
