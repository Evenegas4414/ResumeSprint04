package com.ervr.resume;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    private static final int DELAY_MILLIS = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Se usa un Handler para retrasar la navegación a MainActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Se crea un Intent para iniciar MainActivity
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);

                // Cierra WelcomeActivity
                finish();
            }
        }, DELAY_MILLIS);
    }
}
