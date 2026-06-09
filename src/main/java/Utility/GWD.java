package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// General Web Driver - İçerisinde driver nesnelerini barındırır ve dağıtır.
public class GWD {

    // İçerisinde driverları tutan ThreadLocal objesi
    private static ThreadLocal<WebDriver> threads = new ThreadLocal<>();
    public static WebDriverWait wait;
    public static JavascriptExecutor js;

    // ThreadLocal içerisinde aktif driver varsa return eden, yok ise oluşturan getter method
    public static WebDriver getDriver(){

        // Eğer ThreadLocal içerisinde aktif driver yok ise -
        if(threads.get() == null){
            // - Setup yap ve yeni driver oluştur
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            // threads içine yeni driver ı koy, driver varsa artık bu if bloğuna girmeyecek
            threads.set(driver);

            // window u maximize yap
            threads.get().manage().window().maximize();
        }

        // Wait ve js executor da yoksa 1 er tane new yapar, genel sayfa yüklenmesini ve genel element bekleme
        // süresini optimize eder
        if(wait == null && js == null){
            threads.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            threads.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            wait = new WebDriverWait(threads.get(), Duration.ofSeconds(20));
            js = (JavascriptExecutor) threads.get();
        }

        // Yeni aktif driver ı return et.
        return threads.get();
    }

    public static void quitDriver() {
        if (threads.get() != null) {

            threads.get().quit();

            WebDriver driver = threads.get();

            driver = null;

            threads.set(driver);
        }
    }


}
