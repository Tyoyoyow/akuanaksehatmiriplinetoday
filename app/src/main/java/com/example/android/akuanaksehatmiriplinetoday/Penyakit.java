package com.example.android.akuanaksehatmiriplinetoday;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

/**
 * Created by tyo on 24/04/18.
 */

public class Penyakit {
    private String nama;
    private String deskripsi;
    private String pengobatan;
    private String penyebab;
    private int image;

    static final String TITLE_KEY = "Title";
    static final String IMAGE_KEY = "Image Resource";


    public Penyakit(){}

    public Penyakit(String nama, String deskripsi, String pengobatan, String penyebab, int image) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.pengobatan = pengobatan;
        this.penyebab = penyebab;
        this.image = image;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getPengobatan() {
        return pengobatan;
    }

    public void setPengobatan(String pengobatan) {
        this.pengobatan = pengobatan;
    }

    public String getPenyebab() {
        return penyebab;
    }

    public void setPenyebab(String penyebab) {
        this.penyebab = penyebab;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public static String getTitleKey() {
        return TITLE_KEY;
    }

    public static String getImageKey() {
        return IMAGE_KEY;
    }

//    public static Intent starter(Context context, String title, @DrawableRes int imageResId) {
//        Intent detailIntent = new Intent(context, DetailActivity.class);
//        detailIntent.putExtra(TITLE_KEY, title);
//        detailIntent.putExtra(IMAGE_KEY, imageResId);
//
//        return detailIntent;
//    }
}
