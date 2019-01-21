package com.solarwindsmsp.chess.layout;

import com.solarwindsmsp.chess.piece.IPiece;

public class Position implements IPosition{

    private IPiece piece;

    public Position() {}

    public Position(IPiece piece) {
        this.piece = piece;
    }

    public IPiece getPiece() {
        return piece;
    }

    public void setPiece(IPiece piece) {
        this.piece = piece;
    }

}
