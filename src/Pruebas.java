import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Pruebas {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "F:/PruebasPagina/driver/chromedriver.exe");
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    //Comprar sin Iniciar sesión
    @Test
    public void CP1() throws InterruptedException {
        driver.get("https://www.mediamarkt.es/");
        driver.findElement(By.id("pwa-consent-layer-accept-all-button")).click();
        WebElement busqueda = driver.findElement(By.className("sc-19g71jg-1"));
        busqueda.sendKeys("msi katana");
        WebElement boton=driver.findElement(By.className("sc-19g71jg-2"));
        boton.click();
        driver.findElement(By.className("sc-140xkaw-1")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("giKMZX")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("iNaIdT")).click();
        Thread.sleep(4000);
        driver.findElement(By.className("iNaIdT")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("jqvSNP")).click();
        driver.close();
        Thread.sleep(2000);
        //WebElement resul=driver.findElement(By.className("eJlgzS"));
        String tit=driver.getTitle();
        assertEquals("Ya estoy registrado", tit);
    }
    //En esta prueba como se puede ver si permite comprar algo sin iniciar sesión entrando como invitado.


    //Filtros de búsqueda
    @Test 
    public void CP2() throws InterruptedException {
        driver.get("https://www.mediamarkt.es/");
        driver.findElement(By.id("pwa-consent-layer-accept-all-button")).click();
        driver.findElement(By.className("jqWRKP")).click();;
        driver.findElement(By.className("RUhjZ")).click();;
        Thread.sleep(2000);
        
        //Esta prueba no la pasa debido a que no permite meter mas de un filtro a la vez.
    }

    //Correo inválido
    @Test 
    public void CP3() throws InterruptedException {
        driver.get("https://www.mediamarkt.es/");
        driver.findElement(By.id("pwa-consent-layer-accept-all-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("cHYTg")).click();
        driver.findElement(By.id("myaccount-dropdown-register-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("iadsbyfiouvadsb");
        Thread.sleep(2000);
        driver.findElement(By.className("hjBcKH")).click();
    }
        //Como se puede ver aqui no permite 
        //darle a enviar porque salta una advertencia de correo inválido

        //Correo repetido
        @Test 
        public void CP4() throws InterruptedException {
        driver.get("https://www.mediamarkt.es/");
        driver.findElement(By.id("pwa-consent-layer-accept-all-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("cHYTg")).click();
        driver.findElement(By.id("myaccount-dropdown-register-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("iadsbyfiouvadsb");
        Thread.sleep(2000);
        driver.findElement(By.className("hjBcKH")).click();
        }
        //Como se puede ver aqui no permite 
        //darle a enviar porque salta una advertencia de correo inválido
    
    
        //Compra producto no disponible
        @Test 
        public void CP5() throws InterruptedException {
        driver.get("https://www.mediamarkt.es/");
        driver.findElement(By.id("pwa-consent-layer-accept-all-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("SLjij")).sendKeys("iphone 14 plus 256");  
        Thread.sleep(2000);
        driver.findElement(By.className("ifPeBD")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("gXReC")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("iNaIdT")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("iNaIdT")).click();
        }


        //Como se puede ver esta prueba si que la pasa porque aunque el producto no este disponible 
        //permite pagarlo y esperar hasta que lo este
    
    }





