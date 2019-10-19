/*
 * Copyright (C) 2019 Integrity Solutions
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
package com.pekinsoft.test.isis;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.netbeans.spi.wizard.WizardPage;

/**
 *
 * @author Sean Carrick
 */
public class DemoPage extends WizardPage {
    private JTextField txtField1;
    private JTextField txtField2;
    
    public DemoPage() {
        setLayout ( new BorderLayout() );
        
        JPanel pnl = new JPanel();
        pnl.add(new JLabel("First Name:"));
        txtField1 = new JTextField(20);
        txtField1.setName("first");
        pnl.add(txtField1);
        add (pnl, BorderLayout.NORTH);
        
        pnl = new JPanel();
        pnl.add(new JLabel("Last Name:"));
        txtField2 = new JTextField(20);
        txtField2.setName("last");
        pnl.add(txtField2);
        add (pnl);
    }
    
    public static final String getDescription() {
        return "Demonstration Page";
    }
    
    @Override
    protected String validateContents ( Component comp, Object o ) {
        if ( txtField1.getText().length() == 0 )
            return "Enter first name.";
        else
            if ( txtField2.getText().length() == 0 )
                return "Enter last name.";
                else
                return null;
    }
}
