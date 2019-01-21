package com.solarwindsmsp.chess.layout;

import com.solarwindsmsp.chess.piece.IPiece;
import com.solarwindsmsp.chess.coordinate.Coordinate;

public class Layout implements ILayout {

    private Position[][] positions;
    private int width;
    private int height;

    public Layout(int width, int height) {
        this.width = width;
        this.height = height;
        positions = new Position[width][height];
    }

    @Override
    public IPiece getPieceFromPosition(Coordinate coordinate) {
        return getPosition(coordinate).getPiece();
    }

    @Override
    public void addPiece(IPiece piece, Coordinate coordinate) {
        Position position = getPosition(coordinate);
        position.setPiece(piece);
    }

    @Override
    public IPiece movePiece(Coordinate coordinate, Coordinate newCoordinate) throws InvalidPosition{
        if (!isValidCoordinate(coordinate) || !isValidCoordinate(newCoordinate))
            throw new InvalidPosition();

        Position position = getPosition(coordinate);
        Position newPosition = getPosition(newCoordinate);
        IPiece capturedPiece = newPosition.getPiece();
        newPosition.setPiece(position.getPiece());
        releasePosition(position);
        return capturedPiece;
    }

    @Override
    public boolean isValidCoordinate(Coordinate coordinate) {
        return (coordinate.getX() >= 0 && coordinate.getX() < width &&
                coordinate.getY() >= 0 && coordinate.getY() < height);
    }

    private void releasePosition(Position position) {
        position.setPiece(null);
    }

    private Position getPosition(Coordinate coordinate) {
        if (positions[coordinate.getX()][coordinate.getY()] == null) {
            positions[coordinate.getX()][coordinate.getY()] = new Position();
        }
        return positions[coordinate.getX()][coordinate.getY()];
    }

}
