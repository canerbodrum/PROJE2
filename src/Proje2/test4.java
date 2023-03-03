package Proje2;

import Utlity.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class test4 extends BaseDriver {
    @Test
    public void test(){
        //Senaryo 4: Negatif Login Test
        //➢ Siteye gidin
        driver.get("http://demowebshop.tricentis.com/");
        //➢ Login butonuna tıklayın
        Actions aksiyonlar=new Actions(driver);
        WebElement login= driver.findElement(By.xpath("//a[text()='Log in']"));
        aksiyonlar.click(login).build().perform();

        //➢ Geçersiz email veya password giriniz
        WebElement id= driver.findElement(By.id("Email"));
        aksiyonlar.sendKeys(id,"asdasdqwe@hotmail.com").build().perform();

        WebElement pass= driver.findElement(By.id("Password"));
        aksiyonlar.sendKeys(pass,"asdasfasdqwe").build().perform();

        //➢ Login butonuna tıklatınız ve login olamadığınızı doğrulayınız

        WebElement log= driver.findElement(By.xpath("(//div[@class='buttons']/input)[3]"));
        aksiyonlar.click(log).build().perform();

        WebElement txt=driver.findElement(By.xpath("//div[@class='validation-summary-errors']/span"));

        boolean txtcheck=txt.getText().startsWith("Login was unsuccessful.");

        Assert.assertTrue("hata oluştu",txtcheck);

    }
}
