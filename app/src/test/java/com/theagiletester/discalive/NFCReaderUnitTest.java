package com.theagiletester.discalive;

import org.junit.Test;

public class NFCReaderUnitTest {

    @Test
    public void itShouldDetectRfidsPresent() {
        DiscAliveEngine rfidReaderService = new DiscAliveEngine(new mockRfidReader());
    }
}


