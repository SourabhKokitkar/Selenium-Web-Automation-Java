package Variables;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configProperties {
	
	public static Properties property;
	
	private static String configpath = "C:\\Users\\PRiNCE\\git\\repository\\OrangeHRM_TestAutomation\\config\\config01.properties";
	
	public static void initPropertyFile() throws IOException {
		
		property = new Properties();
		InputStream instm = new FileInputStream(configpath);
		
		property.load(instm);
	}

}
