package com.solarwindsmsp.chess.piece;

import com.solarwindsmsp.chess.board.InitialPosition;

public abstract class Piece implements IPiece {

    private PieceType pieceType;
    private PieceColor pieceColor;
    private InitialPosition initialPosition;

    public Piece(PieceType pieceType, PieceColor pieceColor) {
        this.pieceType = pieceType;
        this.pieceColor = pieceColor;
        this.initialPosition = pieceColor.equals(PieceColor.BLACK) ? InitialPosition.TOP : InitialPosition.BOTTOM;
    }

    @Override
    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    @Override
    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public InitialPosition getInitialPosition() {
        return initialPosition;
    }

    public void setInitialPosition(InitialPosition initialPosition) {
        this.initialPosition = initialPosition;
    }

    @Override
    public String toString() {
        return currentPositionAsString();
    }

    protected String currentPositionAsString() {
        return String.join(System.lineSeparator(),
                String.format("Initial position: %s", initialPosition),
                String.format("Piece color: %s", pieceColor));
    }


}
