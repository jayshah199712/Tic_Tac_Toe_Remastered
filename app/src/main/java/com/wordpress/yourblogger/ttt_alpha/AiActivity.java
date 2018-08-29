package com.wordpress.yourblogger.ttt_alpha;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class AiActivity extends AppCompatActivity {

    Button one, two, three, four, five, six, seven, eight, nine, buttonReset, button_submit;

    String mark = "O";
    int player = 1;
    Switch switch1;
    int i = -1;
    char board[] = "0123456789".toCharArray();
    boolean betEntered = false;
    EditText editTextInput;
    //TextView textViewPlayer;
    int P1 = 500, P2 = 500;
    int tmp1 = 0, tmp2 = 0;
    int markSwitch = 1;
    TextView bet_textview;
    TextView coinstextView;
    //TextView comp_textview;
    int temp=0;
    int toss=0;
    int playerturn=0;
    int compturn=0;
    boolean turn=true;
    String playermark;
    String compmark;
    MediaPlayer ding;
    MediaPlayer bgm;
    MediaPlayer buzzer;
    MediaPlayer draw;
    MediaPlayer vicotry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai);

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
        coinstextView = (TextView) findViewById(R.id.coinstextView);
        //textViewPlayer = (TextView) findViewById(R.id.textViewPlayer);
        bet_textview =(TextView) findViewById(R.id.bet_textview);
        //comp_textview=(TextView) findViewById(R.id.comp_textview);
       // switch1 = (Switch) findViewById(R.id.switch1);
        coinstextView.setText(String.valueOf(P1));
       // comp_textview.setText("Rem AI: " + String.valueOf(P2));

        ding = MediaPlayer.create(AiActivity.this, R.raw.ding);
        draw = MediaPlayer.create(AiActivity.this,R.raw.draw);
        buzzer = MediaPlayer.create(AiActivity.this,R.raw.buzzer);
        vicotry = MediaPlayer.create(AiActivity.this,R.raw.victory);
        bgm = MediaPlayer.create(AiActivity.this,R.raw.bgm);
        bgm.setLooping(true);
        bgm.start();


        one.setBackgroundResource(R.drawable.reset);
        two.setBackgroundResource(R.drawable.reset);
        three.setBackgroundResource(R.drawable.reset);
        four.setBackgroundResource(R.drawable.reset);
        five.setBackgroundResource(R.drawable.reset);
        six.setBackgroundResource(R.drawable.reset);
        seven.setBackgroundResource(R.drawable.reset);
        eight.setBackgroundResource(R.drawable.reset);
        nine.setBackgroundResource(R.drawable.reset);


        AlertDialog.Builder builder = new AlertDialog.Builder(AiActivity.this);
        builder.setMessage("Player select your Marker !!")
                .setCancelable(false)
                .setPositiveButton("O", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        playermark="O";
                        compmark="X";
                    }
                })
                .setNegativeButton("X", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        playermark="X";
                        compmark="O";
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();


        // OnCLickListeners for all the 9 buttons of board
        //if(betEntered) {
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (board[1] == '1' && betEntered) {
                    choice();
                    one.setBackgroundResource(getMarkImage());
                    //one.setText(mark);
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
                    two.setBackgroundResource(getMarkImage());
                    //two.setText(mark);
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
        //}
        // Bet submitted

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gamble();
                if(betEntered) {
                    editTextInput.setEnabled(false);
                    button_submit.setClickable(false);
                }

            }
        });


        // Reset everything
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AiActivity.this);
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

