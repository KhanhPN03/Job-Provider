/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class Company {

    private String com_id;
    private String com_name;
    private String com_address;
    private String com_phone;  
    private String tax;
    private String update_status;
    private Account account;

    public Company() {
    }

    public Company(String com_id, String com_name, String com_address, String com_phone, String tax, String update_status, Account account) {
        this.com_id = com_id;
        this.com_name = com_name;
        this.com_address = com_address;
        this.com_phone = com_phone;
        this.tax = tax;
        this.update_status = update_status;
        this.account = account;
    }

    public String getCom_id() {
        return com_id;
    }

    public void setCom_id(String com_id) {
        this.com_id = com_id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }  

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public String getCom_phone() {
        return com_phone;
    }

    public void setCom_phone(String com_phone) {
        this.com_phone = com_phone;
    }

    public String getCom_address() {
        return com_address;
    }

    public void setCom_address(String com_address) {
        this.com_address = com_address;
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

}
