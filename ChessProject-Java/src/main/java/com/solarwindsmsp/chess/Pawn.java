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
                int numberPositions = this.getInitialPosition().equals(InitialPosition.BOTTOM) ? 1 : -1;
                return (newX == this.getXCoordinate() && newY == this.getYCoordinate() + numberPositions);
            case CAPTURE:
                //TODO
                return false;
            default:
                //Invalid movement
                return false;
        }
    }

}
