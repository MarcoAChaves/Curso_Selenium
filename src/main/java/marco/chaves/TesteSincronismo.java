package marco.chaves;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TesteSincronismo {

    private WebDriver driver;
    private DSL dsl;

    @Before
    public void inicializa() {
        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        //driver.get("C:\\Users\\MOCV\\Downloads\\campo_treinamento\\componentes.html");
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL(driver);
    }

    @After
    public void finaliza() {
        //driver.quit();
    }

    @Test
    public void deveutilizarEsperaFixa() throws InterruptedException {
        dsl.clicarBotao("buttonDelay");
        Thread.sleep(5000); //Modo basico de espera FIXA para a aplicação carregar
        dsl.escrever("novoCampo", "Deu Certo?");
    }

    @Test
    public void deveutilizarEsperaImplicita() throws InterruptedException {
        dsl.clicarBotao("buttonDelay");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Modo de espera IMPLICITA para a aplicação carregar.
        dsl.escrever("novoCampo", "Deu Certo?");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);//Desligando a espera 0 para não "impactar" o teste.
    }

    @Test
    public void deveUtilizarEsperaExplicita()throws InterruptedException {
        dsl.clicarBotao("buttonDelay");
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
        dsl.escrever("novoCampo", "Deu Certo?");
    }
}
