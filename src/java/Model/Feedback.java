/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 *
 * @author ADMIN
 */
public class Feedback {

    private String f_id;
    private String c_id;
    private String post_id;
    private String fb_detail;
    private String fb_date;

    public Feedback() {
    }

    public Feedback(String f_id, String c_id, String post_id, String fb_detail, String fb_date) {
        this.f_id = f_id;
        this.c_id = c_id;
        this.post_id = post_id;
        this.fb_detail = fb_detail;
        this.fb_date = fb_date;
    }

    public String getF_id() {
        return f_id;
    }

    public void setF_id(String f_id) {
        this.f_id = f_id;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getFb_detail() {
        return fb_detail;
    }

    public void setFb_detail(String fb_detail) {
        this.fb_detail = fb_detail;
    }

    public String getFb_date() {
        return fb_date;
    }

    public void setFb_date(String fb_date) {
        this.fb_date = fb_date;
    }

    
}
