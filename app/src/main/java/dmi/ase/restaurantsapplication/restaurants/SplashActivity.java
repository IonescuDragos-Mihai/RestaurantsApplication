package dmi.ase.restaurantsapplication.restaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import dmi.ase.restaurantsapplication.R;

public class SplashActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        goToMainActivity();

    }

    private void goToMainActivity() {
        Handler h = new Handler();
        h.postDelayed(() -> {
            intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }, 2000);

    }
}