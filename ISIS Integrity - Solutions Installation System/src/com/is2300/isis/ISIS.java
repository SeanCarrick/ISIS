/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.is2300.isis;

import java.io.File;
import java.util.Map;

/**
 *
 * @author Sean Carrick
 */
public class ISIS {
    private static boolean isDebugging = true;
    private static int startPoint = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Test our 'utils.ResourceExporter.exportResource(String resourceName)
        //+ function.
        
        String outPath = System.getProperty("user.home") 
                         + System.getProperty("file.separator") + "tmp"
                         + System.getProperty("file.separator");
        File tmp = new File(outPath);
        
        if ( !tmp.exists() )
            tmp.mkdir();
        
        // Set the start point of our substring to either 5 or 9, depending upon
        //+ if we are debugging (in NetBeans) or not (executing the JAR).
        if ( isDebugging ) {
            startPoint = 5;
        } else {
            startPoint = 9;
        }
        
        /* Get the System Environment Variables from the system on which we are
         * running.
        */
        Map<String, String> env = System.getenv();
        for ( String envName : env.keySet() ) 
            System.out.format("%s=%s%n", envName, env.get(envName));
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            if ( !System.getProperty("os.name").toLowerCase().contains("linux") )
                javax.swing.UIManager.setLookAndFeel(
                        javax.swing.UIManager.getSystemLookAndFeelClassName());
            else {
            
                for (javax.swing.UIManager.LookAndFeelInfo info : 
                        javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            }
        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | 
                javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println("Cause:\t" + ex.getCause().toString());
            System.err.println("Message:\t" + ex.getMessage());
            ex.printStackTrace(System.err);
        }
        //</editor-fold>
        MakeInstaller.main(null);
        
//        // We'll use a variable name to make it easier to change later.
//        String rsName = "com/is2300/isis/resources/derby.jar";
//        
//        try {
//            System.out.println(ResourceExporter.exportResource(rsName, 
//                    ISIS.class, 
//                    outPath, startPoint));
//        } catch (Exception ex) {
//            System.err.println(ex.getCause());
//            System.err.println(ex.getMessage());
//            ex.printStackTrace(System.err);
//        }

    }
    
}
