package Proje2;

import Utlity.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class test extends BaseDriver {
    @Test
    public void test(){
//        Techno Study Testing Project 2
//url: http://demowebshop.tricentis.com/
        driver.get("http://demowebshop.tricentis.com/");
// ➢ Bu projeyi Java ve Selenium kütüphanesini kullanarak test edeceksiniz
// ➢ Action class kullanılacak
// Test Senaryoları
//Senaryo 1: Kayıt oluşturma Testi
//➢ Siteye gidin
//➢ Register butonuna tıklayın

        WebElement register= driver.findElement(By.cssSelector("a[href='/register']"));
        Actions aksiyonlar=new Actions(driver);
        aksiyonlar.click(register).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//➢ Kişisel bilgileri doldurun ve register butonuna tıklayın
        WebElement ad= driver.findElement(By.id("FirstName"));
        aksiyonlar.sendKeys(ad,"tester14").build().perform();

        WebElement soyad= driver.findElement(By.id("LastName"));
        aksiyonlar.sendKeys(soyad,"techno").build().perform();

        WebElement email= driver.findElement(By.id("Email"));
        aksiyonlar.sendKeys(email,"grup14tester@gmail.com").build().perform();

        WebElement pass= driver.findElement(By.id("Password"));
        aksiyonlar.sendKeys(pass,"testerlar14").build().perform();

        WebElement repass= driver.findElement(By.id("ConfirmPassword"));
        aksiyonlar.sendKeys(repass,"testerlar14").build().perform();

        WebElement male= driver.findElement(By.id("gender-male"));
        aksiyonlar.click(male).build().perform();

        WebElement register2= driver.findElement(By.id("register-button"));

        aksiyonlar.click(register2).build().perform();

        //➢ Başarılı bir şekilde kaydolduğunuzu doğrulayınız
        WebElement checktxt= driver.findElement(By.xpath("//*[@class='result']"));
        boolean kayit=checktxt.getText().contains("Your registration completed");
        Assert.assertTrue("text gözükmedi",kayit);
    }
}
