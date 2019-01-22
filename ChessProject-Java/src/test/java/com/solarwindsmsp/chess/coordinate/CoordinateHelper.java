package com.solarwindsmsp.chess.coordinate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CoordinateHelper {

    public Coordinate getCoordinateMock(int x, int y) {
        Coordinate coordinate = mock(Coordinate.class);
        when(coordinate.getX()).thenReturn(x);
        when(coordinate.getY()).thenReturn(y);
        return coordinate;
    }

}
