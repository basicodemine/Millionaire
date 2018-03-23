package com.milyoner.akademi.bilisim.milyoner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class OyunEkran extends AppCompatActivity {
    Oyun oyun;
    Button a, b, c, d;
    Button witdraw;
    ImageButton yariyariya;
    ImageButton telefonla;
    ImageButton seyircisor;
    TextView soru;
    TextView suregosterici;
    Button[] parabuttonlari = new Button[12];
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_oyun_ekran);
        getSupportActionBar().hide();
        gorselata();
        try {
            oyun = new Oyun(this, a, b, c, d, soru);
            oyun.setParabutton(parabuttonlari);
            oyun.setZamansayaci(suregosterici);
            oyun.setYariyariya(yariyariya);
            oyun.setTelefonla(telefonla);
            oyun.setSeyircisor(seyircisor);
            oyun.setCekilbuttonu(witdraw);
            oyun.setSoruadet(12);
            oyun.oyunOyna();
        } catch (Exception e) {
            Log.e("HATA ALDIM", e.toString());
        }
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.interstitial_full_screen));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.e("TAG", "EROOR REKLAM VS.");
        }
    }

    void gorselata() {
        a = (Button) findViewById(R.id.a);
        b = (Button) findViewById(R.id.b);
        c = (Button) findViewById(R.id.c);
        d = (Button) findViewById(R.id.d);
        seyircisor = (ImageButton) findViewById(R.id.seyircisor);
        telefonla = (ImageButton) findViewById(R.id.telefonla);
        yariyariya = (ImageButton) findViewById(R.id.yariyariya);
        soru = (TextView) findViewById(R.id.sorucontainer);
        parabuttonlari[0] = (Button) findViewById(R.id.para1);
        parabuttonlari[1] = (Button) findViewById(R.id.para2);
        parabuttonlari[2] = (Button) findViewById(R.id.para3);
        parabuttonlari[3] = (Button) findViewById(R.id.para4);
        parabuttonlari[4] = (Button) findViewById(R.id.para5);
        parabuttonlari[5] = (Button) findViewById(R.id.para6);
        parabuttonlari[6] = (Button) findViewById(R.id.para7);
        parabuttonlari[7] = (Button) findViewById(R.id.para8);
        parabuttonlari[8] = (Button) findViewById(R.id.para9);
        parabuttonlari[9] = (Button) findViewById(R.id.para10);
        parabuttonlari[10] = (Button) findViewById(R.id.para11);
        parabuttonlari[11] = (Button) findViewById(R.id.para12);
        suregosterici = (TextView) findViewById(R.id.suregosterici);
        witdraw = (Button) findViewById(R.id.cekil);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (oyun.mediaPlayer.isPlaying())
            oyun.mediaPlayer.stop();
        try {
            oyun.sureakisi.cancel();
            oyun.countDownTimer.cancel();
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.e("TAG", "EROOR REKLAM VS.");
            }
        } catch (Exception e) {
            Log.e("Timer", e.toString());
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (oyun.mediaPlayer.isPlaying())
            oyun.mediaPlayer.stop();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (oyun.mediaPlayer.isPlaying())
            oyun.mediaPlayer.stop();
        try {
            oyun.sureakisi.cancel();
        } catch (Exception e) {
            Log.e("Timer", e.toString());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (oyun.mediaPlayer.isPlaying())
            oyun.mediaPlayer.stop();
        try {
            oyun.sureakisi.cancel();
        } catch (Exception e) {
            Log.e("Timer", e.toString());
        }
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.e("TAG", "EROOR REKLAM VS.");
        }

    }




}
