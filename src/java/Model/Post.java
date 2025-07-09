/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 *
 * @author ADMIN
 */
public class Post {

    private String post_id;
    private String date_start;
    private String date_end;
    private PostDetail postDetail;
    

    public Post() {
    }

    public Post(String post_id, String date_start, String date_end, PostDetail postDetail) {
        this.post_id = post_id;
        this.date_start = date_start;
        this.date_end = date_end;
        this.postDetail = postDetail;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
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

    public PostDetail getPostDetail() {
        return postDetail;
    }

    public void setPostDetail(PostDetail postDetail) {
        this.postDetail = postDetail;
    }

    

    

}
