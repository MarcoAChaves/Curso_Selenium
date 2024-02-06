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
    private CampoTreinamentoPage page;

    @Before
    public void inicializa(){
        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL(driver);
        page = new CampoTreinamentoPage(driver);
    }

    @After
    public void finaliza(){
        driver.quit();
    }

    @Test
    public void deveRealizarCadastroComSucesso(){
        page.setName("Wagner");
        page.setSobrenome("Costa");
        page.setSexoMasculino();
        page.setComidaPizza();
        page.setEscolaridade("Mestrado");
        page.setEsporte("Natacao");
        page.cadastrar();

        Assert.assertEquals("Cadastrado!",page.obterResultadoCadastro());
        Assert.assertEquals("Wagner", page.obterNomeCadastro());
        Assert.assertEquals("Costa", page.obterSobrenomeCadastro());
        Assert.assertEquals("Masculino", page.obterSexoCadastro());
        Assert.assertEquals("Pizza", page.obterComidaCadastro());
        Assert.assertEquals("mestrado", page.obterEscolaridadeCadastro());
        Assert.assertEquals("Natacao", page.obterEsportesCadastro());
    }

    @Test
    public void deveValidarNomeObrigatorio(){
        page.cadastrar();
        Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
    }

    @Test
    public void deveValidarSobrenomeObrigatorio(){
        page.setName("Nome Qualquer");
        page.cadastrar();
        Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
    }

    @Test
    public void deveValidarSexoObrigatorio(){
        page.setName("Nome Qualquer");
        page.setSobrenome( "Sobrenome qualquer");
        page.cadastrar();
        Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
    }

    @Test
    public void deveValidarComidaVegetariana(){
        page.setName("Nome qualquer");
        page.setSobrenome("Sobrenome qualquer");
        page.setSexoFeminino();
        page.setComidaCarne();
        page.setComidaVegetariano();
        page.cadastrar();
        Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
    }

    @Test
    public void deveValidarEsportistaIndeciso(){
        page.setName("Nome qualquer");
        page.setSobrenome("Sobrenome qualquer");
        page.setSexoFeminino();
        page.setComidaCarne();
        page.setEsporte("Karate", "O que eh esporte?");
        page.cadastrar();
        Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
    }
}
