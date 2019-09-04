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
package com.is2300.isis.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Sean Carrick <sean at carricktrucking.com>
 */
public class ResourceExporter {
    
    public static String exportResource(String resourceName, Class cls, 
                    String outPath, int startPoint) throws Exception {

        InputStream in = ClassLoader.getSystemClassLoader().getSystemResourceAsStream(resourceName);
        FileOutputStream out = new FileOutputStream(outPath + 
                        resourceName.substring(resourceName.lastIndexOf("/")));
        
        int readBytes;
        byte[] buffer = new byte[4096];
        while ( (readBytes = in.read(buffer)) > 0 )
            out.write(buffer, 0, readBytes);
        
        in.close();
        out.close();
        
        return out.toString();
    }
    
    public static String exportResource(String resourceName) throws Exception {
        InputStream in = null;
        OutputStream out = null;
        String jarFolder;
        
        in = ResourceExporter.class.getResourceAsStream(resourceName);

        if ( in == null ) 
            throw new Exception("Cannot get resource \"" + resourceName + 
                    "\" from Jar file.");
        
        int readBytes;
        
        byte[] buffer = new byte[4096];
        
        jarFolder = new File(ResourceExporter.class.getProtectionDomain()
                            .getCodeSource().getLocation().toURI().getPath())
                            .getParentFile().getPath().replace('\\', '/');
        
        out = new FileOutputStream(jarFolder + resourceName);
        
        while ( (readBytes = in.read(buffer)) > 0 ) 
            out.write(buffer, 0, readBytes);
        
        in.close();
        out.close();
        
        return jarFolder + resourceName;
    }
}
