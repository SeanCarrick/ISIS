/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.is2300.isis;

import com.is2300.isis.utils.ResourceExporter;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        // Set the start point of our substring to either 5 or 9, depending upon
        //+ if we are debugging (in NetBeans) or not (executing the JAR).
        if ( isDebugging ) {
            startPoint = 5;
        } else {
            startPoint = 9;
        }
        
        // First, we'll try just the name of the resource file to export.
        String rsName = "PSInstaller.jar";
        
        try {
            System.out.println(ResourceExporter.exportResource(rsName, 
                    ISISIntegritySolutionsInstallationSystem.class, 
                    "/home/sean/tmp", startPoint));
        } catch (Exception ex) {
            System.err.println(ex.getCause());
            System.err.println(ex.getMessage());
            ex.printStackTrace(System.err);
        }
        
        // Then, we'll try it with the absolute path.
        rsName = "/com/is2300/isis/resources/PSInstaller.jar";
        
        try {
            System.out.println(ResourceExporter.exportResource(rsName, 
                    ISISIntegritySolutionsInstallationSystem.class, 
                    "/home/sean/tmp", startPoint));
        } catch (Exception ex) {
            System.err.println(ex.getCause());
            System.err.println(ex.getMessage());
            ex.printStackTrace(System.err);
        }
        
        // Then, we'll try it with the relative path.
        rsName = "../resources/PSInstaller.jar";
        
        try {
            System.out.println(ResourceExporter.exportResource(rsName, 
                    ISISIntegritySolutionsInstallationSystem.class, 
                    "/home/sean/tmp", startPoint));
        } catch (Exception ex) {
            System.err.println(ex.getCause());
            System.err.println(ex.getMessage());
            ex.printStackTrace(System.err);
        }
        
        // Last, we'll try it using dots instead of slashes.
        rsName = "com.is2300.isis.resources.PSInstaller.jar";
        
        try {
            System.out.println(ResourceExporter.exportResource(rsName, 
                    ISISIntegritySolutionsInstallationSystem.class, 
                    "/home/sean/tmp", startPoint));
        } catch (Exception ex) {
            System.err.println(ex.getCause());
            System.err.println(ex.getMessage());
            ex.printStackTrace(System.err);
        }

    }
    
}
