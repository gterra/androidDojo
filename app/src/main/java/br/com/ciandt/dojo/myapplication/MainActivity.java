package br.com.ciandt.dojo.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

import java.util.Timer;
import java.util.TimerTask;

import br.com.ciandt.dojo.caracter.Caracter;

public class MainActivity extends Activity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        ImageView imageView = (ImageView) findViewById(R.id.img_splash);
        Picasso.with(getApplicationContext()).load(R.mipmap.splash_screen).into(imageView);
        this.run();
    }

    @Override
    public void run() {
        try {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), Caracter.class));
                }
            },2000);
        }catch (Exception ex){
            Log.e("Error",ex.toString());
        }
    }
}
