package ashwat.com.ashwat.ashwat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class Counter extends AppCompatActivity {

    private ImageButton reset;
    RingProgressBar ringProgressBar;
    TextView textView;
    int progress = 0;
    String shotnum ="";
    int shoot=0;

    Handler myhandeler = new Handler(){


        @Override
        public void handleMessage(Message msg){

            if(msg.what == 0){
                if (progress<7){
                    progress++;
                    ringProgressBar.setProgress(progress);
                }
            }


        }


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        final SharedPreferencesManager prefs = SharedPreferencesManager.getInstance(getApplicationContext());
        shoot = prefs.getResult();
        ringProgressBar =(RingProgressBar) findViewById(R.id.progress_bar_2);
        ringProgressBar.setProgress(1);
        reset = findViewById(R.id.reset);
        textView = (TextView)  findViewById(R.id.textView);



        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefs.end();
                Intent intent = new Intent(Counter.this,Register.class);

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<7;i++){

                    try{
                        Thread.sleep(1500);
                        myhandeler.sendEmptyMessage(0);

                        shotnum = ""+shoot;
                        shoot++;
                        textView.setText(shotnum);
                    }catch(InterruptedException e){
                        e.printStackTrace();

                    }

                }
            }
        }).start();
    }




}



    /*

    private Button end,increment;
    private TextView counter,error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        end = findViewById(R.id.end);
        increment = findViewById(R.id.increment);
        counter = findViewById(R.id.result);
        error = findViewById(R.id.result2);

        final SharedPreferencesManager prefs = SharedPreferencesManager.getInstance(getApplicationContext());

     

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefs.end();
                counter.setText(prefs.getResult()+"");
                error.setText(" ");

            }
        });

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefs.increment();
                if(prefs.getResult()>7){
                    counter.setText("7");
                    error.setText(7-prefs.getResult()+"");
                }
                else {
                    counter.setText(prefs.getResult()+"");
                    error.setText(" ");
                }

            }
        });
    }
}*/
