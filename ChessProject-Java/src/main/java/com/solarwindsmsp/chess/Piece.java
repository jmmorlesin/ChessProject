package com.solarwindsmsp.chess;

public abstract class Piece {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;
    private InitialPosition initialPosition;

    public Piece(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
        this.initialPosition = pieceColor.equals(PieceColor.BLACK) ? InitialPosition.TOP : InitialPosition.BOTTOM;
    }

    public ChessBoard getChesssBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

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

    public void setCoordinates(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public abstract void move(MovementType movementType, int newX, int newY);

    @Override
    public String toString() {
        return currentPositionAsString();
    }

    protected String currentPositionAsString() {
        String eol = System.lineSeparator();
        return String.join(eol,
                String.format("Current X: %d", this.getXCoordinate()),
                String.format("Current Y: %d", this.getYCoordinate()),
                String.format("Piece Color: %s", this.getPieceColor()));
    }


}
