/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ThoughtWorks.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author raja-1573
 */

public class ConstantFile {
		
		private static final String HOME = System.getProperty("user.dir");
        private static final String propFileName = HOME + "\\bin\\ThoughtWorks\\Constants\\input.properties";
        private static final  Properties prop = new Properties();
        
        private static void getPropFile() throws IOException{
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(new File(propFileName));
                prop.load(fis);
            } catch (Exception e) {
                    System.out.println("Exception: " + e);
            } finally {
                fis.close();
            }
        }
        static
            {
              try
              {
                getPropFile();
              }
              catch (Exception e)
              {
              }
            }
	
        public static String getProp(String name) {
                return prop.getProperty(name);
        }
}
