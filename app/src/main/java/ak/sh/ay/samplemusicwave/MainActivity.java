package ak.sh.ay.samplemusicwave;

import android.media.MediaPlayer;
import android.media.audiofx.Visualizer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import ak.sh.ay.musicwave.MusicWave;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    private MediaPlayer mMediaPlayer;
    private Visualizer mVisualizer;
    private MusicWave musicWave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initialise();
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status;
                if (mMediaPlayer.isPlaying()) {
                    status = "Sound Paused";
                    mMediaPlayer.pause();
                    fab.setImageResource(android.R.drawable.ic_media_play);
                } else {
                    status = "Sound Started";
                    mVisualizer.setEnabled(true);
                    mMediaPlayer.start();
                    fab.setImageResource(android.R.drawable.ic_media_pause);
                }
                Snackbar.make(view, status, Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing() && mMediaPlayer != null) {
            mVisualizer.release();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    private void initialise() {
        musicWave = (MusicWave) findViewById(R.id.musicWave);
        mMediaPlayer = MediaPlayer.create(this, R.raw.unrelenting);
        prepareVisualizer();
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mVisualizer.setEnabled(false);
                fab.setImageResource(android.R.drawable.ic_media_play);
            }
        });
    }

    private void prepareVisualizer() {
        mVisualizer = new Visualizer(mMediaPlayer.getAudioSessionId());
        mVisualizer.setCaptureSize(Visualizer.getCaptureSizeRange()[1]);
        mVisualizer.setDataCaptureListener(
                new Visualizer.OnDataCaptureListener() {
                    public void onWaveFormDataCapture(Visualizer visualizer,
                                                      byte[] bytes, int samplingRate) {
                        musicWave.updateVisualizer(bytes);
                    }

                    public void onFftDataCapture(Visualizer visualizer,
                                                 byte[] bytes, int samplingRate) {
                    }
                }, Visualizer.getMaxCaptureRate() / 2, true, false);
        mVisualizer.setEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_color_solid) {
            Log.e("action_color_solid", "" + musicWave.getConfig().getColorGradient());
            musicWave.getConfig().setColorGradient(false);
            return true;
        }
        if (id == R.id.action_color_gradient) {
            Log.e("action_color_gradient", "" + musicWave.getConfig().getColorGradient());
            musicWave.getConfig().setColorGradient(true);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
