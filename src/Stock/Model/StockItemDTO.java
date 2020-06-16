/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stock.Model;

/**
 *
 * @author Wind
 */
public class StockItemDTO {
    int id;
    String siteName;
    int itemID;
    String itemName;
    int amount;

    public StockItemDTO() {
    }

    public StockItemDTO(int id, String siteName, int itemID, String itemName, int amount) {
        this.id = id;
        this.siteName = siteName;
        this.itemID = itemID;
        this.itemName = itemName;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

   
    
    
}
