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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

class SampleClass{
    String  name;
    int     food;
    int     lastDay;
    int     id;
};

public class MainActivity extends Activity {
    //  レトルトごはんのカレンダーデータ
    final Calendar rrCal = Calendar.getInstance();

    int crrYear = rrCal.get(Calendar.YEAR);
    int crrMonth = rrCal.get(Calendar.MONTH);
    int crrDay = rrCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog rerice_datePickerDialog;

    //  缶詰（米）のカレンダーデータ
    final Calendar krCal = Calendar.getInstance();

    int ckrYear = krCal.get(Calendar.YEAR);
    int ckrMonth = krCal.get(Calendar.MONTH);
    int ckrDay = krCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog kandume_datePickerDialog;

    //  乾パン（米）のカレンダーデータ
    final Calendar kpCal = Calendar.getInstance();

    int ckpYear = kpCal.get(Calendar.YEAR);
    int ckpMonth = kpCal.get(Calendar.MONTH);
    int ckpDay = kpCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog kanpan_datePickerDialog;

    //  乾麺のカレンダーデータ
    final Calendar kmCal = Calendar.getInstance();

    int ckmYear = kmCal.get(Calendar.YEAR);
    int ckmMonth = kmCal.get(Calendar.MONTH);
    int ckmDay = kmCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog kanmen_datePickerDialog;

    //  缶詰（魚・肉）のカレンダーデータ
    final Calendar kdCal = Calendar.getInstance();

    int ckdYear = kdCal.get(Calendar.YEAR);
    int ckdMonth = kdCal.get(Calendar.MONTH);
    int ckdDay = kdCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog kandume2_datePickerDialog;

    //  レトルト食品のカレンダーデータ
    final Calendar reCal = Calendar.getInstance();

    int creYear = reCal.get(Calendar.YEAR);
    int creMonth = reCal.get(Calendar.MONTH);
    int creDay = reCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog retoruto_datePickerDialog;

    //  フリーズドライのカレンダーデータ
    final Calendar fCal = Calendar.getInstance();

    int cfYear = fCal.get(Calendar.YEAR);
    int cfMonth = fCal.get(Calendar.MONTH);
    int cfDay = fCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog furizzu_datePickerDialog;

    //  カロリーメイトのカレンダーデータ
    final Calendar caCal = Calendar.getInstance();

    int ccaYear = caCal.get(Calendar.YEAR);
    int ccaMonth = caCal.get(Calendar.MONTH);
    int ccaDay = caCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog karori_datePickerDialog;

    //  お菓子のカレンダーデータ
    final Calendar cnCal = Calendar.getInstance();

    int ccnYear = cnCal.get(Calendar.YEAR);
    int ccnMonth = cnCal.get(Calendar.MONTH);
    int ccnDay = cnCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog okasi_datePickerDialog;

    //  粉ミルクのカレンダーデータ
    final Calendar pmCal = Calendar.getInstance();

    int cpmYear = pmCal.get(Calendar.YEAR);
    int cpmMonth = pmCal.get(Calendar.MONTH);
    int cpmDay = pmCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog konamilk_datePickerDialog;

    //  離乳食のカレンダーデータ
    final Calendar bfCal = Calendar.getInstance();

    int cbfYear = bfCal.get(Calendar.YEAR);
    int cbfMonth = bfCal.get(Calendar.MONTH);
    int cbfDay = bfCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog rinyuushoku_datePickerDialog;

    //  水のカレンダーデータ
    final Calendar miCal = Calendar.getInstance();

    int cmiYear = miCal.get(Calendar.YEAR);
    int cmiMonth = miCal.get(Calendar.MONTH);
    int cmiDay = miCal.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog mizu_datePickerDialog;

    public static final int NEED_FOOD_ADULT = 3;
    public static final int NEED_WATER_ADULT = 3;
    public static final int NEED_FOOD_KIDS = 2;
    public static final int NEED_WATER_KIDS = 2;
    public static final int NEED_FOOD_BABY = 3;
    public static final int NEED_WATER_BABY = 2;
    public static final int MAX_FOODS_CATEGORY = 12;
    public static final float GRAPH_DENO_FOOD = 12.0f;
    public static final float GRAPH_DENO_STOCK = 12.0f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
        //  設定の合計人数
        int adult   = pref.getInt("key_adult", 0);
        int kids    = pref.getInt("key_kids", 0);
        int baby    = pref.getInt("key_baby", 0);

        //  期日のデータを取得、デフォルトは「14」日
        int limit = pref.getInt("key_limit", 14);

        //  備えちゃお日数のデータを取得、デフォルトは「3」日
        int setting = pref.getInt("key_setting", 3);


//        TextView tw = (TextView)findViewById(R.id.Date);
        final Calendar cal = Calendar.getInstance();
/*
        tw.setText("今日は"
                   +  cal.get(Calendar.YEAR) + "年"
                   + (cal.get(Calendar.MONTH)+1) + "月"
                   +  cal.get(Calendar.DATE) + "日です");
*/
        Button btnSetting = (Button)findViewById(R.id.home_setting);
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSetting = new Intent();
                intentSetting.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.setting");

