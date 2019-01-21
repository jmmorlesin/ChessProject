package com.solarwindsmsp.chess.board;

import com.solarwindsmsp.chess.coordinate.Coordinate;
import com.solarwindsmsp.chess.layout.ILayout;
import com.solarwindsmsp.chess.layout.Layout;


public abstract class Board implements IBoard {

    protected ILayout layout;
    private int maxWidth;
    private int maxHeight;

    public Board(int maxWidth, int maxHeight) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        layout = new Layout(maxWidth, maxHeight);
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    protected boolean isLegalBoardPosition(Coordinate coordinate) {
        return layout.isValidCoordinate(coordinate);
    }

    protected boolean isEmpty(Coordinate coordinate) {
        return layout.getPieceFromPosition(coordinate) == null;
    }

    @Override
    public ILayout getLayout() {
        return layout;
    }

}
