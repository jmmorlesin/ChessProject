package com.solarwindsmsp.chess;

import static com.solarwindsmsp.chess.Constants.MAX_BOARD_WIDTH;
import static com.solarwindsmsp.chess.Constants.MAX_BOARD_HEIGHT;
import static com.solarwindsmsp.chess.Constants.INVALID_COORDINATE;

public class ChessBoard {

    private Piece[][] pieces;
    private int maxWidth;
    private int maxHeight;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
        maxWidth = MAX_BOARD_WIDTH;
        maxHeight = MAX_BOARD_HEIGHT;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    private void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    private void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public void add(Piece piece, int xCoordinate, int yCoordinate) {
        if (this.isLegalBoardPosition(xCoordinate, yCoordinate) && this.isEmpty(xCoordinate, yCoordinate)) {
            piece.setCoordinates(xCoordinate, yCoordinate);
            pieces[xCoordinate][yCoordinate] = piece;
        } else {
            piece.setCoordinates(INVALID_COORDINATE, INVALID_COORDINATE);
        }
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return (xCoordinate >= 0 && xCoordinate < MAX_BOARD_WIDTH &&
                yCoordinate >= 0 && yCoordinate < MAX_BOARD_HEIGHT);
    }

    private boolean isEmpty(int xCoordinate, int yCoordinate) {
        return (pieces[xCoordinate][yCoordinate] == null);
    }


}