                startActivity(intentSetting);
            }
        });

        Button btnStock = (Button)findViewById(R.id.home_stock);
        btnStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStock = new Intent();
                intentStock.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.stock");

                startActivity(intentStock);
            }
        });

        Button btnFood = (Button)findViewById(R.id.home_food);
        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFood = new Intent();
                intentFood.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.food");

                startActivity(intentFood);
            }
        });

        ImageView btnMetarFood = (ImageView)findViewById(R.id.graphLeft);
        btnMetarFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.food");

                startActivity(intent);
            }
        });

        TextView btnAlertFood = (TextView)findViewById(R.id.aleat_food);
        btnAlertFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.food");

                startActivity(intent);
            }
        });

        /**********************************************************************************/
        //
        //  非常食の合計値S


        int ReRice = 0;
        ReRice = pref.getInt("key_ReRice", ReRice);

        int kandume = 0;
        kandume = pref.getInt("key_kandume", kandume);

        int kanmen = 0;
        kanmen = pref.getInt("key_kanmen", kanmen);

        int kanpan = 0;
        kanpan = pref.getInt("key_kanpan", kanpan);

        int kandume2 = 0;
        kandume2 = pref.getInt("key_kandume2", kandume2);

        int retoruto = 0;
        retoruto = pref.getInt("key_retoruto", retoruto);

        int furizzu = 0;
        furizzu = pref.getInt("key_furizzu", furizzu);

        int kona = 0;
        kona = pref.getInt("key_konamilk", kona);

        int rinyu = 0;
        rinyu = pref.getInt("key_rinyu", rinyu);

        int karori = 0;
        karori = pref.getInt("key_karori", karori);

        int okasi = 0;
        okasi = pref.getInt("key_okasi", okasi);

        int mizu = 0;
        mizu = pref.getInt("key_mizu", mizu);


        /**********************************************************************************/

        //消費期限のデータ（日数）取得
        int rrYear = pref.getInt("rrYear", cal.get(Calendar.YEAR));
        int rrMonth = pref.getInt("rrMonth", cal.get(Calendar.MONTH));
        int rrDay = pref.getInt("rrDay", cal.get(Calendar.DAY_OF_MONTH));

        int krYear = pref.getInt("krYear", cal.get(Calendar.YEAR));
        int krMonth = pref.getInt("krMonth", cal.get(Calendar.MONTH));
        int krDay = pref.getInt("krDay", cal.get(Calendar.DAY_OF_MONTH));

        int kmYear = pref.getInt("kmYear", cal.get(Calendar.YEAR));
        int kmMonth = pref.getInt("kmMonth", cal.get(Calendar.MONTH));
        int kmDay = pref.getInt("kmDay", cal.get(Calendar.DAY_OF_MONTH));

        int kpYear = pref.getInt("kpYear", cal.get(Calendar.YEAR));
        int kpMonth = pref.getInt("kpMonth", cal.get(Calendar.MONTH));
        int kpDay = pref.getInt("kpDay", cal.get(Calendar.DAY_OF_MONTH));

        int kdYear = pref.getInt("kdYear", cal.get(Calendar.YEAR));
        int kdMonth = pref.getInt("kdMonth", cal.get(Calendar.MONTH));
        int kdDay = pref.getInt("kdDay", cal.get(Calendar.DAY_OF_MONTH));

        int fYear = pref.getInt("fYear", cal.get(Calendar.YEAR));
        int fMonth = pref.getInt("fMonth", cal.get(Calendar.MONTH));
        int fDay = pref.getInt("fDay", cal.get(Calendar.DAY_OF_MONTH));

        int reYear = pref.getInt("reYear", cal.get(Calendar.YEAR));
        int reMonth = pref.getInt("reMonth", cal.get(Calendar.MONTH));
        int reDay = pref.getInt("reDay", cal.get(Calendar.DAY_OF_MONTH));

        int miYear = pref.getInt("miYear", cal.get(Calendar.YEAR));
        int miMonth = pref.getInt("miMonth", cal.get(Calendar.MONTH));
        int miDay = pref.getInt("miDay", cal.get(Calendar.DAY_OF_MONTH));

        int cnYear = pref.getInt("cnYear", cal.get(Calendar.YEAR));
        int cnMonth = pref.getInt("cnMonth", cal.get(Calendar.MONTH));
        int cnDay = pref.getInt("cnDay", cal.get(Calendar.DAY_OF_MONTH));

        int caYear = pref.getInt("caYear", cal.get(Calendar.YEAR));
        int caMonth = pref.getInt("caMonth", cal.get(Calendar.MONTH));
        int caDay = pref.getInt("caDay", cal.get(Calendar.DAY_OF_MONTH));

        int pmYear = pref.getInt("pmYear", cal.get(Calendar.YEAR));
        int pmMonth = pref.getInt("pmMonth", cal.get(Calendar.MONTH));
        int pmDay = pref.getInt("pmDay", cal.get(Calendar.DAY_OF_MONTH));

        int bfYear = pref.getInt("bfYear", cal.get(Calendar.YEAR));
        int bfMonth = pref.getInt("bfMonth", cal.get(Calendar.MONTH));
        int bfDay = pref.getInt("bfDay", cal.get(Calendar.DAY_OF_MONTH));

        //  消費期限の表示。
        int lReRice = DeadlineFood(rrYear, rrMonth, rrDay);
        TextDeadline("レトルトごはん", ReRice,lReRice, R.id.limit_food1, limit);
        if( lReRice < 0 ){
            ReRice = 0;
        }


        int lKandume = DeadlineFood(krYear, krMonth, krDay);
        TextDeadline("缶詰（ご飯）", kandume, lKandume, R.id.limit_food2, limit);
        if( lKandume < 0 ){
             kandume = 0;
        }


        int lKanmen = DeadlineFood(kmYear, kmMonth, kmDay);
        TextDeadline("乾麺", kanmen,lKanmen, R.id.limit_food3, limit);
        if( lKanmen < 0 ){
            kanmen = 0;
        }

        int lKanpan = DeadlineFood(kpYear, kpMonth, kpDay);
        TextDeadline("乾パン", kanpan, lKanpan, R.id.limit_food4, limit);
        if( lKanpan < 0 ){
            kanpan = 0;
        }


        int lKandume2 = DeadlineFood(kdYear, kdMonth, kdDay);
        TextDeadline("缶詰（魚・肉）", kandume2, lKandume2, R.id.limit_food5, limit);
        if( lKandume2 < 0 ){
            kandume2 = 0;
        }


        int lRetoruto = DeadlineFood(reYear, reMonth, reDay);
        TextDeadline("レトルト食品", retoruto,lRetoruto, R.id.limit_food6, limit);
        if( lRetoruto < 0 ){
            retoruto = 0;
        }


        int lFurizzu = DeadlineFood(fYear, fMonth, fDay);
        TextDeadline("フリーズドライ", furizzu, lFurizzu, R.id.limit_food7, limit);
        if( lFurizzu < 0 ){
            furizzu = 0;
        }

//        DeadlineFood("カロリーメイト", caYear, caMonth, caDay, limit, R.id.limit_food8);
        int lKarori = DeadlineFood(caYear, caMonth, caDay);
        TextDeadline("カロリーメイト", karori, lKarori, R.id.limit_food8, limit);
        if( lKarori < 0 ){
            karori = 0;
        }

//        DeadlineFood("菓子類", cnYear, cnMonth, cnDay, limit, R.id.limit_food9);
        int lOkasi = DeadlineFood(cnYear, cnMonth, cnDay);
        TextDeadline("菓子類", okasi, lOkasi, R.id.limit_food9, limit);
        if( lOkasi < 0 ){
            okasi = 0;
        }

//        DeadlineFood("粉ミルク", pmYear, pmMonth, pmDay, limit, R.id.limit_food10);
        int lKona = DeadlineFood(pmYear, pmMonth, pmDay);
        TextDeadline("粉ミルク", kona, lKona, R.id.limit_food10, limit);
        if( lKona < 0 ){
            kona = 0;
        }

//        DeadlineFood("離乳食", bfYear, bfMonth, bfDay, limit, R.id.limit_food11);
        int lRinyu = DeadlineFood(bfYear, bfMonth, bfDay);
        TextDeadline("離乳食", rinyu, lRinyu, R.id.limit_food11, limit);
        if( lRinyu < 0 ){
            rinyu = 0;
        }

