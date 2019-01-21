package com.solarwindsmsp.chess.board;

import com.solarwindsmsp.chess.layout.IllegalPosition;
import com.solarwindsmsp.chess.layout.InvalidPosition;
import com.solarwindsmsp.chess.movement.InvalidMovement;
import com.solarwindsmsp.chess.movement.MovementType;
import com.solarwindsmsp.chess.piece.IPiece;
import com.solarwindsmsp.chess.coordinate.Coordinate;


public class ChessBoard extends Board {

    private static int MAX_BOARD_WIDTH = 8;
    private static int MAX_BOARD_HEIGHT = 8;

    public ChessBoard() {
        super(MAX_BOARD_WIDTH, MAX_BOARD_HEIGHT);
    }

    @Override
    public void add(IPiece piece, Coordinate coordinate) throws IllegalPosition, NotEmptyPosition {
        if (!isLegalBoardPosition(coordinate))
            throw new IllegalPosition();

        if (!isEmpty(coordinate))
            throw new NotEmptyPosition();

        layout.addPiece(piece, coordinate);
    }

    @Override
    public void move(MovementType movementType, Coordinate coordinate, Coordinate newCoordinate)
            throws InvalidPosition, InvalidMovement, NotEmptyPosition {

        if (!isLegalBoardPosition(coordinate) || !isLegalBoardPosition(newCoordinate))
            throw new InvalidPosition();

        IPiece piece = layout.getPieceFromPosition(coordinate);

        if (movementType.equals(MovementType.MOVE) && !isEmpty(newCoordinate))
            throw new NotEmptyPosition();

        if (movementType.equals(MovementType.MOVE) && piece.isValidMovement(movementType, coordinate, newCoordinate)) {
            layout.movePiece(coordinate, newCoordinate);
        } else {
            throw new InvalidMovement();
        }
    }

}
