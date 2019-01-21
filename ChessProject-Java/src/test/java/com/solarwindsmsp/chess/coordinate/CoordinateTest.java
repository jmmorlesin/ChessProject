package com.solarwindsmsp.chess.coordinate;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinateTest {

    private Coordinate testSubject;

    @Before
    public void setUp() {
        this.testSubject = new Coordinate(1, 0);
    }

    @Test
    public void checkValues() {
        assertEquals(1, testSubject.getX());
        assertEquals(0, testSubject.getY());
    }

    @Test
    public void setXCoordinate() {
        testSubject.setX(5);
        assertEquals(5, testSubject.getX());
    }

    @Test
    public void setYCoordinate() {
        testSubject.setY(4);
        assertEquals(4, testSubject.getY());
    }

}