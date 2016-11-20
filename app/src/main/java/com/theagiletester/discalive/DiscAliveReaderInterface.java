package com.theagiletester.discalive;

public interface DiscAliveReaderInterface {
    public boolean detectRfids(int seconds);
    public String readRdid();
}
