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
public class OrderSiteConvertItemIdToItemNameDTO {

    int id;
    String name;

    public OrderSiteConvertItemIdToItemNameDTO(int id, String name, int amount, int status) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.status = status;
    }
    int amount, status;

    public OrderSiteConvertItemIdToItemNameDTO() {
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "OrderSiteConvertItemIdToItemNameDTO{" + "id=" + id + ", name=" + name + ", amount=" + amount + ", status=" + status + '}';
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
