package com.wordpress.yourblogger.ttt_alpha;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button one, two, three, four, five, six, seven, eight, nine, buttonReset, button_submit;
    String mark = "O";
    int player = 1;
    //Switch switch1;
    MediaPlayer ding;
    MediaPlayer bgm;
    MediaPlayer buzzer;
    MediaPlayer draw;
    MediaPlayer vicotry;
    int i = -1;
    char board[] = "0123456789".toCharArray();
    boolean betEntered = false;
    EditText editTextInput;
    TextView textViewPlayer;
    int P1 = 500, P2 = 500;
    int tmp1 = 0, tmp2 = 0;
    int markSwitch = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        draw = MediaPlayer.create(MainActivity.this,R.raw.draw);
        buzzer = MediaPlayer.create(MainActivity.this,R.raw.buzzer);
        vicotry = MediaPlayer.create(MainActivity.this,R.raw.victory);
        bgm = MediaPlayer.create(MainActivity.this,R.raw.bgm);
        bgm.setLooping(true);
        bgm.start();

        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        buttonReset = (Button) findViewById(R.id.buttonReset);
        button_submit = (Button) findViewById(R.id.button_submit);
        editTextInput = (EditText) findViewById(R.id.editTextInput);
        textViewPlayer = (TextView) findViewById(R.id.textViewPlayer);
        //switch1 = (Switch) findViewById(R.id.switch1);


        one.setBackgroundResource(R.drawable.reset);
        two.setBackgroundResource(R.drawable.reset);
        three.setBackgroundResource(R.drawable.reset);
        four.setBackgroundResource(R.drawable.reset);
        five.setBackgroundResource(R.drawable.reset);
        six.setBackgroundResource(R.drawable.reset);
        seven.setBackgroundResource(R.drawable.reset);
        eight.setBackgroundResource(R.drawable.reset);
        nine.setBackgroundResource(R.drawable.reset);

        // OnCLickListeners for all the 9 buttons of board
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (board[1] == '1' && betEntered) {
                    choice();
                    //one.setText(mark);
                    one.setBackgroundResource(getMarkImage());
                    board[1] = mark.charAt(0);
                    display();
                    betEntered = false;
                }

            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (board[2] == '2' && betEntered) {
                    choice();
                    //two.setText(mark);
                    two.setBackgroundResource(getMarkImage());
                    board[2] = mark.charAt(0);
                    display();
                    betEntered = false;
                }
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (board[3] == '3' && betEntered) {
                    choice();
                    //three.setText(mark);
                    three.setBackgroundResource(getMarkImage());
                    board[3] = mark.charAt(0);
                    display();
                    betEntered = false;
                }
            }
        });


        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (board[4] == '4' && betEntered) {
                    choice();
                    //four.setText(mark);
                    four.setBackgroundResource(getMarkImage());
                    board[4] = mark.charAt(0);
                    display();
                    betEntered = false;
                }
            }
        });


        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (board[5] == '5' && betEntered) {
                    choice();
                    //five.setText(mark);
                    five.setBackgroundResource(getMarkImage());
                    board[5] = mark.charAt(0);
                    display();
                    betEntered = false;
                }
            }
        });


        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (board[6] == '6' && betEntered) {
                    choice();
                    //six.setText(mark);
                    six.setBackgroundResource(getMarkImage());
                    board[6] = mark.charAt(0);
                    display();
                    betEntered = false;
                }
            }
        });


        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (board[7] == '7' && betEntered) {
                    choice();
                    //seven.setText(mark);
                    seven.setBackgroundResource(getMarkImage());
                    board[7] = mark.charAt(0);
                    display();
                    betEntered = false;
                }
            }
        });


        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (board[8] == '8' && betEntered) {
                    choice();
                    //eight.setText(mark);
                    eight.setBackgroundResource(getMarkImage());
                    board[8] = mark.charAt(0);
                    display();
                    betEntered = false;
                }
            }
        });


        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (board[9] == '9' && betEntered) {
                    choice();
                    //nine.setText(mark);
                    nine.setBackgroundResource(getMarkImage());
                    board[9] = mark.charAt(0);
                    display();
                    betEntered = false;
                }
            }
        });

        // Bet submitted

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gamble();
            }
        });


        // Reset everything
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Are you sure you want to reset this game?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                gameReset();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        //switch1.setClickable(false);
    }

    public void gamble() {
        int temp = 0;
        boolean forP2 = true;
        boolean result = false;
        if (tmp1 == 0) {
            try{
                temp = Integer.parseInt(editTextInput.getText().toString());
                tmp1 = temp;
            } catch(Exception e) {
                buzzer.start();
                editTextInput.setError("Bet can not be empty");
                tmp1=0;
            }
            if(tmp1 > P1 || tmp1 < 0)
            {
                buzzer.start();
                showDialog("OOPS!!","Invalid amount",false);
                tmp1=0;
            }
                editTextInput.setFocusable(true);
                editTextInput.setText("");
        }
        else {
            if(editTextInput.getText().toString().equals("")) {
                buzzer.start();
                editTextInput.setError("Bet can not be empty");
                return;
            }
            else {
                temp = Integer.parseInt(editTextInput.getText().toString());
                tmp2 = temp;
                if (tmp2 > P2 || tmp2 < 0) {
                    buzzer.start();
                    showDialog("OOPS!!", "Invalid amount", false);
                } else {
                    result = true;
                }
                editTextInput.setText("");
            }
        }
        if (result) {
            if (tmp1 > tmp2) {
                player = 1;
                textViewPlayer.setText("Turn : Player - 1");
                P1 -= tmp1;
                P2 -= tmp2;
                showDialog("","Player 1 won the bet", false);

                button_submit.setClickable(false);
                editTextInput.setEnabled(false);
                //Toast.makeText(getApplicationContext(), "Player 1 won the bet ", Toast.LENGTH_SHORT).show();
               // Toast.makeText(getApplicationContext(), "P1 - remaining points : " + P1, Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(), "P2 - remaining points : " + P2, Toast.LENGTH_SHORT).show();
                tmp1 = 0;
                betEntered = true;
            } else if (tmp2 > tmp1) {
                player = 2;
                textViewPlayer.setText("Turn : Player - 2");
                P1 -= tmp1;
                P2 -= tmp2;
                showDialog("","Player 2 won the bet", false);

                button_submit.setClickable(false);
                editTextInput.setEnabled(false);
                //Toast.makeText(getApplicationContext(), "Player 2 won the bet ", Toast.LENGTH_SHORT).show();
               // Toast.makeText(getApplicationContext(), "P1 - remaining points : " + P1, Toast.LENGTH_SHORT).show();
               // Toast.makeText(getApplicationContext(), "P2 - remaining points : " + P2, Toast.LENGTH_SHORT).show();
                tmp1 = 0;
                betEntered = true;
            } else {
                buzzer.start();
                showDialog("OOPS!!","Both bets are same. Try again",false);
                //Toast.makeText(getApplicationContext(), "Both bids are same. Try again", Toast.LENGTH_SHORT).show();
                tmp1 = 0;
            }
        }
    }

    // Alter the marks
    public void choice() {
        /*if(player%2==1)
            player=1;
        else
            player=2;*/
        //markSwitch++;
        button_submit.setClickable(true);
        editTextInput.setEnabled(true);

        ding = MediaPlayer.create(MainActivity.this,R.raw.ding);
        ding.start();
        textViewPlayer.setText("Turn : ");
        if (player==2) {
            mark="X";
        } else {
            mark="O";
        }
    }

    // Checks the result by checkresult() method and displays it

    public void display() {
        boolean result = false;
        i = checkresult();
        if (i == 1) {
            one.setClickable(false);
            two.setClickable(false);
            three.setClickable(false);
            four.setClickable(false);
            five.setClickable(false);
            six.setClickable(false);
            seven.setClickable(false);
            eight.setClickable(false);
            nine.setClickable(false);
            result=true;
            bgm.pause();
            vicotry.start();
            String str = "Player " + player + " won the match";
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage(str)
                    .setTitle("Congratulations!!!")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            gameReset();
                            //do things
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        } else if (i == 0) {
            draw.start();
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Game draw")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //do things
                            gameReset();
                        }
                    });
            result=true;
            AlertDialog alert = builder.create();
            alert.show();
        }

        if(!result) {

            if (P1 <= 0 || P2 <= 0) {
                if (P1 == 0 && P2 == 0) {
                    //Toast.makeText(getApplicationContext(), "Both the players have 0 points left to bid. Game is over without result", Toast.LENGTH_SHORT).show();
                    draw.start();
                    showDialog("OOPS!!", "Both players have zero points left. Game is over without result", true);
                } else if (P1 <= 0) {
                    //Toast.makeText(getApplicationContext(), "Player 1 has 0 points to bid \n Player 2 Won the Match !!", Toast.LENGTH_SHORT).show();
                    draw.start();
                    showDialog("OOPS!!", "Player 1 has 0 points to bid. Player 2 won the match", true);
                } else if (P2 <= 0) {
                    //Toast.makeText(getApplicationContext(), "Player 2 has 0 points to bid \n Player 1 Won the Match !!", Toast.LENGTH_SHORT).show();
                    draw.start();
                    showDialog("OOPS!!", "Player 2 has 0 points to bid. Player 1 won the match", true);
                }
                Toast.makeText(getApplicationContext(), "Game is over", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /* Returns 1 if game is over with result
               0 if game is over without result (draw)
               -1 if it is in progress */

    public int checkresult() {
        if (board[1] == board[2] && board[2] == board[3]) {
            one.setTextColor(Color.BLUE);
            two.setTextColor(Color.BLUE);
            three.setTextColor(Color.BLUE);
            return 1;
        } else if (board[4] == board[5] && board[5] == board[6]) {
            four.setTextColor(Color.BLUE);
            five.setTextColor(Color.BLUE);
            six.setTextColor(Color.BLUE);
            return 1;
        } else if (board[7] == board[8] && board[8] == board[9])

        {
            seven.setTextColor(Color.BLUE);
            eight.setTextColor(Color.BLUE);
            nine.setTextColor(Color.BLUE);
            return 1;
        } else if (board[1] == board[4] && board[4] == board[7])

        {
            one.setTextColor(Color.BLUE);
            four.setTextColor(Color.BLUE);
            seven.setTextColor(Color.BLUE);
            return 1;
        } else if (board[2] == board[5] && board[5] == board[8])

        {
            two.setTextColor(Color.BLUE);
            five.setTextColor(Color.BLUE);
            eight.setTextColor(Color.BLUE);
            return 1;
        } else if (board[3] == board[6] && board[6] == board[9])

        {
            three.setTextColor(Color.BLUE);
            six.setTextColor(Color.BLUE);
            nine.setTextColor(Color.BLUE);
            return 1;
        } else if (board[1] == board[5] && board[5] == board[9])

        {
            one.setTextColor(Color.BLUE);
            five.setTextColor(Color.BLUE);
            nine.setTextColor(Color.BLUE);
            return 1;
        } else if (board[3] == board[5] && board[5] == board[7])

        {
            three.setTextColor(Color.BLUE);
            five.setTextColor(Color.BLUE);
            seven.setTextColor(Color.BLUE);
            return 1;
        } else if (board[1] != '1' && board[2] != '2' && board[3] != '3'
                && board[4] != '4' && board[5] != '5' && board[6] != '6'
                && board[7] != '7' && board[8] != '8' && board[9] != '9')

            return 0;
        else
            return -1;
    }

    public void gameReset() {
        if(!bgm.isPlaying())
            bgm.start();
        P1 = 500;
        P2 = 500;
        player = 1;
        markSwitch = 1;
        editTextInput.setText("");
        textViewPlayer.setText("Turn : ");
        button_submit.setClickable(true);
        editTextInput.setEnabled(true);
        //switch1.setChecked(true);
        for (i = 0; i < 10; i++) {
            board[i] = String.valueOf(i).charAt(0);
        }

        one.setBackgroundResource(R.drawable.reset);
        two.setBackgroundResource(R.drawable.reset);
        three.setBackgroundResource(R.drawable.reset);
        four.setBackgroundResource(R.drawable.reset);
        five.setBackgroundResource(R.drawable.reset);
        six.setBackgroundResource(R.drawable.reset);
        seven.setBackgroundResource(R.drawable.reset);
        eight.setBackgroundResource(R.drawable.reset);
        nine.setBackgroundResource(R.drawable.reset);

        one.setClickable(true);
        two.setClickable(true);
        three.setClickable(true);
        four.setClickable(true);
        five.setClickable(true);
        six.setClickable(true);
        seven.setClickable(true);
        eight.setClickable(true);
        nine.setClickable(true);
    }


    public void showDialog(String title, String message, final boolean resetGame) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if(resetGame)
                            gameReset();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public int getMarkImage(){

       if(player==1){
           return(R.drawable.o3);
       }else {
           return (R.drawable.x2);
       }
   }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        final Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }


    @Override
    protected void onStop() {
        bgm.pause();
        super.onStop();
    }

    @Override
    protected void onResume() {
        bgm.start();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        bgm.stop();
        super.onDestroy();
    }
}