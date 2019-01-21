package com.solarwindsmsp.chess.piece;

import com.solarwindsmsp.chess.movement.MovementType;
import com.solarwindsmsp.chess.coordinate.Coordinate;
import com.solarwindsmsp.chess.movement.InvalidMovement;

public interface IPiece {

    boolean isValidMovement(MovementType movementType, Coordinate coordinate, Coordinate newCoordinate)
            throws InvalidMovement;

    PieceType getPieceType();

    PieceColor getPieceColor();

}
