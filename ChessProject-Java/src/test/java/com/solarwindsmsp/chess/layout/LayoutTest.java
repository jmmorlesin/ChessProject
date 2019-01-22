package com.solarwindsmsp.chess.layout;

import com.solarwindsmsp.chess.coordinate.Coordinate;
import com.solarwindsmsp.chess.piece.IPiece;
import com.solarwindsmsp.chess.piece.InvalidPiece;
import com.solarwindsmsp.chess.piece.PieceColor;
import com.solarwindsmsp.chess.piece.PieceFactory;
import com.solarwindsmsp.chess.piece.PieceType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class LayoutTest {

    private Layout testSubject;
    private PieceFactory pieceFactory;

    @Before
    public void setUp() {
        testSubject = new Layout(8, 8);
        pieceFactory = PieceFactory.getInstance();
    }

    @Test
    public void addAndGetPieceValidPosition() throws Exception{
        IPiece pawn = pieceFactory.getPiece(PieceType.PAWN, PieceColor.BLACK);
        Coordinate coordinate = new Coordinate(0, 1);
        testSubject.addPiece(pawn, coordinate);

        assertEquals(pawn, testSubject.getPieceFromPosition(coordinate));
    }

    @Test(expected = InvalidPiece.class)
    public void addInvalidPiece() throws Exception{
        IPiece pawn = pieceFactory.getPiece(PieceType.KNIGHT, PieceColor.BLACK);
        Coordinate coordinate = new Coordinate(0, 1);
        testSubject.addPiece(pawn, coordinate);
    }

    @Test
    public void checkValidCoordinates() {
        assertTrue(testSubject.isValidCoordinate(new Coordinate(0, 0)));
        assertTrue(testSubject.isValidCoordinate(new Coordinate(5, 5)));
        assertTrue(testSubject.isValidCoordinate(new Coordinate(7, 7)));
        assertTrue(testSubject.isValidCoordinate(new Coordinate(0, 1)));
    }

    @Test
    public void checkInValidNegativesCoordinates() {
        assertFalse(testSubject.isValidCoordinate(new Coordinate(-1, 0)));
        assertFalse(testSubject.isValidCoordinate(new Coordinate(0, -1)));
    }

    @Test
    public void checkInValidOutOfRangeCoordinates() {
        assertFalse(testSubject.isValidCoordinate(new Coordinate(8, 7)));
        assertFalse(testSubject.isValidCoordinate(new Coordinate(11, 5)));
        assertFalse(testSubject.isValidCoordinate(new Coordinate(6, 9)));
    }

    @Test
    public void checkValidMovement() throws Exception{
        IPiece pawn = pieceFactory.getPiece(PieceType.PAWN, PieceColor.WHITE);
        Coordinate coordinate = new Coordinate(0, 1);
        testSubject.addPiece(pawn, coordinate);

        Coordinate newCoordinate = new Coordinate(0, 2);
        assertNull(testSubject.movePiece(coordinate, newCoordinate));

        assertNull(testSubject.getPieceFromPosition(coordinate));
        assertEquals(pawn, testSubject.getPieceFromPosition(newCoordinate));
    }

    @Test(expected = InvalidPosition.class)
    public void checkInValidMovementOutBoard() throws Exception{
        IPiece pawn = pieceFactory.getPiece(PieceType.PAWN, PieceColor.WHITE);
        Coordinate coordinate = new Coordinate(0, 1);
        testSubject.addPiece(pawn, coordinate);

        Coordinate newCoordinate = new Coordinate(0, 8);
        assertNull(testSubject.movePiece(coordinate, newCoordinate));
    }

}