package com.milyoner.akademi.bilisim.milyoner.Kutuphaneler;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.milyoner.akademi.bilisim.milyoner.Basari;
import com.milyoner.akademi.bilisim.milyoner.R;

import java.util.ArrayList;

/**
 * Created by eGo on 31/08/2017.
 */

public class SkorAdapter extends BaseAdapter {
    Activity activity;
    LayoutInflater inflater;
    public SkorAdapter(Activity activity, ArrayList<Basari> scores) {
        this.activity = activity;
        this.scores = scores;
        inflater=LayoutInflater.from(activity.getApplicationContext());
    }

    ArrayList<Basari> scores;
    @Override
    public int getCount() {
        return scores.size();
    }

    @Override
    public Object getItem(int i) {
        return scores.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=inflater.inflate(R.layout.rowscore,null);
        TextView tvpara=(TextView)v.findViewById(R.id.para);
        TextView tvpuan=(TextView)v.findViewById(R.id.puan);
        TextView tvsure=(TextView)v.findViewById(R.id.sure);

        tvpara.setText(""+scores.get(i).getPara()+" "+activity.getString(R.string.currency));
        tvsure.setText(""+scores.get(i).getSure()+" "+activity.getString(R.string.second));
        tvpuan.setText(""+scores.get(i).getPuan()+" "+activity.getString(R.string.point));

        return v;
    }
}
