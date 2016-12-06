package com.theagiletester.discalive;

/**
 * Created by timwalker on 11/22/16.
 */


//import com.example.android.apis.R;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.nfc.NfcAdapter;
import android.nfc.tech.NfcF;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import static com.theagiletester.discalive.R.layout.activity_main;
import static com.theagiletester.discalive.R.layout.activity_nfc;

import android.nfc.Tag;
import android.speech.tts.TextToSpeech;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.tech.Ndef;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Locale;

/**
 * An example of how to use the NFC foreground dispatch APIs. This will intercept any MIME data
 * based NDEF dispatch as well as all dispatched for NfcF tags.
 */

public class NfcActivity extends Activity {
    private NfcAdapter mAdapter;
    private PendingIntent mPendingIntent;
    private IntentFilter[] mFilters;
    private String[][] mTechLists;
    private TextView mText;
    private TextView mTextView;
    private int mCount = 0;

    public static final String MIME_TEXT_PLAIN = "text/plain";

    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        setContentView(activity_nfc);

        Log.d("Cucumber NFC", "nfcActivity onCreate with " + savedState);

        mTextView = (TextView) findViewById(R.id.textViewNfcResult);

        mAdapter = NfcAdapter.getDefaultAdapter(this);

        // Create a generic PendingIntent that will be deliver to this activity. The NFC stack
        // will fill in the intent with the details of the discovered tag before delivering to
        // this activity.
        mPendingIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

        Log.d("Cucumber NFC", "PendingIntent: " + mPendingIntent.toString());

        // Setup an intent filter for all MIME based dispatches
        IntentFilter ndef = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
        try {
            ndef.addDataType("*/*");
        } catch (MalformedMimeTypeException e) {
            throw new RuntimeException("fail", e);
        }
        mFilters = new IntentFilter[]{
                ndef,
        };
        // Setup a tech list for all NfcF tags
        mTechLists = new String[][]{new String[]{NfcF.class.getName()}};

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Cucumber NFC", "onResume");
        if (mAdapter != null) {
            mAdapter.enableForegroundDispatch(this, mPendingIntent, mFilters,
                    mTechLists);
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        Log.d("Cucumber NFC", "Discovered tag with intent: " + intent);
        handleIntent(intent);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Cucumber NFC", "onPause");
        if (mAdapter != null) mAdapter.disableForegroundDispatch(this);
    }

    private void handleIntent(Intent intent) {
        String action = intent.getAction();
        Log.d("Cucumber NFC", "Intent Action: " + action.toString());
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {
            String type = intent.getType();
            Log.d("Cucumber NFC", "type: " + type);
            Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            Log.d("Cucumber NFC", "tag: " + tag);

            if (MIME_TEXT_PLAIN.equals(type)) {
                new NdefReaderTask().execute(tag);

            } else {
                Log.d("Cucumber NFC", "Wrong mime type: " + type);
            }

        } else if (NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)) {

            // In case we would still use the Tech Discovered Intent
            Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            String[] techList = tag.getTechList();
            String searchedTech = Ndef.class.getName();
            Log.d("Cucumber NFC", "tag: " + tag.toString());
            for (String tech : techList) {
                Log.d("Cucumber NFC", "tech: " + tech + ", searched: " + searchedTech);
                if (searchedTech.equals(tech)) {
                    new NdefReaderTask().execute(tag);
                    break;
                }
            }
        }
    }

    private class NdefReaderTask extends AsyncTask<Tag, Void, String> {

        @Override
        protected String doInBackground(Tag... params) {
            Tag tag = params[0];

            Ndef ndef = Ndef.get(tag);
            if (ndef == null) {
                // NDEF is not supported by this Tag.
                return null;
            }

            NdefMessage ndefMessage = ndef.getCachedNdefMessage();

            NdefRecord[] records = ndefMessage.getRecords();
            for (NdefRecord ndefRecord : records) {
                if (ndefRecord.getTnf() == NdefRecord.TNF_WELL_KNOWN && Arrays.equals(ndefRecord.getType(), NdefRecord.RTD_TEXT)) {
                    try {
                        String theText = readText(ndefRecord);
                        Log.d("Cucumber NFC", "theText: " + theText);
                        return theText;
                    } catch (UnsupportedEncodingException e) {
                        Log.e("Cucumber NFC", "Unsupported Encoding", e);
                    }
                }
            }

            return null;
        }

        private String readText(NdefRecord record) throws UnsupportedEncodingException {
        /*
         * See NFC forum specification for "Text Record Type Definition" at 3.2.1
         *
         * http://www.nfc-forum.org/specs/
         *
         * bit_7 defines encoding
         * bit_6 reserved for future use, must be 0
         * bit_5..0 length of IANA language code
         */

            byte[] payload = record.getPayload();

            // Get the Text Encoding
            String textEncoding = ((payload[0] & 128) == 0) ? "UTF-8" : "UTF-16";

            // Get the Language Code
            int languageCodeLength = payload[0] & 0063;

            // String languageCode = new String(payload, 1, languageCodeLength, "US-ASCII");
            // e.g. "en"

            // Get the Text
            return new String(payload, languageCodeLength + 1, payload.length - languageCodeLength - 1, textEncoding);
        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null) {
                mTextView.setText(result);
                Log.d("Cucumber NFC", result);
            }
        }
    }
}