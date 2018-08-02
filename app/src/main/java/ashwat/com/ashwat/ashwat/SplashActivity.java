package ashwat.com.ashwat.ashwat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferencesManager prefs = SharedPreferencesManager.getInstance(getApplicationContext());

        Intent intent;

        if (prefs.getResult() != 0) {

            intent = new Intent(SplashActivity.this, Counter.class);

        } else {

            intent = new Intent(SplashActivity.this, Register.class);
        }

        startActivity(intent);

        finish();

    }

}
