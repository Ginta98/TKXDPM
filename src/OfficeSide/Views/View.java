/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OfficeSide.Views;

import OfficeSide.Models.ItemDTO;
import java.util.ArrayList;

/**
 *
 * @author Wind
 */
public class View {

    public void consoleAllItem(ArrayList<ItemDTO> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).toString());
        }

    }
}
