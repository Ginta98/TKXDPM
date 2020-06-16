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
public class LackOrderedDTO {

    int id;
    int orderedSiteId;
    int amount;

    public LackOrderedDTO(int orderedSiteId, int amount) {
        this.orderedSiteId = orderedSiteId;
        this.amount = amount;
    }

    public LackOrderedDTO(int id, int orderedSiteId, int amount) {
        this.id = id;
        this.orderedSiteId = orderedSiteId;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderedSiteId() {
        return orderedSiteId;
    }

    public void setOrderedSiteId(int orderedSiteId) {
        this.orderedSiteId = orderedSiteId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LackOrderedDTO() {
    }
    
}
