package com.solarwindsmsp.chess.board;

import com.solarwindsmsp.chess.layout.ILayout;
import com.solarwindsmsp.chess.layout.IllegalPosition;
import com.solarwindsmsp.chess.layout.InvalidPosition;
import com.solarwindsmsp.chess.movement.InvalidMovement;
import com.solarwindsmsp.chess.movement.MovementType;
import com.solarwindsmsp.chess.piece.IPiece;
import com.solarwindsmsp.chess.coordinate.Coordinate;

public interface IBoard {

    void add(IPiece piece, Coordinate coordinate) throws IllegalPosition, NotEmptyPosition;

    void move(MovementType movementType, Coordinate coordinate, Coordinate newCoordinate)
            throws InvalidPosition, InvalidMovement, NotEmptyPosition;

    ILayout getLayout();

}
