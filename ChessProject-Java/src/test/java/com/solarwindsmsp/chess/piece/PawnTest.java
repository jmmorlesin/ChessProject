package com.solarwindsmsp.chess.piece;

import com.solarwindsmsp.chess.board.InitialPosition;
import com.solarwindsmsp.chess.movement.InvalidMovement;
import com.solarwindsmsp.chess.movement.MovementType;
import com.solarwindsmsp.chess.coordinate.Coordinate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class PawnTest {

    private Pawn testSubject;
    private MovementType movementType = MovementType.MOVE;

    @Before
    public void setUp() {
        this.testSubject = new Pawn(PieceColor.WHITE);
    }

    @Test
    public void checkColor() {
        assertEquals(testSubject.getPieceColor(), PieceColor.WHITE);
    }

    @Test
    public void checkType() {
        assertEquals(testSubject.getPieceType(), PieceType.PAWN);
    }

    @Test
    public void checkValidMovement() throws Exception {
        Coordinate coordinate = new Coordinate(0, 1);
        Coordinate newCoordinate = new Coordinate(0, 2);
        assertTrue(testSubject.isValidMovement(movementType, coordinate, newCoordinate));
    }

    @Test
    public void checkValidInitialMovement() throws Exception {
        Coordinate coordinate = new Coordinate(0, 1);
        Coordinate newCoordinate = new Coordinate(0, 3);
        assertTrue(testSubject.isValidMovement(movementType, coordinate, newCoordinate));
    }

    @Test
    public void checkValidMovementFromTop() throws Exception {
        Coordinate coordinate = new Coordinate(0, 6);
        Coordinate newCoordinate = new Coordinate(0, 5);
        testSubject.setInitialPosition(InitialPosition.TOP);
        assertTrue(testSubject.isValidMovement(movementType, coordinate, newCoordinate));
    }

    @Test
    public void checkInValidForwardMovement() throws Exception {
        Coordinate coordinate = new Coordinate(0, 1);
        Coordinate newCoordinate = new Coordinate(0, 4);
        assertFalse(testSubject.isValidMovement(movementType, coordinate, newCoordinate));
    }

    @Test
    public void checkInValidBackMovement() throws Exception {
        Coordinate coordinate = new Coordinate(0, 1);
        Coordinate newCoordinate = new Coordinate(0, 0);
        assertFalse(testSubject.isValidMovement(movementType, coordinate, newCoordinate));
    }

    @Test
    public void checkInValidLateralMovement() throws Exception {
        Coordinate coordinate = new Coordinate(0, 1);
        Coordinate newCoordinate = new Coordinate(1, 1);
        assertFalse(testSubject.isValidMovement(movementType, coordinate, newCoordinate));
    }

    @Test
    public void checkInValidDiagonalMovement() throws Exception {
        Coordinate coordinate = new Coordinate(0, 1);
        Coordinate newCoordinate = new Coordinate(1, 2);
        assertFalse(testSubject.isValidMovement(movementType, coordinate, newCoordinate));
    }

    //This test will become invalid once the capture movement is implemented
    @Test(expected = InvalidMovement.class)
    public void checkCaptureNotValidYet() throws Exception {
        Coordinate coordinate = new Coordinate(0, 1);
        Coordinate newCoordinate = new Coordinate(1, 2);

        assertFalse(testSubject.isValidMovement(MovementType.CAPTURE, coordinate, newCoordinate));
    }

    @Test
    public void testToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Initial position: BOTTOM");
        sb.append(System.lineSeparator());
        sb.append("Piece color: WHITE");
        assertEquals(sb.toString(), testSubject.toString());
    }

}