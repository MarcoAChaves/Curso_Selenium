package marco.chaves.test.java;

import marco.chaves.core.DriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class TesteRegraDeNegocio extends BaseTest {


    @Before
    public void inicializa() {
        DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    }

    @After
    public void finaliza() {
        DriverFactory.killDriver();
    }

    @Test
    public void deveValidarNomeObrigatorio() {
        DriverFactory.getDriver().findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = DriverFactory.getDriver().switchTo().alert();
        Assert.assertEquals("Nome eh obrigatorio", alert.getText());
    }

    @Test
    public void deveValidarSobrenomeObrigatorio() {
        DriverFactory.getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
        DriverFactory.getDriver().findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = DriverFactory.getDriver().switchTo().alert();
        Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
    }

    @Test
    public void deveValidarSexoObrigatorio() {
        DriverFactory.getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
        DriverFactory.getDriver().findElement(By.id("elementosForm:sobrenome")).sendKeys("Nome qualquer");
        DriverFactory.getDriver().findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = DriverFactory.getDriver().switchTo().alert();
        Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
    }

    @Test
    public void deveValidarComidaVegetariana() {
        DriverFactory.getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
        DriverFactory.getDriver().findElement(By.id("elementosForm:sobrenome")).sendKeys("Nome qualquer");
        DriverFactory.getDriver().findElement(By.id("elementosForm:sexo:1")).click();
        DriverFactory.getDriver().findElement(By.id("elementosForm:comidaFavorita:0")).click();
        DriverFactory.getDriver().findElement(By.id("elementosForm:comidaFavorita:3")).click();
        DriverFactory.getDriver().findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = DriverFactory.getDriver().switchTo().alert();
        Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
    }

    @Test
    public void deveValidarEsportistaIndeciso() {
        DriverFactory.getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
        DriverFactory.getDriver().findElement(By.id("elementosForm:sobrenome")).sendKeys("Nome qualquer");
        DriverFactory.getDriver().findElement(By.id("elementosForm:sexo:1")).click();
        DriverFactory.getDriver().findElement(By.id("elementosForm:comidaFavorita:0")).click();
        Select combo = new Select(DriverFactory.getDriver().findElement(By.id("elementosForm:esportes")));
        combo.selectByVisibleText("Karate");
        combo.selectByVisibleText("O que eh esporte?");
        DriverFactory.getDriver().findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = DriverFactory.getDriver().switchTo().alert();
        Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
    }
}
