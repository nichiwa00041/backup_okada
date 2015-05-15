package com.example.okadayosuke.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;

public class food extends Activity {

    final Calendar cal = Calendar.getInstance();

    //  最後の更新日
    int lastYear = cal.get(Calendar.YEAR);
    int lastMonth = cal.get(Calendar.MONTH);
    int lastDay = cal.get(Calendar.DAY_OF_MONTH);

    int mYear = cal.get(Calendar.YEAR);
    int mMonth = cal.get(Calendar.MONTH);
    int mDay = cal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog datePickerDialog;

    //  レトルトごはんのカレンダーデータ
    final Calendar rrCal = Calendar.getInstance();

    int rrYear = rrCal.get(Calendar.YEAR);
    int rrMonth = rrCal.get(Calendar.MONTH);
    int rrDay = rrCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog rerice_datePickerDialog;

    //  缶詰（米）のカレンダーデータ
    final Calendar krCal = Calendar.getInstance();

    int krYear = krCal.get(Calendar.YEAR);
    int krMonth = krCal.get(Calendar.MONTH);
    int krDay = krCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog kandume_datePickerDialog;

    //  乾パン（米）のカレンダーデータ
    final Calendar kpCal = Calendar.getInstance();

    int kpYear = kpCal.get(Calendar.YEAR);
    int kpMonth = kpCal.get(Calendar.MONTH);
    int kpDay = kpCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog kanpan_datePickerDialog;

    //  乾麺のカレンダーデータ
    final Calendar kmCal = Calendar.getInstance();

    int kmYear = kmCal.get(Calendar.YEAR);
    int kmMonth = kmCal.get(Calendar.MONTH);
    int kmDay = kmCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog kanmen_datePickerDialog;

    //  缶詰（魚・肉）のカレンダーデータ
    final Calendar kdCal = Calendar.getInstance();

    int kdYear = kdCal.get(Calendar.YEAR);
    int kdMonth = kdCal.get(Calendar.MONTH);
    int kdDay = kdCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog kandume2_datePickerDialog;

    //  レトルト食品のカレンダーデータ
    final Calendar reCal = Calendar.getInstance();

    int reYear = reCal.get(Calendar.YEAR);
    int reMonth = reCal.get(Calendar.MONTH);
    int reDay = reCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog retoruto_datePickerDialog;

    //  フリーズドライのカレンダーデータ
    final Calendar fCal = Calendar.getInstance();

    int fYear = fCal.get(Calendar.YEAR);
    int fMonth = fCal.get(Calendar.MONTH);
    int fDay = fCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog furizzu_datePickerDialog;

    //  カロリーメイトのカレンダーデータ
    final Calendar caCal = Calendar.getInstance();

    int caYear = caCal.get(Calendar.YEAR);
    int caMonth = caCal.get(Calendar.MONTH);
    int caDay = caCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog karori_datePickerDialog;

    //  お菓子のカレンダーデータ
    final Calendar cnCal = Calendar.getInstance();

    int cnYear = cnCal.get(Calendar.YEAR);
    int cnMonth = cnCal.get(Calendar.MONTH);
    int cnDay = cnCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog okasi_datePickerDialog;

    //  粉ミルクのカレンダーデータ
    final Calendar pmCal = Calendar.getInstance();

    int pmYear = pmCal.get(Calendar.YEAR);
    int pmMonth = pmCal.get(Calendar.MONTH);
    int pmDay = pmCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog konamilk_datePickerDialog;

    //  離乳食のカレンダーデータ
    final Calendar bfCal = Calendar.getInstance();

    int bfYear = bfCal.get(Calendar.YEAR);
    int bfMonth = bfCal.get(Calendar.MONTH);
    int bfDay = bfCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog rinyuushoku_datePickerDialog;

    //  水のカレンダーデータ
    final Calendar miCal = Calendar.getInstance();

