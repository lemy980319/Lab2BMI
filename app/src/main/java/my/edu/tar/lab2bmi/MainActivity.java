package my.edu.tar.lab2bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String TAG_MESSAGE = "my.edu.tarc.lab2BMI.MESSAGE";
    private EditText weightInput;
    private EditText heightInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Link UI to program
        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
    }

    public void calculateBMI(View view){
        int weight,height;
        double BMI;
        if(TextUtils.isEmpty(weightInput.getText())){
            weightInput.setError("Please enter your weight(kg)");
            return;
        }else if(TextUtils.isEmpty(heightInput.getText())){
            heightInput.setError("Please enter your height(cm)");
        }

        weight = Integer.parseInt(weightInput.getText().toString());
        height = Integer.parseInt(heightInput.getText().toString());

        BMI = weight/(height/100*(height/100));

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(TAG_MESSAGE, BMI);
        startActivity(intent);
    }


}
