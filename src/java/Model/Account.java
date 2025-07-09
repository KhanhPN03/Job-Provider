/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class Account {

    private String a_id;
    private String username;
    private String password;
    private String role;
    private String accImg;
    private String email;
    private String Q1;
    private String anQ1;
    private String Q2;
    private String anQ2;

    public Account() {
    }

    public Account(String a_id, String username, String password, String role, String accImg, String email, String Q1, String anQ1, String Q2, String anQ2) {
        this.a_id = a_id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.accImg = accImg;
        this.email = email;
        this.Q1 = Q1;
        this.anQ1 = anQ1;
        this.Q2 = Q2;
        this.anQ2 = anQ2;
    }

    public String getAccImg() {
        return accImg;
    }

    public void setAccImg(String accImg) {
        this.accImg = accImg;
    }

    public String getA_id() {
        return a_id;
    }

    public void setA_id(String a_id) {
        this.a_id = a_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQ1() {
        return Q1;
    }

    public void setQ1(String Q1) {
        this.Q1 = Q1;
    }

    public String getAnQ1() {
        return anQ1;
    }

    public void setAnQ1(String anQ1) {
        this.anQ1 = anQ1;
    }

    public String getQ2() {
        return Q2;
    }

    public void setQ2(String Q2) {
        this.Q2 = Q2;
    }

    public String getAnQ2() {
        return anQ2;
    }

    public void setAnQ2(String anQ2) {
        this.anQ2 = anQ2;
    }
    
    

}
