import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadMultipleFiles {

	public static WebDriver driver;
	public static void  setup() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Oxygen Eclipse\\Williams_sonoma\\driverExe\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.tinyupload.com/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebElement browse=driver.findElement(By.xpath("//input[@name='uploaded_file']"));
		browse.click();
		Thread.sleep(5000);
		String DirectoryPath="C:\\Users\\Amit\\Desktop\\test data\\";		
		String AllFilePath="";
		File Directory=new File(DirectoryPath);
		File[] AllFiles=Directory.listFiles();
		
		for(File file:AllFiles)
		{
			if(file.isFile())
			{
				AllFilePath=AllFilePath+"\""+file.getName()+"\""+" ";
			}
		}
		
		try {
			Runtime.getRuntime().exec("C:\\Users\\Amit\\Desktop\\Auto it\\FileUpload.exe" + " "+DirectoryPath);
			Thread.sleep(5000);
			Runtime.getRuntime().exec("C:\\Users\\Amit\\Desktop\\Auto it\\FileUpload.exe" + " "+AllFilePath);
		Thread.sleep(20000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
setup();
	}

}
