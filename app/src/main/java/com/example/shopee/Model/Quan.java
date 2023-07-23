package com.example.shopee.Model;

import java.io.Serializable;
import java.util.Calendar;

public class Quan implements Serializable {
    int MAQ;
    int MALQ;
    int MATK;
    String TENQ;
    String DIACHIQ;
    String TGMO;
    String IMGQ;
    String AMTHUC;
    String MONDACTRUNG;
    String MUCDICH;

    public Quan() {
    }



    public int getMAQ() {
        return MAQ;
    }

    public void setMAQ(int MAQ) {
        this.MAQ = MAQ;
    }

    public int getMALQ() {
        return MALQ;
    }

    public void setMALQ(int MALQ) {
        this.MALQ = MALQ;
    }

    public int getMATK() {
        return MATK;
    }

    public void setMATK(int MATK) {
        this.MATK = MATK;
    }

    public String getTENQ() {
        return TENQ;
    }

    public void setTENQ(String TENQ) {
        this.TENQ = TENQ;
    }

    public String getDIACHIQ() {
        return DIACHIQ;
    }

    public void setDIACHIQ(String DIACHIQ) {
        this.DIACHIQ = DIACHIQ;
    }

    public String getTGMO() {
        return TGMO;
    }

    public void setTGMO(String TGMO) {
        this.TGMO = TGMO;
    }

    public String getIMGQ() {
        return IMGQ;
    }

    public void setIMGQ(String IMGQ) {
        this.IMGQ = IMGQ;
    }

    public String getAMTHUC() {
        return AMTHUC;
    }

    public void setAMTHUC(String AMTHUC) {
        this.AMTHUC = AMTHUC;
    }

    public String getMONDACTRUNG() {
        return MONDACTRUNG;
    }

    public void setMONDACTRUNG(String MONDACTRUNG) {
        this.MONDACTRUNG = MONDACTRUNG;
    }

    public String getMUCDICH() {
        return MUCDICH;
    }

    public void setMUCDICH(String MUCDICH) {
        this.MUCDICH = MUCDICH;
    }
}
