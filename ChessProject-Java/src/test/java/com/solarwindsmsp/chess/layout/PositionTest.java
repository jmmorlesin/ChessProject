package com.solarwindsmsp.chess.layout;

import com.solarwindsmsp.chess.piece.IPiece;
import com.solarwindsmsp.chess.piece.PieceColor;
import com.solarwindsmsp.chess.piece.PieceFactory;
import com.solarwindsmsp.chess.piece.PieceType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PositionTest {

    private Position testSubject;
    private PieceFactory pieceFactory;

    @Before
    public void setUp() {
        this.testSubject = new Position();
        this.pieceFactory = PieceFactory.getInstance();
    }

    @Test
    public void getPieceFromEmptyPosition() {
        assertNull(testSubject.getPiece());
    }

    @Test
    public void getPieceFromPosition() throws Exception {
        IPiece pawn = pieceFactory.getPiece(PieceType.PAWN, PieceColor.WHITE);
        testSubject.setPiece(pawn);

        assertEquals(pawn, testSubject.getPiece());
    }

}