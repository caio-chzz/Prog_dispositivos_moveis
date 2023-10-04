package com.example.testtts;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements OnInitListener {

    private TextToSpeech tts;
    private Button btnSpeak;
    private EditText txtText;
    private boolean ttsLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSpeak = (Button) findViewById(R.id.bfala);
        txtText = (EditText) findViewById(R.id.editT);


        tts = new TextToSpeech(this, this);


    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            tts.setLanguage(Locale.getDefault());
            ttsLoaded = true;


        }
    }

    public void falar (View view) {
        if(ttsLoaded)
        {

            String text = txtText.getText().toString();
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }

    }
}