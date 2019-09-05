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
package com.is2300.isis;

import com.is2300.isis.pages.GetDefInstLocPage;
import com.is2300.isis.pages.GetJARPage;
import com.is2300.isis.pages.GetLAPage;
import com.is2300.isis.producers.MakeInstallerProducer;
import com.is2300.isis.pages.GetTitlePage;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Toolkit;
import org.netbeans.api.wizard.WizardDisplayer;
import org.netbeans.spi.wizard.Wizard;
import org.netbeans.spi.wizard.WizardPage;

/**
 *
 * @author Sean Carrick <sean at carricktrucking.com>
 */
public class MakeInstaller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final Class[] pages = new Class[] {
            GetTitlePage.class, 
            GetLAPage.class, 
            GetJARPage.class, 
            GetDefInstLocPage.class
        };
        
        Runnable r;
        r = new Runnable() {
            public void run() {
                MakeInstallerProducer mip = new MakeInstallerProducer();
                int height = Toolkit.getDefaultToolkit().getScreenSize().height;
                int width = Toolkit.getDefaultToolkit().getScreenSize().width;
                int x = (width - 800) / 2;
                int y = (height - 500) / 2;
                
                Wizard wizard = WizardPage.createWizard("Make Installer", pages,
                        mip);
                WizardDisplayer.showWizard(wizard, new Rectangle(x, y, 800, 500));
                
                System.exit(0);
            }
        };
        
        EventQueue.invokeLater(r);
    }
    
}
