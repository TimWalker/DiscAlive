package com.theagiletester.discalive;

/**
 * Created by timwalker on 11/20/16.
 */

public class DiscAliveReader implements DiscAliveReaderInterface{
    public boolean detectSmartDisc(int seconds) {
        return false;
    };

    public String readSmartDisc() {
        return "";
    };

    public boolean initialize() { return true; }
}
