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
package com.is2300.test.isis;

import com.is2300.isis.pages.FoodPanelProvider;
import java.awt.EventQueue;
import java.util.Map;
import org.netbeans.api.wizard.WizardDisplayer;
import org.netbeans.spi.wizard.DeferredWizardResult;
import org.netbeans.spi.wizard.ResultProgressHandle;
import org.netbeans.spi.wizard.Summary;
import org.netbeans.spi.wizard.Wizard;
import org.netbeans.spi.wizard.WizardException;
import org.netbeans.spi.wizard.WizardPage;

/**
 *
 * @author Sean Carrick
 */
public class WizDemo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final Class[] pages = new Class[]{
            FoodPanelProvider.class
        };

        Runnable r;
        r = new Runnable() {
            public void run() {
                /* Set the Nimbus look and feel */
                //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
                /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
                 */
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if (System.getProperty("os.name").toLowerCase().contains("linux")) {
                            if ("Nimbus".equals(info.getName())) {
                                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                break;
                            }
                        } else {
                            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(WizDemo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(WizDemo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(WizDemo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(WizDemo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>

                MyProducer mp = new MyProducer();
                Wizard wizard = WizardPage.createWizard(pages, mp);
                System.out.println("Result = " + WizardDisplayer.showWizard(wizard));
                System.exit(0);
            }
        };

        EventQueue.invokeLater(r);
    }

}

class MyProducer implements WizardPage.WizardResultProducer {

    public Object finish(Map wizardData) throws WizardException {
        System.out.println("finish called");
        System.out.println(wizardData);

//        String[] items = new String[2];
//        items[0] = "First Name: " + wizardData.get("first");
//        items[1] = "Last Name: " + wizardData.get("last");
        return new Result();
    }

    public boolean cancel(Map settings) {
        System.out.println("cancel called");
        System.out.println(settings);

        return true;
    }
}

class Result extends DeferredWizardResult {

    public Result() {
        // Uncomment the following line to make it possible to close the dialog
        //+ while the operation is running (abort the operation, in other words).

//         super(true);
    }

    @Override
    public void start(Map settings, ResultProgressHandle progress) {
        progress.setProgress("Phase 1", 0, 3);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {

        }

        progress.setProgress("Phase 2", 1, 3);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {

        }

        progress.setProgress("Phase 3", 2, 3);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {

        }

        String[] items = new String[2];
        items[0] = "First Name: " + settings.get("first");
        items[1] = "Last Name: " + settings.get("last");

        // Replace null with an object reference to have this object returned
        //+ from showWizard() method.
        progress.finished(Summary.create(items, this));
    }
}
