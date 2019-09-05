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
package com.is2300.isis.pages;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.netbeans.spi.wizard.WizardPage;

/**
 *
 * @author Sean Carrick <sean at carricktrucking.com>
 */
public class GetLAPage extends WizardPage {
    public GetLAPage() {
        initComponents();
    }
    
    public static final String getDescription() {
        return "Welcome to the ISIS Wizard";
    }
    
    @Override
    protected String validateContents(Component component, Object event) {
        if ( component == null || !((JCheckBox)component).isSelected() )
            return "Do you wish to use this file?";
        
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        edtLicense = new javax.swing.JEditorPane();
        license = new javax.swing.JCheckBox();
        btnSelectLicense = new javax.swing.JButton();

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

        license.setMnemonic('U');
        license.setText("Use this license.");

        // Make sure that the selection value writes to the Map.
        license.setSelected(!license.isSelected());
        license.setSelected(!license.isSelected());

        btnSelectLicense.setMnemonic('L');
        btnSelectLicense.setText("Select License...");
        btnSelectLicense.addActionListener((java.awt.event.ActionEvent evt) -> {
            License_Clicked(evt);
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSelectLicense)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
                .addComponent(license)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(license)
                    .addComponent(btnSelectLicense))
                .addContainerGap())
        );
    }// </editor-fold>                        

    private void License_Clicked(java.awt.event.ActionEvent evt) {                                 
        // Create and display a file selector.
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("License "
                + "Text Files", "txt");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Select License File");
        
        int returnVal = chooser.showOpenDialog(this);
        
        if ( returnVal == JFileChooser.APPROVE_OPTION ) {
            File license = chooser.getSelectedFile();
            
            try {
                URL url = new URL(license.toURI().toURL().toString());
                
                edtLicense.setPage(url);
            } catch (MalformedURLException ex) {
                System.err.println("Cause:\t" + ex.getCause().toString());
                System.err.println("Message:\t" + ex.getLocalizedMessage()); 
                ex.printStackTrace(System.err);
            } catch (IOException ex) {
                System.err.println("Cause:\t" + ex.getCause().toString());
                System.err.println("Message:\t" + ex.getLocalizedMessage()); 
                ex.printStackTrace(System.err);
            }
        }
    }                                


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnSelectLicense;
    private javax.swing.JEditorPane edtLicense;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox license;
    // End of variables declaration                   
}
