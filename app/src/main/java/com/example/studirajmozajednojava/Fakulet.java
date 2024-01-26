package com.example.studirajmozajednojava;

import java.util.ArrayList;
import java.util.Arrays;

import kotlin.Unit;

public class Fakulet {
    int picId;
    CharSequence[] smjerovi;
    String name, desc, addr, county, email, phoneNum, city;
    double difficulty;

    boolean doesMatchSearchQuery;
    public Fakulet(double difficulty, int picId, String name, String desc, String county, String addr, String city, String email, String phoneNum, CharSequence[] smjerovi) {
        this.picId = picId;
        this.name = name;
        this.city = city;
        this.desc = desc;
        this.addr = addr;
        this.county = county;
        this.email = email;
        this.phoneNum = phoneNum;
        this.smjerovi = smjerovi;
        this.difficulty = difficulty;
    }
    public boolean doesMatchSearchQuery(String searchQuery) {
        return this.name.toLowerCase().contains(searchQuery.toLowerCase());
    }
}
