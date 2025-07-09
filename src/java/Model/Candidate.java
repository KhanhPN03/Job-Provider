/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

//import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Candidate {

    private String c_id;    
    private String c_name;
    private String c_address;
    private String c_phone;  
    private String c_dob;
    private String tax;
    private Account account;
    
    public Candidate() {
    }

    public Candidate(String c_id, String c_name, String c_address, String c_phone, String c_dob, String tax, Account account) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_address = c_address;
        this.c_phone = c_phone;
        this.c_dob = c_dob;
        this.tax = tax;
        this.account = account;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }


    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }

    public String getC_phone() {
        return c_phone;
    }

    public void setC_phone(String c_phone) {
        this.c_phone = c_phone;
    }

    public String getC_dob() {
        return c_dob;
    }

    public void setC_dob(String c_dob) {
        this.c_dob = c_dob;
    } 

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
