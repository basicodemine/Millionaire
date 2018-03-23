package com.milyoner.akademi.bilisim.milyoner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.milyoner.akademi.bilisim.milyoner.Kutuphaneler.SkorAdapter;

import java.util.ArrayList;
import java.util.Collections;

public class SkorListe extends AppCompatActivity {

    ListView scorelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_skor_liste);
        getSupportActionBar().hide();
        gorselata();
    }


    void gorselata() {

        scorelist = (ListView) findViewById(R.id.skorlistview);

        SQLiteSkor sqLiteSkor = new SQLiteSkor(this);
        SkorAdapter adapter = new SkorAdapter(this, sqLiteSkor.getAllScoresHighest());
        scorelist.setAdapter(adapter);

    }

    public void skoragore(View view) {
        SQLiteSkor sqLiteSkor = new SQLiteSkor(this);
        SkorAdapter adapter = new SkorAdapter(this, sqLiteSkor.getAllScoresHighest());
        scorelist.setAdapter(adapter);
    }

    public void tarihegore(View view) {
        SQLiteSkor sqLiteSkor = new SQLiteSkor(this);
        ArrayList <Basari> list= sqLiteSkor.getAllScores();
        Collections.reverse(list);
        SkorAdapter adapter = new SkorAdapter(this,list);
        scorelist.setAdapter(adapter);
    }

    public void temizle(View view) {
        SQLiteSkor sqLiteSkor = new SQLiteSkor(this);
        sqLiteSkor.deleteAllScores();
        SkorAdapter adapter = new SkorAdapter(this, sqLiteSkor.getAllScoresHighest());
        scorelist.setAdapter(adapter);
    }
}
