package com.example.huchuan.calculator;


import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.NavigationView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment implements View.OnClickListener {

    Button btn_0,btn_1,btn_2,btn_3,btn_4,
            btn_5,btn_6,btn_7,btn_8,btn_9,
            btn_plus,btn_minus,btn_multiply,btn_divide,btn_equal,
            btn_clean,btn_dot,btn_leftBracket,btn_rightBracket;

    TextView input,output;

    String calculateResult="";

    public CalculatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_calculator, container, false);
        //Buttons
        btn_0=(Button) view.findViewById(R.id.zero);
        btn_1=(Button) view.findViewById(R.id.one);
        btn_2=(Button) view.findViewById(R.id.two);
        btn_3=(Button) view.findViewById(R.id.three);
        btn_4=(Button) view.findViewById(R.id.four);
        btn_5=(Button) view.findViewById(R.id.five);
        btn_6=(Button) view.findViewById(R.id.six);
        btn_7=(Button) view.findViewById(R.id.seven);
        btn_8=(Button) view.findViewById(R.id.eight);
        btn_9=(Button) view.findViewById(R.id.nine);
        btn_plus=(Button) view.findViewById(R.id.plus);
        btn_minus=(Button) view.findViewById(R.id.minus);
        btn_multiply=(Button) view.findViewById(R.id.multiply);
        btn_divide=(Button) view.findViewById(R.id.divide);
        btn_equal=(Button) view.findViewById(R.id.equal);
        btn_clean=(Button) view.findViewById(R.id.clean);
        btn_dot=(Button) view.findViewById(R.id.dot);
        btn_leftBracket=(Button) view.findViewById(R.id.leftBracket);
        btn_rightBracket=(Button) view.findViewById(R.id.rightBracket);
        //TextViews
        input=(TextView)view.findViewById(R.id.input);
        output=(TextView)view.findViewById(R.id.output);
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
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String changed=input.getText().toString();
                if(!changed.equals("")){
                    Log.i("change",changed);
                    calculateResult=calculate(changed);
                    if(!calculateResult.equals("表达式错误")){
                        output.setText(calculateResult);
                    }
                }
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        String tag=(String)v.getTag();
        switch (id){
            case R.id.clean:
                delete();
                break;
//            case R.id.leftBracket:
//                break;
//            case R.id.rightBracket:
//                break;
//            case R.id.divide:
//                break;
//            case R.id.multiply:
//                break;
//            case R.id.minus:
//                break;
//            case R.id.plus:
//                break;
            case R.id.equal:
                //output.setText(calculate(input.getText().toString()));
//                String result=calculate(input.getText().toString());
                if(calculateResult.equals("表达式错误")){
                    output.setText(calculateResult);
                }else {
                    input.setText(calculateResult);
                    output.setText("");
                    calculateResult="";
                }
                break;
            default:
                input(tag);
        }
    }

    private void input(String content){
        input.append(content);
    }
    private void delete(){
        if(input.getText().length()>0)
            input.setText(input.getText().subSequence(0,input.getText().length()-1));
    }
    private void clean(){
        input.setText("");
        output.setText("");
    }
    private String calculate(String input){
        input=input.replace('×','*').replace('÷','/');
        Calculator calculator=new Calculator();
        String result;
        result=calculator.calculate(input);
        return result;
    }

}
