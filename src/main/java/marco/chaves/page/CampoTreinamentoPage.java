package marco.chaves.page;

import marco.chaves.core.BasePage;
import marco.chaves.core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CampoTreinamentoPage extends BasePage {

    public CampoTreinamentoPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }


    public static boolean isRadioMarcado(String sexo) {
        return true;
    }

    public static boolean isCheckMarcado(String carne) {
        return true;
    }
    public void setNome(String nome) {
        dsl.escrever("elementosForm:nome", nome);
    }

    public static String getName() {
        return dsl.obterValorCampo("elementosForm:nome");
    }

    public static void setSugestoes(String texto) {
        dsl.escrever(By.id("elementosForm:sugestoes"), texto);
    }

    public static String getSugestoes() {
        return dsl.obterValorCampo("elementosForm:sugestoes");
    }

    public static void clicarRadio1(String sexo) {
        dsl.clicarRadio("elementosForm:sexo:0");
    }

    public static void selecionarComida(String comida) {

        String id = switch (comida.toLowerCase()) {
            case "carne" -> "elementosForm:comidaFavorita:0";
            case "frango" -> "elementosForm:comidaFavorita:1";
            case "pizza" -> "elementosForm:comidaFavorita:2";
            case "vegetariano" -> "elementosForm:comidaFavorita:3";
            default -> throw new IllegalArgumentException("Comida inválida: " + comida);
        };

        dsl.clicarCheckbox(By.id(id));
    }

    public static void selecionarEscolaridade(String texto) {
        Select combo = new Select(escolaridade);
        combo.selectByVisibleText(texto);
    }

    @FindBy(id = "elementosForm:escolaridade")
    private static WebElement escolaridade;

    public static String EscolaridadeSelecionada() {
        Select combo = new Select(escolaridade);
        return combo.getFirstSelectedOption().getText();
    }

}
