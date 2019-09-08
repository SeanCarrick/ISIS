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

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.netbeans.spi.wizard.WizardController;
import org.netbeans.spi.wizard.WizardException;
import org.netbeans.spi.wizard.WizardPanelProvider;

/**
 *
 * @author Sean Carrick <sean at carricktrucking.com>
 */
public class FoodPanelProvider extends WizardPanelProvider implements ActionListener {
    private JCheckBox meatBox;
    private JCheckBox steakBox;
    private Map settings;
    private WizardController controller;
    
    public FoodPanelProvider() {
        super("Choose Your Dinner", new String[] {"vegetarian", "mealChoice"},
                new String[] {"Food preferences", "Meal Choice"});
    }
        
    protected JComponent createPanel(WizardController controller, String id, Map settings) {
        this.settings = settings;
        this.controller = controller;
        JPanel result = new JPanel();
        result.setLayout (new FlowLayout());

        if ( "vegetarian".equals(id)) {
            meatBox = new JCheckBox("I agree to eat meat");
            meatBox.setSelected(Boolean.TRUE.equals(settings.get("likesMeat")));
            meatBox.addActionListener(this);
            result.add(meatBox);
            controller.setProblem(meatBox.isSelected() ? null : "You must eat meat");

            // not the last pane, so the Finish button should never be enabled here
            controller.setForwardNavigationMode(WizardController.MODE_CAN_CONTINUE);
        } else if ( "mealChoice".equals(id)) {
            steakBox = new JCheckBox("I will have the steak");
            steakBox.addActionListener(this);
            steakBox.setSelected(Boolean.TRUE.equals(settings.get("eatsSteak")));
            result.add(steakBox);
            controller.setProblem(steakBox.isSelected() ? null : "You must order teh steak");
            if ( steakBox.isSelected() )
                controller.setForwardNavigationMode(WizardController.MODE_CAN_FINISH);
            else
                controller.setForwardNavigationMode(WizardController.MODE_CAN_CONTINUE);
        } else {
            throw new Error("Unknown ID " + id);
        }

        return result;
    }

    protected Object finish(Map settings) throws WizardException {
        // Really you would construct some object or do something with the 
        //+ contents of the map.
        return "Rood Finished";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JCheckBox src = (JCheckBox) e.getSource();
        if ( src == meatBox ) {
            settings.put("likesMeat", src.isSelected() ? Boolean.TRUE : Boolean.FALSE);
            controller.setProblem(src.isSelected() ? null : "You must eat meat!");
        } else {
            if ( steakBox.isSelected() )
                controller.setForwardNavigationMode(WizardController.MODE_CAN_FINISH);
            else
                controller.setForwardNavigationMode(WizardController.MODE_CAN_CONTINUE);
            settings.put("eatsSteak", src.isSelected() ? Boolean.TRUE : Boolean.FALSE);
            controller.setProblem (src.isSelected() ? null : "We only serve steak!");
        }
    }
    
}
