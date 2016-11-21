package com.theagiletester.discalive;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class NFCReaderUnitTest {

    @Test
    public void itShouldReportThatThereAreNFCDevicesWithinReadRangeWhenThereAre() {
        DiscAliveReaderInterface NFCReaderService = new mockNFCReaderServiceWhenRfidsPresent();
        assertThat(NFCReaderService.detectSmartDisc(0), is(true));
    }

    @Test
    public void itShouldReturnASmartDiscPayloadWhenReadingASmartDisc() {
        DiscAliveReaderInterface NFCReaderService = new mockNFCReaderServiceWhenRfidsPresent();
        assertThat(NFCReaderService.readSmartDisc(), is("SmartDisc Payload"));
    }

    @Test
    public void itShouldReportThatThereAreNoNFCDevicesWithinReadRangeWhenThereAreNot() {
        DiscAliveReaderInterface NFCReaderService = new mockNFCReaderServiceWhenRfidsAreNotPresent();
        assertThat(NFCReaderService.detectSmartDisc(0), is(false));
    }

    @Test
    public void itShouldReturnANullPayloadWhenThereAreNoSmartDiscsReadyToRead() {
        DiscAliveReaderInterface NFCReaderService = new mockNFCReaderServiceWhenRfidsAreNotPresent();
        assertThat(NFCReaderService.readSmartDisc(), is(nullValue()));
    }

}


