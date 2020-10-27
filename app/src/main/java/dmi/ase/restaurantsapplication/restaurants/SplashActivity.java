package dmi.ase.restaurantsapplication.restaurants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import dmi.ase.restaurantsapplication.R;

public class SplashActivity extends AppCompatActivity {
    private Intent intent;
    private Animation animation;
    private AppCompatImageView imageView;
    private static final int SPLASH_DURATION=2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initComponents();
        goToMainActivity();


    }
    private void initComponents(){
        imageView=findViewById(R.id.image_spalh_ibm_logo);
        animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation_logo);
        imageView.setAnimation(animation);
    }
    private void goToMainActivity() {
        Handler h = new Handler();
        h.postDelayed(() -> {
            intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }, SPLASH_DURATION);

    }
}