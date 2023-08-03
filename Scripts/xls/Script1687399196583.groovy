import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverPath())

WebDriver driver = new ChromeDriver()
//DriverFactory.changeWebDriver(driver)
driver.get("https://file-examples.com/wp-content/storage/2017/02/file_example_XLS_10.xls")
Thread.sleep(10000)
driver.get("chrome://downloads/")
JavascriptExecutor js1 = (JavascriptExecutor) driver;
WebElement element1 = (WebElement) js1.executeScript("return document.querySelector('body > downloads-manager').shadowRoot.querySelector('#frb0').shadowRoot.querySelector('#title-area')")
String latestFileName= element1.getText();
println(latestFileName)
driver.get("chrome://settings/downloads")
Thread.sleep(10000)
JavascriptExecutor js2 = (JavascriptExecutor) driver;
WebElement element2 = (WebElement) js2.executeScript("return document.querySelector('body > settings-ui').shadowRoot.querySelector('#main').shadowRoot.querySelector('settings-basic-page').shadowRoot.querySelector('#advancedPage > settings-section:nth-child(8) > settings-downloads-page').shadowRoot.querySelector('#defaultDownloadPath')")
String defaultDownloadPath= element2.getText();
println(defaultDownloadPath)
String CompleteDownloadPath = println(defaultDownloadPath + "/" + latestFileName)
File sourceExcel = new File(CompleteDownloadPath);
FileInputStream fis = new FileInputStream(sourceExcel);
// Open the .xlsx file and construct a workbook object
HSSFWorkbook book = new HSSFWorkbook(fis)
// Get the top sheet out of the workbook
HSSFSheet sheet = book.getSheetAt(0)
for (Row row in sheet) {
	// Iterating over each column of the row
	for (Cell cell in row) {
		switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				print(cell.getStringCellValue() + "\t")
				break
			case Cell.CELL_TYPE_NUMERIC:
				print(cell.getNumericCellValue() + "\t")
				break
			case Cell.CELL_TYPE_BOOLEAN:
				print(cell.getBooleanCellValue() + "\t")
				break
			default:
				break
		}
	}
	print "\n"
}