package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ImageView Dice;
    private TextView Game;
    private Button Btn;
    private TextView Total;
    private TextView Score;
    private Button Reset;
    private int remain = 3;
    private int score = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Dice = findViewById(R.id.Dice);
        Game = findViewById(R.id.Game);
        Btn = findViewById(R.id.Btn);
        Total = findViewById(R.id.Total);
        Score = findViewById(R.id.Score);
        Reset = findViewById(R.id.Reset);
        Total.setText("Total: " +remain);
        Score.setText("Score: "+score);

        Btn.setOnClickListener(v -> {
            int random = (int) (Math.random() * 6 + 1);
            if (random == 1) {
                Dice.setImageResource(R.drawable.mat1);
            } else if (random == 2) {
                Dice.setImageResource(R.drawable.mat2);
            } else if (random == 3) {
                Dice.setImageResource(R.drawable.mat3);
            } else if (random == 4) {
                Dice.setImageResource(R.drawable.mat4);
            } else if (random == 5) {
                Dice.setImageResource(R.drawable.mat5);
            } else if (random == 6) {
                Dice.setImageResource(R.drawable.mat6);
            }
            score += random;
            remain--;
            Total.setText("Total: " +remain);
            Score.setText("Score: "+score);
            if (remain == 0) {
                Reset.setVisibility(TextView.VISIBLE);
                Btn.setVisibility(TextView.GONE);
            }
        });
        Reset.setOnClickListener(v -> {
            remain = 3;
            score = 0;
            Total.setText("Total: " +remain);
            Score.setText("Score: "+score);
            Dice.setImageResource(R.drawable.mat1);
            Reset.setVisibility(TextView.GONE);
            Btn.setVisibility(TextView.VISIBLE);
        });
    }
}
