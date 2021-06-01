package com.example.actuallyusefulnotes.Model;

import androidx.room.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


public class Note implements Serializable {
    private long ID;
    private String titulo;
    private String categoria;
    private String date;
    private String time;
    private String author;
    private String text;
    private String reminderText;
    private long alarmTime;
    private Map<String, Date> eventList;

    protected Note(String titulo, String categoria, String date, String time, String author, String text, String reminderText, long alarmTime) {
        this.categoria = categoria;
        this.time = time;
        this.date = date;
        this.titulo = titulo;
        this.author = author;
        this.text = text;
        this.reminderText = reminderText;
        this.alarmTime = alarmTime;
        this.eventList = new HashMap<String, Date>();
    }

    protected Note(long ID, String titulo, String categoria, String date, String time, String author, String text, String reminderText, long alarmTime) {
        this.ID = ID;
        this.categoria = categoria;
        this.time = time;
        this.date = date;
        this.titulo = titulo;
        this.author = author;
        this.text = text;
        this.reminderText = reminderText;
        this.alarmTime = alarmTime;
        this.eventList = new Hashtable();
    }

    public Note(){
    }

    public void addEvent(String event){
        Date date = new Date();
        this.eventList.put(event, date);
    }

    public void deleteEvent(String event){
        this.eventList.remove(event);
    }

    public Object getEventStatus(String event){
        return this.eventList.get(event);
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReminderText() {
        return reminderText;
    }

    public void setReminderText(String reminderText) {
        this.reminderText = reminderText;
    }

    public Map<String, Date> getEventList() {
        return eventList;
    }

    public void setEventList(Map<String, Date> eventList) {
        this.eventList = eventList;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setAlarmTime(long alarmTime) {
        this.alarmTime = alarmTime;
    }

    public long getAlarmTime() {
        return alarmTime;
    }

}