//        switch1.setClickable(false);
    }

    public void gamble() {
        int comp = 0;
        //Scanner sc =new Scanner(System.in);
        boolean forP2 = false;
        boolean result = false;
        if (tmp1 == 0) {
            if(editTextInput.getText().toString().equals("")) {
                buzzer.start();
                editTextInput.setError("Bet can not be empty");
                return;
            }
            temp = Integer.parseInt(editTextInput.getText().toString());
            tmp1 = temp;
        }
        if (tmp1 > P1 || tmp1 < 0 || tmp1%5!=0) {
            buzzer.start();
            showDialog("OOPS!!", "Invalid amount by Player 1", false);
            tmp1 = 0;
        }
        editTextInput.setFocusable(true);
        editTextInput.setText("");
        if (tmp1 != 0) {
            Android();
            if (tmp2 > P2 || tmp2 < 0) {
                buzzer.start();
                showDialog("OOPS!!", "Invalid amount by Android", false);
            } else {
                result = true;
            }
            editTextInput.setText("");
            if (result) {
                if (tmp1 > tmp2) {
                    player = 1;
                    //textViewPlayer.setText("Player : 1");
                    P1 -= tmp1;
                    P2 -= tmp2;
                    showDialog(" ","Player won the bet",false);
                    //Toast.makeText(getApplicationContext(), "Player 1 won the bet ", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(), "P1 - remaining points : " + P1, Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(), "Android - remaining points : " + P2, Toast.LENGTH_SHORT).show();
                    tmp1 = 0;
                    turn=true;
                    playerturn++;
                    betEntered = true;
                } else if (tmp2 > tmp1) {
                    player = 2;
                    //textViewPlayer.setText("Player : 2");
                    P1 -= tmp1;
                    P2 -= tmp2;
                   // showDialog(" ","Android won the bet",false);
                    Toast.makeText(getApplicationContext(), "Android won the bet ", Toast.LENGTH_LONG).show();
                    //Toast.makeText(getApplicationContext(), "P1 - remaining points : " + P1, Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(), "Android - remaining points : " + P2, Toast.LENGTH_SHORT).show();
                    tmp1 = 0;
                    turn=false;
                    compturn++;
                    betEntered = true;
                    Androidturn();
                } else {
                    showDialog("OOPS!!", "Both bets are same. Try again", false);
                    //Toast.makeText(getApplicationContext(), "Both bids are same. Try again", Toast.LENGTH_SHORT).show();
                    tmp1 = 0;
                }

                coinstextView.setText(String.valueOf(P1));
                //comp_textview.setText("Rem AI: \n" + String.valueOf(P2));
            }
        }
    }

    // Alter the turns
    public void choice() {
        /*if(player%2==1)
            player=1;
        else
            player=2;*/
        ding.start();
        editTextInput.setEnabled(true);
        button_submit.setClickable(true);
        //textViewPlayer.setText("Player : ");
        if(turn)
            mark=playermark;
        else
            mark=compmark;
       /* markSwitch++;
        if (markSwitch % 2 == 1) {
            //mark="O";
            mark = switch1.getTextOff().toString();
            switch1.setChecked(true);
        } else {
            //mark="X";
            mark = switch1.getTextOn().toString();
            switch1.setChecked(false);
        }*/
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
            //Toast.makeText(getApplicationContext(),"Player "+--player+" Won the match",Toast.LENGTH_SHORT).show();
            String str = "Player " + player + " won the match";
            String str1 = "You just got pawned by Android";
            AlertDialog.Builder builder = new AlertDialog.Builder(AiActivity.this);
            if(player==2) {
                draw.start();
                builder.setMessage(str1)
                        .setTitle("Congratulations!!!")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                gameReset();
                                //do things
                            }
                        });
            }
            else {
                bgm.pause();
                vicotry.start();
                builder.setMessage(str)
                        .setTitle("Congratulations!!!")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                gameReset();
                                //do things
                            }
                        });
            }
            AlertDialog alert = builder.create();
            alert.show();
        } else if (i == 0) {
            draw.start();
            AlertDialog.Builder builder = new AlertDialog.Builder(AiActivity.this);
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
                    showDialog("OOPS!!", "Player 1 has 0 points to bid. Android won the match", true);
                } else if (P2 <= 0) {
                    //Toast.makeText(getApplicationContext(), "Player 2 has 0 points to bid \n Player 1 Won the Match !!", Toast.LENGTH_SHORT).show();
                    vicotry.start();
                    showDialog("OOPS!!", "Android has 0 points to bid. Player 1 won the match", true);
                }
               // Toast.makeText(getApplicationContext(), "Game is over", Toast.LENGTH_SHORT).show();
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
        betEntered=false;
        editTextInput.setEnabled(true);
        button_submit.setClickable(true);
        player = 1;
        markSwitch = 1;
        editTextInput.setText("");
        //textViewPlayer.setText("Player : ");
