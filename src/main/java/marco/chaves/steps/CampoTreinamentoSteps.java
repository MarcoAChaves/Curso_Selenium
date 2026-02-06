package marco.chaves.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import marco.chaves.page.CampoTreinamentoPage;
import org.junit.Assert;

public class CampoTreinamentoSteps {

    private CampoTreinamentoPage page = new CampoTreinamentoPage();

    @When("o usuario preenche o campo Nome com {string}")
    public void preencherCampoNome(String texto) {
        page.setNome(texto);
    }

    @Then("o campo Nome deve conter o valor {string}")
    public void validarCampoNome(String valorEsperado) {
        Assert.assertEquals(valorEsperado, page.getNome());
    }
}
