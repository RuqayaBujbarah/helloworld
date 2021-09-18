package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String userinput;
    String newmessage = "";
    String alphabets = "abcdefghijklmnopqrstuvwxyz";
    int count = 0;
    int j = 0;

    void encode (String text){
        TextView outputtxt = findViewById(R.id.outputtxt);
        for(int i = 0;i<text.length();i++){

            if(Character.isLetter(text.charAt(i))==false){
                newmessage = newmessage + text.substring(i,i+1);
            }
            else{
                while(Character.compare(text.charAt(i),alphabets.charAt(j))!=0&&j<25){
                    j++;}
                if(j==25){
                    j++;
                }
                j = j + 13;
                if(j<26){
                    newmessage += alphabets.charAt(j);
                }
                else{
                    j = j - 26;
                    newmessage += alphabets.charAt(j);
                }

                count++;
                j = 0;
            }
        }
        outputtxt.setText(newmessage);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText txt = findViewById(R.id.txt);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userinput = txt.getText().toString();
                userinput = userinput.toLowerCase();
                encode(userinput);


            }
        });

    }
}