package io.ezekielamitchell;

import org.junit.jupiter.api.Assertions;

class MainTest {

    @org.junit.jupiter.api.Test
    void testString() {
        Assertions.assertTrue(new Builder().testString("2.5"));
    }
}