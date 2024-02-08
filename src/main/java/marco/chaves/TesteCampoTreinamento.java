package marco.chaves;

import marco.chaves.core.DSL;
import marco.chaves.core.DriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static marco.chaves.core.DriverFactory.getDriver;


public class TesteCampoTreinamento {


    private DSL dsl;

    @Before
    public void inicializa() {
        //driver.get("C:\\Users\\MOCV\\Downloads\\campo_treinamento\\componentes.html");
        getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL();
    }

    @After
    public void finaliza() {
        DriverFactory.killDriver();
    }

    @Test
    public void testeTextField() {
        dsl.escrever("elementosForm:nome", "Teste de escrita");
        Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome"));
    }

    @Test
    public void deveInteragirComTextArea() {
        dsl.escrever("elementosForm:sugestoes", "teste");
        Assert.assertEquals("teste", getDriver().findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
    }

    @Test
    public void deveInteragirComRadioButton() {
        getDriver().findElement(By.id("elementosForm:sexo:0")).click();
        Assert.assertTrue(getDriver().findElement(By.id("elementosForm:sexo:0")).isSelected());
    }

    @Test
    public void deveInteragirComCheckBox() {
        dsl.clicarRadio("elementosForm:comidaFavorita:0");
        Assert.assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:0"));
    }

    @Test
    public void deveInteragirComCombo() {
        //WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        //Select combo = new Select(element);
        //combo.selectByIndex(2); - modo de busca por posição
        //combo.selectByValue("superior"); - modo de busca por valor
        //combo.selectByVisibleText("2o grau completo"); //modo de busca por valor visível
        dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
        Assert.assertEquals("2o grau completo", dsl.obterValorCombo("elementosForm:escolaridade"));
    }

    @Test
    public void deveVerificarValoresCombo() {
        WebElement element = getDriver().findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        Assert.assertEquals(8, options.size());

        boolean encontrou = false;
        for (WebElement option : options) {
            if (option.getText().equals("Mestrado")) {
                encontrou = true;
                break;
            }
        }
        Assert.assertTrue(encontrou);
    }

    @Test
    public void deveVerificarValoresComboMultiplo() {
        dsl.selecionarCombo("elementosForm:esportes", "Natacao");
        dsl.selecionarCombo("elementosForm:esportes", "Corrida");
        dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
        WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(3, allSelectedOptions.size());

        combo.deselectByVisibleText("Corrida");
        allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(2, allSelectedOptions.size());
    }

    @Test
    public void deveInteragirComBotoes() {
        dsl.clicarBotao("buttonSimple");
        WebElement botao = getDriver().findElement(By.id("buttonSimple"));
        Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
    }

    @Test
    public void deveInteragirComLinks() {
        dsl.clicarLink("Voltar");
        Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
    }

    @Test
    public void deveBuscarTextosNaPagina() {
        //Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
        Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));
    }

    @Test
    public void testJavascript() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        //js.executeScript("alert('Testando js via selenium')"); - interagindo com o alerta
        js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
        js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");

        WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
        js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");

    }

    @Test
    public void deveClicarBotaoTabela() {
        dsl.clicarBotaoTabela("Escolaridade", "Mestrado", "Radio", "elementosForm:tableUsuarios");
    }
}
