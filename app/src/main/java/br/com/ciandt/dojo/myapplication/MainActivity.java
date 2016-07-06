package br.com.ciandt.dojo.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.transition.Explode;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Timer;
import java.util.TimerTask;

import br.com.ciandt.dojo.myapplication.character.CharacterActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        //setBackgroundImage();
        setTransactionSplashScreen();
    }

    protected void setBackgroundImage() {
        try {
            ImageView imageView = (ImageView) findViewById(R.id.img_splash);
            Picasso.with(getApplicationContext()).load(R.mipmap.splash_screen).into(imageView);
        } catch (Exception ex) {
            Log.e("ErrorSetImage", ex.toString());
        }
    }

    protected void setTransactionSplashScreen() {
        try {
            getWindow().setExitTransition(new Explode());
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(getApplicationContext(), CharacterActivity.class),
                                    ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, null).toBundle());
                        }
                    });

                }
            }, 3000);

        } catch (Exception ex) {
            Log.e("ErrorSetSplashScreen", ex.toString());
        }
    }
}
