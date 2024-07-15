package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {


//                WebDriverManager.chromedriver().setup();
//                ChromeDriver driver = new ChromeDriver();

                try {
                    FileInputStream file = new FileInputStream(new File("C:\\Users\\sy012\\IdeaProjects\\TSample\\target\\htmlPages.xlsx"));
                    XSSFWorkbook workbook = new XSSFWorkbook(file);
                    XSSFSheet sheet = workbook.getSheetAt(0);
                    Iterator<Row> rowIterator = sheet.iterator();
                    while (rowIterator.hasNext()) {
                        Row row = rowIterator.next();
                        Iterator<Cell> cellIterator = row.cellIterator();
                        while (cellIterator.hasNext()) {
                            Cell cell = cellIterator.next();
                            String link = cell.getStringCellValue();
                            HttpURLConnection c = (HttpURLConnection) new URL(link).openConnection();
                            c.setRequestMethod("HEAD");
                            c.connect();
                            int r = c.getResponseCode();
                            if (r == 200) {System.out.println("Page is Working: " + r + " " + link);
                            } else {
                                System.out.println("Page is Not Working: " + r + " " + link);
                            }
                        }
                    }
                    file.close();
                } catch (Exception e) { e.printStackTrace(); }



//                driver.get("https://www.flipkart.com/search?q=iphone+14&as=on&as-show=on&otracker=AS_Query_OrganicAutoSuggest_3_2_na_na_na&otracker1=AS_Query_OrganicAutoSuggest_3_2_na_na_na&as-pos=3&as-type=RECENT&suggestionId=iphone+14&requestId=1090781d-0462-43fc-b42f-821208444f58&as-searchtext=iphone%2014");
//                driver.manage().window().maximize();

//                List<WebElement> findElements = driver.findElements(By.xpath("//div[contains(text() ,'58,999')]/preceding::div[@class='KzDlHZ']"));//(//div[@class='Nx9bqj _4b5DiR']/preceding::div[@class='KzDlHZ'])[1]
//
//                for (WebElement webElement : findElements) {
//                    System.out.println(webElement.getText());
//                }
//
//                List<WebElement> findElements1 = driver.findElements(By.xpath("//span[contains(text(),'13')]/preceding::div[@class='KzDlHZ'][1]"));//span[text()='13% off' and preceding::div[@class='KzDlHZ']]
//
//                for (WebElement webElement : findElements1) {
//                    System.out.println(webElement.getText());
//                }
//
//
//
//
//
//				List<WebElement> allLinks = driver.findElements(By.tagName("a"));
//
//
//		for (int i = 0; i < allLinks.size(); i++) {
//
//			WebElement individualLink =allLinks.get(i);
//			String attribute = individualLink.getAttribute("href");
//
//			URL url= new URL(attribute);
//			URLConnection openConnection = url.openConnection();
//			HttpURLConnection httpURLConnection = (HttpURLConnection)openConnection;
//
//			int responseCode = httpURLConnection.getResponseCode();
//
//			if (responseCode >= 200 && responseCode <= 299) {
//
//				System.out.println("valid Response or Succusful Response" + attribute);
//
//			} else {
//
//				System.out.println("Broken link"+ attribute);
//			}
//		}



//        List<String> urls = Arrays.asList(
//                "https://syenapp.com/download.html",
//                "https://syenapp.com/#howitworks",
//                "https://syenapp.in/amazon_syenappdeals.html",
//                "https://syenapp.in/proddeals.html"
//        );
//
//
//        for (String url : urls) {
//
//            openNewWindow(driver, url);
//
//            if (isBrokenLink(url)) {
//                System.out.println("Broken link: " + url);
//            } else {
//                System.out.println("Valid link: " + url);
//            }
//
//        }
//
//
//     //   driver.quit();
//    }
//
//    private static void openNewWindow(WebDriver driver, String url) {
//
//        ((JavascriptExecutor) driver).executeScript("window.open('" + url + "', '_blank');");
//    }
//
//    private static boolean isBrokenLink(String url) {
//        try (CloseableHttpClient client = HttpClients.createDefault()) {
//            HttpHead request = new HttpHead(url);
//            HttpResponse response = client.execute(request);
//            return response.getStatusLine().getStatusCode() >= 400;
//        } catch (IOException e) {
//            System.out.println("Error checking " + url + ": " + e.getMessage());
//            return true;
//        }
    }





}