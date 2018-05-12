/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moppy.control.gui.netpanel;

import com.moppy.control.NetworkManager;
import com.moppy.core.status.StatusConsumer;
import com.moppy.core.status.StatusUpdate;

/**
 *
 * @author Sam
 */
public class NetworkPanel extends javax.swing.JPanel implements StatusConsumer {

    private NetworkManager netManager;

    /**
     * Creates new form NetworkPanel
     */
    public NetworkPanel() {
        initComponents();
    }

    public void setNetworkManager(NetworkManager netManager) {
        this.netManager = netManager;
        updateBridgesList();
    }

    private void updateBridgesList() {
        //TODO: This is a very crude method for doing this currently.  This should be replaced
        // with something list/map backed so that elements are not constantly destroyed/recreated

        netBridgesPanel.removeAll();

        netManager.getAvailableNetworkBridges().entrySet().forEach(ab -> {
            netBridgesPanel.add(new BridgePanel(netManager, ab.getKey(), ab.getValue()));
        });

        netBridgesPanel.revalidate();
        netBridgesPanel.repaint();
    }

    private void updateDevicesList() {
        //TODO: This is a very crude method for doing this currently.  This should be replaced
        // with something list/map backed so that elements are not constantly destroyed/recreated

        netDevicesPanel.removeAll();

        netManager.getRecentlySeenDevices().forEach(device -> {
            netDevicesPanel.add(new DevicePanel(device));
        });

        netDevicesPanel.revalidate();
        netDevicesPanel.repaint();
    }

        @Override
    public void receiveUpdate(StatusUpdate update) {
        switch (update.getType()) {
            case NET_STATUS_CHANGED:
                updateBridgesList();
                break;
            case NET_DEVICES_CHANGED:
                updateDevicesList();
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        netBridgesPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        netDevicesPanel = new javax.swing.JPanel();

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        netBridgesPanel.setLayout(new javax.swing.BoxLayout(netBridgesPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(netBridgesPanel);

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getSize()+2f));
        jLabel1.setText("Network Bridges");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        netDevicesPanel.setLayout(new javax.swing.BoxLayout(netDevicesPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(netDevicesPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel netBridgesPanel;
    private javax.swing.JPanel netDevicesPanel;
    // End of variables declaration//GEN-END:variables

}