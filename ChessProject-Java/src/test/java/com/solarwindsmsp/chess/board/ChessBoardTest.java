package com.solarwindsmsp.chess.board;

import com.solarwindsmsp.chess.coordinate.Coordinate;
import com.solarwindsmsp.chess.layout.ILayout;
import com.solarwindsmsp.chess.layout.IllegalPosition;
import com.solarwindsmsp.chess.layout.InvalidPosition;
import com.solarwindsmsp.chess.movement.InvalidMovement;
import com.solarwindsmsp.chess.movement.MovementType;
import com.solarwindsmsp.chess.piece.IPiece;
import com.solarwindsmsp.chess.piece.PieceColor;
import com.solarwindsmsp.chess.piece.PieceFactory;
import com.solarwindsmsp.chess.piece.PieceType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChessBoardTest {

    private ChessBoard testSubject;
    private PieceFactory pieceFactory;
    private Coordinate coordinate;
    private MovementType movementType;

    @Before
    public void setUp() {
        testSubject = new ChessBoard();
        pieceFactory = PieceFactory.getInstance();
        coordinate = new Coordinate(1, 1);
        movementType = MovementType.MOVE;
    }

    @Test
    public void hasMaxBoardWidthOf8() {
        assertEquals(8, testSubject.getMaxWidth());
    }

    @Test
    public void hasMaxBoardHeightOf8() {
        assertEquals(8, testSubject.getMaxHeight());
    }


    @Test
    public void addValidPawn() throws Exception{
        IPiece pawn = pieceFactory.getPiece(PieceType.PAWN, PieceColor.WHITE);
        testSubject.add(pawn, coordinate);
    }

    @Test(expected = IllegalPosition.class)
    public void addPawnIllegalPosition() throws Exception{
        IPiece pawn = pieceFactory.getPiece(PieceType.PAWN, PieceColor.WHITE);
        testSubject.add(pawn, new Coordinate(8, 1));
    }

    @Test(expected = NotEmptyPosition.class)
    public void addPawnNotEmptyPosition() throws Exception{
        testSubject.add(pieceFactory.getPiece(PieceType.PAWN, PieceColor.WHITE), coordinate);
        testSubject.add(pieceFactory.getPiece(PieceType.PAWN, PieceColor.WHITE), coordinate);
    }

    @Test
    public void checkValidMovement() throws Exception{
        IPiece pawn = pieceFactory.getPiece(PieceType.PAWN, PieceColor.WHITE);
        Coordinate newCoordinate = new Coordinate(1, 2);
        testSubject.add(pawn, coordinate);

        testSubject.move(movementType, coordinate, newCoordinate);
        ILayout layout = testSubject.getLayout();
        assertEquals(pawn, layout.getPieceFromPosition(newCoordinate));
    }

    @Test(expected = InvalidPosition.class)
    public void checkInvalidDestinationPosition() throws Exception{
        IPiece pawn = pieceFactory.getPiece(PieceType.PAWN, PieceColor.WHITE);
        Coordinate newCoordinate = new Coordinate(0, 9);
        testSubject.add(pawn, coordinate);

        testSubject.move(movementType, coordinate, newCoordinate);
    }

    @Test(expected = InvalidPosition.class)
    public void checkInvalidOriginPosition() throws Exception{
        IPiece pawn = pieceFactory.getPiece(PieceType.PAWN, PieceColor.WHITE);
        Coordinate coordinate = new Coordinate(0, -1);
        Coordinate newCoordinate = new Coordinate(0, 4);
        testSubject.add(pawn, new Coordinate(0, 1));

        testSubject.move(movementType, coordinate, newCoordinate);
    }

    @Test(expected = InvalidMovement.class)
    public void checkInvalidMovement() throws Exception{
        IPiece pawn = pieceFactory.getPiece(PieceType.PAWN, PieceColor.WHITE);
        Coordinate newCoordinate = new Coordinate(0, 4);
        testSubject.add(pawn, coordinate);

        testSubject.move(movementType, coordinate, newCoordinate);
    }

    //Probably this test is not needed because the conditions has been tested in an isolated way in specific test.
    @Test
    public void limitsTheNumberOfPawns() throws Exception{
        for (int i = 0; i < 10; i++)
        {
            IPiece pawn = pieceFactory.getPiece(PieceType.PAWN, PieceColor.BLACK);
            int row = i / testSubject.getMaxWidth();

            Coordinate coordinate = new Coordinate(7 + row, i % testSubject.getMaxWidth());
            if (row < 1)
            {
                testSubject.add(pawn, coordinate);
                ILayout layout = testSubject.getLayout();
                assertEquals(pawn, layout.getPieceFromPosition(coordinate));
            }
            else
            {
                try {
                    testSubject.add(pawn, coordinate);
                } catch (Exception e) {
                    assertEquals(IllegalPosition.class, e.getClass());
                }
            }
        }
    }

}