//        DeadlineFood("水", miYear, miMonth, miDay, limit, R.id.limit_food12);
        int lMizu = DeadlineFood(miYear, miMonth, miDay);
        TextDeadline("水", mizu, lMizu, R.id.limit_food12, limit);
        if( lMizu < 0 ){
            mizu = 0;
        }


        int tFood = ReRice + kandume + kanmen + kanpan
                + kandume2 + retoruto + furizzu + kona
                + mizu + rinyu + karori + okasi;
        //  非常食の合計値E
        //
        /**********************************************************************************/

        //  備蓄食品の総ポイント。
        //  注意点：小人以上は、カロリーメイトと乾パンが3点。幼児は粉ミルクが3点。他は1点。

        //  全合計の食品ポイント（水を除く）
        float   fAll = tFood + ( ( karori * 2 ) + ( kanpan * 2 ) + ( kona * 2 ) ) - mizu;
        float   fBaby = ( kona * 3 ) + rinyu;   //  幼児の合計値

        //  大人と小人に関係する食品の合計値（離乳食と粉ミルクを除いたポイント）
        float   okAll = fAll - fBaby;

        //  有効な食品のポイントからの割合の変数。
        float rateOverKids;
        float rateBaby;
        float div = 2.0f;

        if( adult > 0 || kids > 0) {    //  大人または小人が1人でもいる場合
            rateOverKids = getRateFoods(okAll, adult, kids, setting);
        } else {                        //  いない場合。ないと思うが。
            rateOverKids = 0.0f;
            div -= 1.0f;
        }
        if( baby > 0 ) {                //  幼児がいる場合
            rateBaby = CalRateForBaby(fBaby, baby, setting);
        } else {                        //  いない場合。
            rateBaby = 0.0f;
            div -= 1.0f;
        }
        //  割合を足し合わせて、平均。
        float rateFood;
        if( !( div == 0.0f ) ) {    //  訳：設定人数が1人でもいた場合。
            rateFood = (rateOverKids + rateBaby) / div;
        } else {                    //  訳：設定人数が全て0人の場合。
            rateFood = 0.0f;
        }



        /**********************************************************************************/

        //  備蓄水の総ポイント。念のため、新しい変数に隔離。
        //  注意点：大人は3ポイント。小人、幼児は2ポイント、必要になる。
        //  水のポイント自体は1つにつき3ポイント、小人以下は2ポイント
        //  要するに、一人一日分。人種に応じて必要合計値を出して分母にすればいい。
        float   tWater = mizu;

        float   rateWater = getRateWater(tWater, adult, kids, baby, setting);

        //  小数点をなくす処理。小数点は切り捨て。
        float   rateFoodGraph = ( ( rateFood + rateWater ));                 //  0.0f～1.0f
        int     rateFoodTotal = (int)( ( rateFood + rateWater ) * 100 );     //  0～100（％）

        if( (adult + kids + baby) == 0 ){
            rateFoodGraph = 0.0f;
            rateFoodTotal = 0;
        }

        /**********************************************************************************/
        //  備蓄品の計算S

        /**********************************************************************************/

        float gas = 0;
        gas = pref.getFloat("key_gas", gas);

        float almi = 0;
        almi = pref.getFloat("key_almi", almi);

        float bombe = 0;
        bombe = pref.getFloat("key_bombe", bombe);

        float gunte = 0;
        gunte = pref.getFloat("key_gunte", gunte);

        float hue = 0;
        hue = pref.getFloat("key_hue", hue);

        float matti = 0;
        matti = pref.getFloat("key_matti", matti);

        float thisshu = 0;
        thisshu = pref.getFloat("key_thissyu", thisshu);

        float sitagi = 0;
        sitagi = pref.getFloat("key_sitagi", sitagi);

        float kodomositagi = 0;
        kodomositagi = pref.getFloat("key_kodomositagi", kodomositagi);

        float kaichuudento = 0;
        kaichuudento = pref.getFloat("key_kaichuudenntou", kaichuudento);

        float koppu = 0;
        koppu = pref.getFloat("key_koppu", koppu);

        float utuwa = 0;
        utuwa = pref.getFloat("key_utuwa", utuwa);

        float taoru = 0;
        taoru = pref.getFloat("key_taoru", taoru);

        float rappu = 0;
        rappu = pref.getFloat("key_rappu", rappu);

        float hukuro = 0;
        hukuro = pref.getFloat("key_hukuro", hukuro);

        float spoon = 0;
        spoon = pref.getFloat("key_spoon", spoon);

        float hasi = 0;
        hasi = pref.getFloat("key_hasi", hasi);

        float denti = 0;
        denti = pref.getFloat("key_denti", denti);

        float radio = 0;
        radio = pref.getFloat("key_radio", radio);

        float kankiri = 0;
        kankiri = pref.getFloat("key_kankiri", kankiri);

        float masuku = 0;
        masuku = pref.getFloat("key_masuku", masuku);

        float juudennki = 0;
        juudennki = pref.getFloat("key_juudennki", juudennki);

        float nebukuro = 0;
        nebukuro = pref.getFloat("key_nebukuro", nebukuro);

        float bin  = 0;
        bin = pref.getFloat("key_bin", bin);

        float omutu = 0;
        omutu = pref.getFloat("key_omutu", omutu);

        //  ストックの合計数
        float tStock = gas + almi + bombe + gunte
                + hue + matti + sitagi + thisshu
                + kodomositagi + kaichuudento + koppu
                + utuwa + taoru + rappu + hukuro
                + spoon + hasi + denti + radio
                + kankiri + masuku + juudennki + nebukuro
                + bin + omutu;

        float rateAll = 0.0f;

        rateAll += UsedFamilyStock( almi, setting, 1.0f, 1.0f, 2.0f);
        rateAll += UsedFamilyStock( rappu, setting, 1.0f, 1.0f, 3.0f);
        rateAll += UsedFamilyStock( bombe, setting, 1.0f, 2.0f, 5.0f);
        rateAll += UsedFamilyStock( gas, setting, 1.0f, 1.0f, 1.0f);
        rateAll += UsedFamilyStock( thisshu, setting, 1.0f, 1.0f, 3.0f);
        rateAll += UsedFamilyStock( hukuro, setting, 1.0f, 1.0f, 1.0f);
        rateAll += UsedFamilyStock( spoon, setting, 1.0f, 1.0f, 1.0f);
        rateAll += UsedFamilyStock( hasi, setting, 1.0f, 1.0f, 1.0f);
        rateAll += UsedFamilyStock( denti, setting, 2.0f, 2.0f, 4.0f);


/*
        //  大人の所持備蓄数（必需品）
        float nessAdultStock = gas + almi + bombe
                + sitagi + thisshu + kodomositagi + kaichuudento + koppu
                + utuwa + taoru + rappu + hukuro
                + spoon + hasi + (denti*2);

        //  幼児の所持備蓄数（必需品）
        float nessBabyStock = bin + omutu;


        float usesAdultStock = gunte + hue + matti + radio
                             + kankiri + masuku + juudennki;

/**********************************************************************************/
//  必需品
/**********************************************************************************/
/*
        //　大人
        float nessNeedStock1 = 0;
        if( (adult+kids) > 0 ) {
            nessNeedStock1 = GetNeedAdultStocks(adult, kids, setting);
        } else {
            nessNeedStock1 = 0.0f;
        }

        //  幼児のみ
        float nessNeedStock2 = 0;
        if(baby > 0) {
            nessNeedStock2 = GetNeedBabyStocks(baby, setting);
        } else {
            nessNeedStock2 = 0.0f;
        }

        //  団体。合計人数が1以上の場合は固定。
        float nessNeedStock3 = 0;
        if((adult+kids+baby) > 0) {
            nessNeedStock3 = GetNeedStocksOrg(setting);
        } else {
            nessNeedStock3 = 0.0f;
        }

        //  必需品の最後の割合の計算。
        float rateNessStock = 0.0f;
        if((adult+kids+baby) > 0) {
            rateNessStock = GetRateStocks(nessAdultStock, nessBabyStock, nessNeedStock1, nessNeedStock2, nessNeedStock3, adult, kids, baby);
        } else {
            rateNessStock = 0.0f;
        }
/**********************************************************************************/
//  便利品
/**********************************************************************************/
        //



/**********************************************************************************/
//
/**********************************************************************************/

/*
        //  小数点をなくす処理。小数点は切り捨て。
        float   rateFoodGraph = ( ( rateFood + rateWater ));                 //  0.0f～1.0f
        int     rateFoodTotal = (int)( ( rateFood + rateWater ) * 100 );     //  0～100（％）

        if( (adult + kids + baby) == 0 ){
            rateFoodGraph = 0.0f;
            rateFoodTotal = 0;
        }
*/
        //  デバッグの表示
