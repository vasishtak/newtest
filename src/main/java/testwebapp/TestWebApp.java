package testwebapp;

import static spark.Spark.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestWebApp {
	private final static Logger log = LoggerFactory.getLogger(TestWebApp.class);
	
	public static String getMessage() {
		return "Hello World!";
	}
	
	public static void printHelp() {
		log.info("Usage: java -jar testwebapp-1.0.jar -p<httpport>");
		System.exit(1);		
	}
	
    public static void main(String[] args) {
    	int httpport = 0;
    	    	
    	for( String arg : args) {
    		if(arg.startsWith("-h")) {
    			TestWebApp.printHelp();
    		}
    		if(arg.startsWith("-p")) {
    			httpport = Integer.parseInt(arg.substring(2, arg.length()));
    			log.info("Port set to: " + httpport);
    			port(httpport);
    		}
    	}
    	
    	if ( httpport == 0 ) printHelp();
    	
        get("/", (req, res) -> TestWebApp.getMessage());
    }
}