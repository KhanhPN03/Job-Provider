/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
public class FeedbackData {
    private Feedback feedBack;
    private Candidate candidate;

    public FeedbackData() {
    }

    public FeedbackData(Feedback feedBack, Candidate candidate) {
        this.feedBack = feedBack;
        this.candidate = candidate;
    }

    public Feedback getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(Feedback feedBack) {
        this.feedBack = feedBack;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
    
}
