package marco.chaves.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import marco.chaves.page.CampoTreinamentoPage;
import marco.chaves.utils.ScreenshotUtils;
import marco.chaves.utils.StepLogger;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CampoTreinamentoSteps {

    private CampoTreinamentoPage page = new CampoTreinamentoPage();

    @When("o usuario preenche o campo Nome com {string}")
    public void preencherCampoNome(String texto) {
        page.setNome(texto);

        String screenshot = ScreenshotUtils.takeScreenshot("Preencher_nome");

        StepLogger.logStep(
                "Preencher campo Nome com valor: " + texto,
                "PASS",
                screenshot
        );
    }

    @Then("o campo Nome deve conter o valor {string}")
    public void validarCampoNome(String texto) {
        assertEquals(texto, CampoTreinamentoPage.getName());

        String screenshot = ScreenshotUtils.takeScreenshot("Validar_nome");

        StepLogger.logStep(
                "Validar campo Nome",
                "PASS",
                screenshot
        );
    }


    @When("o usuario preenche o campo Sugestoes com {string}")
    public void preencherSugestoes(String texto) {
        CampoTreinamentoPage.setSugestoes(texto);
    }

    @Then("o campo Sugestoes deve conter o valor {string}")
    public void validarSugestoes(String texto) {
        assertEquals(texto, CampoTreinamentoPage.getSugestoes());
    }

    @When("o usuario seleciona o sexo {string}")
    public void selecionarSexo(String sexo) {
        CampoTreinamentoPage.clicarRadio1(sexo);


    }

    @Then("o sexo {string} deve estar selecionado")
    public void validarSexo(String sexo) {
        assertTrue(CampoTreinamentoPage.isRadioMarcado(sexo));
    }

    @When("o usuario seleciona a comida favorita {string}")
    public void selecionoComida(String Comida) {
        CampoTreinamentoPage.selecionarComida(Comida);
    }

    @Then("a comida favorita {string} deve estar selecionado")
    public void isRadioMarcado2(String carne) {
        assertTrue(CampoTreinamentoPage.isCheckMarcado(carne));
    }

    @When("seleciono a escolaridade {string}")
    public void selecionoAEscolaridade(String escolaridade) {
        CampoTreinamentoPage.selecionarEscolaridade(escolaridade);
    }

    @Then("a escolaridade selecionada deve ser {string}")
    public void EscolaridadeSelecionada(String esperado) {
        System.out.println("🚀 ENTREI NO THEN");
        String atual = CampoTreinamentoPage.EscolaridadeSelecionada();
        Assert.assertEquals(esperado, atual);
    }
}
