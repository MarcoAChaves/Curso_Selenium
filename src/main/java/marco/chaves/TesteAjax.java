package marco.chaves;

import marco.chaves.core.DSL;
import marco.chaves.core.DriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static marco.chaves.core.DriverFactory.getDriver;

public class TesteAjax {
    
    private DSL dsl;

    @Before
    public void inicializa() {
         getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=dd0f1");
        dsl = new DSL();
    }

    @After
    public void finaliza() {
        DriverFactory.killDriver();
    }

    @Test
    public void tesdteAjax(){
        dsl.escrever("j_id_8y:name", "Teste");
        dsl.clicarBotao("j_id_8y:j_id_94");
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_id_8y:display")));
        Assert.assertEquals("Teste", dsl.obterTexto("j_id_8y:display"));

    }

}
