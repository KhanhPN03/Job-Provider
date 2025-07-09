/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class AdsDetail {

    private String adsD_id;
    private String ads_description;
    private String adflick_link;
    private String ads_status;
    private String update_status;


    public AdsDetail() {
    }

    public AdsDetail(String adsD_id, String ads_description, String adflick_link, String ads_status, String update_status) {
        this.adsD_id = adsD_id;
        this.ads_description = ads_description;
        this.adflick_link = adflick_link;
        this.ads_status = ads_status;
        this.update_status = update_status;
    }   

    public String getAdsD_id() {
        return adsD_id;
    }

    public void setAdsD_id(String adsD_id) {
        this.adsD_id = adsD_id;
    }

    public String getAds_description() {
        return ads_description;
    }

    public void setAds_description(String ads_description) {
        this.ads_description = ads_description;
    }

    public String getAdflick_link() {
        return adflick_link;
    }

    public void setAdflick_link(String adflick_link) {
        this.adflick_link = adflick_link;
    }

    public String getAds_status() {
        return ads_status;
    }

    public void setAds_status(String ads_status) {
        this.ads_status = ads_status;
    }

    public String getUpdate_status() {
        return update_status;
    }

    public void setUpdate_status(String update_status) {
        this.update_status = update_status;
    }
   
}
