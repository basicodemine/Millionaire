package com.milyoner.akademi.bilisim.milyoner;

import java.util.Map;

/**
 * Created by eGo on 14/08/2017.
 */

public class SoruClass {
    Map<String,String> cevaplar;
    String dogrucevap;
    String sorulansoru;

    public SoruClass() {
    }

    public Map<String, String> getCevaplar() {

        return cevaplar;
    }

    public void setCevaplar(Map<String, String> cevaplar) {
        this.cevaplar = cevaplar;
    }

    public String getDogrucevap() {
        return dogrucevap;
    }

    public void setDogrucevap(String dogrucevap) {
        this.dogrucevap = dogrucevap;
    }

    public String getSorulansoru() {
        return sorulansoru;
    }

    public void setSorulansoru(String sorulansoru) {
        this.sorulansoru = sorulansoru;
    }

    public SoruClass(Map<String, String> cevaplar, String dogrucevap, String sorulansoru) {

        this.cevaplar = cevaplar;
        this.dogrucevap = dogrucevap;
        this.sorulansoru = sorulansoru;
    }
}
