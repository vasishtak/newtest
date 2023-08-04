package testwebapp;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class WebAppTest {

    @Test
	public void testGetMessage() {
    	assertTrue(TestWebApp.getMessage() == "Hello World!");
    }
   
}