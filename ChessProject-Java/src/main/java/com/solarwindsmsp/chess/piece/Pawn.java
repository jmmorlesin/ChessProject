package com.solarwindsmsp.chess.piece;

import com.solarwindsmsp.chess.movement.MovementType;
import com.solarwindsmsp.chess.board.InitialPosition;
import com.solarwindsmsp.chess.coordinate.Coordinate;
import com.solarwindsmsp.chess.movement.InvalidMovement;

public class Pawn extends Piece {

    public Pawn(PieceColor pieceColor) {
        super(PieceType.PAWN, pieceColor);
    }

    @Override
    public boolean isValidMovement(MovementType movementType, Coordinate coordinate, Coordinate newCoordinate)
            throws InvalidMovement {
        switch (movementType) {
            case MOVE:
                return isValidNormalMovement(coordinate, newCoordinate) ||
                        isValidFirstSpecialMovement(coordinate, newCoordinate);
            case CAPTURE:
            default:
                throw new InvalidMovement();
        }
    }

    private boolean isFirstPosition(int y) {
        int initialY = (this.getInitialPosition().equals(InitialPosition.BOTTOM)) ? 1 : 6;
        return y == initialY;
    }

    private boolean isValidNormalMovement(Coordinate coordinate, Coordinate newCoordinate) {
        int numberPositions = this.getInitialPosition().equals(InitialPosition.BOTTOM) ? 1 : -1;
        return this.isValidJumpingMovement(coordinate, newCoordinate, numberPositions);
    }

    private boolean isValidFirstSpecialMovement(Coordinate coordinate, Coordinate newCoordinate) {
        int numberPositions = this.getInitialPosition().equals(InitialPosition.BOTTOM) ? 2 : -2;
        return this.isFirstPosition(coordinate.getY()) && this.isValidJumpingMovement(coordinate, newCoordinate,
                numberPositions);
    }

    private boolean isValidJumpingMovement(Coordinate coordinate, Coordinate newCoordinate, int numberPositions) {
        return newCoordinate.getX() == coordinate.getX() && newCoordinate.getY() == coordinate.getY() + numberPositions;
    }

}
