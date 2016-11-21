package com.theagiletester.discalive.test;

import com.theagiletester.discalive.DiscAliveReaderInterface;

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
}
