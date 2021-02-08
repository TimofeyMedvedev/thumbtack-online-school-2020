package net.thumbtack.school.misc.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMalePatience {
    @Test
    public void testMalePatience1() {
        MalePatience patience = new MalePatience("Frank", 23, 12000);
        assertAll(
                () -> assertEquals("Frank", patience.getNameHusband()),
                () -> assertEquals(23, patience.getDailyPatience()),
                () -> assertEquals(12000, patience.getTotalPatience())
        );
    }

    @Test
    public void testMalePatience2() {
        MalePatience patience = new MalePatience("Frank", 12000);
        assertAll(
                () -> assertEquals("Frank", patience.getNameHusband()),
                () -> assertEquals(0, patience.getDailyPatience()),
                () -> assertEquals(12000, patience.getTotalPatience())
        );
    }

    @Test
    public void testMalePatience3() {
        MalePatience patience = new MalePatience("Frank");
        assertAll(
                () -> assertEquals("Frank", patience.getNameHusband()),
                () -> assertEquals(0, patience.getDailyPatience()),
                () -> assertEquals(0, patience.getTotalPatience())
        );
    }

    @Test
    public void testSetName() {
        MalePatience patience = new MalePatience("Frank");
        patience.setNameHusband("Zork");
        assertEquals("Zork", patience.getNameHusband());
    }

    @Test
    public void testArea() {
        MalePatience patience = new MalePatience("Frank", 10, 13000);
        assertEquals(12987000, patience.getArea());
    }

    @Test
    public void testStretchAndResize() {
        MalePatience patience = new MalePatience("Frank", 10, 13000);
        patience.stretch(4, 5.6);
        assertEquals(40, patience.getDailyPatience());
        assertEquals(72800, patience.getTotalPatience());

        patience.stretch(100, 5.6);
        assertEquals(0, patience.getDailyPatience());
        assertEquals(407680, patience.getTotalPatience());

        patience = new MalePatience("Frank", 10, 13000);
        patience.resize(0.52);
        assertEquals(5, patience.getDailyPatience());
        assertEquals(6760, patience.getTotalPatience());
    }

    @Test
    public void testEqualsMalePatience() {
        MalePatience patience1 = new MalePatience("Frank", 10, 13000);
        MalePatience patience2 = new MalePatience("Asdf", 100, 100);
        MalePatience patience3 = new MalePatience("Frank", 10, 13000);
        assertEquals(patience1, patience3);
        assertNotEquals(patience1, patience2);
    }
}
