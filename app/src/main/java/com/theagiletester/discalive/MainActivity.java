package com.theagiletester.discalive;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.view.View;
import android.os.Parcelable;
import android.widget.VideoView;
import android.widget.MediaController;

import android.nfc.NdefMessage;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.theagiletester.discalive.R.*;
import static com.theagiletester.discalive.R.layout.*;
public class MainActivity extends Activity {

    DiscAliveEngine dae;

    public static final String TAG = "NfcDemo";
    public static Context myContext;
    private TextView mTextView;
    private NfcAdapter mNfcAdapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myContext = getApplicationContext();
        setContentView(activity_main);
        addListenerOnButton();
        dae = new DiscAliveEngine(new DiscAliveNFCReader());
        Log.d("onStart", "onCreate" + "," + myContext);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("onStart", "onStart");
    }

    public void addListenerOnButton() {

        ImageButton imageButton = (ImageButton) findViewById(id.comeAliveButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Cucumber", "Clicking DiscAlive!");
                dae.detectSmartDiscs();
                dae.getPayload();
            }
        });
    }

    @Override
    public void onNewIntent(Intent intent)
    {
        Log.d("Cucumber","NFC Intent: " + intent.toString());
        setIntent(intent);
        resolveIntent(intent);
    }

    private void resolveIntent(Intent intent) {
        String action = intent.getAction();
        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {
            Parcelable[] rawMsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
            if (rawMsgs != null) {
                Log.d("Cucumber NFC", "rawMsg has content: " + rawMsgs.toString());
                NdefMessage[] msgs = new NdefMessage[rawMsgs.length];
                for (int i = 0; i < rawMsgs.length; i++)
                {
                    msgs[i] = (NdefMessage) rawMsgs[i];
                }
                String tagId = new String(msgs[0].getRecords()[0].getType());
                String body = new String(msgs[0].getRecords()[0].getPayload());
                Log.d("Cucumber NFC", "tagId: " + tagId.toString() + "body: " + body.toString());
            }
        }
    }

    @Override
    public void onStop() {
        super.onStop();
   }

    private class GoogleApiClient {
    }

}