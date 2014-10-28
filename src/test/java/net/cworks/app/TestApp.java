package net.cworks.app;

import org.junit.Test;
import org.junit.Assert;

public class TestApp {

	@Test
	public void testAppName() throws Exception {
		App app = App.create();
        System.out.println("app.name=" + app.getName());
        Assert.assertEquals("Java Tester", app.getName());
	}
	
}