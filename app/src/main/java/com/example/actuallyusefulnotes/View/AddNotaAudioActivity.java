package com.example.actuallyusefulnotes.View;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.actuallyusefulnotes.R;

import java.io.File;
import java.io.IOException;

public class AddNotaAudioActivity extends AppCompatActivity {
    EditText titulo;
    MediaRecorder mediaRecorder;

    public static String fileName = "recorded.3gp";

    String file = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_nota_audio);

        titulo = findViewById(R.id.titulo_audio);

        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);

        mediaRecorder.setOutputFile(file);
    }

    public void onCLick(View v) {
        if (v.getId() == R.id.microfono) {

        } else if (v.getId() == R.id.stop) {

        } else if (v.getId() == R.id.play) {

        } else if (v.getId() == R.id.save_audio) {

        } else if (v.getId() == R.id.delete_audio) {

        }
    }

    private void record() {
        try {
            mediaRecorder.prepare();
            mediaRecorder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stopAudio() {
        mediaRecorder.stop();
        mediaRecorder.release();
    }

    private void playAudio() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(file);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void saveAudio() {

    }

    private void deleteAudio() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.note_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.save_audio) {
            saveAudio();
        }
        return true;
    }
}
