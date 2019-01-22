package com.solarwindsmsp.chess.piece;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PieceHelper {

    public IPiece getPieceMock(PieceType pieceType, PieceColor pieceColor) {
        IPiece pawn = mock(Pawn.class);
        when(pawn.getPieceColor()).thenReturn(pieceColor);
        when(pawn.getPieceType()).thenReturn(pieceType);
        return pawn;
    }
}
