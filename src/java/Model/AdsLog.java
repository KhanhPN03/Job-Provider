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
public class AdsLog {

    private String adsD_id;
    private Date update_date;
    private String AdsLog_description;
    private Date close_date;

    public AdsLog() {
    }

    public AdsLog(String adsD_id, Date update_date, String AdsLog_description, Date close_date) {
        this.adsD_id = adsD_id;
        this.update_date = update_date;
        this.AdsLog_description = AdsLog_description;
        this.close_date = close_date;
    }

    public String getAdsD_id() {
        return adsD_id;
    }

    public void setAdsD_id(String adsD_id) {
        this.adsD_id = adsD_id;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public String getAdsLog_description() {
        return AdsLog_description;
    }

    public void setAdsLog_description(String AdsLog_description) {
        this.AdsLog_description = AdsLog_description;
    }

    public Date getClose_date() {
        return close_date;
    }

    public void setClose_date(Date close_date) {
        this.close_date = close_date;
    }

}
