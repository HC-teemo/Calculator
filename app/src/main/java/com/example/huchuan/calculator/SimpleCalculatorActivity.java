package com.example.huchuan.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SimpleCalculatorActivity extends Activity implements View.OnClickListener{

    Button btn_0,btn_1,btn_2,btn_3,btn_4,
            btn_5,btn_6,btn_7,btn_8,btn_9,
            btn_plus,btn_minus,btn_multiply,btn_divide,btn_equal,
            btn_clean,btn_dot,btn_leftBracket,btn_rightBracket;

    TextView input,output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Buttons
        btn_0=(Button) this.findViewById(R.id.zero);
        btn_1=(Button) this.findViewById(R.id.one);
        btn_2=(Button) this.findViewById(R.id.two);
        btn_3=(Button) this.findViewById(R.id.three);
        btn_4=(Button) this.findViewById(R.id.four);
        btn_5=(Button) this.findViewById(R.id.five);
        btn_6=(Button) this.findViewById(R.id.six);
        btn_7=(Button) this.findViewById(R.id.seven);
        btn_8=(Button) this.findViewById(R.id.eight);
        btn_9=(Button) this.findViewById(R.id.nine);
        btn_plus=(Button) this.findViewById(R.id.plus);
        btn_minus=(Button) this.findViewById(R.id.minus);
        btn_multiply=(Button) this.findViewById(R.id.multiply);
        btn_divide=(Button) this.findViewById(R.id.divide);
        btn_equal=(Button) this.findViewById(R.id.equal);
        btn_clean=(Button) this.findViewById(R.id.clean);
        btn_dot=(Button) this.findViewById(R.id.dot);
        btn_leftBracket=(Button) this.findViewById(R.id.leftBracket);
        btn_rightBracket=(Button) this.findViewById(R.id.rightBracket);
        //TextViews
        input=(TextView)this.findViewById(R.id.input);
        output=(TextView)this.findViewById(R.id.output);
        //setOnClick
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_clean.setOnClickListener(this);
        btn_leftBracket.setOnClickListener(this);
        btn_rightBracket.setOnClickListener(this);

        btn_clean.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                clean();
                return false;
            }
        });
        }
    //OnClickEvent
    @Override
    public void onClick(View v) {
        int id=v.getId();
        String tag=(String)v.getTag();
        switch (id){
            case R.id.clean:
                delete();
                break;
            case R.id.leftBracket:
                break;
            case R.id.rightBracket:
                break;
            case R.id.divide:
                break;
            case R.id.multiply:
                break;
            case R.id.minus:
                break;
            case R.id.plus:
                break;
            case R.id.equal:
                break;
            default:
                input(tag);
        }
    }

    private void input(String content) {
        input.append(content);
    }
    private void delete(){
        if(input.getText().length()>0)
        input.setText(input.getText().subSequence(0,input.getText().length()-1));
    }
    private void clean(){
        input.setText("");
    }
}
