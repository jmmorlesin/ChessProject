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
                return this.isValidNormalMovement(this.getXCoordinate(), this.getYCoordinate(), newX, newY) ||
                        this.isValidFirstSpecialMovement(this.getXCoordinate(), this.getYCoordinate(), newX, newY);
            case CAPTURE:
                //TODO
                return false;
            default:
                //Invalid movement
                return false;
        }
    }

    private boolean isFirstPosition(int y) {
        int initialY = (this.getInitialPosition().equals(InitialPosition.BOTTOM)) ? 1 : 6;
        return y == initialY;
    }

    private boolean isValidNormalMovement(int x, int y, int newX, int newY) {
        int numberPositions = this.getInitialPosition().equals(InitialPosition.BOTTOM) ? 1 : -1;
        return this.isValidJumpingMovement(x, y, newX, newY, numberPositions);
    }

    private boolean isValidFirstSpecialMovement(int x, int y, int newX, int newY) {
        int numberPositions = this.getInitialPosition().equals(InitialPosition.BOTTOM) ? 2 : -2;
        return this.isFirstPosition(y) && this.isValidJumpingMovement(x, y, newX, newY, numberPositions);
    }

    private boolean isValidJumpingMovement(int x, int y, int newX, int newY, int numberPositions) {
        return newX == x && newY == y + numberPositions;
    }

}
