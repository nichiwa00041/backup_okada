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

                String strAdult = String.valueOf(adult);

                TextView tAdult = (TextView)vGas.findViewById(R.id.gas_adult);

                tAdult.setText(strAdult);

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
                alertAlmi.setTitle("アルミホイル");

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

                String strAdult = String.valueOf(adult);

                TextView tAdult = (TextView)vAlmi.findViewById(R.id.almi_adult);

                tAdult.setText(strAdult);

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

                String strAdult = String.valueOf(adult);

                TextView tAdult = (TextView)vBombe.findViewById(R.id.bombe_adult);

                tAdult.setText(strAdult);

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

                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);

                TextView tAdult = (TextView)vGunnte.findViewById(R.id.gunte_adult);
                TextView tKids = (TextView)vGunnte.findViewById(R.id.gunte_kids);

                tAdult.setText(strAdult);
                tKids.setText(strKids);

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

                String strAdult = String.valueOf(adult);

                TextView tAdult = (TextView)vHue.findViewById(R.id.hue_adult);

                tAdult.setText(strAdult);

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


                String strAdult = String.valueOf(adult);

                TextView tAdult = (TextView)vMatti.findViewById(R.id.matti_adult);

                tAdult.setText(strAdult);

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

        ImageButton btnPopThissyu = (ImageButton)findViewById(R.id.popup_thissyu);
        btnPopThissyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertThissyu = new AlertDialog.Builder(stock.this);
                alertThissyu.setTitle("ティッシュ");

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

                String strAdult = String.valueOf(adult);

                TextView tAdult = (TextView)vThissyu.findViewById(R.id.thissyu_adult);

                tAdult.setText(strAdult);

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

        ImageButton btnPopSitagi = (ImageButton)findViewById(R.id.popup_otona);
        btnPopSitagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(stock.this);
                alert.setTitle("大人下着の備蓄");

                LayoutInflater inflater = LayoutInflater.from(stock.this);
                final View viw = inflater.inflate(R.layout.activity_stock_pop_otona, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_sitagi",i);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)viw.findViewById(R.id.input_otona);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                TextView tx1 = (TextView)viw.findViewById(R.id.textView159);

                tx1.setText("大人" + adult + "人");

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alert.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText et = (EditText)viw.findViewById(R.id.input_otona);
                        String str = et.getText().toString();

                        if(str.length() <= 0){
                            str = "0";
                        }

                        int i = Integer.parseInt(str);

                        e.putInt("key_sitagi", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alert.setView(viw);
                alert.show();
            }
        });


        ImageButton btnPopKodomo = (ImageButton)findViewById(R.id.popup_kodomo);
        btnPopKodomo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(stock.this);
                alert.setTitle("小人下着の備蓄");

                LayoutInflater inflater = LayoutInflater.from(stock.this);
                final View viw = inflater.inflate(R.layout.activity_stock_pop_kodomo, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_kodomositagi",i);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)viw.findViewById(R.id.input_kodomo);

                et.setText(str);

                //  のちに整理すること
                int kids = 0;
                kids = pref.getInt("key_kids", kids);

                TextView tx2 = (TextView)viw.findViewById(R.id.textView162);

                tx2.setText("小人" + kids + "人");


                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alert.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText et = (EditText)viw.findViewById(R.id.input_kodomo);
                        String str = et.getText().toString();

                        if(str.length() <= 0){
                            str = "0";
                        }

                        int i = Integer.parseInt(str);

                        e.putInt("key_kodomositagi", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alert.setView(viw);
                alert.show();
            }
        });


        ImageButton btnPopKaichuu = (ImageButton)findViewById(R.id.popup_kaichuudentou);
        btnPopKaichuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(stock.this);
                alert.setTitle("懐中電灯");

                LayoutInflater inflater = LayoutInflater.from(stock.this);
                final View viw = inflater.inflate(R.layout.activity_stock_pop_kaichuudenntou, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_kaichuudenntou",i);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)viw.findViewById(R.id.input_kaichuudenntou);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                TextView tx1 = (TextView)viw.findViewById(R.id.textView152);

                tx1.setText("大人" + adult + "人");


                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alert.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText et = (EditText)viw.findViewById(R.id.input_kaichuudenntou);
                        String str = et.getText().toString();

                        if(str.length() <= 0){
                            str = "0";
                        }

                        int i = Integer.parseInt(str);

                        e.putInt("key_kaichuudenntou", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alert.setView(viw);
                alert.show();
            }
        });


        ImageButton btnPopKoppu = (ImageButton)findViewById(R.id.popup_koppu);
        btnPopKoppu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(stock.this);
                alert.setTitle("コップ（プラスチック）");

                LayoutInflater inflater = LayoutInflater.from(stock.this);
                final View viw = inflater.inflate(R.layout.activity_stock_pop_koppu, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_koppu",i);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)viw.findViewById(R.id.input_koppu);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                int kids = 0;
                kids = pref.getInt("key_kids", kids);

                int baby = 0;
                baby = pref.getInt("key_baby", baby);

                TextView tx1 = (TextView)viw.findViewById(R.id.textView166);
                TextView tx2 = (TextView)viw.findViewById(R.id.textView165);
                TextView tx3 = (TextView)viw.findViewById(R.id.textView164);

                tx1.setText("大人" + adult + "人");
                tx2.setText("小人" + kids + "人");
                tx3.setText("幼児" + baby + "人");


                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alert.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText et = (EditText)viw.findViewById(R.id.input_koppu);
                        String str = et.getText().toString();

                        if(str.length() <= 0){
                            str = "0";
                        }

                        int i = Integer.parseInt(str);

                        e.putInt("key_koppu", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alert.setView(viw);
                alert.show();
            }
        });


        ImageButton btnPopUtuwa = (ImageButton)findViewById(R.id.popup_utuwa);
        btnPopUtuwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(stock.this);
                alert.setTitle("器（プラスチック）");

                LayoutInflater inflater = LayoutInflater.from(stock.this);
                final View viw = inflater.inflate(R.layout.activity_stock_pop_utuwa, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_utuwa",i);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)viw.findViewById(R.id.input_utuwa);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                int kids = 0;
                kids = pref.getInt("key_kids", kids);

                int baby = 0;
                baby = pref.getInt("key_baby", baby);

                TextView tx1 = (TextView)viw.findViewById(R.id.textView170);
                TextView tx2 = (TextView)viw.findViewById(R.id.textView169);
                TextView tx3 = (TextView)viw.findViewById(R.id.textView168);

                tx1.setText("大人" + adult + "人");
                tx2.setText("小人" + kids + "人");
                tx3.setText("幼児" + baby + "人");


                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alert.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText et = (EditText)viw.findViewById(R.id.input_utuwa);
                        String str = et.getText().toString();

                        if(str.length() <= 0){
                            str = "0";
                        }

                        int i = Integer.parseInt(str);

                        e.putInt("key_utuwa", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alert.setView(viw);
                alert.show();
            }
        });


        ImageButton btnPopTaoru = (ImageButton)findViewById(R.id.popup_taoru);
        btnPopTaoru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(stock.this);
                alert.setTitle("タオル");

                LayoutInflater inflater = LayoutInflater.from(stock.this);
                final View viw = inflater.inflate(R.layout.activity_stock_pop_taoru, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_taoru",i);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)viw.findViewById(R.id.input_taoru);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                int kids = 0;
                kids = pref.getInt("key_kids", kids);

                int baby = 0;
                baby = pref.getInt("key_baby", baby);

                TextView tx1 = (TextView)viw.findViewById(R.id.textView174);
                TextView tx2 = (TextView)viw.findViewById(R.id.textView173);
                TextView tx3 = (TextView)viw.findViewById(R.id.textView172);

                tx1.setText("大人" + adult + "人");
                tx2.setText("小人" + kids + "人");
                tx3.setText("幼児" + baby + "人");


                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alert.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText et = (EditText)viw.findViewById(R.id.input_taoru);
                        String str = et.getText().toString();

                        if(str.length() <= 0){
                            str = "0";
                        }

                        int i = Integer.parseInt(str);

                        e.putInt("key_taoru", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alert.setView(viw);
                alert.show();
            }
        });


        ImageButton btnPopRappu = (ImageButton)findViewById(R.id.popup_rappu);
        btnPopRappu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(stock.this);
                alert.setTitle("ラップ");

                LayoutInflater inflater = LayoutInflater.from(stock.this);
                final View viw = inflater.inflate(R.layout.activity_stock_pop_rappu, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_rappu",i);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)viw.findViewById(R.id.input_rappu);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                TextView tx1 = (TextView)viw.findViewById(R.id.textView176);

                tx1.setText("大人" + adult + "人");

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alert.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText et = (EditText)viw.findViewById(R.id.input_rappu);
                        String str = et.getText().toString();

                        if(str.length() <= 0){
                            str = "0";
                        }

                        int i = Integer.parseInt(str);

                        e.putInt("key_rappu", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alert.setView(viw);
                alert.show();
            }
        });


        ImageButton btnPopHukuro = (ImageButton)findViewById(R.id.popup_hukuro);
        btnPopHukuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(stock.this);
                alert.setTitle("ビニール袋");

                LayoutInflater inflater = LayoutInflater.from(stock.this);
                final View viw = inflater.inflate(R.layout.activity_stock_pop_hukuro, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_hukuro",i);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)viw.findViewById(R.id.input_hukuro);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                TextView tx1 = (TextView)viw.findViewById(R.id.textView178);

                tx1.setText("大人" + adult + "人");



                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alert.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText et = (EditText)viw.findViewById(R.id.input_hukuro);
                        String str = et.getText().toString();

                        if(str.length() <= 0){
                            str = "0";
                        }

                        int i = Integer.parseInt(str);

                        e.putInt("key_hukuro", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alert.setView(viw);
                alert.show();
            }
        });


        ImageButton btnPopSpoon = (ImageButton)findViewById(R.id.popup_spoon);
        btnPopSpoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(stock.this);
                alert.setTitle("スプーン");

                LayoutInflater inflater = LayoutInflater.from(stock.this);
                final View viw = inflater.inflate(R.layout.activity_stock_pop_spoon, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_spoon",i);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)viw.findViewById(R.id.input_spoon);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                TextView tx1 = (TextView)viw.findViewById(R.id.textView180);

                tx1.setText("大人" + adult + "人");

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alert.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText et = (EditText)viw.findViewById(R.id.input_spoon);
                        String str = et.getText().toString();

                        if(str.length() <= 0){
                            str = "0";
                        }

                        int i = Integer.parseInt(str);

                        e.putInt("key_spoon", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alert.setView(viw);
                alert.show();
            }
        });


        ImageButton btnPopHasi = (ImageButton)findViewById(R.id.popup_hasi);
        btnPopHasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(stock.this);
                alert.setTitle("割り箸");

                LayoutInflater inflater = LayoutInflater.from(stock.this);
                final View viw = inflater.inflate(R.layout.activity_stock_pop_hasi, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_hasi",i);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)viw.findViewById(R.id.input_hasi);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                TextView tx1 = (TextView)viw.findViewById(R.id.textView182);

                tx1.setText("大人" + adult + "人");

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alert.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText et = (EditText)viw.findViewById(R.id.input_hasi);
                        String str = et.getText().toString();

                        if(str.length() <= 0){
                            str = "0";
                        }

                        int i = Integer.parseInt(str);

                        e.putInt("key_hasi", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alert.setView(viw);
                alert.show();
            }
        });


        ImageButton btnPopDenti = (ImageButton)findViewById(R.id.popup_denti);
        btnPopDenti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(stock.this);
                alert.setTitle("乾電池");

                LayoutInflater inflater = LayoutInflater.from(stock.this);
                final View viw = inflater.inflate(R.layout.activity_stock_pop_denti, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_denti",i);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)viw.findViewById(R.id.input_denti);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                TextView tx1 = (TextView)viw.findViewById(R.id.textView184);

                tx1.setText("大人" + adult + "人");

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alert.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText et = (EditText)viw.findViewById(R.id.input_denti);
                        String str = et.getText().toString();

                        if(str.length() <= 0){
                            str = "0";
                        }

                        int i = Integer.parseInt(str);

                        e.putInt("key_denti", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alert.setView(viw);
                alert.show();
            }
        });


        ImageButton btnPopRadio = (ImageButton)findViewById(R.id.popup_radio);
        btnPopRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(stock.this);
                alert.setTitle("ラジオ");

                LayoutInflater inflater = LayoutInflater.from(stock.this);
                final View viw = inflater.inflate(R.layout.activity_stock_pop_radio, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_radio",i);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)viw.findViewById(R.id.input_radio);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                TextView tx1 = (TextView)viw.findViewById(R.id.textView186);

                tx1.setText("大人" + adult + "人");

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alert.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText et = (EditText)viw.findViewById(R.id.input_radio);
                        String str = et.getText().toString();

                        if(str.length() <= 0){
                            str = "0";
                        }

                        int i = Integer.parseInt(str);

                        e.putInt("key_radio", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alert.setView(viw);
                alert.show();
            }
        });


        ImageButton btnPopKankiri = (ImageButton)findViewById(R.id.popup_kankiri);
        btnPopKankiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(stock.this);
                alert.setTitle("缶切り");

                LayoutInflater inflater = LayoutInflater.from(stock.this);
                final View viw = inflater.inflate(R.layout.activity_stock_pop_kankiri, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_kankiri",i);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)viw.findViewById(R.id.input_kankiri);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                TextView tx1 = (TextView)viw.findViewById(R.id.textView188);

                tx1.setText("大人" + adult + "人");

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alert.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText et = (EditText)viw.findViewById(R.id.input_kankiri);
                        String str = et.getText().toString();

                        if(str.length() <= 0){
                            str = "0";
                        }

                        int i = Integer.parseInt(str);

                        e.putInt("key_kankiri", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alert.setView(viw);
                alert.show();
            }
        });


        ImageButton btnPopMasuku = (ImageButton)findViewById(R.id.popup_masuku);
        btnPopMasuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(stock.this);
                alert.setTitle("マスク");

                LayoutInflater inflater = LayoutInflater.from(stock.this);
                final View viw = inflater.inflate(R.layout.activity_stock_pop_masuku, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_masuku",i);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)viw.findViewById(R.id.input_masuku);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                TextView tx1 = (TextView)viw.findViewById(R.id.textView190);

                tx1.setText("大人" + adult + "人");

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alert.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText et = (EditText)viw.findViewById(R.id.input_masuku);
                        String str = et.getText().toString();

                        if(str.length() <= 0){
                            str = "0";
                        }

                        int i = Integer.parseInt(str);

                        e.putInt("key_masuku", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alert.setView(viw);
                alert.show();
            }
        });


        ImageButton btnPopJuudennki = (ImageButton)findViewById(R.id.popup_juudennki);
        btnPopJuudennki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(stock.this);
                alert.setTitle("携帯電話充電器");

                LayoutInflater inflater = LayoutInflater.from(stock.this);
                final View viw = inflater.inflate(R.layout.activity_stock_pop_juudennki, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_juudennki",i);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)viw.findViewById(R.id.input_juudennki);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                TextView tx1 = (TextView)viw.findViewById(R.id.textView192);

                tx1.setText("大人" + adult + "人");

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alert.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText et = (EditText)viw.findViewById(R.id.input_juudennki);
                        String str = et.getText().toString();

                        if(str.length() <= 0){
                            str = "0";
                        }

                        int i = Integer.parseInt(str);

                        e.putInt("key_juudennki", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alert.setView(viw);
                alert.show();
            }
        });


        ImageButton btnPopNebukuro = (ImageButton)findViewById(R.id.popup_nebukuro);
        btnPopNebukuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(stock.this);
                alert.setTitle("寝袋");

                LayoutInflater inflater = LayoutInflater.from(stock.this);
                final View viw = inflater.inflate(R.layout.activity_stock_pop_nebukuto, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_nebukuro",i);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)viw.findViewById(R.id.input_nebukuro);

                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = pref.getInt("key_adult", adult);

                int kids = 0;
                kids = pref.getInt("key_kids", kids);

                int baby = 0;
                baby = pref.getInt("key_baby", baby);

                TextView tx1 = (TextView)viw.findViewById(R.id.textView200);
                TextView tx2 = (TextView)viw.findViewById(R.id.textView199);
                TextView tx3 = (TextView)viw.findViewById(R.id.textView198);

                tx1.setText("大人" + adult + "人");
                tx2.setText("小人" + kids + "人");
                tx3.setText("幼児" + baby + "人");


                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alert.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText et = (EditText)viw.findViewById(R.id.input_nebukuro);
                        String str = et.getText().toString();

                        if(str.length() <= 0){
                            str = "0";
                        }

                        int i = Integer.parseInt(str);

                        e.putInt("key_nebukuro", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alert.setView(viw);
                alert.show();
            }
        });


        ImageButton btnPopBin = (ImageButton)findViewById(R.id.popup_bin);
        btnPopBin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(stock.this);
                alert.setTitle("哺乳びん");

                LayoutInflater inflater = LayoutInflater.from(stock.this);
                final View viw = inflater.inflate(R.layout.activity_stock_pop_bin, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_bin",i);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)viw.findViewById(R.id.input_bin);

                et.setText(str);

                //  のちに整理すること
                int baby = 0;
                baby = pref.getInt("key_baby", baby);

                TextView tx3 = (TextView)viw.findViewById(R.id.textView194);

                tx3.setText("幼児" + baby + "人");


                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alert.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText et = (EditText)viw.findViewById(R.id.input_bin);
                        String str = et.getText().toString();

                        if(str.length() <= 0){
                            str = "0";
                        }

                        int i = Integer.parseInt(str);

                        e.putInt("key_bin", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alert.setView(viw);
                alert.show();
            }
        });


        ImageButton btnPopOmutu = (ImageButton)findViewById(R.id.popup_omutu);
        btnPopOmutu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(stock.this);
                alert.setTitle("おむつ");

                LayoutInflater inflater = LayoutInflater.from(stock.this);
                final View viw = inflater.inflate(R.layout.activity_stock_pop_omutu, null);

                //  プリファレンスの作成S
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                int i = 0;
                i = pref.getInt("key_omutu",i);
                String str = String.valueOf(i);

                //  必ずView変数で生成したデータを使うこと
                EditText et = (EditText)viw.findViewById(R.id.input_omutu);

                et.setText(str);

                //  のちに整理すること
                int baby = 0;
                baby = pref.getInt("key_baby", baby);

                TextView tx3 = (TextView)viw.findViewById(R.id.textView196);

                tx3.setText("幼児" + baby + "人");


                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alert.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences pref;
                        pref = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = pref.edit();

                        EditText et = (EditText)viw.findViewById(R.id.input_omutu);
                        String str = et.getText().toString();

                        if(str.length() <= 0){
                            str = "0";
                        }

                        int i = Integer.parseInt(str);

                        e.putInt("key_omutu", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alert.setView(viw);
                alert.show();
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
