package com.xzy;

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
