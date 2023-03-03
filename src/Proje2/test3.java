package Proje2;

import Utlity.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class test3 extends BaseDriver {
    @Test
    public void test() {
        //Senaryo 3: Login Test

        //➢ Siteye gidin
        driver.get("http://demowebshop.tricentis.com/");
        //➢ Login butonuna tıklayın
        Actions aksiyonlar=new Actions(driver);
        WebElement login= driver.findElement(By.xpath("//a[text()='Log in']"));
        aksiyonlar.click(login).build().perform();

        //➢ Geçerli email ve password I giriniz
        WebElement id= driver.findElement(By.id("Email"));
        aksiyonlar.sendKeys(id,"grup14tester@gmail.com").build().perform();

        WebElement pass= driver.findElement(By.id("Password"));
        aksiyonlar.sendKeys(pass,"testerlar14").build().perform();

        //➢ Login butonuna tıklatınız ve login olduğunuzu doğrulayınız
        WebElement log= driver.findElement(By.xpath("(//div[@class='buttons']/input)[3]"));
        aksiyonlar.click(log).build().perform();


        WebElement logintest= driver.findElement(By.xpath("//a[text()='grup14tester@gmail.com']"));


        boolean logemail=logintest.getText().contains("grup14tester@gmail.com");

        Assert.assertTrue("giriş hatalı",logemail);

    }
}