//        TextView debug = (TextView)findViewById(R.id.debug);
//        debug.setText("" + rateFinalFood + "、" + rateWater + "、" + rateFoodTotal);

        /*  要チェックアラート　*/
        TextView txt1 = (TextView)findViewById(R.id.textView300);
        txt1.setText("");

        TextView txtFoodAlert = (TextView) findViewById(R.id.aleat_food);
        TextView txtFoodBaby = (TextView) findViewById(R.id.alert_baby);

        if(rateFoodTotal < 60) {
            txtFoodAlert.setText("注意！ 非常食の備蓄率が少なくなっています");
        } else {
            txtFoodAlert.setText("");
        }

        if( baby > 0 && ( (kona + rinyu ) <= 0)){
            txtFoodBaby.setText("粉ミルクと離乳食が備蓄されていません");
        } else {
            txtFoodBaby.setText("");
        }
        //  最終日更新のデータ
        final int lastYear = pref.getInt("last_year", cal.get(Calendar.YEAR));
        final int lastMonth = pref.getInt("last_Month", cal.get((Calendar.MONTH))+1);
        final int lastDay = pref.getInt("last_day", cal.get(Calendar.DAY_OF_MONTH));


        TextView txtLastFood = (TextView)findViewById(R.id.last_food);
        txtLastFood.setText( lastYear + "年" + lastMonth + "月" + lastDay + "日");

        //  非常食のパーセント表示。
        TextView strRateFood = (TextView)findViewById(R.id.percent_food);
        strRateFood.setText(""+ rateFoodTotal);

        /**********************************************************************************/

        //  グラフ図の変化（左のみ）機能はしている。d
        ImageView   graphLeft = (ImageView)findViewById(R.id.graphLeft);

        if(rateFoodGraph < ( 1 / GRAPH_DENO_FOOD ) ){
            graphLeft.setImageResource(R.drawable.graph0);
        } else if ( rateFoodGraph < ( 2 / GRAPH_DENO_FOOD ) ){
            graphLeft.setImageResource(R.drawable.graph1);
        } else if ( rateFoodGraph < ( 3 / GRAPH_DENO_FOOD ) ){
            graphLeft.setImageResource(R.drawable.graph2);
        } else if ( rateFoodGraph < ( 4 / GRAPH_DENO_FOOD ) ){
            graphLeft.setImageResource(R.drawable.graph3);
        } else if ( rateFoodGraph < ( 5 / GRAPH_DENO_FOOD ) ){
            graphLeft.setImageResource(R.drawable.graph4);
        } else if ( rateFoodGraph < ( 6 / GRAPH_DENO_FOOD ) ){
            graphLeft.setImageResource(R.drawable.graph5);
        } else if ( rateFoodGraph < ( 7 / GRAPH_DENO_FOOD ) ){
            graphLeft.setImageResource(R.drawable.graph6);
        } else if ( rateFoodGraph < ( 8 / GRAPH_DENO_FOOD ) ){
            graphLeft.setImageResource(R.drawable.graph7);
        } else if ( rateFoodGraph < ( 9 / GRAPH_DENO_FOOD ) ){
            graphLeft.setImageResource(R.drawable.graph8);
        } else if ( rateFoodGraph < ( 10 / GRAPH_DENO_FOOD ) ){
            graphLeft.setImageResource(R.drawable.graph9);
        } else if ( rateFoodGraph < ( 11 / GRAPH_DENO_FOOD ) ){
            graphLeft.setImageResource(R.drawable.graph10);
        } else if ( rateFoodGraph < ( 12 / GRAPH_DENO_FOOD ) ){
            graphLeft.setImageResource(R.drawable.graph11);
        } else if ( rateFoodGraph == ( 12 / GRAPH_DENO_FOOD ) ){
            graphLeft.setImageResource(R.drawable.graph12);
        }

        /**********************************************************************************/
        //
        /**********************************************************************************/



        /**********************************************************************************/
        //　これより下、ダイアログ
        /**********************************************************************************/

        TextView txtfood1 = (TextView)findViewById(R.id.limit_food1);
        txtfood1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertReRice = new AlertDialog.Builder(MainActivity.this);
                alertReRice.setTitle("レトルトご飯");

                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View vReRice = inflater.inflate(R.layout.activity_food_pop_rerice, null);

                //  プリファレンスの作成S
                SharedPreferences prefReRice = getSharedPreferences("Preferences", MODE_PRIVATE);

                int rrYear = prefReRice.getInt("rrYear",  cal.get(Calendar.YEAR));
                int rrMonth = prefReRice.getInt("rrMonth",  cal.get(Calendar.MONTH));
                int rrDay = prefReRice.getInt("rrDay",  cal.get(Calendar.DAY_OF_MONTH));

                int i = 0;
                i = prefReRice.getInt("key_ReRice", i);

                int adult = 0;
                adult = prefReRice.getInt("key_adult", adult);

                int kids = 0;
                kids = prefReRice.getInt("key_kids", kids);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vReRice.findViewById(R.id.input_ReRice);
                TextView tAdult = (TextView)vReRice.findViewById(R.id.rerice_adult);
                TextView tKids = (TextView)vReRice.findViewById(R.id.rerice_kids);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);

                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                crrYear = prefCal.getInt("rrYear", rrYear);
                crrMonth = prefCal.getInt("rrMonth", rrMonth);
                crrDay = prefCal.getInt("rrDay", rrDay);

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

                                crrYear = year;
                                crrMonth = monthOfYear;
                                crrDay = dayOfMonth;

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
                                MainActivity.this,
                                listener,
                                crrYear,
                                crrMonth,
                                crrDay
                        );
                        rerice_datePickerDialog.show();
                    }

                });
                //  ポップアップ内でカレンダーポップアップE


                //  ダイアログ内での保存S
                alertReRice.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefReRice;
                        prefReRice = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor LastYear = prefReRice.edit();

                        LastYear.putInt("last_year", cal.get(Calendar.YEAR));
                        LastYear.putInt("last_month", cal.get(Calendar.MONTH));
                        LastYear.putInt("last_day", cal.get(Calendar.DAY_OF_MONTH));

                        LastYear.commit();

                        SharedPreferences.Editor e = prefReRice.edit();

                        EditText etReRice = (EditText)vReRice.findViewById(R.id.input_ReRice);
                        String strReRice = etReRice.getText().toString();

                        if(strReRice.length() <= 0){
                            strReRice = "0";
                        }

                        int i = Integer.parseInt(strReRice);

                        e.putInt("key_ReRice", i);
                        e.commit();

                        dialog.dismiss();

                        Intent intent = new Intent();
                        intent.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.MainActivity");

                        startActivity(intent);

                    }

                });

                //  ダイアログ内での保存E

                alertReRice.setView(vReRice);
                alertReRice.show();

            }
        });


        TextView txtfood2 = (TextView)findViewById(R.id.limit_food2);
        txtfood2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertKandume = new AlertDialog.Builder(MainActivity.this);
                alertKandume.setTitle("缶詰（ご飯）");

                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View vKandume = inflater.inflate(R.layout.activity_food_pop_kandume, null);

                //  プリファレンスの作成S
                SharedPreferences prefKandume = getSharedPreferences("Preferences", MODE_PRIVATE);

                int krYear = prefKandume.getInt("krYear",  cal.get(Calendar.YEAR));
                int krMonth = prefKandume.getInt("krMonth",  cal.get(Calendar.MONTH));
                int krDay = prefKandume.getInt("krDay",  cal.get(Calendar.DAY_OF_MONTH));

                int i = 0;
                i = prefKandume.getInt("key_kandume", 0);

                int adult = 0;
                adult = prefKandume.getInt("key_adult", adult);

                int kids = 0;
                kids = prefKandume.getInt("key_kids", kids);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vKandume.findViewById(R.id.input_kandume);
                TextView tAdult = (TextView)vKandume.findViewById(R.id.kandume_adult);
                TextView tKids = (TextView)vKandume.findViewById(R.id.kandume_kids);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);

                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                ckrYear = prefCal.getInt("krYear", 0);
                ckrMonth = prefCal.getInt("krMonth", 0);
                ckrDay = prefCal.getInt("krDay", 0);

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

                                ckrYear = year;
                                ckrMonth = monthOfYear;
                                ckrDay = dayOfMonth;

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
                                MainActivity.this,
                                listener,
                                ckrYear,
                                ckrMonth,
                                ckrDay
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

                        LastYear.putInt("last_year", cal.get(Calendar.YEAR));
                        LastYear.putInt("last_month", cal.get(Calendar.MONTH));
                        LastYear.putInt("last_day", cal.get(Calendar.DAY_OF_MONTH));

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

                        Intent intent = new Intent();
                        intent.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.MainActivity");

                        startActivity(intent);

                    }
                });

                //  ダイアログ内での保存E

                alertKandume.setView(vKandume);
                alertKandume.show();

            }
        });


        TextView txtfood3 = (TextView)findViewById(R.id.limit_food3);
        txtfood3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertKanmen = new AlertDialog.Builder(MainActivity.this);
                alertKanmen.setTitle("乾麺");

                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View vKanmen = inflater.inflate(R.layout.activity_food_pop_kanmen, null);

                //  プリファレンスの作成S
                SharedPreferences prefKanmen = getSharedPreferences("Preferences", MODE_PRIVATE);

                int kmYear = prefKanmen.getInt("kmYear",  cal.get(Calendar.YEAR));
                int kmMonth = prefKanmen.getInt("kmMonth",  cal.get(Calendar.MONTH));
                int kmDay = prefKanmen.getInt("kmDay",  cal.get(Calendar.DAY_OF_MONTH));


                int i = 0;
                i = prefKanmen.getInt("key_kanmen", i);

                int adult = 0;
                adult = prefKanmen.getInt("key_adult", adult);

                int kids = 0;
                kids = prefKanmen.getInt("key_kids", kids);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vKanmen.findViewById(R.id.input_kanmen);
                TextView tAdult = (TextView)vKanmen.findViewById(R.id.kanmen_adult);
                TextView tKids = (TextView)vKanmen.findViewById(R.id.kanmen_kids);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);

                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                ckmYear = prefCal.getInt("kmYear", kmYear);
                ckmMonth = prefCal.getInt("kmMonth", kmMonth);
                ckmDay = prefCal.getInt("kmDay", kmDay);

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

                                ckmYear = year;
                                ckmMonth = monthOfYear;
                                ckmDay = dayOfMonth;

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
                                MainActivity.this,
                                listener,
                                ckmYear,
                                ckmMonth,
                                ckmDay
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

                        LastYear.putInt("last_year", cal.get(Calendar.YEAR));
                        LastYear.putInt("last_month", cal.get(Calendar.MONTH));
                        LastYear.putInt("last_day", cal.get(Calendar.DAY_OF_MONTH));

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
                        Intent intent = new Intent();
                        intent.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.MainActivity");

                        startActivity(intent);

                    }
                });

                //  ダイアログ内での保存E

                alertKanmen.setView(vKanmen);
                alertKanmen.show();

            }
        });



        TextView txtfood4 = (TextView)findViewById(R.id.limit_food4);
        txtfood4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertKanpan = new AlertDialog.Builder(MainActivity.this);
                alertKanpan.setTitle("乾パン");

                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View vKanpan = inflater.inflate(R.layout.activity_food_pop_kanpen, null);

                //  プリファレンスの作成S
                SharedPreferences prefKanpan = getSharedPreferences("Preferences", MODE_PRIVATE);

                int kpYear = prefKanpan.getInt("kpYear",  cal.get(Calendar.YEAR));
                int kpMonth = prefKanpan.getInt("kpMonth",  cal.get(Calendar.MONTH));
                int kpDay = prefKanpan.getInt("kpDay",  cal.get(Calendar.DAY_OF_MONTH));


                int i = 0;
                i = prefKanpan.getInt("key_kanpan", i);

                int adult = 0;
                adult = prefKanpan.getInt("key_adult", adult);

                int kids = 0;
                kids = prefKanpan.getInt("key_kids", kids);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vKanpan.findViewById(R.id.input_kanpan);
                TextView tAdult = (TextView)vKanpan.findViewById(R.id.kanpan_adult);
                TextView tKids = (TextView)vKanpan.findViewById(R.id.kanpan_kids);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);

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

                                ckpYear = year;
                                ckpMonth = monthOfYear;
                                ckpDay = dayOfMonth;

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
                                MainActivity.this,
                                listener,
                                ckpYear,
                                ckpMonth,
                                ckpDay
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

                        LastYear.putInt("last_year", cal.get(Calendar.YEAR));
                        LastYear.putInt("last_month", cal.get(Calendar.MONTH));
                        LastYear.putInt("last_day", cal.get(Calendar.DAY_OF_MONTH));

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
                        Intent intent = new Intent();
                        intent.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.MainActivity");

                        startActivity(intent);

                    }
                });

                //  ダイアログ内での保存E

                alertKanpan.setView(vKanpan);
                alertKanpan.show();

            }
        });



        TextView txtfood5 = (TextView)findViewById(R.id.limit_food5);
        txtfood5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertKandume2 = new AlertDialog.Builder(MainActivity.this);
                alertKandume2.setTitle("缶詰（肉・魚・野菜など）");

                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View vKandume2 = inflater.inflate(R.layout.activity_food_pop_kandume2, null);

                //  プリファレンスの作成S
                SharedPreferences prefKandume2 = getSharedPreferences("Preferences", MODE_PRIVATE);

                int kdYear = prefKandume2.getInt("kdYear",  cal.get(Calendar.YEAR));
                int kdMonth = prefKandume2.getInt("kdMonth",  cal.get(Calendar.MONTH));
                int kdDay = prefKandume2.getInt("kdDay",  cal.get(Calendar.DAY_OF_MONTH));

                int i = 0;
                i = prefKandume2.getInt("key_kandume2", i);

                int adult = 0;
                adult = prefKandume2.getInt("key_adult", adult);

                int kids = 0;
                kids = prefKandume2.getInt("key_kids", kids);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vKandume2.findViewById(R.id.input_kandume2);
                TextView tAdult = (TextView)vKandume2.findViewById(R.id.kandume2_adult);
                TextView tKids = (TextView)vKandume2.findViewById(R.id.kandume2_kids);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);

                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                ckdYear = prefCal.getInt("kdYear", kdYear);
                ckdMonth = prefCal.getInt("kdMonth", kdMonth);
                ckdDay = prefCal.getInt("kdDay", kdDay);

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

                                ckdYear = year;
                                ckdMonth = monthOfYear;
                                ckdDay = dayOfMonth;

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
                                MainActivity.this,
                                listener,
                                ckdYear,
                                ckdMonth,
                                ckdDay
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

                        LastYear.putInt("last_year", cal.get(Calendar.YEAR));
                        LastYear.putInt("last_month", cal.get(Calendar.MONTH));
                        LastYear.putInt("last_day", cal.get(Calendar.DAY_OF_MONTH));

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
                        Intent intent = new Intent();
                        intent.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.MainActivity");

                        startActivity(intent);

                    }
                });

                //  ダイアログ内での保存E

                alertKandume2.setView(vKandume2);
                alertKandume2.show();

            }
        });




        TextView txtfood6 = (TextView)findViewById(R.id.limit_food6);
        txtfood6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertRetoruto = new AlertDialog.Builder(MainActivity.this);
                alertRetoruto.setTitle("レトルト食品");

                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View vRetoruto = inflater.inflate(R.layout.activity_food_pop_retoruto, null);

                //  プリファレンスの作成S
                SharedPreferences prefRetoruto = getSharedPreferences("Preferences", MODE_PRIVATE);

                int reYear = prefRetoruto.getInt("reYear",  cal.get(Calendar.YEAR));
                int reMonth = prefRetoruto.getInt("reMonth",  cal.get(Calendar.MONTH));
                int reDay = prefRetoruto.getInt("reDay",  cal.get(Calendar.DAY_OF_MONTH));


                int i = 0;
                i = prefRetoruto.getInt("key_retoruto", 0);

                int adult = 0;
                adult = prefRetoruto.getInt("key_adult", adult);

                int kids = 0;
                kids = prefRetoruto.getInt("key_kids", kids);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vRetoruto.findViewById(R.id.input_retoruto);
                TextView tAdult = (TextView)vRetoruto.findViewById(R.id.retoruto_adult);
                TextView tKids = (TextView)vRetoruto.findViewById(R.id.retoruto_kids);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);

                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                creYear = prefCal.getInt("reYear", reYear);
                creMonth = prefCal.getInt("reMonth", reMonth);
                creDay = prefCal.getInt("reDay", reDay);

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

                                creYear = year;
                                creMonth = monthOfYear;
                                creDay = dayOfMonth;

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
                                MainActivity.this,
                                listener,
                                creYear,
                                creMonth,
                                creDay
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

                        LastYear.putInt("last_year", cal.get(Calendar.YEAR));
                        LastYear.putInt("last_month", cal.get(Calendar.MONTH));
                        LastYear.putInt("last_day", cal.get(Calendar.DAY_OF_MONTH));

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
                        Intent intent = new Intent();
                        intent.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.MainActivity");

                        startActivity(intent);

                    }
                });

                //  ダイアログ内での保存E

                alertRetoruto.setView(vRetoruto);
                alertRetoruto.show();

            }
        });



        TextView txtfood7 = (TextView)findViewById(R.id.limit_food7);
        txtfood7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertFurizzu = new AlertDialog.Builder(MainActivity.this);
                alertFurizzu.setTitle("フリーズドライ");

                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View vFurizzu = inflater.inflate(R.layout.activity_food_pop_furizzu, null);

                //  プリファレンスの作成S
                SharedPreferences prefFurizzu = getSharedPreferences("Preferences", MODE_PRIVATE);

                int fYear = prefFurizzu.getInt("fYear",  cal.get(Calendar.YEAR));
                int fMonth = prefFurizzu.getInt("fMonth",  cal.get(Calendar.MONTH));
                int fDay = prefFurizzu.getInt("fDay",  cal.get(Calendar.DAY_OF_MONTH));

                int i = 0;
                i = prefFurizzu.getInt("key_furizzu", 0);

                int adult = 0;
                adult = prefFurizzu.getInt("key_adult", adult);

                int kids = 0;
                kids = prefFurizzu.getInt("key_kids", kids);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vFurizzu.findViewById(R.id.input_furizzu);
                TextView tAdult = (TextView)vFurizzu.findViewById(R.id.furizzu_adult);
                TextView tKids = (TextView)vFurizzu.findViewById(R.id.furizzu_kids);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);

                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                cfYear = prefCal.getInt("fYear", fYear);
                cfMonth = prefCal.getInt("fMonth", fMonth);
                cfDay = prefCal.getInt("fDay", fDay);

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

                                cfYear = year;
                                cfMonth = monthOfYear;
                                cfDay = dayOfMonth;

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
                                MainActivity.this,
                                listener,
                                cfYear,
                                cfMonth,
                                cfDay
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

                        LastYear.putInt("last_year", cal.get(Calendar.YEAR));
                        LastYear.putInt("last_month", cal.get(Calendar.MONTH));
                        LastYear.putInt("last_day", cal.get(Calendar.DAY_OF_MONTH));

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
                        Intent intent = new Intent();
                        intent.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.MainActivity");

                        startActivity(intent);

                    }
                });

                //  ダイアログ内での保存E

                alertFurizzu.setView(vFurizzu);
                alertFurizzu.show();

            }
        });



        TextView txtfood8 = (TextView)findViewById(R.id.limit_food8);
        txtfood8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertKarori = new AlertDialog.Builder(MainActivity.this);
                alertKarori.setTitle("カロリーメイト");

                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View vKarori = inflater.inflate(R.layout.activity_food_pop_karori, null);

                //  プリファレンスの作成S
                SharedPreferences prefKarori = getSharedPreferences("Preferences", MODE_PRIVATE);

                int caYear = prefKarori.getInt("caYear",  cal.get(Calendar.YEAR));
                int caMonth = prefKarori.getInt("caMonth",  cal.get(Calendar.MONTH));
                int caDay = prefKarori.getInt("caDay",  cal.get(Calendar.DAY_OF_MONTH));

                int i = 0;
                i = prefKarori.getInt("key_karori", 0);

                int adult = 0;
                adult = prefKarori.getInt("key_adult", adult);

                int kids = 0;
                kids = prefKarori.getInt("key_kids", kids);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vKarori.findViewById(R.id.input_karori);
                TextView tAdult = (TextView)vKarori.findViewById(R.id.karori_adult);
                TextView tKids = (TextView)vKarori.findViewById(R.id.karori_kids);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);

                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                ccaYear = prefCal.getInt("caYear", caYear);
                ccaMonth = prefCal.getInt("caMonth", caMonth);
                ccaDay = prefCal.getInt("caDay", caDay);



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

                                ccaYear = year;
                                ccaMonth = monthOfYear;
                                ccaDay = dayOfMonth;

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
                                MainActivity.this,
                                listener,
                                ccaYear,
                                ccaMonth,
                                ccaDay
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

                        LastYear.putInt("last_year", cal.get(Calendar.YEAR));
                        LastYear.putInt("last_month", cal.get(Calendar.MONTH));
                        LastYear.putInt("last_day", cal.get(Calendar.DAY_OF_MONTH));

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
                        Intent intent = new Intent();
                        intent.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.MainActivity");

                        startActivity(intent);

                    }
                });

                //  ダイアログ内での保存E

                alertKarori.setView(vKarori);
                alertKarori.show();
            }
        });



        TextView txtfood9 = (TextView)findViewById(R.id.limit_food9);
        txtfood9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertOkasi = new AlertDialog.Builder(MainActivity.this);
                alertOkasi.setTitle("菓子類");

                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View vOkasi = inflater.inflate(R.layout.activity_food_pop_okasi, null);

                //  プリファレンスの作成S
                SharedPreferences prefOkasi = getSharedPreferences("Preferences", MODE_PRIVATE);

                int cnYear = prefOkasi.getInt("cnYear",  cal.get(Calendar.YEAR));
                int cnMonth = prefOkasi.getInt("cnMonth",  cal.get(Calendar.MONTH));
                int cnDay = prefOkasi.getInt("cnDay",  cal.get(Calendar.DAY_OF_MONTH));

                int i = 0;
                i = prefOkasi.getInt("key_okasi", 0);

                int adult = 0;
                adult = prefOkasi.getInt("key_adult", adult);

                int kids = 0;
                kids = prefOkasi.getInt("key_kids", kids);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vOkasi.findViewById(R.id.input_okasi);
                TextView tAdult = (TextView)vOkasi.findViewById(R.id.okasi_adult);
                TextView tKids = (TextView)vOkasi.findViewById(R.id.okasi_kids);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);

                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                ccnYear = prefCal.getInt("cnYear", cnYear);
                ccnMonth = prefCal.getInt("cnMonth", cnMonth);
                ccnDay = prefCal.getInt("cnDay", cnDay);

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

                                ccnYear = year;
                                ccnMonth = monthOfYear;
                                ccnDay = dayOfMonth;

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
                                MainActivity.this,
                                listener,
                                ccnYear,
                                ccnMonth,
                                ccnDay
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

                        LastYear.putInt("last_year", cal.get(Calendar.YEAR));
                        LastYear.putInt("last_month", cal.get(Calendar.MONTH));
                        LastYear.putInt("last_day", cal.get(Calendar.DAY_OF_MONTH));

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
                        Intent intent = new Intent();
                        intent.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.MainActivity");

                        startActivity(intent);

                    }
                });

                //  ダイアログ内での保存E

                alertOkasi.setView(vOkasi);
                alertOkasi.show();

            }
        });



        TextView txtfood10 = (TextView)findViewById(R.id.limit_food10);
        txtfood10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertKona = new AlertDialog.Builder(MainActivity.this);
                alertKona.setTitle("粉ミルク");

                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View vKona = inflater.inflate(R.layout.activity_food_pop_konamilk, null);

                //  プリファレンスの作成S
                SharedPreferences prefKona = getSharedPreferences("Preferences", MODE_PRIVATE);

                int pmYear = prefKona.getInt("pmYear",  cal.get(Calendar.YEAR));
                int pmMonth = prefKona.getInt("pmMonth",  cal.get(Calendar.MONTH));
                int pmDay = prefKona.getInt("pmDay",  cal.get(Calendar.DAY_OF_MONTH));

                int i = 0;
                i = prefKona.getInt("key_konamilk", 0);

                int baby = 0;
                baby = prefKona.getInt("key_baby", baby);

                String str = String.valueOf(i);
                String strBaby = String.valueOf(baby);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vKona.findViewById(R.id.input_konamilk);
                TextView tBaby = (TextView)vKona.findViewById(R.id.konamilk_baby);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tBaby.setText(strBaby);

                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                cpmYear = prefCal.getInt("pmYear", pmYear);
                cpmMonth = prefCal.getInt("pmMonth", pmMonth);
                cpmDay = prefCal.getInt("pmDay", pmDay);

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

                                cpmYear = year;
                                cpmMonth = monthOfYear;
                                cpmDay = dayOfMonth;

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
                                MainActivity.this,
                                listener,
                                cpmYear,
                                cpmMonth,
                                cpmDay
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

                        LastYear.putInt("last_year", cal.get(Calendar.YEAR));
                        LastYear.putInt("last_month", cal.get(Calendar.MONTH));
                        LastYear.putInt("last_day", cal.get(Calendar.DAY_OF_MONTH));

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
                        Intent intent = new Intent();
                        intent.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.MainActivity");

                        startActivity(intent);

                    }
                });

                //  ダイアログ内での保存E

                alertKona.setView(vKona);
                alertKona.show();

            }
        });



        TextView txtfood11 = (TextView)findViewById(R.id.limit_food11);
        txtfood11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertRinyu = new AlertDialog.Builder(MainActivity.this);
                alertRinyu.setTitle("離乳食");

                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View vRinyu = inflater.inflate(R.layout.activity_food_pop_rinyu, null);

                //  プリファレンスの作成S
                SharedPreferences prefRinyu = getSharedPreferences("Preferences", MODE_PRIVATE);

                int bfYear = prefRinyu.getInt("bfYear",  cal.get(Calendar.YEAR));
                int bfMonth = prefRinyu.getInt("bfMonth",  cal.get(Calendar.MONTH));
                int bfDay = prefRinyu.getInt("bfDay",  cal.get(Calendar.DAY_OF_MONTH));

                int i = 0;
                i = prefRinyu.getInt("key_rinyu", i);

                int baby = 0;
                baby = prefRinyu.getInt("key_baby", baby);

                String str = String.valueOf(i);
                String strBaby = String.valueOf(baby);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vRinyu.findViewById(R.id.input_rinyu);
                TextView tBaby = (TextView)vRinyu.findViewById(R.id.rinyu_baby);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tBaby.setText(strBaby);

                //  プリファレンス
                SharedPreferences prefCal = getSharedPreferences("Preferences", MODE_PRIVATE);
                cbfYear = prefCal.getInt("bfYear", bfYear);
                cbfMonth = prefCal.getInt("bfMonth", bfMonth);
                cbfDay = prefCal.getInt("bfDay", bfDay);

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

                                cbfYear = year;
                                cbfMonth = monthOfYear;
                                cbfDay = dayOfMonth;

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
                                MainActivity.this,
                                listener,
                                cbfYear,
                                cbfMonth,
                                cbfDay
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

                        LastYear.putInt("last_year", cal.get(Calendar.YEAR));
                        LastYear.putInt("last_month", cal.get(Calendar.MONTH));
                        LastYear.putInt("last_day", cal.get(Calendar.DAY_OF_MONTH));

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
                        Intent intent = new Intent();
                        intent.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.MainActivity");

                        startActivity(intent);

                    }
                });

                //  ダイアログ内での保存E

                alertRinyu.setView(vRinyu);
                alertRinyu.show();

            }
        });



        TextView txtfood12 = (TextView)findViewById(R.id.limit_food12);
        txtfood12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertMisu = new AlertDialog.Builder(MainActivity.this);
                alertMisu.setTitle("水");

                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View vMisu = inflater.inflate(R.layout.activity_food_pop_mizu, null);

                //  プリファレンスの作成S
                SharedPreferences prefMisu = getSharedPreferences("Preferences", MODE_PRIVATE);

                int miYear = prefMisu.getInt("miYear",  cal.get(Calendar.YEAR));
                int miMonth = prefMisu.getInt("miMonth",  cal.get(Calendar.MONTH));
                int miDay = prefMisu.getInt("miDay",  cal.get(Calendar.DAY_OF_MONTH));

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
                cmiYear = prefCal.getInt("miYear", miYear);
                cmiMonth = prefCal.getInt("miMonth", miMonth);
                cmiDay = prefCal.getInt("miDay", miDay);

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

                                cmiYear = year;
                                cmiMonth = monthOfYear;
                                cmiDay = dayOfMonth;

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
                                MainActivity.this,
                                listener,
                                cmiYear,
                                cmiMonth,
                                cmiDay
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

                        LastYear.putInt("last_year", cal.get(Calendar.YEAR));
                        LastYear.putInt("last_month", cal.get(Calendar.MONTH));
                        LastYear.putInt("last_day", cal.get(Calendar.DAY_OF_MONTH));

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
                        Intent intent = new Intent();
                        intent.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.MainActivity");

                        startActivity(intent);

                    }
                });

                //  ダイアログ内での保存E

                alertMisu.setView(vMisu);
                alertMisu.show();

            }
        });
