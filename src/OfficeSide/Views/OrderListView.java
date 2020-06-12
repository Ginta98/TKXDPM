/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OfficeSide.Views;

import OfficeSide.Models.ItemDTO;
import OfficeSide.Models.OrderDTO;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Wind
 */
public class OrderListView extends JFrame {

    List<OrderDTO> items = null;

    public OrderListView(List<OrderDTO> items) {
        setTitle("Orders");
        this.items = items;
        this.setSize(693, 458);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        String data[][] = new String[items.size()][6];
        for (int i = 0; i < items.size(); i++) {
            String[] row = {
                String.valueOf(items.get(i).getId()),
                items.get(i).getName(),
                items.get(i).getDateCreated(),
                String.valueOf(items.get(i).getAmount()),
                String.valueOf(items.get(i).getStatus()),
                String.valueOf(items.get(i).getItem_id())
            };
            data[i] = row;
        }
        String[] columnNames = {"id", "name", "date_created", "amount", "status", "item_id"};
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

}
