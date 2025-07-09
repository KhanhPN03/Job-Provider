package Model_Data;

import Model.PostDetail;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class PostData {
    private PostDetail postDetail;
    private List<FeedbackData> listFBdata;
    private String date_start;

    public PostData() {
    }

    public PostData(PostDetail postDetail, List<FeedbackData> listFBdata, String date_start) {
        this.postDetail = postDetail;
        this.listFBdata = listFBdata;
        this.date_start = date_start;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    
    public PostDetail getPostDetail() {
        return postDetail;
    }

    public void setPostDetail(PostDetail postDetail) {
        this.postDetail = postDetail;
    }

    public List<FeedbackData> getListFBdata() {
        return listFBdata;
    }

    public void setListFBdata(List<FeedbackData> listFBdata) {
        this.listFBdata = listFBdata;
    }

    

}
