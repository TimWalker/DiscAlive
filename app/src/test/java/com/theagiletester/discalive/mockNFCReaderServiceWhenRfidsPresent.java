package com.theagiletester.discalive;

/**
 * Created by timwalker on 11/19/16.
 */

public class mockNFCReaderServiceWhenRfidsPresent implements DiscAliveReaderInterface {

    public boolean detectRfids(int seconds) {
        return true;
    }

    public String readRdid() {
        return "Beast";
    }
}
