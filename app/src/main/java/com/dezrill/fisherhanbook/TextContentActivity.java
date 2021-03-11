package com.dezrill.fisherhanbook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TextContentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        Intent intent=getIntent();

        TextView textView=findViewById(R.id.textView);
        ImageView imageView=findViewById(R.id.imageView3);

        switch (intent.getStringExtra("TITLE")) {
            case "Рыба":{
                switch (intent.getFlags()){
                    case 0:{
                        textView.setText(R.string.carpio);
                        imageView.setImageResource(R.drawable.carpio);
                        setTitle("Карп");
                    }break;
                    case 1:{
                        textView.setText(R.string.catfish);
                        imageView.setImageResource(R.drawable.som);
                        setTitle("Сом");
                    }break;
                    case 2:{
                        textView.setText(R.string.perch);
                        imageView.setImageResource(R.drawable.okun);
                        setTitle("Окунь");
                    }break;
                    case 3:{
                        textView.setText(R.string.pike);
                        imageView.setImageResource(R.drawable.schuka);
                        setTitle("Щука");
                    }break;
                    case 4:{
                        textView.setText(R.string.salmon);
                        imageView.setImageResource(R.drawable.losos);
                        setTitle("Лосось");
                    }break;
                    case 5: {
                        textView.setText(R.string.sturgeon);
                        imageView.setImageResource(R.drawable.osetr);
                        setTitle("Осётр");
                    }
                }break;
            }
            case "Наживка":{
                /*switch (intent.getFlags()) {
                    case 0: {
                        textView.setText(R.string.carpio);
                        imageView.setImageResource(R.drawable.carpio);
                        setTitle("Карп");
                    }
                    break;
                    case 1: {
                        textView.setText(R.string.catfish);
                        imageView.setImageResource(R.drawable.som);
                        setTitle("Сом");
                    }
                    break;
                    case 2: {
                        textView.setText(R.string.perch);
                        imageView.setImageResource(R.drawable.okun);
                        setTitle("Окунь");
                    }
                    break;
                    case 3: {
                        textView.setText(R.string.pike);
                        imageView.setImageResource(R.drawable.schuka);
                        setTitle("Щука");
                    }
                    break;
                    case 4: {
                        textView.setText(R.string.salmon);
                        imageView.setImageResource(R.drawable.losos);
                        setTitle("Лосось");
                    }break;
                }*/
            }
            case "Снасти":{

            }
            case "Прикормка":{

            }
            case "Рыбацкие истории":{

            }
            case "Полезные советы":{

            }
        }
    }
}
