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
public class ItemDTO {

    private String name;
    private int id, price, number;

    public ItemDTO() {
    }

    public ItemDTO(String name, int price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public ItemDTO(int id, int price, int number, String name) {
        this.id = id;
        this.price = price;
        this.number = number;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ItemDTO{" + "name=" + name + ", id=" + id + ", price=" + price + ", number=" + number + '}';
    }

}
