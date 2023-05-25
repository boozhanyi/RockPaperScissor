package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button paper, rock, scissor;
    TextView score;
    ImageView humanChoice, computerChoice;
    int humanScore, computerScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paper = findViewById(R.id.paper);
        rock = findViewById(R.id.rock);
        scissor = findViewById(R.id.scissor);

        humanChoice = findViewById(R.id.human_choice);
        computerChoice = findViewById(R.id.computer_choice);

        score = findViewById(R.id.score);

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                humanChoice.setImageResource(R.drawable.paper);
                String message = play_turn("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                score.setText("Score Human :" +humanScore+ "Computer :" +computerScore);
            }
        });

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                humanChoice.setImageResource(R.drawable.rock);
                String message = play_turn("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                score.setText("Score Human :" +humanScore+ "Computer :" +computerScore);
            }
        });

        scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                humanChoice.setImageResource(R.drawable.scissors);
                String message = play_turn("scissor");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                score.setText("Score Human : " +humanScore+ "Computer : " +computerScore);
            }
        });
    }

    public String play_turn(String player_choice) {
        String computer_choice = "";
        Random r = new Random();

        int computer_choice_number = r.nextInt(3) + 1;

        if (computer_choice_number == 1) {
            computer_choice = "rock";
            computerChoice.setImageResource(R.drawable.rock);
        } else if (computer_choice_number == 2) {
            computer_choice = "scissor";
            computerChoice.setImageResource(R.drawable.scissors);
        } else if (computer_choice_number == 3) {
            computer_choice = "paper";
            computerChoice.setImageResource(R.drawable.paper);
        }

        if (computer_choice == player_choice) {
            return "Draw. Nobody won";
        } else if (player_choice == "rock" && computer_choice == "scissor") {
            humanScore++;
            return "Rock crushes scissor. You win";
        } else if (player_choice == "rock" && computer_choice == "paper") {
            computerScore++;
            return "Paper cover rock. Computer win";
        } else if (player_choice == "scissor" && computer_choice == "rock") {
            computerScore++;
            return "Rock crushes scissor. Computer win";
        } else if (player_choice == "scissor" && computer_choice == "paper") {
            humanScore++;
            return "Scissor cut paper. You win";
        } else if (player_choice == "paper" && computer_choice == "rock") {
            humanScore++;
            return "Paper cover rock. You win";
        } else if (player_choice == "paper" && computer_choice == "scissor") {
            computerScore++;
            return "Scissor cut paper. Computer win";
        }else return "Not Sure";
    }
}