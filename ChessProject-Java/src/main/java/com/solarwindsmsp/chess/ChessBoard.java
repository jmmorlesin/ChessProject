package com.solarwindsmsp.chess;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 8;
    public static int MAX_BOARD_HEIGHT = 8;
    //TODO move
    public static int INVALID_COORDINATE = -1;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];

    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (this.isLegalBoardPosition(xCoordinate, yCoordinate) && this.isEmpty(xCoordinate, yCoordinate)) {
            pawn.setCoordinates(xCoordinate, yCoordinate);
            pieces[xCoordinate][yCoordinate] = pawn;
        } else {
            pawn.setCoordinates(INVALID_COORDINATE, INVALID_COORDINATE);
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
