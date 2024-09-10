package org.iit.healthcare.mmptitan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProjectConfiguration {
	public Properties readPropertyFile(String fileName) throws FileNotFoundException, IOException
	{
		
		Properties prop = new Properties();
		File f = new File(fileName);
		prop.load( new FileInputStream(f.getAbsolutePath()));
		return prop;
	}

}
