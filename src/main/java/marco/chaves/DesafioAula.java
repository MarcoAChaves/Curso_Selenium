package marco.chaves;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafioAula {

    private WebDriver driver;
    private DSL dsl;

    @Before
    public void inicializa() {
        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL(driver);
    }
    @After
    public void finaliza(){
        driver.quit();
    }

    @Test
    public void desafioCadastro() {

        dsl.escreve("elementosForm:nome","Marco");
        dsl.escreve("elementosForm:sobrenome","Chaves");
        dsl.clicarRadio("elementosForm:sexo:0");
        dsl.clicarRadio("elementosForm:comidaFavorita:0");
        dsl.selecionarCombo("elementosForm:escolaridade","Mestrado");
        dsl.selecionarCombo("elementosForm:esportes", "Corrida");
        dsl.clicarBotao("elementosForm:cadastrar");

        Assert.assertTrue(dsl.obterTexto("resultado").startsWith("Cadastrado!"));
        Assert.assertTrue(dsl.obterTexto("descNome").endsWith("Marco"));
        Assert.assertEquals("Sobrenome: Chaves", dsl.obterTexto("descSobrenome"));
        Assert.assertEquals("Sexo: Masculino", dsl.obterTexto("descSexo"));
        Assert.assertEquals("Comida: Carne", dsl.obterTexto("descComida"));
        Assert.assertEquals("Escolaridade: mestrado",dsl.obterTexto("descEscolaridade"));
        Assert.assertEquals("Esportes: Corrida", dsl.obterTexto("descEsportes"));

   }
}
