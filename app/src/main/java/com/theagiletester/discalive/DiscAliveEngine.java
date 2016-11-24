package com.theagiletester.discalive;

import android.app.Activity;

/**
 * Created by timwalker on 11/19/16.
 */

public class DiscAliveEngine {
    DiscAliveReader discAliveReader = null;
    StringBuffer payload = new StringBuffer(1024);
    Activity mActivity;

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

    public boolean initialize() {
        return this.discAliveReader.initialize();

    }

    public void setActivity(Activity activity){
        this.mActivity = activity;
    }

    public String getPayload() {
        return payload.toString();
    }
}