package com.solarwindsmsp.chess.layout;

import com.solarwindsmsp.chess.piece.IPiece;
import com.solarwindsmsp.chess.coordinate.Coordinate;

public interface ILayout {

    IPiece getPieceFromPosition(Coordinate coordinate);

    void addPiece(IPiece piece, Coordinate coordinate);

    IPiece movePiece(Coordinate coordinate, Coordinate newCoordinate) throws InvalidPosition;

    boolean isValidCoordinate(Coordinate coordinate);

}
