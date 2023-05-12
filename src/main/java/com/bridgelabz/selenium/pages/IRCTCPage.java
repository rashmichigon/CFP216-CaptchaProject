package com.bridgelabz.selenium.pages;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class IRCTCPage {
    WebDriver driver;

    @FindBy(xpath = "//a[@class='search_btn loginText ng-star-inserted']")
    WebElement loginButton;

//    @FindBy(xpath = "//input[@id='9308847']")
//    WebElement userName;
//
//    @FindBy(xpath = "//input[@id='348183']")
//    WebElement passWord;

    @FindBy(xpath = "//div[@class='captcha_div']")
    WebElement captchaImage;

    public IRCTCPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void handleCaptcha() throws InterruptedException, IOException, TesseractException {
        loginButton.click();
       // Thread.sleep(1000);
        //userName.sendKeys("rashmi");
        //Thread.sleep(1000);
        //passWord.sendKeys("Rashmi@123");
        //Thread.sleep(1000);
        String path="C:\\Users\\Admin\\IdeaProjects\\CaptchaProject\\Screenshots\\Image1.png";
        File src = captchaImage.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src,new File(path));

        Tesseract img = new Tesseract();
        img.setDatapath("C:\\Program Files (x86)\\Tesseracts\\testdata");
        String captchaText = img.doOCR(new File(path));
        System.out.println(captchaText);
    }
}
