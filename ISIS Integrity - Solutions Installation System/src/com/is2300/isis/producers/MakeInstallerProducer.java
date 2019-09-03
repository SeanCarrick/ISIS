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
package com.is2300.isis.producers;

import com.is2300.isis.generators.InstallerGenerator;
import java.util.Map;
import javax.swing.JLabel;
import org.netbeans.spi.wizard.Summary;
import org.netbeans.spi.wizard.WizardException;
import org.netbeans.spi.wizard.WizardPage;

/**
 *
 * @author Sean Carrick <sean at carricktrucking.com>
 */
public class MakeInstallerProducer implements WizardPage.WizardResultProducer {
    
    @Override
    public Object finish(Map wizardData) throws WizardException {
        String title = (String) wizardData.get("title");
        String lapath = (String) wizardData.get("lapath");
        String jarpath = (String) wizardData.get("jarpath");
        String definstlocpath = (String) wizardData.get("definstlocpath");
        InstallerGenerator.configure(title, lapath, jarpath, definstlocpath);
        
        String result = InstallerGenerator.makeInstaller();
        
        if ( result != null ) 
            return Summary.create (new JLabel("Unable to make installer:" +
                    result, JLabel.CENTER), null);
        
        else
            return Summary.create(new JLabel("Installer created.", 
                    JLabel.CENTER), null);
    }

    @Override
    public boolean cancel(Map settings) {
        return true; // Allow the user to cancel the wizard
    }
    
}
