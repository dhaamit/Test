package framework;

import java.io.IOException;

import org.testng.annotations.Test;


public class IntializeTest extends Base {
@Test
public void intialize () throws IOException
{
	driver = initializeBroswer();
	driver.get("https://www.google.com/");
}
}