/*************************************************************************************************/
//  バブルソート処理。S
//  クラスはここで初利用。遅すぎた。
/*************************************************************************************************/
        SampleClass[] sc = new SampleClass[MAX_FOODS_CATEGORY];

        for(int i = 0; i < MAX_FOODS_CATEGORY; ++i) {
            sc[i] = new SampleClass();
        }

        Initialize(sc[0],sc[1],sc[2],sc[3],sc[4],sc[5],sc[6],sc[7],sc[8],sc[9],sc[10],sc[11]);

//        sc[0].name = "レトルトご飯";

        sc[0].lastDay = lReRice;
        sc[1].lastDay = lKandume;
        sc[2].lastDay = lKanmen;
        sc[3].lastDay = lKanpan;
        sc[4].lastDay = lKandume2;
        sc[5].lastDay = lRetoruto;
        sc[6].lastDay = lFurizzu;
        sc[7].lastDay = lKarori;
        sc[8].lastDay = lOkasi;
        sc[9].lastDay = lKona;
        sc[10].lastDay = lRinyu;
        sc[11].lastDay = lMizu;


//        TextView txt1 = (TextView)findViewById(R.id.textView300);
  //      txt1.setText(""+sc[0].data);
/*
        TextView txt2 = (TextView)findViewById(R.id.textView301);
        txt2.setText(""+lKandume);

        TextView txt3 = (TextView)findViewById(R.id.textView302);
        txt3.setText(""+lKanmen);

        TextView txt4 = (TextView)findViewById(R.id.textView303);
        txt4.setText(""+lKanpan);
*/
        func5(sc[0],sc[1],sc[2],sc[3],sc[4],sc[5],sc[6],sc[7],sc[8],sc[9],sc[10],sc[11],limit);


