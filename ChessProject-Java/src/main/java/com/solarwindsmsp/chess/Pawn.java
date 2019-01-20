package com.solarwindsmsp.chess;

public class Pawn extends Piece {

    public Pawn(PieceColor pieceColor) {
        super(pieceColor);
    }

    public void move(MovementType movementType, int newX, int newY) {
        if (this.isValidMovement(movementType, newX, newY)) {
            this.setCoordinates(newX, newY);
        }
    }

    private boolean isValidMovement(MovementType movementType, int newX, int newY) {
        switch (movementType) {
            case MOVE:
                if (this.getInitialPosition().equals(InitialPosition.BOTTOM)) {
                    return (newX == this.getXCoordinate() && newY == this.getYCoordinate() + 1);
                } else {
                    return (newX == this.getXCoordinate() && newY == this.getYCoordinate() - 1);
                }
            case CAPTURE:
                //TODO
                return false;
            default:
                //Invalid movement
                return false;
        }
    }

}
