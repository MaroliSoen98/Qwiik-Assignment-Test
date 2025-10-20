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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
'Call login test case'
WebUI.callTestCase(findTestCase('SauceDemo/Login Page'), [:])

WebUI.delay(5)

'Click sort filter dropdown'
WebUI.click(findTestObject('SwagHomePage/select_sortFilter'))

'Verify sort option price is visible'
WebUI.verifyElementPresent(findTestObject('SwagHomePage/select_sortItemPrice'), 0)

'Click sort by price option'
WebUI.click(findTestObject('SwagHomePage/select_sortItemPrice'))

WebUI.delay(3)

'Loop sebanyak 3 kali'
for (int i = 1; i <= 3; i++) {
	'Buat XPath dinamis'
	String dynamicXPath = "//div[" + i + "]/div[2]/div[2]/button"
	
	'Buat TestObject secara dinamis'
	TestObject dynamicButton = new TestObject()
	dynamicButton.addProperty("xpath", ConditionType.EQUALS, dynamicXPath)
	
	'Verifikasi element present'
	WebUI.verifyElementPresent(dynamicButton, 0)
	WebUI.click(dynamicButton)
}

'Verify Cart icon is visible'
WebUI.verifyElementPresent(findTestObject('CheckoutItem/a_SwagCartLink'), 0)

'Click Cart icon to go to Cart page'
WebUI.click(findTestObject('CheckoutItem/a_SwagCartLink'))

'Verify Checkout button is visible'
WebUI.verifyElementPresent(findTestObject('CheckoutItem/btn_ShoppingCheckout'), 0)

'Click Checkout button'
WebUI.click(findTestObject('CheckoutItem/btn_ShoppingCheckout'))

'Fill in First Name fields'
WebUI.setText(findTestObject('CheckoutItem/input_first-name'), 'Alex')

'Fill in Last Name field'
WebUI.setText(findTestObject('CheckoutItem/input_last-name'), 'Hunter')

'Fill in Postal Code field'
WebUI.setText(findTestObject('CheckoutItem/input_postal-code'), '12345')

'Verify Continue button is visible'
WebUI.verifyElementPresent(findTestObject('CheckoutItem/btn_Continue'), 0)

'Click Continue button'
WebUI.click(findTestObject('CheckoutItem/btn_Continue'))

'Verify Finish button is visible'
WebUI.verifyElementPresent(findTestObject('CheckoutItem/button_Finish'), 0)

'Click Finish button to complete checkout'
WebUI.click(findTestObject('CheckoutItem/button_Finish'))

'Verify checkout complete message is visible'
WebUI.verifyElementPresent(findTestObject('CheckoutItem/msg_CheckoutComplete'), 0)

'Verify Back Home button is visible'
WebUI.verifyElementPresent(findTestObject('CheckoutItem/btn_backHome'), 0)

'Click Back Home button'
WebUI.click(findTestObject('CheckoutItem/btn_backHome'))

'Verify menu button is visible on Home page'
WebUI.verifyElementPresent(findTestObject('SwagHomePage/btn_menuSwag'), 0)

'Click menu button'
WebUI.click(findTestObject('SwagHomePage/btn_menuSwag'))

'Verify Logout link are visible'
WebUI.verifyElementPresent(findTestObject('SwagHomePage/a_logout'), 0)

'Click Logout link'
WebUI.click(findTestObject('SwagHomePage/a_logout'))

'Close browser session'
WebUI.closeBrowser()
