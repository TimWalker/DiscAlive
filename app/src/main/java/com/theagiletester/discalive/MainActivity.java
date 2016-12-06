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
    public static final String TAG = "NfcDemo";
    public static Context myContext;
    private TextView mTextView;
    private NfcAdapter mNfcAdapter;
    private GoogleApiClient client;
    private GoogleApiClient client2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myContext = getApplicationContext();
        setContentView(activity_main);
        addListenerOnButton();
        Log.d("Cucumber", "onCreate" + "," + myContext);
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
                comeAlive();
            }
        });
    }

    private void comeAlive() {
        Intent intent = new Intent(this, NfcActivity.class);
        startActivity(intent);
    }

    @Override
    public void onStop() {
        super.onStop();
   }

    private class GoogleApiClient {
    }

}