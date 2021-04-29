package com.sezzle.calculator.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DividerTest {

    @Test
    void testExecuteShouldReturn5() {
        Number result = new Divider().execute(new Number("15"), new Number("3"));
        assertEquals(new Number("5"), result);
    }

}