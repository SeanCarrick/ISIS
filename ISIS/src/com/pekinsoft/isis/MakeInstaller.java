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
package com.pekinsoft.isis;

import com.pekinsoft.isis.pages.GetAddtlJARsPage;
import com.pekinsoft.isis.pages.GetDefInstLocPage;
import com.pekinsoft.isis.pages.GetJARPage;
import com.pekinsoft.isis.pages.GetLAPage;
import com.pekinsoft.isis.pages.GetLibsPage;
import com.pekinsoft.isis.producers.MakeInstallerProducer;
import com.pekinsoft.isis.pages.GetTitlePage;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
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
            GetAddtlJARsPage.class,
            GetLibsPage.class,
            GetDefInstLocPage.class
        };
        
//        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("com/is2300/"
//                                          + "isis/contents/WizardSidebar.png"));
//        if (image != null) {
//            final ImageIcon icon = new ImageIcon(image.getImage());
//            Dimension logoSize = new Dimension(icon.getIconWidth(), icon.getIconHeight());
//            final BufferedImage img
//                    = createCompatibleTranslucentImage(logoSize.width,
//                            logoSize.height);
//            Graphics2D g = img.createGraphics();
//            g.setColor(Color.white);
//            g.fillRect(0, 0, icon.getIconWidth(), icon.getIconHeight());
//            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5F));
//            icon.paintIcon(null, g, 0, 0);
//            g.dispose();
//            UIManager.put("wizard.sidebar.image", createCompatibleTranslucentImage(img.getWidth(), img.getHeight())); //$NON-NLS-1$
//        }
        System.setProperty("wizard.sidebar.image", String.valueOf(ClassLoader.getSystemResource("com/is2300/isis/contents/WizardSidebar.png")));
        String tmp = System.getProperty("wizard.sidebar.image");
        tmp = tmp.replace("file:/", "file:///");
        System.setProperty("wizard.sidebar.image", tmp);
        
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
    
    public static BufferedImage createCompatibleTranslucentImage(int w, int h) {
        final BufferedImage compatTransImage;
        final GraphicsConfiguration gc = getGraphicsConfiguration();

        BufferedImage timg;
        timg = gc.createCompatibleImage(1, 1, BufferedImage.TRANSLUCENT);

        if (timg.getType() == BufferedImage.TYPE_INT_ARGB_PRE) {
            timg = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        }

        compatTransImage = timg;
        
//        compatTranslImageType = compatTransImage.getType();

        final ColorModel cm = compatTransImage.getColorModel();
        final WritableRaster wr = cm.createCompatibleWritableRaster(w, h);
        return new BufferedImage(cm, wr, cm.isAlphaPremultiplied(), null);
    }

    private static GraphicsConfiguration getGraphicsConfiguration() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().
                getDefaultScreenDevice().getDefaultConfiguration();
    }
}
