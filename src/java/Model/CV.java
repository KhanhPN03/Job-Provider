/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class CV {

    private String cv_id;
    private String c_id;
    private String name;
    private String dob;
    private String gender;
    private String email;
    private String phone;
    private String cv_link;
    private String post_id;

    public CV() {
    }

    public CV(String cv_id, String c_id, String name, String dob, String gender, String email, String phone, String cv_link, String post_id) {
        this.cv_id = cv_id;
        this.c_id = c_id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.cv_link = cv_link;
        this.post_id = post_id;
    }

    public String getCv_id() {
        return cv_id;
    }

    public void setCv_id(String cv_id) {
        this.cv_id = cv_id;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCv_link() {
        return cv_link;
    }

    public void setCv_link(String cv_link) {
        this.cv_link = cv_link;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    

    

}
