package com.example.nanase.mymaillauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    public String ADDRESS = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radio = (RadioGroup) findViewById(R.id.radioGroup);
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                switch (checkedId){
                    case R.id.address1:
                        imageView.setImageResource(R.drawable.keemacurry);
                        break;
                    case  R.id.address2:
                        imageView.setImageResource(R.drawable.gum);
                        break;
                    case R.id.address3:
                        imageView.setImageResource(R.drawable.surume);
                        break;
                    default:
                        break;
                }
                ADDRESS = radioButton.getText().toString();
            }
        });

    }

    public void onSendButtonTapped(View view){
        EditText title = (EditText) findViewById(R.id.title);
        String subject = String.valueOf(title.getText());
        EditText memo = (EditText) findViewById(R.id.memo);
        String text = String.valueOf(memo.getText());

        Uri uri = Uri.parse("mailto:" + ADDRESS);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(intent);
    }

}
