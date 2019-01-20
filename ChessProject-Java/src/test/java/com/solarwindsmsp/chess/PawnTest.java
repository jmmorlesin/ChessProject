package com.solarwindsmsp.chess;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PawnTest {

    private ChessBoard chessBoard;
    private Pawn testSubjectBlack;
    private Pawn testSubjectWhite;
    private Pawn testSubjectWhiteTop;
    private Pawn testSubjectBlackBottom;

    @Before
    public void setUp() {
        this.chessBoard = new ChessBoard();
        this.testSubjectBlack = new Pawn(PieceColor.BLACK);
        this.testSubjectWhite = new Pawn(PieceColor.WHITE);
        this.testSubjectWhiteTop = new Pawn(PieceColor.WHITE);
        this.testSubjectWhiteTop.setInitialPosition(InitialPosition.TOP);
        this.testSubjectBlackBottom = new Pawn(PieceColor.BLACK);
        this.testSubjectBlackBottom.setInitialPosition(InitialPosition.BOTTOM);
    }

    @Test
    public void chessBoard_Add_Sets_XCoordinate() {
        this.chessBoard.add(testSubjectBlack, 6, 3);
        assertEquals(6, testSubjectBlack.getXCoordinate());
    }

    @Test
    public void chessBoard_Add_Sets_YCoordinate() {
        this.chessBoard.add(testSubjectBlack, 6, 3);
        assertEquals(3, testSubjectBlack.getYCoordinate());
    }

    @Test
    public void chessBoard_Add_Sets_PieceColor() {
        this.chessBoard.add(testSubjectBlack, 6, 3);
        assertEquals(PieceColor.BLACK, testSubjectBlack.getPieceColor());
    }

    @Test
    public void chessBoard_Add() {
        this.chessBoard.add(testSubjectBlack, 6, 3);
        assertEquals(6, testSubjectBlack.getXCoordinate());
        assertEquals(3, testSubjectBlack.getYCoordinate());
        assertEquals(PieceColor.BLACK, testSubjectBlack.getPieceColor());
    }


    @Test
    public void pawn_Move_IllegalCoordinates_Right_DoesNotMove() {
        chessBoard.add(testSubjectBlack, 6, 3);
        testSubjectBlack.move(MovementType.MOVE, 7, 3);
        assertEquals(6, testSubjectBlack.getXCoordinate());
        assertEquals(3, testSubjectBlack.getYCoordinate());
        assertEquals(PieceColor.BLACK, testSubjectBlack.getPieceColor());
    }

    @Test
    public void pawn_Move_IllegalCoordinates_Left_DoesNotMove() {
        chessBoard.add(testSubjectBlack, 6, 3);
        testSubjectBlack.move(MovementType.MOVE, 4, 3);
        assertEquals(6, testSubjectBlack.getXCoordinate());
        assertEquals(3, testSubjectBlack.getYCoordinate());
        assertEquals(PieceColor.BLACK, testSubjectBlack.getPieceColor());
    }

    @Test
    public void pawn_Move_LegalCoordinates_Forward_UpdatesCoordinates_TopBoard() {
        chessBoard.add(testSubjectBlack, 6, 3);
        testSubjectBlack.move(MovementType.MOVE, 6, 2);
        assertEquals(6, testSubjectBlack.getXCoordinate());
        assertEquals(2, testSubjectBlack.getYCoordinate());
        assertEquals(PieceColor.BLACK, testSubjectBlack.getPieceColor());
    }

    @Test
    public void pawn_Move_LegalCoordinates_DoubleForward() {
        chessBoard.add(testSubjectBlack, 6, 6);
        testSubjectBlack.move(MovementType.MOVE, 6, 4);
        assertEquals(6, testSubjectBlack.getXCoordinate());
        assertEquals(4, testSubjectBlack.getYCoordinate());
        assertEquals(PieceColor.BLACK, testSubjectBlack.getPieceColor());
    }

    @Test
    public void pawn_Move_IllegalCoordinates_DoubleForward() {
        chessBoard.add(testSubjectBlack, 6, 5);
        testSubjectBlack.move(MovementType.MOVE, 6, 3);
        assertEquals(6, testSubjectBlack.getXCoordinate());
        assertEquals(5, testSubjectBlack.getYCoordinate());
        assertEquals(PieceColor.BLACK, testSubjectBlack.getPieceColor());
    }

    @Test
    public void pawn_Move_LegalCoordinates_Forward_UpdatesCoordinates_BottomBoard() {
        chessBoard.add(testSubjectWhite, 6, 3);
        testSubjectWhite.move(MovementType.MOVE, 6, 4);
        assertEquals(6, testSubjectWhite.getXCoordinate());
        assertEquals(4, testSubjectWhite.getYCoordinate());
        assertEquals(PieceColor.WHITE, testSubjectWhite.getPieceColor());
    }

    @Test
    public void pawn_Move_LegalCoordinates_Forward_UpdatesCoordinates_BlackBottomBoard() {
        chessBoard.add(testSubjectBlackBottom, 6, 3);
        testSubjectBlackBottom.move(MovementType.MOVE, 6, 4);
        assertEquals(6, testSubjectBlackBottom.getXCoordinate());
        assertEquals(4, testSubjectBlackBottom.getYCoordinate());
        assertEquals(PieceColor.BLACK, testSubjectBlackBottom.getPieceColor());
    }

    @Test
    public void pawn_Move_LegalCoordinates_Forward_UpdatesCoordinates_WhiteTopBoard() {
        chessBoard.add(testSubjectWhiteTop, 6, 3);
        testSubjectWhiteTop.move(MovementType.MOVE, 6, 2);
        assertEquals(6, testSubjectWhiteTop.getXCoordinate());
        assertEquals(2, testSubjectWhiteTop.getYCoordinate());
        assertEquals(PieceColor.WHITE, testSubjectWhiteTop.getPieceColor());
    }

}