/*
        func1();
        int i = func3(4);
        TextView t = (TextView)findViewById(R.id.alert_baby);
        t.setText(""+i);
*/
/*************************************************************************************************/
//  バブルソート処理。E
/*************************************************************************************************/
    }
    public void func5(SampleClass x0,SampleClass x1,SampleClass x2,SampleClass x3,
                             SampleClass x4,SampleClass x5,SampleClass x6,SampleClass x7,
                             SampleClass x8,SampleClass x9,SampleClass x10,SampleClass x11,
                             int limit){

        SampleClass[] array = new SampleClass[MAX_FOODS_CATEGORY];
//        int[] finalArray;

        for(int i = 0; i < MAX_FOODS_CATEGORY; ++i) {
            array[i] = new SampleClass();
        }

//        array = new int[12];
//        finalArray = new int[12];
/*
        for(int i = 0; i < 12; ++i){
            finalArray[0] = 0;
        }
*/

        array[0]  = x0;
        array[1]  = x1;
        array[2]  = x2;
        array[3]  = x3;
        array[4]  = x4;
        array[5]  = x5;
        array[6]  = x6;
        array[7]  = x7;
        array[8]  = x8;
        array[9]  = x9;
        array[10] = x10;
        array[11] = x11;

        for(int i = 0; i < MAX_FOODS_CATEGORY-1 ; ++i){
            for(int j = MAX_FOODS_CATEGORY-1; j > i ; --j){
                if(array[j].lastDay < array[j-1].lastDay){
//                    if(array[j].food <= 0) {
                        String n = array[j].name;
                        int t = array[j].lastDay;

                        array[j].name = array[j - 1].name;
                        array[j].lastDay = array[j - 1].lastDay;

                        array[j - 1].name = n;
                        array[j - 1].lastDay = t;
//                    }
                }
            }
        }
/*
        TextDeadline(array[0].name, array[0].food, array[0].lastDay,R.id.limit_food1, limit);
        TextDeadline(array[1].name, array[1].food, array[1].lastDay,R.id.limit_food2, limit);
        TextDeadline(array[2].name, array[2].food, array[2].lastDay,R.id.limit_food3, limit);
        TextDeadline(array[3].name, array[3].food, array[3].lastDay,R.id.limit_food4, limit);
        TextDeadline(array[4].name, array[4].food, array[4].lastDay,R.id.limit_food5, limit);
        TextDeadline(array[5].name, array[5].food, array[5].lastDay,R.id.limit_food6, limit);
        TextDeadline(array[6].name, array[6].food, array[6].lastDay,R.id.limit_food7, limit);
        TextDeadline(array[7].name, array[7].food, array[7].lastDay,R.id.limit_food8, limit);
        TextDeadline(array[8].name, array[8].food, array[8].lastDay,R.id.limit_food9, limit);
        TextDeadline(array[9].name, array[9].food, array[9].lastDay,R.id.limit_food10, limit);
        TextDeadline(array[10].name, array[10].food, array[10].lastDay,R.id.limit_food11, limit);
        TextDeadline(array[11].name, array[11].food, array[11].lastDay,R.id.limit_food12, limit);
/*
        TextView txt1 = (TextView)findViewById(R.id.textView300);
        txt1.setText(x0.name+""+ x0.lastDay);
*/
/*
        TextView txt2 = (TextView)findViewById(R.id.textView301);
        txt2.setText(x1.name+""+ x1.lastDay);

        TextView txt3 = (TextView)findViewById(R.id.textView302);
        txt3.setText(x2.name+""+ x2.lastDay);

        TextView txt4 = (TextView)findViewById(R.id.textView303);
        txt4.setText(x3.name+""+ x3.lastDay);
*/
    }
    //  関数
    public float UsedFamilyStock(float stock, int set, float x, float y, float z){
        float rate = 0.0f;
        switch (set){
            case 1:
                rate = stock / x;
                break;

            case 3:
                rate = stock / y;
                break;

            case 7:
                rate = stock / z;
                break;
        }

        if(rate >= 1.0f){
            rate = 1.0f;
        }

        rate = rate / 13.0f;

        return rate;
    }



