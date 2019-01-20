package com.solarwindsmsp.chess;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;
    private InitialPosition initialPosition;

    public Pawn(PieceColor pieceColor) {
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

    public void move(MovementType movementType, int newX, int newY) {
        if (this.isValidMovement(movementType, newX, newY)) {
            this.setCoordinates(newX, newY);
        }
    }

    private boolean isValidMovement(MovementType movementType, int newX, int newY) {
        switch (movementType) {
            case MOVE:
                if (this.initialPosition.equals(InitialPosition.BOTTOM)) {
                    return (newX == this.xCoordinate && newY == this.yCoordinate + 1);
                } else {
                    return (newX == this.xCoordinate && newY == this.yCoordinate - 1);
                }
            case CAPTURE:
                //TODO
                return false;
            default:
                //Invalid movement
                return false;
        }
    }

    @Override
    public String toString() {
        return currentPositionAsString();
    }

    protected String currentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }
}
