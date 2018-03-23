package com.milyoner.akademi.bilisim.milyoner;

import android.util.Log;

/**
 * Created by eGo on 30/08/2017.
 */

public class Basari {
    long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Basari(long id, String para, int sure, int puan) {

        this.id = id;
        this.para = para;
        this.sure = sure;
        this.puan = puan;
    }

    String para;
    int sure;
    int puan=0;

    void puanHesapla(String para,int sure){
        int kismi=0;
        switch (para) {
            case "0":
                kismi=0;
                break;
            case "500":
                kismi=10000;
                break;
            case "1.000":
                kismi=20000;
                break;
            case "2.000":
                kismi=30000;
                break;
            case "3.000":
                kismi=40000;
                break;
            case "5.000":
                kismi=50000;
                break;
            case "7.500":
                kismi=60000;
                break;
            case "15.000":
                kismi=70000;
                break;
            case "30.000":
                kismi=80000;
                break;
            case "60.000":
                kismi=90000;
                break;
            case "125.000":
                kismi=100000;
                break;
            case "250.000":
                kismi=110000;
                break;
            case "1.000.000":
                kismi=210000;
                break;
        }

        int donecekpuan = kismi/sure;
        puan=donecekpuan;
        Log.e("Puan",""+puan);

    }

    public Basari(String para, int sure) {
        this.para = para;
        this.sure = sure;
        puanHesapla(para,sure);
    }

    public int getPuan() {
        return puan;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public int getSure() {
        return sure;
    }

    public void setSure(int sure) {
        this.sure = sure;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }
}
