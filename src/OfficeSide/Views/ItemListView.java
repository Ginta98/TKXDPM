/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OfficeSide.Views;

import OfficeSide.Models.ItemDTO;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 *
 * @author Wind
 */
public class ItemListView extends JFrame {

    List<ItemDTO> items = null;

    public ItemListView(List<ItemDTO> items) {
        setTitle("Items");
        this.items = items;
        this.setSize(693, 458);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        String data[][] = new String[items.size()][4];
        for (int i = 0; i < items.size(); i++) {
            String[] row = {String.valueOf(items.get(i).getId()), items.get(i).getName(), String.valueOf(items.get(i).getPrice()), String.valueOf(items.get(i).getNumber())};
            data[i] = row;
        }
        String[] columnNames = {"id", "name", "price", "number"};
        JTable j = new JTable(data, columnNames);
        j.setEnabled(false);
        getContentPane().setLayout(new FlowLayout());
        JScrollPane scrollable = new JScrollPane(j);
        setLocationRelativeTo(null);
        scrollable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollable.setPreferredSize(new Dimension(670, 405));
        getContentPane().add(scrollable);

    }

    public static void main(String[] args) {
        new ItemListView(new ArrayList<ItemDTO>()).setVisible(true);
    }
}
