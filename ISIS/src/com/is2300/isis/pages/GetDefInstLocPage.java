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

import com.is2300.isis.ISIS;
import java.awt.Component;
import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import org.netbeans.spi.wizard.WizardPage;

/**
 *
 * @author Sean Carrick <sean at carricktrucking.com>
 */
public class GetDefInstLocPage extends WizardPage {
    public GetDefInstLocPage() {
        initComponents();
    }
    
    public static final String getDescription() {
        return "Set Your Project's Default Install Location";
    }
    
    protected String validateContents(Component component, Object event) {
        if ( (cboEnvVars.getSelectedItem().toString().equalsIgnoreCase("select...") ||
                cboEnvVars.getSelectedItem().toString().equalsIgnoreCase("Other..."))
                && chkUseEnvVars.isSelected() )
            return "You must choose an Environment Variable.";
        if ( txtLocation.getText().isBlank() || txtLocation.getText().isEmpty() )
            return "A default installation path must be chosen";
        
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
        edtDefault = new javax.swing.JEditorPane();
        pnlDefaults = new javax.swing.JPanel();
        chkUseEnvVars = new javax.swing.JCheckBox();
        lblChooseEnvVar = new javax.swing.JLabel();
        cboEnvVars = new javax.swing.JComboBox<>();
        lblLocation = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(530, 360));
        setMinimumSize(new java.awt.Dimension(530, 360));

        edtDefault.setEditable(false);
        try {
            edtDefault.setPage(ClassLoader.getSystemResource("com/is2300/isis/contents/dfltpath.html"));
        } catch ( IOException ex ) {
            System.err.println("Cause: " + ex.getCause().toString());
            System.err.println("Message: " + ex.getMessage());
            ex.printStackTrace(System.err);
        }
        jScrollPane1.setViewportView(edtDefault);

        pnlDefaults.setBorder(javax.swing.BorderFactory.createTitledBorder("Environment Install"));

        chkUseEnvVars.setText("Use Environment Variables?");
        chkUseEnvVars.setName("useEnvVars");
        chkUseEnvVars.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Selection_Changed(evt);
            }
        });

        lblChooseEnvVar.setText("Choose Env. Variable:");

        cboEnvVars.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select..." }));
        cboEnvVars.setName("environmentVariable");

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Select...");

        for ( String key : ISIS.environment.keySet() ) {
            switch ( key.toLowerCase() ) {
                case "programfiles":
                case "programw6432":
                case "programfiles(x86)":
                case "systemdrive":
                case "path":
                model.addElement(key);
                break;
            }
        }
        
        model.addElement("User Home");

        cboEnvVars.setModel(model);
        cboEnvVars.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboSelection_Changed(evt);
            }
        });

        javax.swing.GroupLayout pnlDefaultsLayout = new javax.swing.GroupLayout(pnlDefaults);
        pnlDefaults.setLayout(pnlDefaultsLayout);
        pnlDefaultsLayout.setHorizontalGroup(
            pnlDefaultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDefaultsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkUseEnvVars)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblChooseEnvVar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboEnvVars, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDefaultsLayout.setVerticalGroup(
            pnlDefaultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDefaultsLayout.createSequentialGroup()
                .addGroup(pnlDefaultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkUseEnvVars)
                    .addComponent(lblChooseEnvVar)
                    .addComponent(cboEnvVars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        lblLocation.setText("Install Location:");

        txtLocation.setName("defaultInstallPath");
        txtLocation.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Field_GotFocus(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Field_LostFocus(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblLocation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlDefaults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDefaults, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocation)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(5, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void Selection_Changed(javax.swing.event.ChangeEvent evt) {                                   
        // Enable the text field if this checkbox is NOT selected. Disable the
        //+ text field if this checkbox IS selected.
        txtLocation.setEditable(!chkUseEnvVars.isSelected());
        cboEnvVars.setEnabled(chkUseEnvVars.isSelected());
    }                                  

    private void cboSelection_Changed(java.awt.event.ItemEvent evt) {                                      
        // Place the value of the given environment variable in the text field.
        String key = cboEnvVars.getSelectedItem().toString();
        if ( key.equalsIgnoreCase("user home") ) {
            txtLocation.setText(System.getProperty("user.home") +
                                System.getProperty("file.separator"));
            return;
        }
        
        txtLocation.setText(ISIS.environment.get(key) + 
                            System.getProperty("file.separator"));
    }                                     

    private void Field_GotFocus(java.awt.event.FocusEvent evt) {                                
        txtLocation.selectAll();
    }                               

    private void Field_LostFocus(java.awt.event.FocusEvent evt) {                                 
        txtLocation.select(0, 0);
    }                                


    // Variables declaration - do not modify                     
    private javax.swing.JComboBox<String> cboEnvVars;
    private javax.swing.JCheckBox chkUseEnvVars;
    private javax.swing.JEditorPane edtDefault;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblChooseEnvVar;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JPanel pnlDefaults;
    private javax.swing.JTextField txtLocation;
    // End of variables declaration                   
}