//        switch1.setChecked(true);
        for (i = 0; i < 10; i++) {
            board[i] = String.valueOf(i).charAt(0);
        }
        coinstextView.setText(String.valueOf(P1));
        //comp_textview.setText("Rem AI: " + String.valueOf(P2));

        one.setClickable(true);
        two.setClickable(true);
        three.setClickable(true);
        four.setClickable(true);
        five.setClickable(true);
        six.setClickable(true);
        seven.setClickable(true);
        eight.setClickable(true);
        nine.setClickable(true);

        one.setText("");
        two.setText("");
        three.setText("");
        four.setText("");
        five.setText("");
        six.setText("");
        seven.setText("");
        eight.setText("");
        nine.setText("");

        one.setBackgroundResource(R.drawable.reset);
        two.setBackgroundResource(R.drawable.reset);
        three.setBackgroundResource(R.drawable.reset);
        four.setBackgroundResource(R.drawable.reset);
        five.setBackgroundResource(R.drawable.reset);
        six.setBackgroundResource(R.drawable.reset);
        seven.setBackgroundResource(R.drawable.reset);
        eight.setBackgroundResource(R.drawable.reset);
        nine.setBackgroundResource(R.drawable.reset);


        one.setTextColor(Color.BLACK);
        two.setTextColor(Color.BLACK);
        three.setTextColor(Color.BLACK);
        four.setTextColor(Color.BLACK);
        five.setTextColor(Color.BLACK);
        six.setTextColor(Color.BLACK);
        seven.setTextColor(Color.BLACK);
        eight.setTextColor(Color.BLACK);
        nine.setTextColor(Color.BLACK);



        AlertDialog.Builder builder = new AlertDialog.Builder(AiActivity.this);
        builder.setMessage("Player select your Marker !!")
                .setCancelable(false)
                .setPositiveButton("O", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ding.start();
                        playermark="O";
                        compmark="X";
                    }
                })
                .setNegativeButton("X", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ding.start();
                        playermark="X";
                        compmark="O";
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();


    }

    // Common method to show dialogs

    public void showDialog(String title, String message,final boolean resetGame) {
        AlertDialog.Builder builder = new AlertDialog.Builder(AiActivity.this);
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

    // GO back to Home Activity....
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(AiActivity.this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        final Intent intent = new Intent(AiActivity.this, HomeActivity.class);
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

    public void Android(){
        int Android_bet=5,toss2=0;
        Random r=new Random();

        if(P2>55) {
            if (tmp1 > 0 && tmp1 <= 50) {
                if(compturn==2){
                    tmp2= tmp1 - 5;
                    compturn=0;
                    return;
                }
                if (playerturn == 2) {
                    tmp2 = tmp1 + 5;
                    playerturn=0;
                    return;
                }
                Android_bet = r.nextInt(4) + 1;
                Android_bet *= 5;
                toss = (int) (Math.random() * 2);
                if (toss == 0) {
                    temp = tmp1 + Android_bet;
                    if (temp >= P2) {
                        temp = P2;
                    }
                    tmp2 = temp;

                } else {
                    temp = tmp1 - Android_bet;
                    if (temp < 0) {
                        temp = temp + (temp * (-1)) + tmp1 - 5;
                    }
                    tmp2 = temp;
                }
            }
            if (tmp1 > 50 && tmp1 <= 160) {
                if (compturn == 2) {
                    tmp2 = tmp1 - 5;
                    compturn=0;
                    return;
                }
                if (playerturn == 2) {
                    tmp2 = tmp1 + 5;
                    playerturn=0;
                    return;
                }
                Android_bet = r.nextInt(6) + 1;
                Android_bet *= 5;
                toss = (int) (Math.random() * 2);
                if (toss == 0) {
                    temp = tmp1 + Android_bet;
                    if (temp >= P2) {
                        temp = P2;
                    }
                    tmp2 = temp;
                } else {
                    temp = tmp1 - Android_bet;
                    if (temp < 0) {
                        temp = temp + (temp * (-1)) + tmp1 - 5;
                    }
                    tmp2 = temp;
                }
            }
            if (tmp1 > 160 && tmp1 <= 500) {
                if (compturn == 2) {
                    tmp2 = tmp1 - 5;
                    compturn=0;
                    return;
                }
                if (playerturn == 2) {
                    tmp2 = tmp1 + 5;
                    playerturn=0;
                    return;
                }
                Android_bet = r.nextInt(7) + 1;
                Android_bet *= 5;
                toss = (int) (Math.random() * 2);
                if (toss == 0) {
                    temp = tmp1 + Android_bet;
                    if (temp >= P2) {
                        temp = P2;
                    }
                    tmp2 = temp;
                } else {
                    temp = tmp1 - Android_bet;
                    if (temp < 0) {
                        temp = temp + (temp * (-1)) + tmp1 - 5;
                    }
                    tmp2 = temp;
                }
            }
        }
        else {
            if (compturn == 2) {
                tmp2 = tmp1 - 5;
                compturn=0;
                return;
            }
            if (playerturn == 2) {
                tmp2 = tmp1 + 5;
                playerturn=0;
                return;
            }
            tmp2 = P2;
        }
        //Toast.makeText(getApplicationContext(), "Android Bet:"+String.valueOf(tmp2), Toast.LENGTH_SHORT).show();

            /*toss = (int) (Math.random() * 2);
            if (toss == 0) {
                //temp = Integer.parseInt(editTextInput.getText().toString());
                temp = tmp1 + 5;
                tmp2 = temp;
            } else {
                temp = tmp1 - 5;
                tmp2 = temp;
            }*/
    }


    public void Androidturn(){

        //checking wins vertically
        if(board[1]==board[4] && board[1]==(compmark.charAt(0)) && betEntered){
            if(board[7]!=playermark.charAt(0) && board[7]!=compmark.charAt(0)){
                choice();
                //seven.setText(mark);
                seven.setBackgroundResource(getMarkImage());
                board[7]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[2]==board[5] && board[2]==(compmark.charAt(0)) && betEntered){
            if(board[8]!=playermark.charAt(0) && board[8]!=compmark.charAt(0)){
                choice();
                //eight.setText(mark);
                eight.setBackgroundResource(getMarkImage());
                board[8]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[3]==board[6] && board[3]==(compmark.charAt(0)) && betEntered){
            if(board[9]!=playermark.charAt(0) && board[9]!=compmark.charAt(0)){
                choice();
                //nine.setText(mark);
                nine.setBackgroundResource(getMarkImage());
                board[9]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[7]==board[4] && board[7]==(compmark.charAt(0)) && betEntered){
            if(board[1]!=playermark.charAt(0) && board[1]!=compmark.charAt(0)){
                choice();
                //one.setText(mark);
                one.setBackgroundResource(getMarkImage());
                board[1]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[8]==board[5] && board[8]==(compmark.charAt(0)) && betEntered){
            if(board[2]!=playermark.charAt(0) && board[2]!=compmark.charAt(0)){
                choice();
                //two.setText(mark);
                two.setBackgroundResource(getMarkImage());
                board[2]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[9]==board[6] && board[9]==(compmark.charAt(0)) && betEntered){
            if(board[3]!=playermark.charAt(0) && board[3]!=compmark.charAt(0)){
                choice();
//                three.setText(mark);
                three.setBackgroundResource(getMarkImage());
                board[3]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[1]==board[7] && board[1]==(compmark.charAt(0)) && betEntered){
            if(board[4]!=playermark.charAt(0) && board[4]!=compmark.charAt(0)){
                choice();
//                four.setText(mark);
                four.setBackgroundResource(getMarkImage());
                board[4]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[2]==board[8] && board[2]==(compmark.charAt(0)) && betEntered){
            if(board[5]!=playermark.charAt(0) && board[5]!=compmark.charAt(0)){
                choice();
                //five.setText(mark);
                five.setBackgroundResource(getMarkImage());
                board[5]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[3]==board[9] && board[3]==(compmark.charAt(0)) && betEntered){
            if(board[6]!=playermark.charAt(0) && board[6]!=compmark.charAt(0)){
                choice();
                //six.setText(mark);
                six.setBackgroundResource(getMarkImage());
                board[6]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }

        //checking wins horizontally
        if(board[1]==board[2] && board[1]==(compmark.charAt(0)) && betEntered){
            if(board[3]!=playermark.charAt(0) && board[3]!=compmark.charAt(0)){
                choice();
                //three.setText(mark);
                three.setBackgroundResource(getMarkImage());
                board[3]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[4]==board[5] && board[4]==(compmark.charAt(0)) && betEntered){
            if(board[6]!=playermark.charAt(0) && board[6]!=compmark.charAt(0)){
                choice();
                //six.setText(mark);
                six.setBackgroundResource(getMarkImage());
                board[6]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[7]==board[8] && board[7]==(compmark.charAt(0)) && betEntered){
            if(board[9]!=playermark.charAt(0) && board[9]!=compmark.charAt(0)){
                choice();
                nine.setText(mark);
                board[9]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[3]==board[2] && board[3]==(compmark.charAt(0)) && betEntered){
            if(board[1]!=playermark.charAt(0) && board[1]!=compmark.charAt(0)){
                choice();
                //one.setText(mark);
                one.setBackgroundResource(getMarkImage());
                board[1]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[6]==board[5] && board[6]==(compmark.charAt(0)) && betEntered){
            if(board[4]!=playermark.charAt(0) && board[9]!=compmark.charAt(0)){
                choice();
                //four.setText(mark);
                four.setBackgroundResource(getMarkImage());
                board[4]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[9]==board[8] && board[9]==(compmark.charAt(0)) && betEntered){
            if(board[7]!=playermark.charAt(0) && board[9]!=compmark.charAt(0)){
                choice();
                //seven.setText(mark);
                seven.setBackgroundResource(getMarkImage());
                board[7]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[1]==board[3] && board[1]==(compmark.charAt(0)) && betEntered){
            if(board[2]!=playermark.charAt(0) && board[2]!=compmark.charAt(0)){
                choice();
                //two.setText(mark);
                two.setBackgroundResource(getMarkImage());
                board[2]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[4]==board[6] && board[4]==(compmark.charAt(0)) && betEntered){
            if(board[5]!=playermark.charAt(0) && board[5]!=compmark.charAt(0)){
                choice();
                //five.setText(mark);
                five.setBackgroundResource(getMarkImage());
                board[5]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[7]==board[9] && board[7]==(compmark.charAt(0)) && betEntered){
            if(board[8]!=playermark.charAt(0) && board[8]!=compmark.charAt(0)){
                choice();
                //eight.setText(mark);
                eight.setBackgroundResource(getMarkImage());
                board[8]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }


        // taking win diagonally
        if(board[1]==board[5] && board[1]==(compmark.charAt(0)) && betEntered){
            if(board[9]!=playermark.charAt(0) && board[9]!=compmark.charAt(0)){
                choice();
                //nine.setText(mark);
                nine.setBackgroundResource(getMarkImage());
                board[9]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[9]==board[5] && board[9]==(compmark.charAt(0)) && betEntered){
            if(board[1]!=playermark.charAt(0) && board[1]!=compmark.charAt(0)){
                choice();
                //one.setText(mark);
                one.setBackgroundResource(getMarkImage());
                board[1]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[7]==board[5] && board[7]==(compmark.charAt(0)) && betEntered){
            if(board[3]!=playermark.charAt(0) && board[3]!=compmark.charAt(0)){
                choice();
                //three.setText(mark);
                three.setBackgroundResource(getMarkImage());
                board[3]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[3]==board[5] && board[3]==(compmark.charAt(0)) && betEntered){
            if(board[7]!=playermark.charAt(0) && board[7]!=compmark.charAt(0)){
                choice();
                //seven.setText(mark);
                seven.setBackgroundResource(getMarkImage());
                board[7]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[7]==board[3] && board[7]==(compmark.charAt(0)) && betEntered){
            if(board[5]!=playermark.charAt(0) && board[5]!=compmark.charAt(0)){
                choice();
                //five.setText(mark);
                five.setBackgroundResource(getMarkImage());
                board[5]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[1]==board[9] && board[1]==(compmark.charAt(0)) && betEntered){
            if(board[5]!=playermark.charAt(0) && board[5]!=compmark.charAt(0)){
                choice();
                //five.setText(mark);
                five.setBackgroundResource(getMarkImage());
                board[5]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        //blocking the vertical wins

        if(board[1]==board[4] && board[1]==(playermark.charAt(0)) && betEntered){
            if(board[7]!=playermark.charAt(0) && board[7]!=compmark.charAt(0)){
                choice();
                //seven.setText(mark);
                seven.setBackgroundResource(getMarkImage());
                board[7]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[2]==board[5] && board[2]==(playermark.charAt(0)) && betEntered){
            if(board[8]!=playermark.charAt(0) && board[8]!=compmark.charAt(0)){
                choice();
                //eight.setText(mark);
                eight.setBackgroundResource(getMarkImage());
                board[8]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[3]==board[6] && board[3]==(playermark.charAt(0)) && betEntered){
            if(board[9]!=playermark.charAt(0) && board[9]!=compmark.charAt(0)){
                choice();
                //nine.setText(mark);
                nine.setBackgroundResource(getMarkImage());
                board[9]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[7]==board[4] && board[7]==(playermark.charAt(0)) && betEntered){
            if(board[1]!=playermark.charAt(0) && board[1]!=compmark.charAt(0)){
                choice();
                //one.setText(mark);
                one.setBackgroundResource(getMarkImage());
                board[1]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[8]==board[5] && board[8]==(playermark.charAt(0)) && betEntered){
            if(board[2]!=playermark.charAt(0) && board[2]!=compmark.charAt(0)){
                choice();
                //two.setText(mark);
                two.setBackgroundResource(getMarkImage());
                board[2]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[9]==board[6] && board[9]==(playermark.charAt(0)) && betEntered){
            if(board[3]!=playermark.charAt(0) && board[3]!=compmark.charAt(0)){
                choice();
                //three.setText(mark);
                three.setBackgroundResource(getMarkImage());
                board[3]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[7]==board[1] && board[7]==(playermark.charAt(0)) && betEntered){
            if(board[4]!=playermark.charAt(0) && board[4]!=compmark.charAt(0)){
                choice();
                //four.setText(mark);
                four.setBackgroundResource(getMarkImage());
                board[4]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[8]==board[2] && board[8]==(playermark.charAt(0)) && betEntered){
            if(board[5]!=playermark.charAt(0) && board[5]!=compmark.charAt(0)){
                choice();
                //five.setText(mark);
                five.setBackgroundResource(getMarkImage());
                board[5]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[9]==board[3] && board[9]==(playermark.charAt(0)) && betEntered){
            if(board[6]!=playermark.charAt(0) && board[6]!=compmark.charAt(0)){
                choice();
                //six.setText(mark);
                six.setBackgroundResource(getMarkImage());
                board[6]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        //blocking a win horizontally

        if(board[1]==board[2] && board[1]==(playermark.charAt(0)) && betEntered){
            if(board[3]!=playermark.charAt(0) && board[3]!=compmark.charAt(0)){
                choice();
                //three.setText(mark);
                three.setBackgroundResource(getMarkImage());
                board[3]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[4]==board[5] && board[4]==(playermark.charAt(0)) && betEntered){
            if(board[6]!=playermark.charAt(0) && board[6]!=compmark.charAt(0)){
                choice();
                //six.setText(mark);
                six.setBackgroundResource(getMarkImage());
                board[6]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[7]==board[8] && board[7]==(playermark.charAt(0)) && betEntered){
            if(board[9]!=playermark.charAt(0) && board[9]!=compmark.charAt(0)){
                choice();
                //nine.setText(mark);
                nine.setBackgroundResource(getMarkImage());
                board[9]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[3]==board[2] && board[3]==(playermark.charAt(0)) && betEntered){
            if(board[1]!=playermark.charAt(0) && board[1]!=compmark.charAt(0)){
                choice();
                //one.setText(mark);
                one.setBackgroundResource(getMarkImage());
                board[1]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[6]==board[5] && board[6]==(playermark.charAt(0)) && betEntered){
            if(board[4]!=playermark.charAt(0) && board[4]!=compmark.charAt(0)){
                choice();
                //four.setText(mark);
                four.setBackgroundResource(getMarkImage());
                board[4]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[9]==board[8] && board[9]==(playermark.charAt(0)) && betEntered){
            if(board[7]!=playermark.charAt(0) && board[7]!=compmark.charAt(0)){
                choice();
//                seven.setText(mark);
                seven.setBackgroundResource(getMarkImage());
                board[7]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[3]==board[1] && board[3]==(playermark.charAt(0)) && betEntered){
            if(board[2]!=playermark.charAt(0) && board[2]!=compmark.charAt(0)){
                choice();
                //two.setText(mark);
                two.setBackgroundResource(getMarkImage());
                board[2]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[6]==board[4] && board[6]==(playermark.charAt(0)) && betEntered){
            if(board[5]!=playermark.charAt(0) && board[5]!=compmark.charAt(0)){
                choice();
                //five.setText(mark);
                five.setBackgroundResource(getMarkImage());
                board[5]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[9]==board[7] && board[9]==(playermark.charAt(0)) && betEntered){
            if(board[8]!=playermark.charAt(0) && board[8]!=compmark.charAt(0)){
                choice();
                //eight.setText(mark);
                eight.setBackgroundResource(getMarkImage());
                board[8]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        //blocking wins diagonally

        if(board[1]==board[5] && board[1]==(playermark.charAt(0)) && betEntered){
            if(board[9]!=playermark.charAt(0) && board[9]!=compmark.charAt(0)){
                choice();
                //nine.setText(mark);
                nine.setBackgroundResource(getMarkImage());
                board[9]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[9]==board[5] && board[9]==(playermark.charAt(0)) && betEntered){
            if(board[1]!=playermark.charAt(0) && board[1]!=compmark.charAt(0)){
                choice();
                //one.setText(mark);
                one.setBackgroundResource(getMarkImage());
                board[1]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[7]==board[5] && board[7]==(playermark.charAt(0)) && betEntered){
            if(board[3]!=playermark.charAt(0) && board[3]!=compmark.charAt(0)){
                choice();
                //three.setText(mark);
                three.setBackgroundResource(getMarkImage());
                board[3]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[3]==board[5] && board[3]==(playermark.charAt(0)) && betEntered){
            if(board[7]!=playermark.charAt(0) && board[7]!=compmark.charAt(0)){
                choice();
                //seven.setText(mark);
                seven.setBackgroundResource(getMarkImage());
                board[7]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[7]==board[3] && board[7]==(playermark.charAt(0)) && betEntered){
            if(board[5]!=playermark.charAt(0) && board[5]!=compmark.charAt(0)){
                choice();
                //five.setText(mark);
                five.setBackgroundResource(getMarkImage());
                board[5]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        if(board[1]==board[9] && board[1]==(playermark.charAt(0)) && betEntered){
            if(board[5]!=playermark.charAt(0) && board[5]!=compmark.charAt(0)){
                choice();
                //five.setText(mark);
                five.setBackgroundResource(getMarkImage());
                board[5]=compmark.charAt(0);
                display();
                betEntered=false;

            }
        }
        // making random move

        int move = 0;
        //int rand2 = 0;
        Random r2= new Random();

        while(betEntered){
            move=r2.nextInt(9)+1;
            //rand1 = (int) (Math.random() * 3);
            //rand2 = (int) (Math.random() * 3);
            choice();
            if(board[move] != 'X' && board[move] != 'O' && move!=0){
                if(move==1)
                    one.setBackgroundResource(getMarkImage());
                if(move==2)
                    two.setBackgroundResource(getMarkImage());
                if(move==3)
                    three.setBackgroundResource(getMarkImage());
                if(move==4)
                    four.setBackgroundResource(getMarkImage());
                if(move==5)
                    five.setBackgroundResource(getMarkImage());
                if(move==6)
                    six.setBackgroundResource(getMarkImage());
                if(move==7)
                    seven.setBackgroundResource(getMarkImage());
                if(move==8)
                    eight.setBackgroundResource(getMarkImage());
                if(move==9)
                    nine.setBackgroundResource(getMarkImage());

                board[move] = compmark.charAt(0);
                display();
                betEntered = false;

            }

        }
    }

    public int getMarkImage(){

        if(turn){
            if(playermark.equals("O"))
                return(R.drawable.o3);
            else
                return (R.drawable.x2);
        }
        else {
            if(compmark.equals("O"))
                return (R.drawable.o3);
            else
                return (R.drawable.x2);
        }
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
