/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OfficeSide.Views;

import OfficeSide.Controller.Controller;
import OfficeSide.Models.ItemDTO;
import OfficeSide.Models.ItemOrderDTO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wind
 */
public class OrderDetailView extends javax.swing.JFrame {
    
    List<ItemDTO> items;
    List<ItemOrderDTO> orderDetail;
    DefaultTableModel itemTableModel;
    DefaultTableModel orderTableModel;
    int orderID;
    int status;
    
    public void loadItems() {
        items = Controller.getInstance().loadItems();
        
        int rowCount = itemTableModel.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            itemTableModel.removeRow(i);
        }
        for (int i = 0; i < items.size(); i++) {
            itemTableModel.addRow(new Object[]{items.get(i).getId(), items.get(i).getName(), items.get(i).getPrice(), items.get(i).getNumber()});
        }
    }
    
    public OrderDetailView(int orderID, int status) {
        initComponents();
         setLocationRelativeTo(null);
        this.status = status;
        if (status != 0) {
            addButton.setEnabled(false);
            removeBtn.setEnabled(false);
            commitBtn.setEnabled(false);
        }
        setResizable(false);
        this.orderID = orderID;  
        itemTableModel = (DefaultTableModel) tableListItems.getModel();
        orderTableModel = (DefaultTableModel) orderTable.getModel();
        loadItems();
        orderDetail = Controller.getInstance().getOrderDetail(orderID);
        System.out.println(orderDetail.size());
        for (int i = 0; i < orderDetail.size(); i++) {
            orderTableModel.addRow(new Object[]{orderDetail.get(i).getItemID(), orderDetail.get(i).getAmount()});
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableListItems = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        commitBtn = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        amountSpinner = new javax.swing.JSpinner();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableListItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableListItems);
        if (tableListItems.getColumnModel().getColumnCount() > 0) {
            tableListItems.getColumnModel().getColumn(0).setResizable(false);
            tableListItems.getColumnModel().getColumn(1).setResizable(false);
            tableListItems.getColumnModel().getColumn(2).setResizable(false);
            tableListItems.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Detail");

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item_ID", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(orderTable);
        if (orderTable.getColumnModel().getColumnCount() > 0) {
            orderTable.getColumnModel().getColumn(0).setResizable(false);
            orderTable.getColumnModel().getColumn(1).setResizable(false);
        }

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeBtn.setText("Remove");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        commitBtn.setText("Commit");
        commitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commitBtnActionPerformed(evt);
            }
        });

        jButton8.setText("Back");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(resetButton)
                        .addGap(287, 287, 287)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(commitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addButton)
                                .addGap(18, 18, 18)
                                .addComponent(amountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resetButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        loadItems();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        int index = tableListItems.getSelectedRow();
        int indexExist = -1;
        if ((int) amountSpinner.getValue() > 0) {
            boolean exist = false;
            for (int i = 0; i < orderTable.getRowCount(); i++) {
                if ((int) itemTableModel.getValueAt(index, 0) == (int) orderTableModel.getValueAt(i, 0)) {
                    exist = true;
                    indexExist = i;
                    break;
                }
            }
            
            System.out.println(exist);
            if (exist) {
                
                int originValue = (Integer) orderTableModel.getValueAt(indexExist, 1);
                System.out.println("origin:" + originValue);
                int extraValue = (Integer) amountSpinner.getValue();
                System.out.println("extra:" + extraValue);
                int total = originValue + extraValue;
                orderTableModel.setValueAt(total, indexExist, 1);
            } else {
                orderTableModel.addRow(new Object[]{itemTableModel.getValueAt(index, 0), amountSpinner.getValue()});
            }
        }
        

    }//GEN-LAST:event_addButtonActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        // TODO add your handling code here:
        int index = orderTable.getSelectedRow();
        System.out.println(index);
        if (index != -1) {
            orderTableModel.removeRow(index);
        }

    }//GEN-LAST:event_removeBtnActionPerformed

    private void commitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commitBtnActionPerformed
        // TODO add your handling code here:
//        if (orderTableModel.getRowCount() == 0) {
//            JOptionPane.showMessageDialog(this, "No item selected.");
//        } else {
//
//        }
        try {
            Controller.getInstance().deleteOrderItemByOrderID(orderID);
            for (int i = 0; i < orderTable.getRowCount(); i++) {
                ItemOrderDTO itemOrder = new ItemOrderDTO();
                itemOrder.setOrderID(this.orderID);
                itemOrder.setItemID((int) orderTableModel.getValueAt(i, 0));
                itemOrder.setAmount((int) orderTableModel.getValueAt(i, 1));
                Controller.getInstance().createItemOrder(itemOrder);
            }
            JOptionPane.showMessageDialog(this, "Success");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Fail");
        }
    }//GEN-LAST:event_commitBtnActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(OrderDetailView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(OrderDetailView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(OrderDetailView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(OrderDetailView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new OrderDetailView().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JSpinner amountSpinner;
    private javax.swing.JButton commitBtn;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable orderTable;
    private javax.swing.JButton removeBtn;
    private javax.swing.JButton resetButton;
    private javax.swing.JTable tableListItems;
    // End of variables declaration//GEN-END:variables
}
