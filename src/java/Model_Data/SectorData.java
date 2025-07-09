/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model_Data;

/**
 *
 * @author admin
 */
public class SectorData {
    private String sector;
    private String quantity;

    public SectorData() {
    }

    public SectorData(String sector, String quantity) {
        this.sector = sector;
        this.quantity = quantity;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
}
