package com.solarwindsmsp.chess.piece;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PieceFactoryTest {

    private PieceFactory testSubject;

    @Before
    public void setUp() {
        testSubject = PieceFactory.getInstance();
    }

    @Test
    public void checkClassPawn() throws Exception {
        assertEquals(Pawn.class, testSubject.getPiece(PieceType.PAWN, PieceColor.BLACK).getClass());
    }

    @Test
    public void checkPawnProperties() throws Exception {
        IPiece pawn = testSubject.getPiece(PieceType.PAWN, PieceColor.BLACK);
        assertEquals(pawn.getPieceColor(), PieceColor.BLACK);
        assertEquals(pawn.getPieceType(), PieceType.PAWN);
    }

    @Test(expected = InvalidPiece.class)
    public void checkPieceNotAvailableYet() throws Exception {
        testSubject.getPiece(PieceType.KING, PieceColor.BLACK);
    }

    @Test
    public void checkSingleton() {
        assertEquals(testSubject, PieceFactory.getInstance());
    }

}