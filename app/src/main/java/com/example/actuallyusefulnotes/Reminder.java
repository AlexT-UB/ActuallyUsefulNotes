package com.example.actuallyusefulnotes;

public class Reminder extends BasicNote{
    long alarmTime;
    String text;

    public Reminder (String titulo, String categoria, String date, String time, String author, String text , long alarmTime){
        super(titulo, categoria, date, time, author);
        this.text= text;
        this.alarmTime = alarmTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(long alarmTime) {
        this.alarmTime = alarmTime;
    }
}
