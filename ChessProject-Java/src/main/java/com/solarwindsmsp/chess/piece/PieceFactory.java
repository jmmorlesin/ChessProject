package com.solarwindsmsp.chess.piece;

public class PieceFactory {

    private static PieceFactory instance;

    private PieceFactory() {}

    public static PieceFactory getInstance() {
        if (instance == null) {
            instance = new PieceFactory();
        }
        return instance;
    }

    public IPiece getPiece(PieceType pieceType, PieceColor pieceColor) throws InvalidPiece {
        switch (pieceType) {
            case PAWN:
                return new Pawn(pieceColor);
            default:
                throw new InvalidPiece();
        }
    }
}
