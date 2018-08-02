package ashwat.com.ashwat.ashwat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Register extends AppCompatActivity {

    private ImageButton start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        start = findViewById(R.id.start);
        final SharedPreferencesManager prefs = SharedPreferencesManager.getInstance(getApplicationContext());

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefs.start();
                //Navigate to counter activity
                Intent intent = new Intent(Register.this,Counter.class);
                startActivity(intent);
            }
        });
    }
}
