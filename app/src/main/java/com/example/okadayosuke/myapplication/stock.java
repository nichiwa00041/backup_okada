package com.example.okadayosuke.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class stock extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        ImageButton btnPopGas = (ImageButton)findViewById(R.id.popup_gas);
        btnPopGas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertGas = new AlertDialog.Builder(stock.this);
                alertGas.setTitle("ガスコンロの備蓄");

                LayoutInflater inflater = LayoutInflater.from(stock.this);
                final View vGas = inflater.inflate(R.layout.activity_stock_pop_gas, null);


                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_gas",0);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)vGas.findViewById(R.id.input_gas);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                int kids = 0;
                kids = pref.getInt("key_kids", kids);

                int baby = 0;
                baby = pref.getInt("key_baby", baby);

                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                TextView tAdult = (TextView)vGas.findViewById(R.id.gas_adult);
                TextView tKids = (TextView)vGas.findViewById(R.id.gas_kids);
                TextView tBaby = (TextView)vGas.findViewById(R.id.gas_baby);

                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertGas.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText etGas = (EditText)vGas.findViewById(R.id.input_gas);
                        String strGas = etGas.getText().toString();

                        if(strGas.length() <= 0){
                            strGas = "0";
                        }

                        int i = Integer.parseInt(strGas);

                        e.putInt("key_gas", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E


                alertGas.setView(vGas);
                alertGas.show();
            }
        });

        ImageButton btnPopAlmi = (ImageButton)findViewById(R.id.popup_almi);
        btnPopAlmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertAlmi = new AlertDialog.Builder(stock.this);
                alertAlmi.setTitle("ラップ・アルミホイルの備蓄");

                LayoutInflater inflater2 = LayoutInflater.from(stock.this);
                final View vAlmi = inflater2.inflate(R.layout.activity_stock_pop_almi, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_almi",0);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)vAlmi.findViewById(R.id.input_almi);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                int kids = 0;
                kids = pref.getInt("key_kids", kids);

                int baby = 0;
                baby = pref.getInt("key_baby", baby);

                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                TextView tAdult = (TextView)vAlmi.findViewById(R.id.almi_adult);
                TextView tKids = (TextView)vAlmi.findViewById(R.id.almi_kids);
                TextView tBaby = (TextView)vAlmi.findViewById(R.id.almi_baby);

                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertAlmi.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText etAlmi = (EditText)vAlmi.findViewById(R.id.input_almi);
                        String strAlmi = etAlmi.getText().toString();

                        if(strAlmi.length() <= 0){
                            strAlmi = "0";
                        }

                        int i = Integer.parseInt(strAlmi);

                        e.putInt("key_almi", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertAlmi.setView(vAlmi);
                alertAlmi.show();
            }
        });

        ImageButton btnPopBombe = (ImageButton)findViewById(R.id.popup_bombe);
        btnPopBombe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertBombe = new AlertDialog.Builder(stock.this);
                alertBombe.setTitle("ガスボンベの備蓄");

                LayoutInflater inflater3 = LayoutInflater.from(stock.this);
                final View vBombe = inflater3.inflate(R.layout.activity_stock_pop_bombe, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_bombe",0);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)vBombe.findViewById(R.id.input_bombe);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                int kids = 0;
                kids = pref.getInt("key_kids", kids);

                int baby = 0;
                baby = pref.getInt("key_baby", baby);

                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                TextView tAdult = (TextView)vBombe.findViewById(R.id.bombe_adult);
                TextView tKids = (TextView)vBombe.findViewById(R.id.bombe_kids);
                TextView tBaby = (TextView)vBombe.findViewById(R.id.bombe_baby);

                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertBombe.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText etBombe = (EditText)vBombe.findViewById(R.id.input_bombe);
                        String strBombe = etBombe.getText().toString();

                        if(strBombe.length() <= 0){
                            strBombe = "0";
                        }

                        int i = Integer.parseInt(strBombe);

                        e.putInt("key_bombe", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertBombe.setView(vBombe);
                alertBombe.show();
            }
        });

        ImageButton btnPopGunnte = (ImageButton)findViewById(R.id.popup_gunnte);
        btnPopGunnte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertGunnte = new AlertDialog.Builder(stock.this);
                alertGunnte.setTitle("軍手の備蓄");

                LayoutInflater inflater4 = LayoutInflater.from(stock.this);
                final View vGunnte = inflater4.inflate(R.layout.activity_stock_pop_gunnte, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_gunte",0);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)vGunnte.findViewById(R.id.input_gunnte);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                int kids = 0;
                kids = pref.getInt("key_kids", kids);

                int baby = 0;
                baby = pref.getInt("key_baby", baby);

                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                TextView tAdult = (TextView)vGunnte.findViewById(R.id.gunte_adult);
                TextView tKids = (TextView)vGunnte.findViewById(R.id.gunte_kids);
                TextView tBaby = (TextView)vGunnte.findViewById(R.id.gunte_baby);

                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertGunnte.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText etGunnte = (EditText)vGunnte.findViewById(R.id.input_gunnte);
                        String strGunnte = etGunnte.getText().toString();

                        if(strGunnte.length() <= 0){
                            strGunnte = "0";
                        }

                        int i = Integer.parseInt(strGunnte);

                        e.putInt("key_gunte", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertGunnte.setView(vGunnte);
                alertGunnte.show();
            }
        });

        ImageButton btnPopHue = (ImageButton)findViewById(R.id.popup_hue);
        btnPopHue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertHue = new AlertDialog.Builder(stock.this);
                alertHue.setTitle("笛の備蓄");

                LayoutInflater inflater5 = LayoutInflater.from(stock.this);
                final View vHue = inflater5.inflate(R.layout.activity_stock_pop_hue, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_hue",0);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)vHue.findViewById(R.id.input_hue);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                int kids = 0;
                kids = pref.getInt("key_kids", kids);

                int baby = 0;
                baby = pref.getInt("key_baby", baby);

                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                TextView tAdult = (TextView)vHue.findViewById(R.id.hue_adult);
                TextView tKids = (TextView)vHue.findViewById(R.id.hue_kids);
                TextView tBaby = (TextView)vHue.findViewById(R.id.hue_baby);

                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertHue.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText etHue = (EditText)vHue.findViewById(R.id.input_hue);
                        String strHue = etHue.getText().toString();

                        if(strHue.length() <= 0){
                            strHue = "0";
                        }

                        int i = Integer.parseInt(strHue);

                        e.putInt("key_hue", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertHue.setView(vHue);
                alertHue.show();
            }
        });

        ImageButton btnPopMatti = (ImageButton)findViewById(R.id.popup_matti);
        btnPopMatti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertMatti = new AlertDialog.Builder(stock.this);
                alertMatti.setTitle("マッチ・ライターの備蓄");

                LayoutInflater inflater6 = LayoutInflater.from(stock.this);
                final View vMatti = inflater6.inflate(R.layout.activity_stock_pop_matti, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_matti",0);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)vMatti.findViewById(R.id.input_matti);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                int kids = 0;
                kids = pref.getInt("key_kids", kids);

                int baby = 0;
                baby = pref.getInt("key_baby", baby);

                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                TextView tAdult = (TextView)vMatti.findViewById(R.id.matti_adult);
                TextView tKids = (TextView)vMatti.findViewById(R.id.matti_kids);
                TextView tBaby = (TextView)vMatti.findViewById(R.id.matti_baby);

                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertMatti.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText etMatti = (EditText)vMatti.findViewById(R.id.input_matti);
                        String strMatti = etMatti.getText().toString();

                        if(strMatti.length() <= 0){
                            strMatti = "0";
                        }

                        int i = Integer.parseInt(strMatti);

                        e.putInt("key_matti", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertMatti.setView(vMatti);
                alertMatti.show();
            }
        });

        ImageButton btnPopSitagi = (ImageButton)findViewById(R.id.popup_sitagi);
        btnPopSitagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertSitagi = new AlertDialog.Builder(stock.this);
                alertSitagi.setTitle("下着の備蓄");

                LayoutInflater inflater7 = LayoutInflater.from(stock.this);
                final View vSitagi = inflater7.inflate(R.layout.activity_stock_pop_sitagi, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_sitagi",0);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)vSitagi.findViewById(R.id.input_sitagi);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                int kids = 0;
                kids = pref.getInt("key_kids", kids);

                int baby = 0;
                baby = pref.getInt("key_baby", baby);

                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                TextView tAdult = (TextView)vSitagi.findViewById(R.id.sitagi_adult);
                TextView tKids = (TextView)vSitagi.findViewById(R.id.sitagi_kids);
                TextView tBaby = (TextView)vSitagi.findViewById(R.id.sitagi_baby);

                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertSitagi.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText etSitagi = (EditText)vSitagi.findViewById(R.id.input_sitagi);
                        String strSitagi = etSitagi.getText().toString();

                        if(strSitagi.length() <= 0){
                            strSitagi = "0";
                        }

                        int i = Integer.parseInt(strSitagi);

                        e.putInt("key_sitagi", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertSitagi.setView(vSitagi);
                alertSitagi.show();
            }
        });

        ImageButton btnPopThissyu = (ImageButton)findViewById(R.id.popup_thissyu);
        btnPopThissyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertThissyu = new AlertDialog.Builder(stock.this);
                alertThissyu.setTitle("ティッシュの備蓄");

                LayoutInflater inflater8 = LayoutInflater.from(stock.this);
                final View vThissyu = inflater8.inflate(R.layout.activity_stock_pop_thissyu, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_thissyu",0);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)vThissyu.findViewById(R.id.input_thissyu);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                int kids = 0;
                kids = pref.getInt("key_kids", kids);

                int baby = 0;
                baby = pref.getInt("key_baby", baby);

                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                TextView tAdult = (TextView)vThissyu.findViewById(R.id.thissyu_adult);
                TextView tKids = (TextView)vThissyu.findViewById(R.id.thissyu_kids);
                TextView tBaby = (TextView)vThissyu.findViewById(R.id.thissyu_baby);

                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertThissyu.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText etThissyu = (EditText)vThissyu.findViewById(R.id.input_thissyu);
                        String strThissyu = etThissyu.getText().toString();

                        if(strThissyu.length() <= 0){
                            strThissyu = "0";
                        }

                        int i = Integer.parseInt(strThissyu);

                        e.putInt("key_thissyu", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertThissyu.setView(vThissyu);
                alertThissyu.show();
            }
        });

        //  画面遷移
        Button btnHome = (Button)findViewById(R.id.stock_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent();
                intentHome.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.MainActivity");

                startActivity(intentHome);
            }
        });

        Button btnSetting = (Button)findViewById(R.id.stock_setting);
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSetting = new Intent();
                intentSetting.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.setting");

                startActivity(intentSetting);
            }
        });

        Button btnFood = (Button)findViewById(R.id.stock_food);
        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFood = new Intent();
                intentFood.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.food");

                startActivity(intentFood);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stock, menu);
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
