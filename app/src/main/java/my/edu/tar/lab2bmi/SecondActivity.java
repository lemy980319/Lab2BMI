package my.edu.tar.lab2bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //define local variable
        TextView textViewMessage;
        textViewMessage = findViewById(R.id.textViewMessage);
        ImageView imageView = findViewById(R.id.imageView);
        //Retrieve intent data
        Intent intent = getIntent();//Who called me?
        //check

        if (intent.hasExtra(MainActivity.TAG_MESSAGE)) {
            Double stringMsg = intent.getDoubleExtra(MainActivity.TAG_MESSAGE, 0);

            if(stringMsg <= 18.5){
                imageView.setImageResource(R.drawable.under);
            } else if(stringMsg > 18.5 && stringMsg <= 25){
                imageView.setImageResource(R.drawable.normal);
            }else{
                imageView.setImageResource(R.drawable.over);
            }

            textViewMessage.setText(String.valueOf(stringMsg));


        }
    }
}
