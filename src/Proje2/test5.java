package Proje2;

import Utlity.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class test5 extends BaseDriver {
    @Test
    public void Test(){
        //Senaryo 5: Order Test

        //➢ Siteye gidin
        driver.get("http://demowebshop.tricentis.com/");
        //➢ Login olun
        Actions aksiyonlar=new Actions(driver);
        WebElement login= driver.findElement(By.xpath("//a[text()='Log in']"));
        aksiyonlar.click(login).build().perform();

        WebElement id= driver.findElement(By.id("Email"));
        aksiyonlar.sendKeys(id,"grup14tester@gmail.com").build().perform();

        WebElement pass= driver.findElement(By.id("Password"));
        aksiyonlar.sendKeys(pass,"testerlar14").build().perform();

        WebElement log= driver.findElement(By.xpath("(//div[@class='buttons']/input)[3]"));
        aksiyonlar.click(log).build().perform();
        //➢ Computers>Notebook un altında “14.1-inch Laptop” adli ürüne tıklatınız

        WebElement computer=driver.findElement(By.xpath("//a[@href='/computers']"));
        aksiyonlar.moveToElement(computer).build().perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement laptops=driver.findElement(By.xpath("//a[@href='/notebooks']"));
        aksiyonlar.moveToElement(laptops).build().perform();

        aksiyonlar.click(laptops).build().perform();

        //➢ Ad to Cart butonuna tıklatınız ve urunun başarılı bir şekilde eklendiğini doğrulayın
        WebElement addtocard=driver.findElement(By.xpath("//input[@value='Add to cart']"));
        aksiyonlar.click(addtocard).build().perform();
        //➢ Shopping cart butonuna tıklatıp sepetinize gidin ve urunun orda görüldüğünü doğrulayın
        WebElement gotocard=driver.findElement(By.cssSelector("a.ico-cart>:nth-child(1)"));
        aksiyonlar.click(gotocard).build().perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


        //➢ Agree check box tıklatıp Sartları Kabul edin
        WebElement iagree=driver.findElement(By.id("termsofservice"));
        aksiyonlar.click(iagree).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //➢ Checkout butonuna tıklatın
        WebElement checkout=driver.findElement(By.id("checkout"));
        aksiyonlar.click(checkout).build().perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement company=driver.findElement(By.id("BillingNewAddress_Company"));

        aksiyonlar.sendKeys(company,"technostudy").build().perform();

        WebElement city=driver.findElement(By.id("BillingNewAddress_City"));
        aksiyonlar.sendKeys(city,"istanbul").build().perform();

        WebElement adress1=driver.findElement(By.id("BillingNewAddress_Address1"));

        aksiyonlar.sendKeys(adress1,"çinçin mahallesi").build().perform();

        WebElement adress2=driver.findElement(By.id("BillingNewAddress_Address2"));

        aksiyonlar.sendKeys(adress2,"çukur sokak").build().perform();

        WebElement postalCode=driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));

        aksiyonlar.sendKeys(postalCode,"34400").build().perform();

        WebElement phonenumber=driver.findElement(By.id("BillingNewAddress_PhoneNumber"));

        aksiyonlar.sendKeys(phonenumber,"05555555555").build().perform();

        WebElement faxnumber=driver.findElement(By.id("BillingNewAddress_FaxNumber"));

        aksiyonlar.sendKeys(faxnumber,"02125555555").build().perform();

        Select select=new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
        select.selectByValue("77");

        WebElement contin=driver.findElement(By.xpath("//*[@value='Continue']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        aksiyonlar.click(contin).build().perform();



        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement contin2=driver.findElement(By.xpath("(//input[@value='Continue'])[2]"));
        contin2.click();

        WebElement contin3=driver.findElement(By.xpath("(//input[@value='Continue'])[3]"));
        contin3.click();

        WebElement contin4=driver.findElement(By.xpath("(//input[@value='Continue'])[4]"));
        contin4.click();

        WebElement contin5=driver.findElement(By.xpath("(//input[@value='Continue'])[5]"));
        contin5.click();

        WebElement contin6=driver.findElement(By.xpath("//*[@onclick='ConfirmOrder.save()']"));
        contin6.click();

        WebElement txtknt=driver.findElement(By.xpath("//*[text()='Your order has been successfully processed!']"));

        Assert.assertTrue("EŞLEŞMEDİ",txtknt.getText().startsWith("Your order has been successfully processed"));

        //*[text()='Your order has been successfully processed!']

        //➢ Açılan sayfada tüm bilgileri doldurun ve confirm order butonuna tıklatın
        //*[text()='Your order has been successfully processed!']
        //➢ “Your order has been successfully processed!” mesajının görüldüğünü doğrulayın
    }
}
