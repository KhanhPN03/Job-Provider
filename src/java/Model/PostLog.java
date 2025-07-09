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
public class PostLog {

    private String postD_id;
    private Date update_date;
    private Date close_date;
    private String PostLog_descrition;

    public PostLog() {
    }

    public PostLog(String postD_id, Date update_date, Date close_date, String PostLog_descrition) {
        this.postD_id = postD_id;
        this.update_date = update_date;
        this.close_date = close_date;
        this.PostLog_descrition = PostLog_descrition;
    }

    public String getPostD_id() {
        return postD_id;
    }

    public void setPostD_id(String postD_id) {
        this.postD_id = postD_id;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public Date getClose_date() {
        return close_date;
    }

    public void setClose_date(Date close_date) {
        this.close_date = close_date;
    }

    public String getPostLog_descrition() {
        return PostLog_descrition;
    }

    public void setPostLog_descrition(String PostLog_descrition) {
        this.PostLog_descrition = PostLog_descrition;
    }

}
