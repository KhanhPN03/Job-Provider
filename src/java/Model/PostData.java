package Model;

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

    public PostData() {
    }

    public PostData(PostDetail postDetail, List<FeedbackData> listFBdata) {
        this.postDetail = postDetail;
        this.listFBdata = listFBdata;
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
