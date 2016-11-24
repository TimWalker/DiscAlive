package com.theagiletester.discalive;
import android.app.Activity;
import android.app.PendingIntent;
import android.speech.tts.TextToSpeech;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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

import android.media.MediaPlayer;
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
//        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
//        if (nfcAdapter == null) {
//            // Stop here, we definitely need NFC
//            Toast.makeText(this, "This device doesn't support NFC.", Toast.LENGTH_LONG).show();
//            finish();
//        }
        Log.d("Cucumber", "Established an NfcAdapter");
        readFromIntent(getIntent());

//        IntentFilter tagDetected = new IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
//        tagDetected.addCategory(Intent.CATEGORY_DEFAULT);

        //writeTagFilters = new IntentFilter[] { tagDetected };
        Log.d("Cucumber", "onCreate" + "," + myContext);
    }

    private void readFromIntent(Intent intent) {
        String action = intent.getAction();
        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {
            Parcelable[] rawMsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
            NdefMessage[] msgs = null;
            if (rawMsgs != null) {
                msgs = new NdefMessage[rawMsgs.length];
                for (int i = 0; i < rawMsgs.length; i++) {
                    msgs[i] = (NdefMessage) rawMsgs[i];
                }
            }
            buildTagViews(msgs);
        }
    }
    private void buildTagViews(NdefMessage[] msgs) {
        if (msgs == null || msgs.length == 0) return;

        String text = "";
//        String tagId = new String(msgs[0].getRecords()[0].getType());
        byte[] payload = msgs[0].getRecords()[0].getPayload();
        String textEncoding = ((payload[0] & 128) == 0) ? "UTF-8" : "UTF-16"; // Get the Text Encoding
        int languageCodeLength = payload[0] & 0063; // Get the Language Code, e.g. "en"
        // String languageCode = new String(payload, 1, languageCodeLength, "US-ASCII");

        try {
            // Get the Text
            text = new String(payload, languageCodeLength + 1, payload.length - languageCodeLength - 1, textEncoding);
        } catch (Exception e) {
            Log.e("UnsupportedEncoding", e.toString());
        }

        //tvNFCContent.setText("NFC Content: " + text);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("onStart", "onStart");
//        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), raw.greetings);
//        mp.start();
//
//        //private EditText write;
//        TextToSpeech ttobj=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//            @Override
//            public void onInit(int status) {
//            }
//        });
//
//        ttobj.speak("The rain in spain", TextToSpeech.QUEUE_FLUSH, null);
    }

    public void addListenerOnButton() {

        ImageButton imageButton = (ImageButton) findViewById(id.comeAliveButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Cucumber", "Clicking DiscAlive!");
                dae.initialize();
                /*
                    TODO Investigate a non-intent read direct from nfc as in these interfaces
                    dae.detectSmartDiscs();
                    dae.getPayload();
                */
            }
        });
    }

    @Override
    public void onNewIntent(Intent intent)
    {
        Log.d("Cucumber","NFC Intent: " + intent.toString());
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), raw.smartdisc_detected);
        mp.start();
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