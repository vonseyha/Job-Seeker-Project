package com.von_seyha.mobile.jobseeker.model;

public class ViewTypeHomeModel {
    int image_background , image_button_show;
    String Title , Term , Email , Password , show_more;

    public int getImage_background() {
        return image_background;
    }

    public void setImage_background(int image_background) {
        this.image_background = image_background;
    }

    public int getImage_button_show() {
        return image_button_show;
    }

    public void setImage_button_show(int image_button_show) {
        this.image_button_show = image_button_show;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String term) {
        Term = term;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getShow_more() {
        return show_more;
    }

    public void setShow_more(String show_more) {
        this.show_more = show_more;
    }
}
