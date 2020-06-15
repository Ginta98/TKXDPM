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
public class SiteDTO {
    int id;
    String name,deliverType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeliverType() {
        return deliverType;
    }

    public void setDeliverType(String deliverType) {
        this.deliverType = deliverType;
    }

    public int getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(int deliverTime) {
        this.deliverTime = deliverTime;
    }
    int deliverTime;

    public SiteDTO() {
    }

    public SiteDTO(int id, String name, String deliverType, int deliverTime) {
        this.id = id;
        this.name = name;
        this.deliverType = deliverType;
        this.deliverTime = deliverTime;
    }
    
}
