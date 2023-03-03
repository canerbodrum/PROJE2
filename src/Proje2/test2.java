package Proje2;

import Utlity.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class test2 extends BaseDriver {
    @Test
    public void test2(){
        //Senaryo 2: Negatif kayıt Testi
        //➢ Siteye gidin
        driver.get("http://demowebshop.tricentis.com/");
        //➢ Register butonuna tıklayın
        Actions aksiyonlar=new Actions(driver);
        WebElement register= driver.findElement(By.cssSelector("a[href='/register']"));
        aksiyonlar.click(register).build().perform();

        //➢ Yukarda kaydolduğunuz email ile kaydolmaya calisin
        WebElement ad= driver.findElement(By.xpath("//input[@id='FirstName']"));
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
        //➢ Register butonuna tıkayınız

        //➢ “The specified email already exists” mesajının görüldüğünü doğrulayınız
        WebElement txtcheck= driver.findElement(By.xpath("//li[text()='The specified email already exists']"));
        boolean txt=txtcheck.getText().contains("The specified email already exists");

        Assert.assertTrue("KAYIT DOĞRULANMADI ",txt);


    }
}
