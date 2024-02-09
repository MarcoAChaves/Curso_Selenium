package marco.chaves.test;

import marco.chaves.core.DSL;
import marco.chaves.core.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TesteSincronismo {

    private DSL dsl;

    @Before
    public void inicializa() {
        DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL();
    }

    @After
    public void finaliza() {
        DriverFactory.killDriver();
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
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Modo de espera IMPLICITA para a aplicação carregar.
        dsl.escrever("novoCampo", "Deu Certo?");
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);//Desligando a espera 0 para não "impactar" o teste.
    }

    @Test
    public void deveUtilizarEsperaExplicita() throws InterruptedException {
        dsl.clicarBotao("buttonDelay");
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
        dsl.escrever("novoCampo", "Deu Certo?");
    }
}
