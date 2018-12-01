package com.example.fsmvustudentapp;

public class Foods {
    public String day;
    public String soup;
    public String main_course;
    public String main_course2;

    public Foods(String day, String soup, String main_course, String main_course2, String main_course3, String meze, String aperitif) {
        this.day = day;
        this.soup = soup;
        this.main_course = main_course;
        this.main_course2 = main_course2;
        this.main_course3 = main_course3;
        this.meze = meze;
        this.aperitif = aperitif;
    }

    public String main_course3;
    public String meze;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getSoup() {
        return soup;
    }

    public void setSoup(String soup) {
        this.soup = soup;
    }

    public String getMain_course() {
        return main_course;
    }

    public void setMain_course(String main_course) {
        this.main_course = main_course;
    }

    public String getMain_course2() {
        return main_course2;
    }

    public void setMain_course2(String main_course2) {
        this.main_course2 = main_course2;
    }

    public String getMain_course3() {
        return main_course3;
    }

    public void setMain_course3(String main_course3) {
        this.main_course3 = main_course3;
    }

    public String getMeze() {
        return meze;
    }

    public void setMeze(String meze) {
        this.meze = meze;
    }

    public String getAperitif() {
        return aperitif;
    }

    public void setAperitif(String aperitif) {
        this.aperitif = aperitif;
    }

    public String aperitif;
}
