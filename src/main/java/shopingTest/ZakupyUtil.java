package shopingTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZakupyUtil {

	public static boolean waitForAjax(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {

					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

		return wait.until(jQueryLoad) && wait.until(jsLoad);

	}

	public static void klikniecieLogowanie(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
		element.click();
	}

	public static void logowanie(WebDriver driver) {
		klikniecieLogowanie(driver);
		WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		email.sendKeys("b2bnetworkwarszawa@gmail.com");

		WebElement haslo = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
		haslo.sendKeys("n3tw0rk2017");
		WebElement submit = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span/i"));
		submit.click();
	}

	public static void przekierowanieNaWomen(WebDriver driver) {
		WebElement women = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
		women.click();
	}

	public static List<WebElement> pobranieElementowWlasciwosci(WebDriver driver) {
		WebElement Wlasciwosci = driver.findElement(By.xpath("//*[@id=\"ul_layered_id_feature_7\"]"));
		List<WebElement> wybor = Wlasciwosci.findElements(By.tagName("li"));
		return wybor;
	}

	public static void wybranieRozmiaruL(WebDriver driver) {
		WebElement s = driver.findElement(By.xpath("//*[@id=\"layered_id_attribute_group_3\"]"));
		s.click();

	}

	public static void wybranieProduktu(WebDriver driver, int nrObrazka) {
		WebElement openProduct = driver
				.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+nrObrazka+"]/div/div[1]/div/a[1]/img"));
		openProduct.click();
	}

	public static void dodanieDoKoszyka(WebDriver driver) {
		WebElement addToCart = driver
				.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button"));
		addToCart.click();
	}
	
	public static void finalizacjaZakupow(WebDriver driver) {
		WebElement proceedToCheckout = driver
				.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
		proceedToCheckout.click();
	}
	
	public static double sumaProduktowWKoszyku(WebDriver driver) {
		WebElement cenaProduktu = driver.findElement(By.xpath("//*[@id=\"total_product\"]"));
		String suma = cenaProduktu.getText();
		return Double.parseDouble(suma.substring(1));
	}
	
	public static double cenaProduktuPierwszegoWKoszyku(WebDriver driver) {
		WebElement sumaProduktowWKoszyku = driver.findElement(By.xpath("//*[@id=\"product_price_2_7_31337\"]/span"));
		String suma = sumaProduktowWKoszyku.getText();
		return Double.parseDouble(suma.substring(1));
	}
	
	public static double pobranieCeny (WebDriver driver) {
		WebElement tabela = driver.findElement(By.xpath("//*[@id=\"cart_summary\"]/tbody"));
//		tabela.findElements(By.tagName("tr"));
		List<WebElement> trs = tabela.findElements(By.tagName("tr"));
	    double suma = 0;
		for(WebElement tr: trs) {   //trs - kolekcja
			  List<WebElement> tds = tr.findElements(By.tagName("td"));
			  tds.get(5);
			  WebElement cena = tds.get(5);
			  String cenaString = cena.getText().substring(1);
			  suma = suma + Double.parseDouble(cenaString);
			  
		  
		  }
	    return suma;
	}
	
	public static void wybranieProduktu(WebDriver driver) {
		WebElement openProduct = driver
				.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img"));
		openProduct.click();
	}

	public static void klikniecieDrugiejSztukiProduktu(WebDriver driver) {
		WebElement addProduct = driver
				.findElement(By.xpath("//*[@id=\"cart_quantity_up_2_7_0_31337\"]/span"));
		addProduct.click();
	}
	
	public static int liczbaProduktowWKoszyku (WebDriver driver) {
		WebElement iloscSztuk = driver
				.findElement(By.xpath("//*[@id=\"product_2_7_0_31337\"]/td[5]/input[1]"));
		String text = iloscSztuk.getAttribute("value");
		return Integer.parseInt(text);
		
	}
	
	public static double cenaJednegoProduktu(WebDriver driver) {
		WebElement costOfOneProduct = driver
				.findElement(By.xpath("//*[@id=\"product_price_2_7_31337\"]/span"));
		String cena = costOfOneProduct.getText().substring(1);
		return Double.parseDouble(cena);
	}
	
	public static void ustawComboNaLowestFirst(WebDriver driver) {
		WebElement combo = driver.findElement(By.xpath("//*[@id=\"selectProductSort\"]"));
		Select listaRozwijana = new Select(combo);
		listaRozwijana.selectByVisibleText("Price: Lowest first");
		
	}
	
	public static void wybranieProduktu2(WebDriver driver) {
		WebElement openProduct = driver
				.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img"));
		openProduct.click();
	}
	
	public static String printedChiffonDress(WebDriver driver) {
		WebElement nazwa = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1"));
		String nazwa2 = nazwa.getText();
		return nazwa2;
		
		
				
	}
	
}
