package com.theagiletester.discalive;

/**
 * Created by timwalker on 11/19/16.
 */

public class DiscAliveEngine {
    DiscAliveReader discAliveReader = null;
    StringBuffer payload = new StringBuffer(1024);

    public DiscAliveEngine(DiscAliveReader discAliveReader) {
        this.discAliveReader = discAliveReader;
    }

    public boolean detectSmartDiscs() {
        return discAliveReader.detectSmartDisc(0);
    }

    public boolean readSmartDisc() {
        payload.append(discAliveReader.readSmartDisc());
        return true;
    }

    public String getPayload() {
        return payload.toString();
    }
}