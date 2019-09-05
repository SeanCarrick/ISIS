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

import java.io.IOException;
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
        return "Welcome to the ISIS Wizard";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Place all component setup and configuration in this method.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        edtTitle = new javax.swing.JEditorPane();

        setMaximumSize(new java.awt.Dimension(530, 360));
        setMinimumSize(new java.awt.Dimension(530, 360));

        try {
            edtTitle.setPage(ClassLoader.getSystemResource("com/is2300/isis/contents/title.html"));
        } catch ( IOException ex ) {
            System.err.println("Cause: " + ex.getCause().toString());
            System.err.println("Message: " + ex.getMessage());
            ex.printStackTrace(System.err);
        }
        jScrollPane1.setViewportView(edtTitle);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );
    }// </editor-fold>                        


    // Variables declaration - All variables needed should be declared below.
    private javax.swing.JEditorPane edtTitle;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}
