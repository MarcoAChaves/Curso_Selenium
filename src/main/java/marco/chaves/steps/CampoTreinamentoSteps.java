package marco.chaves.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import marco.chaves.page.CampoTreinamentoPage;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CampoTreinamentoSteps {

    private CampoTreinamentoPage page = new CampoTreinamentoPage();

    @When("o usuario preenche o campo Nome com {string}")
    public void preencherCampoNome(String texto) {
        page.setNome(texto);
    }

    @Then("o campo Nome deve conter o valor {string}")
    public void validarCampoNome(String texto) {
        assertEquals(texto, CampoTreinamentoPage.getName());
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
    public void isRadioMarcado2(String carne){
        assertTrue(CampoTreinamentoPage.isCheckMarcado(carne));
    }

}