    int miYear = miCal.get(Calendar.YEAR);
    int miMonth = miCal.get(Calendar.MONTH);
    int miDay = miCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog mizu_datePickerDialog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        //  画面遷移
        Button btnHome = (Button)findViewById(R.id.food_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent();
                intentHome.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.MainActivity");

                startActivity(intentHome);
            }
        });

        Button btnSetting = (Button)findViewById(R.id.food_setting);
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSetting = new Intent();
                intentSetting.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.setting");

                startActivity(intentSetting);
            }
        });

        Button btnStock = (Button)findViewById(R.id.food_stock);
        btnStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStock = new Intent();
                intentStock.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.stock");

                startActivity(intentStock);
            }
        });


        //  ポップアップ（ダイアログ）の作成
        ImageButton btnReRice = (ImageButton)findViewById(R.id.popup_food_retorutogohan);
        btnReRice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertReRice = new AlertDialog.Builder(food.this);
                alertReRice.setTitle("レトルトご飯");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vReRice = inflater.inflate(R.layout.activity_food_pop_rerice, null);

                //  プリファレンスの作成S
                SharedPreferences prefReRice = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefReRice.getInt("key_ReRice", i);

                int adult = 0;
                adult = prefReRice.getInt("key_adult", adult);

                int kids = 0;
                kids = prefReRice.getInt("key_kids", kids);

                int baby = 0;
                baby = prefReRice.getInt("key_baby", baby);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vReRice.findViewById(R.id.input_ReRice);
                TextView tAdult = (TextView)vReRice.findViewById(R.id.rerice_adult);
                TextView tKids = (TextView)vReRice.findViewById(R.id.rerice_kids);
                TextView tBaby = (TextView)vReRice.findViewById(R.id.rerice_baby);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);


                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                rrYear = prefCal.getInt("rrYear", rrYear);
                rrMonth = prefCal.getInt("rrMonth", rrMonth);
                rrDay = prefCal.getInt("rrDay", rrDay);

                //  ポップアップ内の日付、設定した賞味期限の表示(まだ未完成、個数の保存を終えた後に更新されるが残っている)
                TextView tw = (TextView)vReRice.findViewById(R.id.date_rerice);
                tw.setText("賞味期限は"
                        + rrYear + "年"
                        + (rrMonth+1) + "月"
                        + rrDay + "日です");

                //  プリファレンスの作成E


                //  ポップアップ内でカレンダーポップアップS
                ImageButton btnCal = (ImageButton)vReRice.findViewById(R.id.calendar_rerice);
                btnCal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){

                            public void onDateSet(

                                    DatePicker view,
                                    int year,
                                    int monthOfYear,
                                    int dayOfMonth){

                                rrYear = year;
                                rrMonth = monthOfYear;
                                rrDay = dayOfMonth;

                                //  プリファレンスに保存
                                SharedPreferences cal = getSharedPreferences("Preferences", MODE_PRIVATE);
                                SharedPreferences.Editor e_rrYear = cal.edit();
                                SharedPreferences.Editor e_rrMonth = cal.edit();
                                SharedPreferences.Editor e_rrDay = cal.edit();

                                e_rrYear.putInt("rrYear", year);
                                e_rrMonth.putInt("rrMonth", monthOfYear);
                                e_rrDay.putInt("rrDay", dayOfMonth);

                                e_rrYear.commit();
                                e_rrMonth.commit();
                                e_rrDay.commit();
                            }
                        };

                        rerice_datePickerDialog = new DatePickerDialog(
                                food.this,
                                listener,
                                rrYear,
                                rrMonth,
                                rrDay
                        );
                        rerice_datePickerDialog.show();
                    }

                });
                //  ポップアップ内でカレンダーポップアップE


                //  ダイアログ内での保存S
                alertReRice.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefRiRice;
                        prefRiRice = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor LastYear = prefRiRice.edit();
                        SharedPreferences.Editor LastMonth = prefRiRice.edit();
                        SharedPreferences.Editor LastDay = prefRiRice.edit();

                        LastYear.putInt("last_year", lastYear);
                        LastMonth.putInt("last_month", lastMonth);
                        LastDay.putInt("last_day", lastDay);

                        LastYear.commit();
                        LastMonth.commit();
                        LastDay.commit();

                        SharedPreferences.Editor e = prefRiRice.edit();
                        EditText etReRice = (EditText)vReRice.findViewById(R.id.input_ReRice);
                        String strReRice = etReRice.getText().toString();

                        if(strReRice.length() <= 0){
                            strReRice = "0";
                        }

                        int i = Integer.parseInt(strReRice);

                        e.putInt("key_ReRice", i);
                        e.commit();

                        dialog.dismiss();

                    }
                });

                //  ダイアログ内での保存E

                alertReRice.setView(vReRice);
                alertReRice.show();

            }
        });

        //  ポップアップ（ダイアログ）の作成
        ImageButton btnKandume = (ImageButton)findViewById(R.id.popup_food_kandume);
        btnKandume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertKandume = new AlertDialog.Builder(food.this);
                alertKandume.setTitle("缶詰（ご飯）");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vKandume = inflater.inflate(R.layout.activity_food_pop_kandume, null);

                //  プリファレンスの作成S
                SharedPreferences prefKandume = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefKandume.getInt("key_kandume", 0);

                int adult = 0;
                adult = prefKandume.getInt("key_adult", adult);

                int kids = 0;
                kids = prefKandume.getInt("key_kids", kids);

                int baby = 0;
                baby = prefKandume.getInt("key_baby", baby);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vKandume.findViewById(R.id.input_kandume);
                TextView tAdult = (TextView)vKandume.findViewById(R.id.kandume_adult);
                TextView tKids = (TextView)vKandume.findViewById(R.id.kandume_kids);
                TextView tBaby = (TextView)vKandume.findViewById(R.id.kandume_baby);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                krYear = prefCal.getInt("krYear", krYear);
                krMonth = prefCal.getInt("krMonth", krMonth);
                krDay = prefCal.getInt("krDay", krDay);

                //  ポップアップ内の日付、設定した賞味期限の表示
                TextView tw = (TextView)vKandume.findViewById(R.id.date_kandume);
                tw.setText("賞味期限は"
                        + krYear + "年"
                        + (krMonth+1) + "月"
                        + krDay + "日です");
                //  プリファレンスの作成E

                //  ポップアップ内でカレンダーポップアップS
                ImageButton btnCal = (ImageButton)vKandume.findViewById(R.id.calendar_kandume);
                btnCal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){

                            public void onDateSet(

                                    DatePicker view,
                                    int year,
                                    int monthOfYear,
                                    int dayOfMonth){

                                krYear = year;
                                krMonth = monthOfYear;
                                krDay = dayOfMonth;

                                //  プリファレンスに保存
                                SharedPreferences cal = getSharedPreferences("Preferences", MODE_PRIVATE);
                                SharedPreferences.Editor e_krYear = cal.edit();
                                SharedPreferences.Editor e_krMonth = cal.edit();
                                SharedPreferences.Editor e_krDay = cal.edit();

                                e_krYear.putInt("krYear", year);
                                e_krMonth.putInt("krMonth", monthOfYear);
                                e_krDay.putInt("krDay", dayOfMonth);

                                e_krYear.commit();
                                e_krMonth.commit();
                                e_krDay.commit();
                            }
                        };

                        kandume_datePickerDialog = new DatePickerDialog(
                                food.this,
                                listener,
                                krYear,
                                krMonth,
                                krDay
                        );
                        kandume_datePickerDialog.show();
                    }
                });
                //  ポップアップ内でカレンダーポップアップE


                //  ダイアログ内での保存S
                alertKandume.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefKandume;
                        prefKandume = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor LastYear = prefKandume.edit();
                        SharedPreferences.Editor LastMonth = prefKandume.edit();
                        SharedPreferences.Editor LastDay = prefKandume.edit();

                        LastYear.putInt("last_year", lastYear);
                        LastMonth.putInt("last_month", lastMonth);
                        LastDay.putInt("last_day", lastDay);

                        LastYear.commit();
                        LastMonth.commit();
                        LastDay.commit();

                        SharedPreferences.Editor e = prefKandume.edit();

                        EditText etKandume = (EditText)vKandume.findViewById(R.id.input_kandume);
                        String strKandume = etKandume.getText().toString();

                        if(strKandume.length() <= 0){
                            strKandume = "0";
                        }

                        int i = Integer.parseInt(strKandume);

                        e.putInt("key_kandume", i);
                        e.commit();

                        dialog.dismiss();

                    }
                });

                //  ダイアログ内での保存E

                alertKandume.setView(vKandume);
                alertKandume.show();

            }
        });


        //  ポップアップ（ダイアログ）の作成
        ImageButton btnKanpan = (ImageButton)findViewById(R.id.popup_food_kanpan);
        btnKanpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertKanpan = new AlertDialog.Builder(food.this);
                alertKanpan.setTitle("乾パン");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vKanpan = inflater.inflate(R.layout.activity_food_pop_kanpen, null);

                //  プリファレンスの作成S
                SharedPreferences prefKanpan = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefKanpan.getInt("key_kanpan", i);

                int adult = 0;
                adult = prefKanpan.getInt("key_adult", adult);

                int kids = 0;
                kids = prefKanpan.getInt("key_kids", kids);

                int baby = 0;
                baby = prefKanpan.getInt("key_baby", baby);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vKanpan.findViewById(R.id.input_kanpan);
                TextView tAdult = (TextView)vKanpan.findViewById(R.id.kanpan_adult);
                TextView tKids = (TextView)vKanpan.findViewById(R.id.kanpan_kids);
                TextView tBaby = (TextView)vKanpan.findViewById(R.id.kanpan_baby);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                kpYear = prefCal.getInt("kpYear", kpYear);
                kpMonth = prefCal.getInt("kpMonth", kpMonth);
                kpDay = prefCal.getInt("kpDay", kpDay);

                //  ポップアップ内の日付、設定した賞味期限の表示
                TextView tw = (TextView)vKanpan.findViewById(R.id.date_kanpan);
                tw.setText("賞味期限は"
                        + kpYear + "年"
                        + (kpMonth+1) + "月"
                        + kpDay + "日です");
                //  プリファレンスの作成E


                //  プリファレンスの作成E


                //  ポップアップ内でカレンダーポップアップS
                ImageButton btnCal = (ImageButton)vKanpan.findViewById(R.id.calendar_kanpan);
                btnCal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){

                            public void onDateSet(

                                    DatePicker view,
                                    int year,
                                    int monthOfYear,
                                    int dayOfMonth){

                                kpYear = year;
                                kpMonth = monthOfYear;
                                kpDay = dayOfMonth;

                                //  プリファレンスに保存
                                SharedPreferences cal = getSharedPreferences("Preferences", MODE_PRIVATE);
                                SharedPreferences.Editor e_kpYear = cal.edit();
                                SharedPreferences.Editor e_kpMonth = cal.edit();
                                SharedPreferences.Editor e_kpDay = cal.edit();

                                e_kpYear.putInt("kpYear", year);
                                e_kpMonth.putInt("kpMonth", monthOfYear);
                                e_kpDay.putInt("kpDay", dayOfMonth);

                                e_kpYear.commit();
                                e_kpMonth.commit();
                                e_kpDay.commit();
                            }
                        };

                        kanpan_datePickerDialog = new DatePickerDialog(
                                food.this,
                                listener,
                                kpYear,
                                kpMonth,
                                kpDay
                        );
                        kanpan_datePickerDialog.show();
                    }
                });
                //  ポップアップ内でカレンダーポップアップE

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertKanpan.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefKanpan;
                        prefKanpan = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor LastYear = prefKanpan.edit();
                        SharedPreferences.Editor LastMonth = prefKanpan.edit();
                        SharedPreferences.Editor LastDay = prefKanpan.edit();

                        LastYear.putInt("last_year", lastYear);
                        LastMonth.putInt("last_month", lastMonth);
                        LastDay.putInt("last_day", lastDay);

                        LastYear.commit();
                        LastMonth.commit();
                        LastDay.commit();

                        SharedPreferences.Editor e = prefKanpan.edit();

                        EditText etKanpan = (EditText)vKanpan.findViewById(R.id.input_kanpan);
                        String strKanpan = etKanpan.getText().toString();

                        if(strKanpan.length() <= 0){
                            strKanpan = "0";
                        }

                        int i = Integer.parseInt(strKanpan);

                        e.putInt("key_kanpan", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertKanpan.setView(vKanpan);
                alertKanpan.show();

            }
        });


        //  ポップアップ（ダイアログ）の作成
        ImageButton btnKanmen = (ImageButton)findViewById(R.id.popup_food_kanmen);
        btnKanmen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertKanmen = new AlertDialog.Builder(food.this);
                alertKanmen.setTitle("乾麺");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vKanmen = inflater.inflate(R.layout.activity_food_pop_kanmen, null);

                //  プリファレンスの作成S
                SharedPreferences prefKanmen = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefKanmen.getInt("key_kanmen", i);

                int adult = 0;
                adult = prefKanmen.getInt("key_adult", adult);

                int kids = 0;
                kids = prefKanmen.getInt("key_kids", kids);

                int baby = 0;
                baby = prefKanmen.getInt("key_baby", baby);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);


                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vKanmen.findViewById(R.id.input_kanmen);
                TextView tAdult = (TextView)vKanmen.findViewById(R.id.kanmen_adult);
                TextView tKids = (TextView)vKanmen.findViewById(R.id.kanmen_kids);
                TextView tBaby = (TextView)vKanmen.findViewById(R.id.kanmen_baby);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);


                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                kmYear = prefCal.getInt("kmYear", kmYear);
                kmMonth = prefCal.getInt("kmMonth", kmMonth);
                kmDay = prefCal.getInt("kmDay", kmDay);

                //  ポップアップ内の日付、設定した賞味期限の表示
                TextView tw = (TextView)vKanmen.findViewById(R.id.date_kanmen);
                tw.setText("賞味期限は"
                        + kmYear + "年"
                        + (kmMonth+1) + "月"
                        + kmDay + "日です");
                //  プリファレンスの作成E

                //  ポップアップ内でカレンダーポップアップS
                ImageButton btnCal = (ImageButton)vKanmen.findViewById(R.id.calendar_kanmen);
                btnCal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){

                            public void onDateSet(

                                    DatePicker view,
                                    int year,
                                    int monthOfYear,
                                    int dayOfMonth){

                                kmYear = year;
                                kmMonth = monthOfYear;
                                kmDay = dayOfMonth;

                                //  プリファレンスに保存
                                SharedPreferences cal = getSharedPreferences("Preferences", MODE_PRIVATE);
                                SharedPreferences.Editor e_kmYear = cal.edit();
                                SharedPreferences.Editor e_kmMonth = cal.edit();
                                SharedPreferences.Editor e_kmDay = cal.edit();

                                e_kmYear.putInt("kmYear", year);
                                e_kmMonth.putInt("kmMonth", monthOfYear);
                                e_kmDay.putInt("kmDay", dayOfMonth);

                                e_kmYear.commit();
                                e_kmMonth.commit();
                                e_kmDay.commit();
                            }
                        };

                        kanmen_datePickerDialog = new DatePickerDialog(
                                food.this,
                                listener,
                                kmYear,
                                kmMonth,
                                kmDay
                        );
                        kanmen_datePickerDialog.show();
                    }
                });
                //  ポップアップ内でカレンダーポップアップE


                //  ダイアログ内での保存S
                alertKanmen.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefKanmen;
                        prefKanmen = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor LastYear = prefKanmen.edit();
                        SharedPreferences.Editor LastMonth = prefKanmen.edit();
                        SharedPreferences.Editor LastDay = prefKanmen.edit();

                        LastYear.putInt("last_year", lastYear);
                        LastMonth.putInt("last_month", lastMonth);
                        LastDay.putInt("last_day", lastDay);

                        LastYear.commit();
                        LastMonth.commit();
                        LastDay.commit();

                        SharedPreferences.Editor e = prefKanmen.edit();

                        EditText etKanmen = (EditText)vKanmen.findViewById(R.id.input_kanmen);
                        String strKanmen = etKanmen.getText().toString();

                        if(strKanmen.length() <= 0){
                            strKanmen = "0";
                        }

                        int i = Integer.parseInt(strKanmen);

                        e.putInt("key_kanmen", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertKanmen.setView(vKanmen);
                alertKanmen.show();

            }
        });



        //  ポップアップ（ダイアログ）の作成
        ImageButton btnKandume2 = (ImageButton)findViewById(R.id.popup_food_kandume2);
        btnKandume2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertKandume2 = new AlertDialog.Builder(food.this);
                alertKandume2.setTitle("缶詰（肉・魚・野菜など）");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vKandume2 = inflater.inflate(R.layout.activity_food_pop_kandume2, null);

                //  プリファレンスの作成S
                SharedPreferences prefKandume2 = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefKandume2.getInt("key_kandume2", i);

                int adult = 0;
                adult = prefKandume2.getInt("key_adult", adult);

                int kids = 0;
                kids = prefKandume2.getInt("key_kids", kids);

                int baby = 0;
                baby = prefKandume2.getInt("key_baby", baby);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vKandume2.findViewById(R.id.input_kandume2);
                TextView tAdult = (TextView)vKandume2.findViewById(R.id.kandume2_adult);
                TextView tKids = (TextView)vKandume2.findViewById(R.id.kandume2_kids);
                TextView tBaby = (TextView)vKandume2.findViewById(R.id.kandume2_baby);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                kdYear = prefCal.getInt("kdYear", kdYear);
                kdMonth = prefCal.getInt("kdMonth", kdMonth);
                kdDay = prefCal.getInt("kdDay", kdDay);

                //  ポップアップ内の日付、設定した賞味期限の表示
                TextView tw = (TextView)vKandume2.findViewById(R.id.date_kandume2);
                tw.setText("賞味期限は"
                        + kdYear + "年"
                        + (kdMonth+1) + "月"
                        + kdDay + "日です");
                //  プリファレンスの作成E

                //  ポップアップ内でカレンダーポップアップS
                ImageButton btnCal = (ImageButton)vKandume2.findViewById(R.id.calendar_kandume2);
                btnCal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){

                            public void onDateSet(

                                    DatePicker view,
                                    int year,
                                    int monthOfYear,
                                    int dayOfMonth){

                                kdYear = year;
                                kdMonth = monthOfYear;
                                kdDay = dayOfMonth;

                                //  プリファレンスに保存
                                SharedPreferences cal = getSharedPreferences("Preferences", MODE_PRIVATE);
                                SharedPreferences.Editor e_kdYear = cal.edit();
                                SharedPreferences.Editor e_kdMonth = cal.edit();
                                SharedPreferences.Editor e_kdDay = cal.edit();

                                e_kdYear.putInt("kdYear", year);
                                e_kdMonth.putInt("kdMonth", monthOfYear);
                                e_kdDay.putInt("kdDay", dayOfMonth);

                                e_kdYear.commit();
                                e_kdMonth.commit();
                                e_kdDay.commit();
                            }
                        };

                        kandume2_datePickerDialog = new DatePickerDialog(
                                food.this,
                                listener,
                                kdYear,
                                kdMonth,
                                kdDay
                        );
                        kandume2_datePickerDialog.show();
                    }
                });
                //  ポップアップ内でカレンダーポップアップE


                //  ダイアログ内での保存S
                alertKandume2.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefKandume2;
                        prefKandume2 = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor LastYear = prefKandume2.edit();
                        SharedPreferences.Editor LastMonth = prefKandume2.edit();
                        SharedPreferences.Editor LastDay = prefKandume2.edit();

                        LastYear.putInt("last_year", lastYear);
                        LastMonth.putInt("last_month", lastMonth);
                        LastDay.putInt("last_day", lastDay);

                        LastYear.commit();
                        LastMonth.commit();
                        LastDay.commit();

                        SharedPreferences.Editor e = prefKandume2.edit();

                        EditText etKandume2 = (EditText)vKandume2.findViewById(R.id.input_kandume2);
                        String strKandume2 = etKandume2.getText().toString();

                        if(strKandume2.length() <= 0){
                            strKandume2 = "0";
                        }

                        int i = Integer.parseInt(strKandume2);

                        e.putInt("key_kandume2", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertKandume2.setView(vKandume2);
                alertKandume2.show();

            }
        });



        //  ポップアップ（ダイアログ）の作成
        ImageButton btnFurizzu = (ImageButton)findViewById(R.id.popup_food_furizzu);
        btnFurizzu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertFurizzu = new AlertDialog.Builder(food.this);
                alertFurizzu.setTitle("フリーズドライ");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vFurizzu = inflater.inflate(R.layout.activity_food_pop_furizzu, null);

                //  プリファレンスの作成S
                SharedPreferences prefFurizzu = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefFurizzu.getInt("key_furizzu", 0);

                int adult = 0;
                adult = prefFurizzu.getInt("key_adult", adult);

                int kids = 0;
                kids = prefFurizzu.getInt("key_kids", kids);

                int baby = 0;
                baby = prefFurizzu.getInt("key_baby", baby);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vFurizzu.findViewById(R.id.input_furizzu);
                TextView tAdult = (TextView)vFurizzu.findViewById(R.id.furizzu_adult);
                TextView tKids = (TextView)vFurizzu.findViewById(R.id.furizzu_kids);
                TextView tBaby = (TextView)vFurizzu.findViewById(R.id.furizzu_baby);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                fYear = prefCal.getInt("fYear", fYear);
                fMonth = prefCal.getInt("fMonth", fMonth);
                fDay = prefCal.getInt("fDay", fDay);

                //  ポップアップ内の日付、設定した賞味期限の表示
                TextView tw = (TextView)vFurizzu.findViewById(R.id.date_furizzu);
                tw.setText("賞味期限は"
                        + fYear + "年"
                        + (fMonth+1) + "月"
                        + fDay + "日です");
                //  プリファレンスの作成E

                //  ポップアップ内でカレンダーポップアップS
                ImageButton btnCal = (ImageButton)vFurizzu.findViewById(R.id.calendar_furizzu);
                btnCal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){

                            public void onDateSet(

                                    DatePicker view,
                                    int year,
                                    int monthOfYear,
                                    int dayOfMonth){

                                fYear = year;
                                fMonth = monthOfYear;
                                fDay = dayOfMonth;

                                //  プリファレンスに保存
                                SharedPreferences cal = getSharedPreferences("Preferences", MODE_PRIVATE);
                                SharedPreferences.Editor e_fYear = cal.edit();
                                SharedPreferences.Editor e_fMonth = cal.edit();
                                SharedPreferences.Editor e_fDay = cal.edit();

                                e_fYear.putInt("fYear", year);
                                e_fMonth.putInt("fMonth", monthOfYear);
                                e_fDay.putInt("fDay", dayOfMonth);

                                e_fYear.commit();
                                e_fMonth.commit();
                                e_fDay.commit();
                            }
                        };

                        furizzu_datePickerDialog = new DatePickerDialog(
                                food.this,
                                listener,
                                fYear,
                                fMonth,
                                fDay
                        );
                        furizzu_datePickerDialog.show();
                    }
                });
                //  ポップアップ内でカレンダーポップアップE

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertFurizzu.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefFurizzu;
                        prefFurizzu = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor LastYear = prefFurizzu.edit();
                        SharedPreferences.Editor LastMonth = prefFurizzu.edit();
                        SharedPreferences.Editor LastDay = prefFurizzu.edit();

                        LastYear.putInt("last_year", lastYear);
                        LastMonth.putInt("last_month", lastMonth);
                        LastDay.putInt("last_day", lastDay);

                        LastYear.commit();
                        LastMonth.commit();
                        LastDay.commit();

                        SharedPreferences.Editor e = prefFurizzu.edit();

                        EditText etFurizzu = (EditText)vFurizzu.findViewById(R.id.input_furizzu);
                        String strFurizzu = etFurizzu.getText().toString();

                        if(strFurizzu.length() <= 0){
                            strFurizzu = "0";
                        }

                        int i = Integer.parseInt(strFurizzu);

                        e.putInt("key_furizzu", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertFurizzu.setView(vFurizzu);
                alertFurizzu.show();

            }
        });



        //  ポップアップ（ダイアログ）の作成
        ImageButton btnRetoruto = (ImageButton)findViewById(R.id.popup_food_retoruto);
        btnRetoruto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertRetoruto = new AlertDialog.Builder(food.this);
                alertRetoruto.setTitle("レトルト食品");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vRetoruto = inflater.inflate(R.layout.activity_food_pop_retoruto, null);

                //  プリファレンスの作成S
                SharedPreferences prefRetoruto = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefRetoruto.getInt("key_retoruto", 0);

                int adult = 0;
                adult = prefRetoruto.getInt("key_adult", adult);

                int kids = 0;
                kids = prefRetoruto.getInt("key_kids", kids);

                int baby = 0;
                baby = prefRetoruto.getInt("key_baby", baby);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vRetoruto.findViewById(R.id.input_retoruto);
                TextView tAdult = (TextView)vRetoruto.findViewById(R.id.retoruto_adult);
                TextView tKids = (TextView)vRetoruto.findViewById(R.id.retoruto_kids);
                TextView tBaby = (TextView)vRetoruto.findViewById(R.id.retoruto_baby);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                reYear = prefCal.getInt("reYear", reYear);
                reMonth = prefCal.getInt("reMonth", reMonth);
                reDay = prefCal.getInt("reDay", reDay);

                //  ポップアップ内の日付、設定した賞味期限の表示
                TextView tw = (TextView)vRetoruto.findViewById(R.id.date_retoruto);
                tw.setText("賞味期限は"
                        + reYear + "年"
                        + (reMonth+1) + "月"
                        + reDay + "日です");
                //  プリファレンスの作成E

                //  ポップアップ内でカレンダーポップアップS
                ImageButton btnCal = (ImageButton)vRetoruto.findViewById(R.id.calendar_retoruto);
                btnCal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){

                            public void onDateSet(

                                    DatePicker view,
                                    int year,
                                    int monthOfYear,
                                    int dayOfMonth){

                                reYear = year;
                                reMonth = monthOfYear;
                                reDay = dayOfMonth;

                                //  プリファレンスに保存
                                SharedPreferences cal = getSharedPreferences("Preferences", MODE_PRIVATE);
                                SharedPreferences.Editor e_reYear = cal.edit();
                                SharedPreferences.Editor e_reMonth = cal.edit();
                                SharedPreferences.Editor e_reDay = cal.edit();

                                e_reYear.putInt("reYear", year);
                                e_reMonth.putInt("reMonth", monthOfYear);
                                e_reDay.putInt("reDay", dayOfMonth);

                                e_reYear.commit();
                                e_reMonth.commit();
                                e_reDay.commit();
                            }
                        };

                        retoruto_datePickerDialog = new DatePickerDialog(
                                food.this,
                                listener,
                                reYear,
                                reMonth,
                                reDay
                        );
                        retoruto_datePickerDialog.show();
                    }
                });
                //  ポップアップ内でカレンダーポップアップE


                //  ダイアログ内での保存S
                alertRetoruto.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefRetoruto;
                        prefRetoruto = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor LastYear = prefRetoruto.edit();
                        SharedPreferences.Editor LastMonth = prefRetoruto.edit();
                        SharedPreferences.Editor LastDay = prefRetoruto.edit();

                        LastYear.putInt("last_year", lastYear);
                        LastMonth.putInt("last_month", lastMonth);
                        LastDay.putInt("last_day", lastDay);

                        LastYear.commit();
                        LastMonth.commit();
                        LastDay.commit();

                        SharedPreferences.Editor e = prefRetoruto.edit();

                        EditText etRetoruto = (EditText)vRetoruto.findViewById(R.id.input_retoruto);
                        String strRetoruto = etRetoruto.getText().toString();

                        if(strRetoruto.length() <= 0){
                            strRetoruto = "0";
                        }

                        int i = Integer.parseInt(strRetoruto);

                        e.putInt("key_retoruto", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertRetoruto.setView(vRetoruto);
                alertRetoruto.show();

            }
        });


        //  ポップアップ（ダイアログ）の作成
        ImageButton btnMisu = (ImageButton)findViewById(R.id.popup_mizu);
        btnMisu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertMisu = new AlertDialog.Builder(food.this);
                alertMisu.setTitle("水");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vMisu = inflater.inflate(R.layout.activity_food_pop_mizu, null);

                //  プリファレンスの作成S
                SharedPreferences prefMisu = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefMisu.getInt("key_mizu", 0);

                int adult = 0;
                adult = prefMisu.getInt("key_adult", adult);

                int kids = 0;
                kids = prefMisu.getInt("key_kids", kids);

                int baby = 0;
                baby = prefMisu.getInt("key_baby", baby);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vMisu.findViewById(R.id.input_mizu);
                TextView tAdult = (TextView)vMisu.findViewById(R.id.mizu_adult);
                TextView tKids = (TextView)vMisu.findViewById(R.id.mizu_kids);
                TextView tBaby = (TextView)vMisu.findViewById(R.id.mizu_baby);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                miYear = prefCal.getInt("miYear", miYear);
                miMonth = prefCal.getInt("miMonth", miMonth);
                miDay = prefCal.getInt("miDay", miDay);

                //  ポップアップ内の日付、設定した賞味期限の表示
                TextView tw = (TextView)vMisu.findViewById(R.id.date_mizu);
                tw.setText("賞味期限は"
                        + miYear + "年"
                        + (miMonth+1) + "月"
                        + miDay + "日です");
                //  プリファレンスの作成E

                //  ポップアップ内でカレンダーポップアップS
                ImageButton btnCal = (ImageButton)vMisu.findViewById(R.id.calendar_mizu);
                btnCal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){

                            public void onDateSet(

                                    DatePicker view,
                                    int year,
                                    int monthOfYear,
                                    int dayOfMonth){

                                miYear = year;
                                miMonth = monthOfYear;
                                miDay = dayOfMonth;

                                //  プリファレンスに保存
                                SharedPreferences cal = getSharedPreferences("Preferences", MODE_PRIVATE);
                                SharedPreferences.Editor e_miYear = cal.edit();
                                SharedPreferences.Editor e_miMonth = cal.edit();
                                SharedPreferences.Editor e_miDay = cal.edit();

                                e_miYear.putInt("miYear", year);
                                e_miMonth.putInt("miMonth", monthOfYear);
                                e_miDay.putInt("miDay", dayOfMonth);

                                e_miYear.commit();
                                e_miMonth.commit();
                                e_miDay.commit();
                            }
                        };

                        mizu_datePickerDialog = new DatePickerDialog(
                                food.this,
                                listener,
                                miYear,
                                miMonth,
                                miDay
                        );
                        mizu_datePickerDialog.show();
                    }
                });
                //  ポップアップ内でカレンダーポップアップE

                //  ダイアログ内での保存S
                alertMisu.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefMisu;
                        prefMisu = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor LastYear = prefMisu.edit();
                        SharedPreferences.Editor LastMonth = prefMisu.edit();
                        SharedPreferences.Editor LastDay = prefMisu.edit();

                        LastYear.putInt("last_year", lastYear);
                        LastMonth.putInt("last_month", lastMonth);
                        LastDay.putInt("last_day", lastDay);

                        LastYear.commit();
                        LastMonth.commit();
                        LastDay.commit();

                        SharedPreferences.Editor e = prefMisu.edit();

                        EditText etMisu = (EditText)vMisu.findViewById(R.id.input_mizu);
                        String strMisu = etMisu.getText().toString();

                        if(strMisu.length() <= 0){
                            strMisu = "0";
                        }

                        int i = Integer.parseInt(strMisu);

                        e.putInt("key_mizu", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertMisu.setView(vMisu);
                alertMisu.show();

            }
        });


        //  ポップアップ（ダイアログ）の作成
        ImageButton btnOkasi = (ImageButton)findViewById(R.id.popup_okasi);
        btnOkasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertOkasi = new AlertDialog.Builder(food.this);
                alertOkasi.setTitle("菓子類");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vOkasi = inflater.inflate(R.layout.activity_food_pop_okasi, null);

                //  プリファレンスの作成S
                SharedPreferences prefOkasi = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefOkasi.getInt("key_okasi", 0);

                int adult = 0;
                adult = prefOkasi.getInt("key_adult", adult);

                int kids = 0;
                kids = prefOkasi.getInt("key_kids", kids);

                int baby = 0;
                baby = prefOkasi.getInt("key_baby", baby);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vOkasi.findViewById(R.id.input_okasi);
                TextView tAdult = (TextView)vOkasi.findViewById(R.id.okasi_adult);
                TextView tKids = (TextView)vOkasi.findViewById(R.id.okasi_kids);
                TextView tBaby = (TextView)vOkasi.findViewById(R.id.okasi_baby);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                cnYear = prefCal.getInt("cnYear", cnYear);
                cnMonth = prefCal.getInt("cnMonth", cnMonth);
                cnDay = prefCal.getInt("cnDay", cnDay);

                //  ポップアップ内の日付、設定した賞味期限の表示
                TextView tw = (TextView)vOkasi.findViewById(R.id.date_okasi);
                tw.setText("賞味期限は"
                        + cnYear + "年"
                        + (cnMonth+1) + "月"
                        + cnDay + "日です");
                //  プリファレンスの作成E

                //  ポップアップ内でカレンダーポップアップS
                ImageButton btnCal = (ImageButton)vOkasi.findViewById(R.id.calendar_okasi);
                btnCal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){

                            public void onDateSet(

                                    DatePicker view,
                                    int year,
                                    int monthOfYear,
                                    int dayOfMonth){

                                cnYear = year;
                                cnMonth = monthOfYear;
                                cnDay = dayOfMonth;

                                //  プリファレンスに保存
                                SharedPreferences cal = getSharedPreferences("Preferences", MODE_PRIVATE);
                                SharedPreferences.Editor e_cnYear = cal.edit();
                                SharedPreferences.Editor e_cnMonth = cal.edit();
                                SharedPreferences.Editor e_cnDay = cal.edit();

                                e_cnYear.putInt("cnYear", year);
                                e_cnMonth.putInt("cnMonth", monthOfYear);
                                e_cnDay.putInt("cnDay", dayOfMonth);

                                e_cnYear.commit();
                                e_cnMonth.commit();
                                e_cnDay.commit();
                            }
                        };

                        okasi_datePickerDialog = new DatePickerDialog(
                                food.this,
                                listener,
                                cnYear,
                                cnMonth,
                                cnDay
                        );
                        okasi_datePickerDialog.show();
                    }
                });
                //  ポップアップ内でカレンダーポップアップE

                //  ダイアログ内での保存S
                alertOkasi.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefOkasi;
                        prefOkasi = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor LastYear = prefOkasi.edit();
                        SharedPreferences.Editor LastMonth = prefOkasi.edit();
                        SharedPreferences.Editor LastDay = prefOkasi.edit();

                        LastYear.putInt("last_year", lastYear);
                        LastMonth.putInt("last_month", lastMonth);
                        LastDay.putInt("last_day", lastDay);

                        LastYear.commit();
                        LastMonth.commit();
                        LastDay.commit();

                        SharedPreferences.Editor e = prefOkasi.edit();

                        EditText etOkasi = (EditText)vOkasi.findViewById(R.id.input_okasi);
                        String strOkasi = etOkasi.getText().toString();

                        if(strOkasi.length() <= 0){
                            strOkasi = "0";
                        }

                        int i = Integer.parseInt(strOkasi);

                        e.putInt("key_okasi", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertOkasi.setView(vOkasi);
                alertOkasi.show();

            }
        });


        //  ポップアップ（ダイアログ）の作成
        ImageButton btnKarori = (ImageButton)findViewById(R.id.popup_karori);
        btnKarori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertKarori = new AlertDialog.Builder(food.this);
                alertKarori.setTitle("カロリーメイト");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vKarori = inflater.inflate(R.layout.activity_food_pop_karori, null);

                //  プリファレンスの作成S
                SharedPreferences prefKarori = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefKarori.getInt("key_karori", 0);

                int adult = 0;
                adult = prefKarori.getInt("key_adult", adult);

                int kids = 0;
                kids = prefKarori.getInt("key_kids", kids);

                int baby = 0;
                baby = prefKarori.getInt("key_baby", baby);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vKarori.findViewById(R.id.input_karori);
                TextView tAdult = (TextView)vKarori.findViewById(R.id.karori_adult);
                TextView tKids = (TextView)vKarori.findViewById(R.id.karori_kids);
                TextView tBaby = (TextView)vKarori.findViewById(R.id.karori_baby);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                caYear = prefCal.getInt("caYear", caYear);
                caMonth = prefCal.getInt("caMonth", caMonth);
                caDay = prefCal.getInt("caDay", caDay);



                //  ポップアップ内の日付、設定した賞味期限の表示
                TextView tw = (TextView)vKarori.findViewById(R.id.date_karori);
                tw.setText("賞味期限は"
                        + caYear + "年"
                        + (caMonth+1) + "月"
                        + caDay + "日です");
                //  プリファレンスの作成E

                //  ポップアップ内でカレンダーポップアップS
                ImageButton btnCal = (ImageButton)vKarori.findViewById(R.id.calendar_karori);
                btnCal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){

                            public void onDateSet(

                                    DatePicker view,
                                    int year,
                                    int monthOfYear,
                                    int dayOfMonth){

                                caYear = year;
                                caMonth = monthOfYear;
                                caDay = dayOfMonth;

                                //  プリファレンスに保存
                                SharedPreferences cal = getSharedPreferences("Preferences", MODE_PRIVATE);
                                SharedPreferences.Editor e_caYear = cal.edit();
                                SharedPreferences.Editor e_caMonth = cal.edit();
                                SharedPreferences.Editor e_caDay = cal.edit();

                                e_caYear.putInt("caYear", year);
                                e_caMonth.putInt("caMonth", monthOfYear);
                                e_caDay.putInt("caDay", dayOfMonth);

                                e_caYear.commit();
                                e_caMonth.commit();
                                e_caDay.commit();
                            }
                        };

                        karori_datePickerDialog = new DatePickerDialog(
                                food.this,
                                listener,
                                caYear,
                                caMonth,
                                caDay
                        );
                        karori_datePickerDialog.show();
                    }
                });
                //  ポップアップ内でカレンダーポップアップE

                //  ダイアログ内での保存S
                alertKarori.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefKarori;
                        prefKarori = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor LastYear = prefKarori.edit();
                        SharedPreferences.Editor LastMonth = prefKarori.edit();
                        SharedPreferences.Editor LastDay = prefKarori.edit();

                        LastYear.putInt("last_year", lastYear);
                        LastMonth.putInt("last_month", lastMonth);
                        LastDay.putInt("last_day", lastDay);

                        LastYear.commit();
                        LastMonth.commit();
                        LastDay.commit();

                        SharedPreferences.Editor e = prefKarori.edit();

                        EditText etKarori = (EditText)vKarori.findViewById(R.id.input_karori);
                        String strKarori = etKarori.getText().toString();

                        if(strKarori.length() <= 0){
                            strKarori = "0";
                        }

                        int i = Integer.parseInt(strKarori);

                        e.putInt("key_karori", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertKarori.setView(vKarori);
                alertKarori.show();

            }
        });

        //  ポップアップ（ダイアログ）の作成
        ImageButton btnKona = (ImageButton)findViewById(R.id.popup_konamilk);
        btnKona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertKona = new AlertDialog.Builder(food.this);
                alertKona.setTitle("粉ミルク");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vKona = inflater.inflate(R.layout.activity_food_pop_konamilk, null);

                //  プリファレンスの作成S
                SharedPreferences prefKona = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefKona.getInt("key_konamilk", 0);

                int adult = 0;
                adult = prefKona.getInt("key_adult", adult);

                int kids = 0;
                kids = prefKona.getInt("key_kids", kids);

                int baby = 0;
                baby = prefKona.getInt("key_baby", baby);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vKona.findViewById(R.id.input_konamilk);
                TextView tAdult = (TextView)vKona.findViewById(R.id.konamilk_adult);
                TextView tKids = (TextView)vKona.findViewById(R.id.konamilk_kids);
                TextView tBaby = (TextView)vKona.findViewById(R.id.konamilk_baby);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                pmYear = prefCal.getInt("pmYear", pmYear);
                pmMonth = prefCal.getInt("pmMonth", pmMonth);
                pmDay = prefCal.getInt("pmDay", pmDay);

                //  ポップアップ内の日付、設定した賞味期限の表示
                TextView tw = (TextView)vKona.findViewById(R.id.date_konamilk);
                tw.setText("賞味期限は"
                        + pmYear + "年"
                        + (pmMonth+1) + "月"
                        + pmDay + "日です");
                //  プリファレンスの作成E

                //  ポップアップ内でカレンダーポップアップS
                ImageButton btnCal = (ImageButton)vKona.findViewById(R.id.calendar_konamilk);
                btnCal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){

                            public void onDateSet(

                                    DatePicker view,
                                    int year,
                                    int monthOfYear,
                                    int dayOfMonth){

                                pmYear = year;
                                pmMonth = monthOfYear;
                                pmDay = dayOfMonth;

                                //  プリファレンスに保存
                                SharedPreferences cal = getSharedPreferences("Preferences", MODE_PRIVATE);
                                SharedPreferences.Editor e_pmYear = cal.edit();
                                SharedPreferences.Editor e_pmMonth = cal.edit();
                                SharedPreferences.Editor e_pmDay = cal.edit();

                                e_pmYear.putInt("pmYear", year);
                                e_pmMonth.putInt("pmMonth", monthOfYear);
                                e_pmDay.putInt("pmDay", dayOfMonth);

                                e_pmYear.commit();
                                e_pmMonth.commit();
                                e_pmDay.commit();
                            }
                        };

                        konamilk_datePickerDialog = new DatePickerDialog(
                                food.this,
                                listener,
                                pmYear,
                                pmMonth,
                                pmDay
                        );
                        konamilk_datePickerDialog.show();
                    }
                });
                //  ポップアップ内でカレンダーポップアップE

                //  ダイアログ内での保存S
                alertKona.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefKona;
                        prefKona = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor LastYear = prefKona.edit();
                        SharedPreferences.Editor LastMonth = prefKona.edit();
                        SharedPreferences.Editor LastDay = prefKona.edit();

                        LastYear.putInt("last_year", lastYear);
                        LastMonth.putInt("last_month", lastMonth);
                        LastDay.putInt("last_day", lastDay);

                        LastYear.commit();
                        LastMonth.commit();
                        LastDay.commit();

                        SharedPreferences.Editor e = prefKona.edit();

                        EditText etKona = (EditText)vKona.findViewById(R.id.input_konamilk);
                        String strKona = etKona.getText().toString();

                        if(strKona.length() <= 0){
                            strKona = "0";
                        }

                        int i = Integer.parseInt(strKona);

                        e.putInt("key_konamilk", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertKona.setView(vKona);
                alertKona.show();

            }
        });


        //  ポップアップ（ダイアログ）の作成
        ImageButton btnRinyu = (ImageButton)findViewById(R.id.popup_rinyu);
        btnRinyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertRinyu = new AlertDialog.Builder(food.this);
                alertRinyu.setTitle("離乳食");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vRinyu = inflater.inflate(R.layout.activity_food_pop_rinyu, null);

                //  プリファレンスの作成S
                SharedPreferences prefRinyu = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefRinyu.getInt("key_rinyu", i);

                int adult = 0;
                adult = prefRinyu.getInt("key_adult", adult);

                int kids = 0;
                kids = prefRinyu.getInt("key_kids", kids);

                int baby = 0;
                baby = prefRinyu.getInt("key_baby", baby);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vRinyu.findViewById(R.id.input_rinyu);
                TextView tAdult = (TextView)vRinyu.findViewById(R.id.rinyu_adult);
                TextView tKids = (TextView)vRinyu.findViewById(R.id.rinyu_kids);
                TextView tBaby = (TextView)vRinyu.findViewById(R.id.rinyu_baby);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                bfYear = prefCal.getInt("bfYear", bfYear);
                bfMonth = prefCal.getInt("bfMonth", bfMonth);
                bfDay = prefCal.getInt("bfDay", bfDay);

                //  ポップアップ内の日付、設定した賞味期限の表示
                TextView tw = (TextView)vRinyu.findViewById(R.id.date_rinyu);
                tw.setText("賞味期限は"
                        + bfYear + "年"
                        + (bfMonth+1) + "月"
                        + bfDay + "日です");
                //  プリファレンスの作成E

                //  ポップアップ内でカレンダーポップアップS
                ImageButton btnCal = (ImageButton)vRinyu.findViewById(R.id.calendar_rinyu);
                btnCal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){

                            public void onDateSet(

                                    DatePicker view,
                                    int year,
                                    int monthOfYear,
                                    int dayOfMonth){

                                bfYear = year;
                                bfMonth = monthOfYear;
                                bfDay = dayOfMonth;

                                //  プリファレンスに保存
                                SharedPreferences cal = getSharedPreferences("Preferences", MODE_PRIVATE);
                                SharedPreferences.Editor e_bfYear = cal.edit();
                                SharedPreferences.Editor e_bfMonth = cal.edit();
                                SharedPreferences.Editor e_bfDay = cal.edit();

                                e_bfYear.putInt("bfYear", year);
                                e_bfMonth.putInt("bfMonth", monthOfYear);
                                e_bfDay.putInt("bfDay", dayOfMonth);

                                e_bfYear.commit();
                                e_bfMonth.commit();
                                e_bfDay.commit();
                            }
                        };

                        rinyuushoku_datePickerDialog = new DatePickerDialog(
                                food.this,
                                listener,
                                bfYear,
                                bfMonth,
                                bfDay
                        );
                        rinyuushoku_datePickerDialog.show();
                    }
                });
                //  ポップアップ内でカレンダーポップアップE

                //  ダイアログ内での保存S
                alertRinyu.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefRinyu;
                        prefRinyu = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor LastYear = prefRinyu.edit();
                        SharedPreferences.Editor LastMonth = prefRinyu.edit();
                        SharedPreferences.Editor LastDay = prefRinyu.edit();

                        LastYear.putInt("last_year", lastYear);
                        LastMonth.putInt("last_month", lastMonth);
                        LastDay.putInt("last_day", lastDay+1);

                        LastYear.commit();
                        LastMonth.commit();
                        LastDay.commit();

                        SharedPreferences.Editor e = prefRinyu.edit();

                        EditText etRinyu = (EditText)vRinyu.findViewById(R.id.input_rinyu);
                        String strRinyu = etRinyu.getText().toString();

                        if(strRinyu.length() <= 0){
                            strRinyu = "0";
                        }

                        int i = Integer.parseInt(strRinyu);

                        e.putInt("key_rinyu", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertRinyu.setView(vRinyu);
                alertRinyu.show();

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_food, menu);
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
