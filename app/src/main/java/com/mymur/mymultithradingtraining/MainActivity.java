package com.mymur.mymultithradingtraining;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private static String[] values = new String[] {"A", "B", "C", "D", "E", "F"};
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        //задаёт онКлик для кнопки
  //      setButtonOnClickBehavior();
    }

    //очень мне понравилось вынесение в отдельный метод инициализации View
    private void initViews(){
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
    }

    public void onClick(View view) {
        textView.setText("");
        new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                          final String index = String.valueOf(i);
                       //     textView.setText(index);
                            textView.post(new Runnable() {
                                @Override
                                public void run() {
                                    textView.append(index);
                                }
                            });


                        }
                    }
                }).start();
    }

//    private void setButtonOnClickBehavior(){
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        for (int i = 0; i < 10; i++) {
//                          final int index = i;
//                            textView.setText(index);
//                        }
//                    }
//                }).start();
//
//            }
//        });
//    }


}
