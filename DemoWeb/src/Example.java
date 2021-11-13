import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C://Users//mittu//Downloads//chromedriver_win32//chromedriver.exe");
		
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://restful-booker.herokuapp.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(" //a[text()='API Docs']")).click();
		
		String a = driver.findElement(By.xpath("//*[@id=\"api-Auth-CreateToken-1.0.0\"]/span")).getText();
		
		System.out.println(a);
	}
}
