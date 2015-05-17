package lukesterlee.c4q.nyc.lunacalculator;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;


public class MainActivity extends Activity {

    TextView panel;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creat buttons and textview.
        Button num0 = (Button) findViewById(R.id.button0);
        panel = (TextView) findViewById(R.id.textView);

        //if saved instance is not empty, then the bundle(pocket) will keep the result when
        //screen rotate.
        if (savedInstanceState != null) {
            panel.setText(savedInstanceState.getString("input"));
        }


        //the event of listen to click, when click button, run the method of onClick,
        //append means add num on screen.
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panel.append("0");
            }
        });

        Button num1 = (Button) findViewById(R.id.button1);
       // panel = (TextView) findViewById(R.id.textView);
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panel.append("1");
            }
        });

        Button num2 = (Button) findViewById(R.id.button2);
       // panel = (TextView) findViewById(R.id.textView);
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panel.append("2");
            }
        });

        Button num3 = (Button) findViewById(R.id.button3);
     //   panel = (TextView) findViewById(R.id.textView);
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panel.append("3");
            }
        });

        Button num4 = (Button) findViewById(R.id.button4);
      //  panel = (TextView) findViewById(R.id.textView);
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panel.append("4");
            }
        });

        Button num5 = (Button) findViewById(R.id.button5);
      //  panel = (TextView) findViewById(R.id.textView);
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panel.append("5");
            }
        });

        Button num6 = (Button) findViewById(R.id.button6);
      //  panel = (TextView) findViewById(R.id.textView);
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panel.append("6");
            }
        });

        Button num7 = (Button) findViewById(R.id.button7);
   //     panel = (TextView) findViewById(R.id.textView);
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panel.append("7");
            }
        });

        Button num8 = (Button) findViewById(R.id.button8);
     //   panel = (TextView) findViewById(R.id.textView);
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panel.append("8");
            }
        });

        Button num9 = (Button) findViewById(R.id.button9);
     //   panel = (TextView) findViewById(R.id.textView);
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panel.append("9");
            }
        });

        Button plus = (Button) findViewById(R.id.buttonAdd);
    //    panel = (TextView) findViewById(R.id.textView);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panel.append("+");
            }
        });

        Button minus = (Button) findViewById(R.id.buttonMinus);
     //   panel = (TextView) findViewById(R.id.textView);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panel.append("-");
            }
        });

        Button mutiple = (Button) findViewById(R.id.buttonMultiple);
     //   panel = (TextView) findViewById(R.id.textView);
        mutiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panel.append("*");
            }
        });

        Button devided = (Button) findViewById(R.id.buttonDevided);
    //    panel = (TextView) findViewById(R.id.textView);
        devided.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panel.append("/");
            }
        });

        Button dot = (Button) findViewById(R.id.buttonDot);
    //    panel = (TextView) findViewById(R.id.textView);
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panel.append(".");
            }
        });

        Button pleft = (Button) findViewById(R.id.buttonPLeft);
    //    panel = (TextView) findViewById(R.id.textView);
        pleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panel.append("(");
            }
        });

        Button pright = (Button) findViewById(R.id.buttonPRight);
    //    panel = (TextView) findViewById(R.id.textView);
        pright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panel.append(")");
            }
        });

        //AC means clear screen, so I use setText but not Append.
        Button clear = (Button) findViewById(R.id.buttonAC);
     //   panel = (TextView) findViewById(R.id.textView);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panel.setText(" ");
            }
        });

        //based on Expression.java, everything passed in panel is string, so need to
        //get the text and transfer it to string.
        Button equals = (Button) findViewById(R.id.buttonEqual);
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = panel.getText().toString();
                try {
                    Expression exp = new Expression(input);
                    BigDecimal answer;
                    answer = exp.eval();
                    String anwserStr = answer.toPlainString();
                    panel.setText(anwserStr);
                } catch (RuntimeException e) {
                    panel.setText("ERROR");
                }
            }
        });

        Button del = (Button) findViewById(R.id.buttonDEL);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (panel.getText().toString().length() > 0) {
                    String past = panel.getText().toString();
                    String now = past.substring(0, past.length() - 1);
                    panel.setText(now);
                }
            }
        });

        // santific calculator

        if (findViewById(R.id.buttonPercent) != null) {
            Button percent = (Button) findViewById(R.id.buttonPercent);
            percent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    panel.append("%");
                }
            });
        }
        if (findViewById(R.id.buttonSin) != null) {
            Button sin = (Button) findViewById(R.id.buttonSin);
            sin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    panel.append("sin(");
                }
            });
        }
        if (findViewById(R.id.buttonCos) != null) {
            Button cos = (Button) findViewById(R.id.buttonCos);
            cos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    panel.append("cos(");
                }
            });
        }
        if (findViewById(R.id.buttonTan) != null) {
            Button tan = (Button) findViewById(R.id.buttonTan);
            tan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    panel.append("tan(");
                }
            });
        }
        if (findViewById(R.id.buttonLn) != null) {
            Button ln = (Button) findViewById(R.id.buttonLn);
            ln.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    panel.append("Ln(");
                }
            });
        }
        if (findViewById(R.id.buttonLog) != null) {
            Button log = (Button) findViewById(R.id.buttonLog);
            log.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    panel.append("log(");
                }
            });
        }
        if (findViewById(R.id.button2up) != null) {
            Button pai = (Button) findViewById(R.id.button2up);
            pai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    panel.append("^");
                }
            });
        }
        if (findViewById(R.id.buttonEup) != null) {
            Button eup = (Button) findViewById(R.id.buttonEup);
            eup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    panel.append("e");
                }
            });
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //save the result when rotate?
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String input = panel.getText().toString();
        outState.putString("input", input);
    }
}
