/*
 * Copyright (C) 2019 Carrick Trucking
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.is2300.isis.canvas;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Sean Carrick <sean at carricktrucking.com>
 */
public class WizardPageVisualLayoutCanvas extends javax.swing.JPanel {

    /**
     * Creates new form WizardPageVisualLayoutCanvas
     */
    public WizardPageVisualLayoutCanvas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        edtLicense = new javax.swing.JEditorPane();
        lblJARFile = new javax.swing.JLabel();
        txtJARFile = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(530, 360));
        setMinimumSize(new java.awt.Dimension(530, 360));

        edtLicense.setEditable(false);
        try {
            edtLicense.setPage(ClassLoader.getSystemResource("com/is2300/isis/contents/license.txt"));
        } catch ( IOException ex ) {
            System.err.println("Cause: " + ex.getCause().toString());
            System.err.println("Message: " + ex.getMessage());
            ex.printStackTrace(System.err);
        }
        jScrollPane1.setViewportView(edtLicense);

        lblJARFile.setText("Default Install Location:");

        txtJARFile.setText(System.getProperty("user.home") + "{somefile}.jar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJARFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtJARFile, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJARFile)
                    .addComponent(txtJARFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane edtLicense;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblJARFile;
    private javax.swing.JTextField txtJARFile;
    // End of variables declaration//GEN-END:variables
}