/*    //  備蓄人、必需品、割合の求め関数
    public float GetRateStocks(float aStock, float bStock, float aNeed, float bNeed, float oNeed, int adult, int kids, int baby){
        float rateFinal = 0.0f;
        float rateAdult = 0.0f;
        float rateBaby = 0.0f;
        float rateUseful = 0.0f;

        if((adult+kids) > 0){
            rateAdult = aStock / aNeed;
            if(rateAdult >= 1.0f){
                rateAdult = 1.0f;
            }
            if( baby > 0 ){
                rateAdult *= 0.5f;
            } else {
                rateAdult *= 0.6f;
            }
        } else {
            rateAdult = 0.0f;
        }

        if(baby > 0){
            rateBaby = bStock / bNeed;
            if( rateBaby >= 1.0f ){
                rateBaby = 1.0f;
            }
            if( (adult+kids) > 0 ){
                rateBaby *= 0.1f;
            } else {
                rateBaby *= 0.6f;
            }
        } else {
            rateBaby = 0.0f;
        }

        rateUseful = (aStock + bStock) / (aNeed + bNeed + oNeed);

        rateAdult *= rateUseful;
        rateBaby  *= rateUseful;

        rateFinal = rateAdult + rateBaby;

        return rateFinal;
    }

    //  備蓄品での合計必要数
    public float GetNeedAdultStocks(int adult, int kids, int set){
        int nAdult = 0;
        int nKids = 0;
        int total = 0;

        switch(set){
            case 1:
                nAdult = adult * 3;
                nKids = kids * 5 ;
                break;

            case 3:
                nAdult = adult * 4;
                nKids = kids * 4;
                break;

            case 7:
                nAdult = adult * 7;
                nKids = kids * 7;
                break;
        }
        total = nAdult + nKids;

        return  total;
    }

    //  幼児合計数
    public float GetNeedBabyStocks(int baby, int set){
        int total = 0;

        switch(set){
            case 1:
                total = (baby * 6);
                break;

            case 3:
                total = (baby * 10);
                break;

            case 7:
                total = (baby * 19);
                break;
        }

        return  total;
    }

    public float GetNeedStocksOrg(int set){
        int total = 0;

        switch(set){
            case 1:
                total = 11;
                break;

            case 3:
                total = 12;
                break;

            case 7:
                total = 22;
                break;
        }
        return total;
    }
*/
    public void Initialize(SampleClass x0,SampleClass x1,SampleClass x2,SampleClass x3,
                            SampleClass x4,SampleClass x5,SampleClass x6,SampleClass x7,
                            SampleClass x8,SampleClass x9,SampleClass x10,SampleClass x11){
        SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
        //  設定の合計人数
//        int adult   = pref.getInt("key_adult", 0);
        x0.name = "レトルトご飯";
        x0.food = pref.getInt("key_ReRice",0);

        x1.name = "缶詰（ご飯）";
        x1.food = pref.getInt("key_kandume",0);

        x2.name = "乾麺";
        x2.food = pref.getInt("key_kanmen",0);

        x3.name = "乾パン";
        x3.food = pref.getInt("key_kanpan",0);

        x4.name = "缶詰（肉・魚）";
        x4.food = pref.getInt("key_kandume2",0);

        x5.name = "レトルト";
        x5.food = pref.getInt("key_retoruto",0);

        x6.name = "フリーズドライ";
        x6.food = pref.getInt("key_furizzu",0);

        x7.name = "カロリーメイト";
        x7.food = pref.getInt("key_karori",0);

        x8.name = "菓子類";
        x8.food = pref.getInt("key_okasi",0);

        x9.name = "粉ミルク";
        x9.food = pref.getInt("key_konamilk",0);

        x10.name = "離乳食";
        x10.food = pref.getInt("key_rinyu",0);

        x11.name = "水";
        x11.food = pref.getInt("key_mizu",0);

    }

    public void TextDeadline(String name,int food, int lastdays, int id, int limit){
        TextView txt = (TextView)findViewById(id);

        if( food <= 0 ) {
            //  表示しない
            txt.setText("");
        } else if ( lastdays == 0 ){
            txt.setText("　　" + name +"の消費期限当日です");
        } else if ( lastdays < 0 ) {
            txt.setText("　　" +  name + "の消費期限が過ぎています");
        } else if ( (lastdays - limit) <= 0){
            txt.setText("　　" +  name + "の消費期限が" + ( lastdays ) + "日前です");
        } else {
            //  表示しない
            txt.setText("");
        }

    }

