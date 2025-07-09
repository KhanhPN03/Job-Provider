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
public class Ads {
    private String ads_id;   
    private String date_start;
    private String date_end;
    private String ads_statistic;
    private AdsDetail adsDetail;

    public Ads() {
    }

    public Ads(String ads_id, String date_start, String date_end, String ads_statistic, AdsDetail adsDetail) {
        this.ads_id = ads_id;
        this.date_start = date_start;
        this.date_end = date_end;
        this.ads_statistic = ads_statistic;
        this.adsDetail = adsDetail;
    }  

    public String getAds_id() {
        return ads_id;
    }

    public void setAds_id(String ads_id) {
        this.ads_id = ads_id;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public String getAds_statistic() {
        return ads_statistic;
    }

    public void setAds_statistic(String ads_statistic) {
        this.ads_statistic = ads_statistic;
    }

    public AdsDetail getAdsDetail() {
        return adsDetail;
    }

    public void setAdsDetail(AdsDetail adsDetail) {
        this.adsDetail = adsDetail;
    }

    
    
    
}
