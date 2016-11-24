package com.theagiletester.discalive;

/**
 * Created by timwalker on 11/19/16.
 */

public class mockNFCReaderServiceWhenRfidsPresent implements DiscAliveReaderInterface {

    @Override
    public boolean detectSmartDisc(int seconds) {
        return true;
    }

    @Override
    public String readSmartDisc() {
        return "SmartDisc Payload";
    }

    @Override
    public boolean initialize() { return false; }
}
