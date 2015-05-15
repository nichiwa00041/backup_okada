package com.example.okadayosuke.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import android.content.SharedPreferences.Editor;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.AdapterView.OnItemClickListener;


public class setting extends Activity {


    protected void onStart() {
        super.onStart();
        SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);

        int aAdt = pref.getInt("array_adult", 0);
        ((Spinner) findViewById(R.id.spinner1)).setSelection(aAdt);
        int akid = pref.getInt("array_kids", 0);
        ((Spinner) findViewById(R.id.spinner2)).setSelection(akid);
        int abay = pref.getInt("array_baby", 0);
        ((Spinner) findViewById(R.id.spinner3)).setSelection(abay);
        int alit = pref.getInt("array_limit", 0);
        ((Spinner) findViewById(R.id.spinner4)).setSelection(alit);
        int aSet = pref.getInt("array_setting", 1);
        ((Spinner) findViewById(R.id.spinner5)).setSelection(aSet);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Button btnHome = (Button)findViewById(R.id.setting_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  インデント作成
                Intent intentHome = new Intent();
                intentHome.setClassName("com.example.okadayosuke.myapplication","com.example.okadayosuke.myapplication.MainActivity");

                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                Spinner spiAdt = (Spinner)findViewById(R.id.spinner1);
                String strAdt = (String)spiAdt.getSelectedItem();
                int adt = Integer.parseInt(strAdt);

                Editor eAdt = pref.edit();
                eAdt.putInt("key_adult", adt);
                eAdt.commit();

                Editor eAAdt = pref.edit();
                int aAdt = ArrayHuman(adt);
                eAAdt.putInt("array_adult", aAdt);
                eAAdt.commit();

                //
                Spinner spiKid = (Spinner)findViewById(R.id.spinner2);
                String strKid = (String)spiKid.getSelectedItem();
                int kid = Integer.parseInt(strKid);

                Editor eKid = pref.edit();
                eKid.putInt("key_kids", kid);
                eKid.commit();

                Editor eAKid = pref.edit();
                int aKid = ArrayHuman(kid);
                eAKid.putInt("array_kids", aKid);
                eAKid.commit();


                Spinner spiBay = (Spinner)findViewById(R.id.spinner3);
                String strBay = (String)spiBay.getSelectedItem();
                int bay = Integer.parseInt(strBay);

                Editor eBay = pref.edit();
                eBay.putInt("key_baby", bay);
                eBay.commit();

                Editor eABay = pref.edit();
                int aBay = ArrayHuman(bay);
                eABay.putInt("array_baby", aBay);
                eABay.commit();


                Spinner spiLit = (Spinner)findViewById(R.id.spinner4);
                String strLit = (String)spiLit.getSelectedItem();
                int lit = Integer.parseInt(strLit);

                Editor eLit = pref.edit();
                eLit.putInt("key_limit", lit);
                eLit.commit();

                Editor eALit = pref.edit();
                int aLit = ArrayLimit(lit);
                eALit.putInt("array_limit", aLit);
                eALit.commit();


                Spinner spiSet = (Spinner)findViewById(R.id.spinner5);
                String strSet = (String)spiSet.getSelectedItem();
                int set = Integer.parseInt(strSet);

                Editor eSet = pref.edit();
                eSet.putInt("key_setting", set);
                eSet.commit();

                Editor eASet = pref.edit();
                int aSet = ArraySetting(set);
                eASet.putInt("array_setting", aSet);
                eASet.commit();

                startActivity(intentHome);
           }
        });

        Button btnStock = (Button)findViewById(R.id.setting_stock);
        btnStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  インデント作成
                Intent intentStock = new Intent();
                intentStock.setClassName("com.example.okadayosuke.myapplication","com.example.okadayosuke.myapplication.stock");

                //  プリファレンス
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                Spinner spiAdt = (Spinner)findViewById(R.id.spinner1);
                String strAdt = (String)spiAdt.getSelectedItem();
                int adt = Integer.parseInt(strAdt);

                Editor eAdt = pref.edit();
                eAdt.putInt("key_adult", adt);
                eAdt.commit();

                Editor eAAdt = pref.edit();
                int aAdt = ArrayHuman(adt);
                eAAdt.putInt("array_adult", aAdt);
                eAAdt.commit();

                //
                Spinner spiKid = (Spinner)findViewById(R.id.spinner2);
                String strKid = (String)spiKid.getSelectedItem();
                int kid = Integer.parseInt(strKid);

                Editor eKid = pref.edit();
                eKid.putInt("key_kids", kid);
                eKid.commit();

                Editor eAKid = pref.edit();
                int aKid = ArrayHuman(kid);
                eAKid.putInt("array_kids", aKid);
                eAKid.commit();


                Spinner spiBay = (Spinner)findViewById(R.id.spinner3);
                String strBay = (String)spiBay.getSelectedItem();
                int bay = Integer.parseInt(strBay);

                Editor eBay = pref.edit();
                eBay.putInt("key_baby", bay);
                eBay.commit();

                Editor eABay = pref.edit();
                int aBay = ArrayHuman(bay);
                eABay.putInt("array_baby", aBay);
                eABay.commit();


                Spinner spiLit = (Spinner)findViewById(R.id.spinner4);
                String strLit = (String)spiLit.getSelectedItem();
                int lit = Integer.parseInt(strLit);

                Editor eLit = pref.edit();
                eLit.putInt("key_limit", lit);
                eLit.commit();

                Editor eALit = pref.edit();
                int aLit = ArrayLimit(lit);
                eALit.putInt("array_limit", aLit);
                eALit.commit();


                Spinner spiSet = (Spinner)findViewById(R.id.spinner5);
                String strSet = (String)spiSet.getSelectedItem();
                int set = Integer.parseInt(strSet);

                Editor eSet = pref.edit();
                eSet.putInt("key_setting", set);
                eSet.commit();

                Editor eASet = pref.edit();
                int aSet = ArraySetting(set);
                eASet.putInt("array_setting", aSet);
                eASet.commit();

                startActivity(intentStock);
            }
        });



        Button btnFood = (Button)findViewById(R.id.setting_food);
        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  インデント作成
                Intent intentFood = new Intent();
                intentFood.setClassName("com.example.okadayosuke.myapplication","com.example.okadayosuke.myapplication.food");

                //  プリファレンス
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                Spinner spiAdt = (Spinner)findViewById(R.id.spinner1);
                String strAdt = (String)spiAdt.getSelectedItem();
                int adt = Integer.parseInt(strAdt);

                Editor eAdt = pref.edit();
                eAdt.putInt("key_adult", adt);
                eAdt.commit();

                Editor eAAdt = pref.edit();
                int aAdt = ArrayHuman(adt);
                eAAdt.putInt("array_adult", aAdt);
                eAAdt.commit();

                //
                Spinner spiKid = (Spinner)findViewById(R.id.spinner2);
                String strKid = (String)spiKid.getSelectedItem();
                int kid = Integer.parseInt(strKid);

                Editor eKid = pref.edit();
                eKid.putInt("key_kids", kid);
                eKid.commit();

                Editor eAKid = pref.edit();
                int aKid = ArrayHuman(kid);
                eAKid.putInt("array_kids", aKid);
                eAKid.commit();


                Spinner spiBay = (Spinner)findViewById(R.id.spinner3);
                String strBay = (String)spiBay.getSelectedItem();
                int bay = Integer.parseInt(strBay);

                Editor eBay = pref.edit();
                eBay.putInt("key_baby", bay);
                eBay.commit();

                Editor eABay = pref.edit();
                int aBay = ArrayHuman(bay);
                eABay.putInt("array_baby", aBay);
                eABay.commit();


                Spinner spiLit = (Spinner)findViewById(R.id.spinner4);
                String strLit = (String)spiLit.getSelectedItem();
                int lit = Integer.parseInt(strLit);

                Editor eLit = pref.edit();
                eLit.putInt("key_limit", lit);
                eLit.commit();

                Editor eALit = pref.edit();
                int aLit = ArrayLimit(lit);
                eALit.putInt("array_limit", aLit);
                eALit.commit();


                Spinner spiSet = (Spinner)findViewById(R.id.spinner5);
                String strSet = (String)spiSet.getSelectedItem();
                int set = Integer.parseInt(strSet);

                Editor eSet = pref.edit();
                eSet.putInt("key_setting", set);
                eSet.commit();

                Editor eASet = pref.edit();
                int aSet = ArraySetting(set);
                eASet.putInt("array_setting", aSet);
                eASet.commit();


                startActivity(intentFood);
            }
        });

    }

    //
    public int ArrayHuman(int array)
    {
        int num = 0;
        switch(array){
            case 0: num = 0; break;
            case 1: num = 1; break;
            case 2: num = 2; break;
            case 3: num = 3; break;
            case 4: num = 4; break;
            case 5: num = 5; break;
            case 6: num = 6; break;
            case 7: num = 7; break;
            case 8: num = 8; break;
            case 9: num = 9; break;
        }
        return num;
    }

    //
    public int ArrayLimit(int array)
    {
        int num = 0;
        switch(array){
            case 14: num = 0; break;
            case 30: num = 1; break;
            case 60: num = 2; break;
        }
        return num;
    }

    //
    public int ArraySetting (int array)
    {
        int num = 0;
        switch(array){
            case 1: num = 0; break;
            case 3: num = 1; break;
            case 7: num = 2; break;
        }
        return num;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_setting, menu);
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
}
