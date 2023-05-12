package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.pages.IRCTCPage;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class CaptchaFile extends BaseClass {

    @BeforeTest
    public void init()
    {
        setUp();
    }

    @Test
    public void handlingTextCaptcha() throws InterruptedException , IOException , TesseractException
    {
        driver.get("https://www.irctc.co.in/nget/train-search");
        IRCTCPage irctcPage = new IRCTCPage(driver);
        irctcPage.handleCaptcha();
        Thread.sleep(3000);
    }
}
