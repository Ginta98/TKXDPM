/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Site.Models;

/**
 *
 * @author Wind
 */
public class SiteItemDTO {
    int id;
    int site_id;
    int item_id;
    int amount;

    public SiteItemDTO(int id, int site_id, int item_id, int amount) {
        this.id = id;
        this.site_id = site_id;
        this.item_id = item_id;
        this.amount = amount;
    }

    public SiteItemDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSite_id() {
        return site_id;
    }

    public void setSite_id(int site_id) {
        this.site_id = site_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public SiteItemDTO(int site_id, int amount) {
        this.site_id = site_id;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}
