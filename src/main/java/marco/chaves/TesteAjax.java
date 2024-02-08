package marco.chaves;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

public class TesteAjax {

    private WebDriver driver;
    private DSL dsl;

    @Before
    public void inicializa() {
        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        //driver.get("C:\\Users\\MOCV\\Downloads\\campo_treinamento\\componentes.html");
        driver.get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=dd0f1");
        dsl = new DSL(driver);
    }

    @After
    public void finaliza() {
        //driver.quit();
    }

    @Test
    public void tesdteAjax(){
        dsl.escrever("j_id_8y:name", "Teste");
        dsl.clicarBotao("j_id_8y:j_id_94");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_id_8y:display")));
        Assert.assertEquals("Teste", dsl.obterTexto("j_id_8y:display"));

    }

}
