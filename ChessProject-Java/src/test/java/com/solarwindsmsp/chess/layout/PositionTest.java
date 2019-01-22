package com.solarwindsmsp.chess.layout;

import com.solarwindsmsp.chess.piece.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PositionTest {

    private Position testSubject;

    @Before
    public void setUp() {
        testSubject = new Position();
    }

    @Test
    public void getPieceFromEmptyPosition() {
        assertNull(testSubject.getPiece());
    }

    @Test
    public void getPieceFromPosition() {
        IPiece pawn = PieceHelper.getPieceMock(PieceType.PAWN, PieceColor.WHITE);
        testSubject.setPiece(pawn);

        assertEquals(pawn, testSubject.getPiece());
    }

}