package com.example.tunweather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class temphum {
    @SerializedName("data")
    private List<temphum> data;
    @SerializedName("temp")
    private float temp;
    @SerializedName("success")
    private String success;
    @SerializedName("hum")
    private float hum;
    @SerializedName("Gouvernorat")
    private String Gouvernorat;
    @SerializedName("date")
    private String date;
    public temphum(float temp, float hum,String Gouvernorat,String date) {
        this.temp = temp;
        this.hum = hum;
        this.Gouvernorat=Gouvernorat;
        this.date=date;
    }
    public  List<temphum> getData() { return data;}
    public String getSuccess() {
        return success;
    }
    public float getTemp() {
        return temp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getHum() {
        return hum;
    }

    public String getGouvernorat() {
        return Gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        Gouvernorat = gouvernorat;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public void setHum(float hum) {
        this.hum = hum;
    }

    @Override
    public String toString() {
        return "temphum{" +
                "temp=" + temp +
                ", success='" + success + '\'' +
                ", hum=" + hum +
                ", Gouvernorat='" + Gouvernorat + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
