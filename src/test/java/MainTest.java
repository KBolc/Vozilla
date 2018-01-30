import Help.WaitForElementHelp;
import Page.MainPage;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;
import java.*;

/**
 * Created by kamil on 11.04.17.
 */

public class MainTest extends WaitForElementHelp {
    WebDriver driver;


    @BeforeClass
    public void setUp() {
        String user = "vozilla-test";
        String pass = "k*yE#45";
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/lib/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/lib/chromedriver.exe");
    }

    @BeforeMethod
    public void setUper(){
        driver = new ChromeDriver();
        MainPage loginPage = new MainPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.vozilla.pl/");
        waitForLoad(driver);
    }

    @AfterMethod
    public void closeTest() {
        driver.close();
//        try {
//
//            FileInputStream file = new FileInputStream(new File("C:/Users/kbolc/Desktop/testy automatyczne/pierwszy.xlsx"));
//            HSSFWorkbook workbook = new HSSFWorkbook(file);
//
//            HSSFSheet sheet = workbook.getSheetAt(0);
//
//            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//
//                Cell resultCell = sheet.getRow(i).getCell(3);
//
//                String keyword = sheet.getRow(i).getCell(2).getStringCellValue();
//
//                String searchText = driver.getTitle();
//
//                if (searchText.equals(keyword)) {
//                    System.out.println("Search is successful.");
//                    resultCell.setCellValue("PASS");
//                } else {
//                    System.out.println("Search is not successful.");
//                    resultCell.setCellValue("FAIL");
//                }
//
//            }
//
//            workbook.close();
//            file.close();
//
//            FileOutputStream outFile = new FileOutputStream(new File("C:/Users/kbolc/Desktop/testy automatyczne/dddd.xls"));
//            workbook.write(outFile);
//            outFile.close();
//
//        } catch (FileNotFoundException fnfe) {
//            fnfe.printStackTrace();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//    }
}}






