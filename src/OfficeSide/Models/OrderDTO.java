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
   int id,status;
   String deliver_date;

    public OrderDTO(int id, int status, String deliver_date) {
        this.id = id;
        this.status = status;
        this.deliver_date = deliver_date;
    }

    public OrderDTO(int status, String deliver_date) {
        this.status = status;
        this.deliver_date = deliver_date;
    }

    public OrderDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDeliver_date() {
        return deliver_date;
    }

    public void setDeliver_date(String deliver_date) {
        this.deliver_date = deliver_date;
    }
   
    
}
