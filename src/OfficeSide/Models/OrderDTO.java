/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OfficeSide.Models;

/**
 *
 * @author Wind
 */
public class OrderDTO {
    int id,amount,status,item_id;
    String dateCreated,name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrderDTO() {
    }

    public OrderDTO(int id, int amount, int status, int item_id, String dateCreated, String name) {
        this.id = id;
        this.amount = amount;
        this.status = status;
        this.item_id = item_id;
        this.dateCreated = dateCreated;
        this.name = name;
    }
    
}
