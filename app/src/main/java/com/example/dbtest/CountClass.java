package com.example.dbtest;

import android.app.Application;


public class CountClass extends Application {

    Integer peopleCount = 0;
    Integer dayCount = 1;

    public Integer getPeopleCount(Integer get) {
        switch (peopleCount) {
            case 0:
                dayCount = 1;
                break;

            case 5:
                dayCount = 2;
                break;

            case 10:
                dayCount = 3;
                break;

            case 30:
                dayCount = 4;
                break;

            case 40:
                dayCount = 5;
                break;
            case 50:
                dayCount = 6;
                break;

            case 60:
                dayCount = 7;
                break;

            case 70:
                dayCount = 8;
                break;

            case 80:
                dayCount = 9;
                break;

            case 90:
                dayCount = 10;
                break;
        }
        return peopleCount;
    }
    public void setPeopleCount(Integer peoplecount){
        this.peopleCount = peoplecount;
    }
}
