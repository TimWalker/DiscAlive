package com.theagiletester.discalive;

/**
 * Created by timwalker on 11/20/16.
 */

public class mockNFCReaderServiceWhenRfidsAreNotPresent implements DiscAliveReaderInterface {

    @Override
    public boolean detectSmartDisc(int seconds) {
        return false;
    }

    @Override
    public String readSmartDisc() {
        return null;
    }
}