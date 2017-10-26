package com.example.huchuan.calculator;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class SimpleCalculatorActivity extends Activity implements NavigationView.OnNavigationItemSelectedListener {
    private NavigationView navigationView;
    //fragments TODO
    private CalculatorFragment calculatorFragment;
    private ConverterFragment converterFragment;
    private SystemFragment systemFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件和声明事件
        navigationView=this.findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        // 设置默认的Fragment
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        calculatorFragment = new CalculatorFragment();
        transaction.replace(R.id.id_content,calculatorFragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        FragmentManager fm = getFragmentManager();
        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (id)
        {
            case R.id.calculator:
                if (calculatorFragment == null)
                {
                    calculatorFragment = new CalculatorFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.id_content, calculatorFragment);
                break;
            case R.id.converter:
                if (converterFragment == null)
                {
                    converterFragment = new ConverterFragment();
                }
                transaction.replace(R.id.id_content, converterFragment);
                break;
            case R.id.system:
                if (systemFragment == null)
                {
                    systemFragment = new SystemFragment();
                }
                transaction.replace(R.id.id_content, systemFragment);
                break;
        }
        // transaction.addToBackStack();
        // 事务提交
        transaction.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }
}
