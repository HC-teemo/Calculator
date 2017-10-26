package com.example.huchuan.calculator;


import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.huchuan.calculator.style.ImgItem;
import com.example.huchuan.calculator.style.MyAdapter;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class SystemFragment extends Fragment implements View.OnClickListener {

    private Spinner spinner1;
    private Spinner spinner2;
    private TextView input1;
    private TextView input2;
    private Button btn_0,btn_1,btn_2,btn_3,btn_4,
            btn_5,btn_6,btn_7,btn_8,btn_9,
            btn_clean,btn_a,btn_b,btn_c,btn_d,btn_e,btn_f;
    private Button[] buttons;
    private FloatingActionButton floatingActionButton;
    private String sys1="二进制";
    private String sys2="二进制";
    public SystemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_system, container, false);
        //初始化控件
        spinner1=view.findViewById(R.id.sys1);
        spinner2=view.findViewById(R.id.sys2);
        input1=view.findViewById(R.id.num1);
        input2=view.findViewById(R.id.num2);
        //Buttons
        btn_0=(Button) view.findViewById(R.id.zero3);
        btn_1=(Button) view.findViewById(R.id.one3);
        btn_2=(Button) view.findViewById(R.id.two3);
        btn_3=(Button) view.findViewById(R.id.three3);
        btn_4=(Button) view.findViewById(R.id.four3);
        btn_5=(Button) view.findViewById(R.id.five3);
        btn_6=(Button) view.findViewById(R.id.six3);
        btn_7=(Button) view.findViewById(R.id.seven3);
        btn_8=(Button) view.findViewById(R.id.eight3);
        btn_9=(Button) view.findViewById(R.id.nine3);
        btn_clean=(Button) view.findViewById(R.id.clean3);
        btn_a=(Button) view.findViewById(R.id.a3);
        btn_b=(Button) view.findViewById(R.id.b3);
        btn_c=(Button) view.findViewById(R.id.c3);
        btn_d=(Button) view.findViewById(R.id.d3);
        btn_e=(Button) view.findViewById(R.id.e3);
        btn_f=(Button) view.findViewById(R.id.f3);
        buttons= new Button[]{btn_0, btn_1,btn_2,btn_3, btn_4,btn_5,btn_6, btn_7,btn_8,btn_9, btn_a,btn_b,btn_c, btn_d,btn_e,btn_f};
        floatingActionButton=view.findViewById(R.id.floatingActionButton2);
        //setOnClick
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos1= spinner1.getSelectedItemPosition();
                int pos2= spinner2.getSelectedItemPosition();
                spinner1.setSelection(pos2);
                spinner2.setSelection(pos1);
            }
        });
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
        btn_clean.setOnClickListener(this);
        btn_a.setOnClickListener(this);
        btn_b.setOnClickListener(this);
        btn_c.setOnClickListener(this);
        btn_d.setOnClickListener(this);
        btn_e.setOnClickListener(this);
        btn_f.setOnClickListener(this);
        // 建立数据源
        final List<ImgItem> syses=new ArrayList<ImgItem>();
        syses.add(new ImgItem( "二进制"));
        syses.add(new ImgItem( "八进制"));
        syses.add(new ImgItem( "十进制"));
        syses.add(new ImgItem( "十六进制"));
        //  建立Adapter绑定数据源
        MyAdapter _MyAdapter=new MyAdapter(syses,getActivity());
        //绑定Adapter
        spinner1.setAdapter(_MyAdapter);
        spinner2.setAdapter(_MyAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                sys1=syses.get(pos).getItemName();
                changeBtn(sys1);
                calculate();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                sys2=syses.get(pos).getItemName();
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return view;
    }

    private void changeBtn(String sys) {
        switch (sys){
            case "二进制":
                for (int i=0;i<buttons.length;i++){
                    buttons[i].setClickable(false);
                    buttons[i].setTextColor(getResources().getColor(R.color.gray));
                }
                btn_0.setClickable(true);
                btn_0.setTextColor(getResources().getColor(R.color.blue));
                btn_1.setClickable(true);
                btn_1.setTextColor(getResources().getColor(R.color.blue));
                break;
            case "八进制":
                for (int i=0;i<buttons.length;i++){
                    buttons[i].setClickable(false);
                    buttons[i].setTextColor(getResources().getColor(R.color.gray));
                }
                for (int i=0;i<8;i++){
                    buttons[i].setClickable(true);
                    buttons[i].setTextColor(getResources().getColor(R.color.blue));
                }
                break;
            case "十进制":
                for (int i=0;i<buttons.length;i++){
                    buttons[i].setClickable(false);
                    buttons[i].setTextColor(getResources().getColor(R.color.gray));
                }
                for (int i=0;i<10;i++){
                    buttons[i].setClickable(true);
                    buttons[i].setTextColor(getResources().getColor(R.color.blue));
                }
                break;
            case "十六进制":
                for (int i=0;i<buttons.length;i++){
                    buttons[i].setClickable(true);
                    buttons[i].setTextColor(getResources().getColor(R.color.blue));
                }
                break;

        }
    }

    private void calculate() {
        int sysInt1=2;
        int sysInt2 = 2;
        switch (sys1){
            case "二进制":
                sysInt1=2;
                break;
            case "八进制":
                sysInt1=8;
                break;
            case "十进制":
                sysInt1=10;
                break;
            case "十六进制":
                sysInt1=16;
                break;
        }
        switch (sys2){
            case "二进制":
                sysInt2=2;
                break;
            case "八进制":
                sysInt2=8;
                break;
            case "十进制":
                sysInt2=10;
                break;
            case "十六进制":
                sysInt2=16;
                break;
        }
        Log.i("value", "in1Int: "+sysInt1+sysInt2);
        String in1=input1.getText().toString();
        Log.i("value", "in1: "+in1);
        int ten=Integer.valueOf(in1,sysInt1);
        Log.i("value", "ten:: "+ten);
        String result="";
        switch (sysInt2){
            case 2:
                result=Integer.toBinaryString(ten);
                break;
            case 8:
                result=Integer.toOctalString(ten);
                break;
            case 10:
                result=String.valueOf(ten);
                break;
            case 16:
                result=Integer.toHexString(ten);
                break;
        }
        Log.i("value", "result: "+result);
        input2.setText(result);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        String tag=(String)v.getTag();
        switch (id){
            case R.id.clean3:
                delete();
                calculate();
                break;
            default:
                input(tag);
                calculate();
        }
    }

    private void input(String content){
        if(input1.getText().toString().equals("0")){
            Log.i("test", "input: "+input1.getText());
            input1.setText("");
        }
        input1.append(content);
    }
    private void delete(){
        if(input1.getText().length()>0)
            input1.setText(input1.getText().subSequence(0,input1.getText().length()-1));
        if(input1.getText().length()==0)
            input1.setText("0");
    }
}
