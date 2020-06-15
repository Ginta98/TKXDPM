/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InternationalOrderingSide.Models;

/**
 *
 * @author Wind
 */
public class OrderedSiteDTO {

    int id, siteId, itemId, amount, status;

    public OrderedSiteDTO(int id, int siteId, int itemId, int amount, int status) {
        this.id = id;
        this.siteId = siteId;
        this.itemId = itemId;
        this.amount = amount;
        this.status = status;
    }

    public OrderedSiteDTO(int siteId, int itemId, int amount, int status) {
        this.siteId = siteId;
        this.itemId = itemId;
        this.amount = amount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public OrderedSiteDTO() {
    }

}
