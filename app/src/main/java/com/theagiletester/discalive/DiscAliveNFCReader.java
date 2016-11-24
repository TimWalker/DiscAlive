package com.theagiletester.discalive;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.nfc.NfcAdapter.*;
import android.nfc.NfcAdapter.ReaderCallback;
import android.app.Activity;
import android.nfc.Tag;
//Todo: Get rid of dependencies for this class for diagnostic only
import android.util.Log;
import android.widget.Toast;

import android.content.Intent;
import android.app.PendingIntent;

/**
 * Created by timwalker on 11/20/16.
 */

public class DiscAliveNFCReader extends DiscAliveReader implements DiscAliveReaderInterface {

    NfcAdapter mNfcAdapter;
    Context mContext;
    Activity mActivity;

    public DiscAliveNFCReader(Context context) {
        Log.d("Cucumber", "Getting an NFCAdapter with context: " + context.toString());
        try {
            mNfcAdapter = NfcAdapter.getDefaultAdapter(context);
            Log.d("Cucumber", "Obtained an NFC Adapter: " + mNfcAdapter.toString());
            if ( (mNfcAdapter != null) && (mNfcAdapter.isEnabled()) ) {
                Log.d("Cucumber", "NFC Adapter is enabled");
            }
        }
        catch (Exception e) {
            Log.d("Cucumber", "Exception getting an NfcAdapter: " + e.getMessage());
        }
    }

    public DiscAliveNFCReader() {
        Log.d("Cucumber", "Getting an NFCAdapter");
        try {
            mNfcAdapter = NfcAdapter.getDefaultAdapter(MainActivity.myContext);
            Log.d("Cucumber", "Obtained an NFC Adapter: " + mNfcAdapter.toString());
            if ( (mNfcAdapter != null) && (mNfcAdapter.isEnabled()) ) {
                Log.d("Cucumber", "NFC Adapter is enabled");
            }
        }
        catch (Exception e) {
            Log.d("Cucumber", "Exception getting an NfcAdapter: " + e.getMessage());
        }
    };

    public boolean initialize()
    {

        if (mNfcAdapter == null)
            return false;

//        if (!enable) {
//            nfcAdapter.disableReaderMode(activity);
//            return;
//        }

//        Bundle opts = new Bundle();
//        opts.putInt(NfcAdapter.EXTRA_READER_PRESENCE_CHECK_DELAY, 5000);

        int flags = NfcAdapter.FLAG_READER_SKIP_NDEF_CHECK;
        flags |= NfcAdapter.FLAG_READER_NFC_A;

//        mNfcAdapter.enableReaderMode(mActivity, new ReaderCallback() {
//            @Override
//            public void onTagDiscovered(Tag tag) {
//                Log.d("Cucumber NFC Reader", "Tag Discovered: " + tag.toString());
//            }
//        }, flags, null);

        return true;
    }

    public void setActivity(Activity activity) {
        mActivity = activity;
    }

    public boolean detectSmartDisc(int seconds) {
        return false;
    };

    public String readSmartDisc() {
        return "";
    };

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        mTextView = (TextView) findViewById(R.id.textView_explanation);
//
//        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
//
//        if (mNfcAdapter == null) {
//            // Stop here, we definitely need NFC
//            Toast.makeText(this, "This device doesn't support NFC.", Toast.LENGTH_LONG).show();
//            finish();
//            return;
//
//        }
//
//        if (!mNfcAdapter.isEnabled()) {
//            mTextView.setText("NFC is disabled.");
//        } else {
//            mTextView.setText(R.string.explanation);
//        }
//
//        handleIntent(getIntent());
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
//    }
//
//    private void handleIntent(Intent intent) {
//        // TODO: handle Intent
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client.connect();
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Main Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app URL is correct.
//                Uri.parse("android-app://com.example.theagiletester.discalive/http/host/path")
//        );
//        AppIndex.AppIndexApi.start(client, viewAction);
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Main Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app URL is correct.
//                Uri.parse("android-app://com.example.theagiletester.discalive/http/host/path")
//        );
//        AppIndex.AppIndexApi.end(client, viewAction);
//        client.disconnect();
//    }

    /***/



}
