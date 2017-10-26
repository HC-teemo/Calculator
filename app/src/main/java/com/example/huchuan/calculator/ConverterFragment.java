package com.example.huchuan.calculator;


import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
public class ConverterFragment extends Fragment implements View.OnClickListener {

    private Spinner spinner1;
    private Spinner spinner2;
    private TextView input1;
    private TextView input2;
    private Button btn_0,btn_1,btn_2,btn_3,btn_4,
            btn_5,btn_6,btn_7,btn_8,btn_9,
            btn_clean,btn_dot;
    private FloatingActionButton floatingActionButton;
    private String money1="CNY";
    private String money2="CNY";
    private Map<String,Double> units=new HashMap<>();
    private String[] unitsArr={"CNY",
            "USD",
            "EUR",
            "GBP",
            "JPY",
            "AUD",
            "CAD"};
    public ConverterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_converter, container, false);
        //初始化控件
        spinner1=view.findViewById(R.id.con1);
        spinner2=view.findViewById(R.id.con2);
        input1=view.findViewById(R.id.money1);
        input2=view.findViewById(R.id.money2);
        //Buttons
        btn_0=(Button) view.findViewById(R.id.zero2);
        btn_1=(Button) view.findViewById(R.id.one2);
        btn_2=(Button) view.findViewById(R.id.two2);
        btn_3=(Button) view.findViewById(R.id.three2);
        btn_4=(Button) view.findViewById(R.id.four2);
        btn_5=(Button) view.findViewById(R.id.five2);
        btn_6=(Button) view.findViewById(R.id.six2);
        btn_7=(Button) view.findViewById(R.id.seven2);
        btn_8=(Button) view.findViewById(R.id.eight2);
        btn_9=(Button) view.findViewById(R.id.nine2);
        btn_clean=(Button) view.findViewById(R.id.clean2);
        btn_dot=(Button) view.findViewById(R.id.dot2);
        floatingActionButton=view.findViewById(R.id.floatingActionButton);
        //setOnClick
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("test", "onClick: "+money1+money2);
                int pos1= spinner1.getSelectedItemPosition();
                int pos2= spinner2.getSelectedItemPosition();
                spinner1.setSelection(pos2);
                spinner2.setSelection(pos1);
                Log.i("test", "onClick: "+money1+money2);
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
        btn_dot.setOnClickListener(this);
        btn_clean.setOnClickListener(this);
        units.put("CNY",6.62);
        units.put("USD",1.0);
        units.put("EUR",0.85);
        units.put("GBP",0.76);
        units.put("JPY",113.48);
        units.put("AUD",1.28);
        units.put("CAD",1.26);
        // 建立数据源
        String[] mItems = getResources().getStringArray(R.array.money);
        // 建立数据源
        final List<ImgItem> moneys=new ArrayList<ImgItem>();
        Log.i("图片", String.valueOf(R.drawable.as));
        moneys.add(new ImgItem(R.drawable.ch, "CNY"));
        moneys.add(new ImgItem(R.drawable.us, "USD"));
        moneys.add(new ImgItem(R.drawable.eu, "EUR"));
        moneys.add(new ImgItem(R.drawable.uk, "GBP"));
        moneys.add(new ImgItem(R.drawable.jp, "JPY"));
        moneys.add(new ImgItem(R.drawable.as, "AUD"));
        moneys.add(new ImgItem(R.drawable.cd, "CAD"));
        //  建立Adapter绑定数据源
        MyAdapter _MyAdapter=new MyAdapter(moneys,getActivity());
        //绑定Adapter
        spinner1.setAdapter(_MyAdapter);
        spinner2.setAdapter(_MyAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                money1=moneys.get(pos).getItemName();
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
                money2=moneys.get(pos).getItemName();
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return view;
    }

    private void calculate() {
        Double val1=Double.parseDouble(input1.getText().toString());
        Double times1=units.get(money1);
        Log.i("test", "calculate: "+money1);
        Log.i("test", "calculate: "+money2);
        Log.i("test", "calculate: "+units.get(money1));
        Log.i("test", "calculate: "+units.get(money2));
        Double times2=units.get(money2);
        Double val2=val1/times1*times2;
        Log.i("test", "calculate: "+val2);
        double eps = 1e-10;
        DecimalFormat df=new DecimalFormat("0.00");
        input2.setText(df.format(val2).toString());
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        String tag=(String)v.getTag();
        switch (id){
            case R.id.clean2:
                delete();
                calculate();
                break;
            case R.id.dot2:
                if(input1.getText().toString().contains("."))
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
