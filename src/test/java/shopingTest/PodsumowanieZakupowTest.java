package shopingTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PodsumowanieZakupowTest {
	private WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?");
	}

//	@Test
//	public void czyCenaNapodsumowaniuZakupowZaProduktPokrywaSieZTotalPrice() {
//		ZakupyUtil.klikniecieLogowanie(driver);
//		ZakupyUtil.logowanie(driver);
//		for (int i = 1; i < 3; i++) {
//			ZakupyUtil.przekierowanieNaWomen(driver);
//			ZakupyUtil.wybranieRozmiaruL(driver);
//			ZakupyUtil.waitForAjax(driver);
//			ZakupyUtil.wybranieProduktu(driver, i);
//			ZakupyUtil.waitForAjax(driver);
//			ZakupyUtil.dodanieDoKoszyka(driver);
//			ZakupyUtil.waitForAjax(driver);
//			ZakupyUtil.finalizacjaZakupow(driver);
//
//		}
//
//		assertEquals(ZakupyUtil.sumaProduktowWKoszyku(driver), ZakupyUtil.pobranieCeny(driver), 2);
//	}

//	@Test
//	public void czySumaCenProduktowPoZwiekszonejIlosciJestZgodnaZTotalemSumy() {
//		ZakupyUtil.klikniecieLogowanie(driver);
//		ZakupyUtil.logowanie(driver);
//		ZakupyUtil.przekierowanieNaWomen(driver);
//		ZakupyUtil.wybranieRozmiaruL(driver);
//		ZakupyUtil.waitForAjax(driver);
//		ZakupyUtil.wybranieProduktu(driver);
//		ZakupyUtil.waitForAjax(driver);
//		ZakupyUtil.dodanieDoKoszyka(driver);
//		ZakupyUtil.waitForAjax(driver);
//		ZakupyUtil.finalizacjaZakupow(driver);
//        ZakupyUtil.klikniecieDrugiejSztukiProduktu(driver);
//        ZakupyUtil.liczbaProduktowWKoszyku(driver);
//        ZakupyUtil.cenaProduktuPierwszegoWKoszyku(driver);
//        
//        assertEquals(ZakupyUtil.sumaProduktowWKoszyku(driver), ZakupyUtil.liczbaProduktowWKoszyku(driver)*ZakupyUtil.cenaJednegoProduktu(driver),2);
//	}
	
	@Test
	public void sprawdzenieCzySortowaniePoNajnizszejCenieWSekcjiWomenDzialaPoprawnie() {
		ZakupyUtil.klikniecieLogowanie(driver);
		ZakupyUtil.logowanie(driver);
		ZakupyUtil.przekierowanieNaWomen(driver);
		ZakupyUtil.ustawComboNaLowestFirst(driver);
		ZakupyUtil.waitForAjax(driver);
		ZakupyUtil.wybranieProduktu2(driver);
	
		assertEquals("Printed Chiffon Dress", ZakupyUtil.printedChiffonDress(driver));
	
	}
	


//	@After
//	public void close() {
//		driver.quit();
//
//	}

}