/*
    //  関数、お試し。関数の中に関数を入れられるか？
    public void func1(){
        func2();
    }

    public void func2(){
        int a = 1234;
        TextView t = (TextView)findViewById(R.id.textView150);
        t.setText("びーちくひん");
    }

    public int func3(int a){
        return func4(a);
    }

    public int func4(int a){
        return a * 4;
    }
*/
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

    //  消費期限、算出関数。（一応完成？テストはまだ）
    //  第一引数から「年、月、日」
    public int DeadlineFood(int year, int month, int day){

        //  月の値の補正。（※1月が0、12月が11になるので）
        month += 1;

        //  テキストとカレンダーのデータの使用宣言。
        Calendar cal = Calendar.getInstance();

        //  うるう年の算出
        int leap = year / 4 - (year / 100) + (year / 400);

        //  year年度に入ってからの経過した日数
        int dayofmonth = DayOfMonth(month) + day;

        //  算出法（日単位） = 年*365 + 月日 + うるう年
        int deadline = (year * 365) + dayofmonth + leap;

        //  本日までを日付で算出。
        int today = (cal.get(Calendar.YEAR) * 365)
                  + (cal.get(Calendar.DAY_OF_YEAR))
                  + leap;

        return (deadline - today);
    }

    //  月を日付に変換
    //  消費期限の関数とセットで使用すること。
    public int DayOfMonth(int month){
        int dayOfMonth = 0; //  現在月を経過日数に変更する変数（※1日を想定）

        switch(month) {
            case  1: dayOfMonth = 0;   break;
            case  2: dayOfMonth = 31;  break;
            case  3: dayOfMonth = 59;  break;
            case  4: dayOfMonth = 90;  break;
            case  5: dayOfMonth = 120; break;
            case  6: dayOfMonth = 151; break;
            case  7: dayOfMonth = 181; break;
            case  8: dayOfMonth = 212; break;
            case  9: dayOfMonth = 243; break;
            case 10: dayOfMonth = 274; break;
            case 11: dayOfMonth = 304; break;
            case 12: dayOfMonth = 335; break;
        }
        return dayOfMonth;
    }

    //  割合の計算式、備蓄兼用で使用できる。
//    rateOverKids = CalRateForOverKids(okAll, fBaby, adult, kids, baby, setting);
    public float getRateFoods(float food, float adult, float kids, float set) {
        //  設定の人数の合計値。
        float totalHuman = adult + kids;
        if(totalHuman == 0){
            return 0.0f;
        }

        //*****************************************************************************************/
        //  大人と小人関係の変数準備S
        //*****************************************************************************************/

        //  大人の必要ポイントを算出
        float nAdult = adult * 3.0f;

        //  小人の必要ポイントを算出
        float nKids = kids * 2.0f;

        //  大人と小人のポイントを算出。
        float tNOverKids = nAdult + nKids;

        //*****************************************************************************************/
        //  割合計算。大人と小人S
        //  （大小食料ポイント ÷ ｛必要ポイント × 設定日数｝） ×（大小人数 ÷ 全人数）
        //*****************************************************************************************/
        float rateOverKids;
        rateOverKids = food / ( tNOverKids * set );

        if(rateOverKids >= 1.0f){
            rateOverKids = 1.0f;
        }

        rateOverKids *= 0.5f;

        return rateOverKids;
    }
    //　幼児バージョン
    public float CalRateForBaby(float food, int baby, int set){

        float nfBaby = baby * 3;

        float rateBaby = food / ( nfBaby * set );

        rateBaby *= 0.5f;

        if(rateBaby >= 0.5f){
            rateBaby = 0.5f;
            return rateBaby;
        } else {
            return rateBaby;
        }
    }


    //
    public float getRateWater(float water, int adult, int kids, int baby, int set){
        float rateWater;
        float needTotal;

        needTotal = ( (( adult * 3 ) + ( kids * 2 ) + ( baby * 2 )) * set );

        rateWater = water / needTotal;

        //  食料との比較のため、半減。
        rateWater *= 0.5f;

        if( rateWater >= 0.5f ){
            rateWater = 0.5f;
            return  rateWater;
        } else {
            return rateWater;
        }
    }
}
