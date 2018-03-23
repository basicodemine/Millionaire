package com.milyoner.akademi.bilisim.milyoner;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class OtherPrograms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_other_programs);
        getSupportActionBar().hide();
    }

    public void seefirst(View view) {
        String url = "https://play.google.com/store/apps/details?id=duyuru.bilisim.com.kpssgunlugum";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void seesecond(View view) {
        String url = "https://play.google.com/store/apps/details?id=kelime.yds.com.ydskelimeezberleme";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void seethird(View view) {
        String url = "https://play.google.com/store/apps/details?id=com.azizerel.haberoku";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void seefourth(View view) {
        String url = "https://play.google.com/store/apps/details?id=com.yesor.no";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
