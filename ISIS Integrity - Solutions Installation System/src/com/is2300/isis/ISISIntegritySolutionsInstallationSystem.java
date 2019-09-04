/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.is2300.isis;

import com.is2300.isis.utils.ResourceExporter;
import java.io.File;

/**
 *
 * @author Sean Carrick
 */
public class ISISIntegritySolutionsInstallationSystem {
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
        
        // We'll use a variable name to make it easier to change later.
        String rsName = "com/is2300/isis/resources/derby.jar";
        
        try {
            System.out.println(ResourceExporter.exportResource(rsName, 
                    ISISIntegritySolutionsInstallationSystem.class, 
                    outPath, startPoint));
        } catch (Exception ex) {
            System.err.println(ex.getCause());
            System.err.println(ex.getMessage());
            ex.printStackTrace(System.err);
        }

    }
    
}
