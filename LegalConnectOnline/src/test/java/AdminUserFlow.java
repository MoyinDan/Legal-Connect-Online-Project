import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminUserFlow {
    //import webDriver
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1.Open your Chrome browser
        driver = new ChromeDriver(options);
    }

    @Test(priority = 0)
    public void adminUserSuccessfullyEnteredLegalConnectOnlinePage() throws InterruptedException {
        //Visit the Admin User URL
        driver.get("https://staging.legalconnectonline.com/legalconnect-website-angular/admin");
        // Test1. Verify that the user input the right url and it on the right page
        if (driver.getCurrentUrl().contains("https://staging.legalconnectonline.com/legalconnect-website-angular/admin"))
            //pass
            System.out.println("Correct LegalConnectOnlinePage Webpage URL");
        else
            //fail
            System.out.println("Wrong LegalConnectOnlinePage Webpage URL");
        Thread.sleep(5000);
        //Maximize the browser
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void adminUserSuccessfullyLogin() throws InterruptedException {
        //Click on login as admin menu to open the login page
        final WebElement element = driver.findElement(By.xpath("/html/body/lc-root/app-site/div/mat-toolbar/div/div[2]/div[2]/a"));
        element.click();
        Thread.sleep(15000);

        //Input your email on the email field
        driver.findElement(By.xpath("(//input[@id='Email'])[1]")).sendKeys("carlos@legalconnectonline.com");

        //Input your password on the password field
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("Secure@123");

        //Click on the login button
        driver.findElement(By.xpath("//*[@id=\"login_button_text\"]")).click();
        Thread.sleep(10000);

        //Test2. Verify that when user click on the login button he/she is directed to the application.
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://staging.legalconnectonline.com/legalconnect-portal-admin/admin";
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct logged in admin Url");
        else
            //faIl
            System.out.println("Wrong logged in admin Url");
    }


    @Test(priority = 2)
    public void adminUserReviewLawyerDocumentsBeforeOnboarding() throws InterruptedException {
        //Click on request menu to view list of lawyers to review
        driver.findElement(By.xpath("/html/body/app-root/app-admin/mat-sidenav-container/mat-sidenav/div/admin-nav/div/cdk-accordion/cdk-accordion-item[5]/a/p")).click();
        Thread.sleep(3000);

        //Test3. Verify that when admin click request menu, he/she is successfully redirected to the right page.
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://staging.legalconnectonline.com/legalconnect-portal-admin/admin/practitioner";
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct legal practitioners requests page");
        else
            //faIl
            System.out.println("Wrong legal practitioners requests page");

        //admin clicks on the right page to select lawyer to review
        driver.findElement(By.xpath("/html/body/app-root/app-admin/mat-sidenav-container/mat-sidenav-content/div/div/app-practitionerrequests/div/main/div[2]/pagination-template/div/div[6]")).click();
        Thread.sleep(3000);

        //admin clicks the lawyer to review
        driver.findElement(By.xpath("/html/body/app-root/app-admin/mat-sidenav-container/mat-sidenav-content/div/div/app-practitionerrequests/div/main/div[2]/table/tbody/tr[7]/td[5]/a")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void adminUserApprovesLawyerRequest() throws InterruptedException {
        //click on the approve button
        driver.findElement(By.xpath("/html/body/app-root/app-admin/mat-sidenav-container/mat-sidenav-content/div/div/app-practitionerreviews/div/main/div/div/div[2]/div[1]/span")).click();
        Thread.sleep(5000);
        System.out.println("URL after Admin Approval" + driver.getCurrentUrl());

    }

    @Test(priority = 4)
    public void adminClicksOnManagementTabToManageOtherUsers() throws InterruptedException {
        //Click management tab
        driver.findElement(By.xpath("/html/body/app-root/app-admin/mat-sidenav-container/mat-sidenav/div/admin-nav/div/cdk-accordion/cdk-accordion-item[7]/a/p")).click();
        Thread.sleep(5000);

        //Test4. Verify that when admin click management menu, he/she is successfully redirected to the right page.
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://staging.legalconnectonline.com/legalconnect-portal-admin/admin/management/admin-management";
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct managementPage page");
        else
            //faIl
            System.out.println("Wrong management page");
    }

    @Test(priority = 5)
    public void adminClicksOnLegalPractitionerTabToManagerLawyer() throws InterruptedException {
        //Click legal practitioner tab
        driver.findElement(By.xpath("/html/body/app-root/app-admin/mat-sidenav-container/mat-sidenav/div/admin-nav/div/cdk-accordion/cdk-accordion-item[7]/div/a[3]/p")).click();
        Thread.sleep(3000);

        //Test5. Verify that when admin click legal practitioner menu, he/she is successfully redirected to the right page.
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://staging.legalconnectonline.com/legalconnect-portal-admin/admin/management/practitioners";
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct legal practitioner page");
        else
            //faIl
            System.out.println("Wrong legal practitioner page");
    }

    @Test(priority = 6)
    public void adminClicksSpecificLegalPractitionerToManage() throws InterruptedException {
        //Click on specific page
        driver.findElement(By.xpath("/html/body/app-root/app-admin/mat-sidenav-container/mat-sidenav-content/div/div/ng-component/div/main/div/div/div/div[2]/div/div/div/div/pagination-template/div/div[7]/p/span")).click();
        Thread.sleep(5000);

        //Click on specific lawyer to manage
        driver.findElement(By.xpath("/html/body/app-root/app-admin/mat-sidenav-container/mat-sidenav-content/div/div/ng-component/div/main/div/div/div/div[2]/div/div/div/div/table/tbody/tr/td[4]/div")).click();
        Thread.sleep(3000);

    }


    @Test(priority = 7)
    public void adminSetCommissionForLawyer() throws InterruptedException {

        //Click on set commission
        driver.findElement(By.xpath("/html/body/app-root/app-admin/mat-sidenav-container/mat-sidenav-content/div/div/ng-component/div/div[2]/div[2]/div[2]/div[8]/div[5]")).click();
        Thread.sleep(3000);

        //Click on service charge commission field
        driver.findElement(By.xpath("//*[@id=\"mat-dialog-2\"]/div/div[2]/div/form/div/div[1]/input")).sendKeys("10");

        //Click on save button
        driver.findElement(By.xpath("//*[@id=\"mat-dialog-2\"]/div/div[2]/div/form/div/div[2]/button[1]")).click();
        Thread.sleep(5000);

    }

    @Test(priority = 8)
    public void adminDeactivateLawyerAccount() throws InterruptedException {

        //Click on deactivate link
        driver.findElement(By.xpath("/html/body/app-root/app-admin/mat-sidenav-container/mat-sidenav-content/div/div/ng-component/div/div[2]/div[2]/div[2]/div[8]/div[6]")).click();
        Thread.sleep(3000);

        //Click on deactivate button
        driver.findElement(By.xpath("//*[@id=\"mat-dialog-3\"]/app-toggle-practitioner-status/div/div/button[1]")).click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void quitBrowser() {
        //Quit the browser.
        driver.quit();
    }


}
