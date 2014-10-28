package net.cworks.app;

import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class App {

	private Properties properties = null;

    private App(Properties properties) {
        this.properties = properties;
    }

    public static App create() throws Exception {
        Properties prop = new Properties();
        InputStream in = ClassLoader.getSystemClassLoader()
            .getResourceAsStream("app.properties");
        prop.load(in);
        in.close();
        if(prop == null) {
            prop = new Properties();
        }
        if(!prop.containsKey("app.name")) {
            prop.setProperty("app.name", App.class.getName());
        }
        return new App(prop);
    }

	public String getName() {
        return properties.getProperty("app.name");
	}

    /**
     * Boot it up
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws Exception {
        App app = App.create();
        System.out.println("Starting: " + app.getName());
    }
	
}