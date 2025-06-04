package com.example.pb_01;

public class AktifMac {
    private String takim1Isim;
    private String takim2Isim;
    private int macSiraNo;
    private float oran15ust;
    private float oran15alt;
    private float oran25ust;
    private float oranMs1;
    private float oranMsX;
    private float oranMs2;
    private int macID;
    private String baslangicSaati;
    private String bitisSaati;
    private boolean aktifMi;
    private int skorTakim1;
    private int skorTakim2;
    private boolean macBasladiMi;

    // Constructor, getters, and setters

    public AktifMac(String takim1Isim, String takim2Isim, int macSiraNo, float oran15ust, float oran15alt, float oran25ust, float oranMs1, float oranMs2, float oranMsX, int macID, String baslangicSaati, String bitisSaati, boolean aktifMi, int skorTakim1, int skorTakim2, boolean macBasladiMi) {
        this.takim1Isim = takim1Isim;
        this.takim2Isim = takim2Isim;
        this.macSiraNo = macSiraNo;
        this.oran15ust = oran15ust;
        this.oran15alt = oran15alt;
        this.oran25ust = oran25ust;
        this.oranMs1 = oranMs1;
        this.oranMs2 = oranMs2;
        this.oranMsX = oranMsX;
        this.macID = macID;
        this.baslangicSaati = baslangicSaati;
        this.bitisSaati = bitisSaati;
        this.aktifMi = aktifMi;
        this.skorTakim1 = skorTakim1;
        this.skorTakim2 = skorTakim2;
        this.macBasladiMi = macBasladiMi;
    }

    // Getters and Setters
    public String getTakim1Isim() { return takim1Isim; }
    public void setTakim1Isim(String takim1Isim) { this.takim1Isim = takim1Isim; }
    public String getTakim2Isim() { return takim2Isim; }
    public void setTakim2Isim(String takim2Isim) { this.takim2Isim = takim2Isim; }
    public int getMacSiraNo() { return macSiraNo; }
    public void setMacSiraNo(int macSiraNo) { this.macSiraNo = macSiraNo; }
    public float getOran15ust() { return oran15ust; }
    public void setOran15ust(float oran15ust) { this.oran15ust = oran15ust; }
    public float getOran15alt() { return oran15alt; }
    public void setOran15alt(float oran15alt) { this.oran15alt = oran15alt; }
    public float getOran25ust() { return oran25ust; }
    public void setOran25ust(float oran25ust) { this.oran25ust = oran25ust; }
    public float getOranMs1() { return oranMs1; }
    public void setOranMs1(float oranMs1) { this.oranMs1 = oranMs1; }
    public float getOranMsX() { return oranMsX; }
    public void setOranMsX(float oranMsX) { this.oranMsX = oranMsX; }
    public float getOranMs2() { return oranMs2; }
    public void setOranMs2(float oranMs2) { this.oranMs2 = oranMs2; }
    public int getMacID() { return macID; }
    public void setMacID(int macID) { this.macID = macID; }
    public String getBaslangicSaati() { return baslangicSaati; }
    public void setBaslangicSaati(String baslangicSaati) { this.baslangicSaati = baslangicSaati; }
    public String getBitisSaati() { return bitisSaati; }
    public void setBitisSaati(String bitisSaati) { this.bitisSaati = bitisSaati; }
    public boolean isAktifMi() { return aktifMi; }
    public void setAktifMi(boolean aktifMi) { this.aktifMi = aktifMi; }
    public int getSkorTakim1() { return skorTakim1; }
    public void setSkorTakim1(int skorTakim1) { this.skorTakim1 = skorTakim1; }
    public int getSkorTakim2() { return skorTakim2; }
    public void setSkorTakim2(int skorTakim2) { this.skorTakim2 = skorTakim2; }
    public boolean isMacBasladiMi() { return macBasladiMi; }
    public void setMacBasladiMi(boolean macBasladiMi) { this.macBasladiMi = macBasladiMi; }
}
