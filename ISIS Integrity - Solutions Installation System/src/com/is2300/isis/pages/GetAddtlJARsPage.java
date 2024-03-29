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
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.netbeans.spi.wizard.WizardPage;

/**
 *
 * @author Sean Carrick <sean at carricktrucking.com>
 */
public class GetAddtlJARsPage extends WizardPage {
    public GetAddtlJARsPage() {
        initComponents();
    }
    
    public static final String getDescription() {
        return "Select Additional Project JAR File(s)";
    }
    
    @Override
    protected String validateContents(Component component, Object event) {
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
        edtAddtlJARs = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstFiles = new javax.swing.JList<>();
        btnSelectAdditional = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(530, 360));
        setMinimumSize(new java.awt.Dimension(530, 360));

        edtAddtlJARs.setEditable(false);
        try {
            edtAddtlJARs.setPage(ClassLoader.getSystemResource("com/is2300/isis/contents/additional.html"));
        } catch ( IOException ex ) {
            System.err.println("Cause: " + ex.getCause().toString());
            System.err.println("Message: " + ex.getMessage());
            ex.printStackTrace(System.err);
        }
        jScrollPane1.setViewportView(edtAddtlJARs);

        jScrollPane2.setViewportView(lstFiles);

        btnSelectAdditional.setText("Select Additional JAR Files...");
        btnSelectAdditional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_Click(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSelectAdditional)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSelectAdditional)
                .addContainerGap())
        );
    }// </editor-fold>                        

    private void Button_Click(java.awt.event.ActionEvent evt) {                              
        // Create and display a file selector.
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("License "
                + "Java Archive Files", "jar");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Select Project JAR File");
        chooser.setMultiSelectionEnabled(true);
        
        int returnVal = chooser.showOpenDialog(this);
        
        if ( returnVal == JFileChooser.APPROVE_OPTION ) {
            DefaultListModel<String> model = new DefaultListModel<>();
            File[] files = chooser.getSelectedFiles();
            
            if ( lstFiles.getModel().getSize() > 0 ) {
                for ( int x = 0; x < lstFiles.getModel().getSize(); x++ )
                    model.add(x, lstFiles.getModel().getElementAt(x));
            }
            
            if ( files.length > 1 ) {
            
                for ( File file : files ) {
                    model.addElement(file.getAbsolutePath());
                }
            } else
                model.addElement(files[0].getAbsolutePath());
            
            lstFiles.setModel(model);
        }
    }                             


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnSelectAdditional;
    private javax.swing.JEditorPane edtAddtlJARs;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstFiles;
    // End of variables declaration                   
}
