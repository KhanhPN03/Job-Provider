/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class Employer {

    private String e_id; 
    private String e_name;
    private String e_address;
    private String e_phone;
    private String tax;
    private String update_status;
    private Account account;

    public Employer() {
    }

    public Employer(String e_id, String e_name, String e_address, String e_phone, String tax, String update_status, Account account) {
        this.e_id = e_id;
        this.e_name = e_name;
        this.e_address = e_address;
        this.e_phone = e_phone;
        this.tax = tax;
        this.update_status = update_status;
        this.account = account;
    }

   

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_address() {
        return e_address;
    }

    public void setE_address(String e_address) {
        this.e_address = e_address;
    }

    public String getE_phone() {
        return e_phone;
    }

    public void setE_phone(String e_phone) {
        this.e_phone = e_phone;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getUpdate_status() {
        return update_status;
    }

    public void setUpdate_status(String update_status) {
        this.update_status = update_status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    

    

}
