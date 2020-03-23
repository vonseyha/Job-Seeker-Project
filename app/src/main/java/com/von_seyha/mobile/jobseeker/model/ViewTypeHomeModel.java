package com.von_seyha.mobile.jobseeker.model;

public class ViewTypeHomeModel {
    int image_background ;
    int image_button_show;
    String Title , Term , Email , Password , show_more;

    //Add more
    String requirement;
    String experience;
    String lastdate;
    String address;
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLastdate() {
        return lastdate;
    }

    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
    }

    //Old Before Add more
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
