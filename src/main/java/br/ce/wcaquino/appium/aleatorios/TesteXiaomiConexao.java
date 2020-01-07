package br.ce.wcaquino.appium.aleatorios;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class TesteXiaomiConexao {
	
	
	
	public static AndroidDriver driver;
	   
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
    	
    	    DesiredCapabilities capabilities = new DesiredCapabilities();
    	
    	    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

            capabilities.setCapability("deviceName", "JoiceRedmi");

            capabilities.setCapability("platformVersion", "9");

            capabilities.setCapability("platformName", "Android");

            capabilities.setCapability("appPackage", "com.android.calculator2");

            capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    	    driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

    	
    }

  
}
