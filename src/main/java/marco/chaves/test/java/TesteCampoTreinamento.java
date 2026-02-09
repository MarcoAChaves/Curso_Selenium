package marco.chaves.test.java;

import marco.chaves.utils.ActionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.List;

import static org.openqa.selenium.By.id;


public class TesteCampoTreinamento extends BaseTest {

    @Test
    public void testeTextField() {

        ActionUtils.type(driver,
                id("elementosForm:nome"),
                "Teste de escrita",
                "Preencheu campo Nome");

        Assert.assertEquals("Teste de escrita",
                ActionUtils.getValue(driver,
                        id("elementosForm:nome"),
                        "Validou valor do campo Nome"));
    }

    @Test
    public void deveInteragirComTextArea() {

        ActionUtils.type(driver,
                id("elementosForm:sugestoes"),
                "teste",
                "Preencher o campo Sugestões");

        ActionUtils.getValue(driver,
                id("elementosForm:sugestoes"),
                "Campo preenchido"
        );
    }

    @Test
    public void deveInteragirComRadioButton() {

        // Clica no radio Masculino
        ActionUtils.click(driver,
                By.id("elementosForm:sexo:0"),
                "Selecionou sexo Masculino");

        // Valida se está selecionado
        boolean selecionado = ActionUtils.isSelected(driver,
                By.id("elementosForm:sexo:0"),
                "Validou radio Masculino selecionado");

        Assert.assertTrue(selecionado);
    }

    @Test
    public void deveInteragirComCheckBox() {
        // Clica no checkbox Carne
        ActionUtils.click(driver,
                By.id("elementosForm:comidaFavorita:0"),
                "Selecionou comida favorita");

        // Valida se está selecionado
        boolean selecionado1 = ActionUtils.isSelected(driver,
                By.id("elementosForm:comidaFavorita:0"),
                "Validou checkbox selecionado");

        Assert.assertTrue(selecionado1);
    }

    @Test
    public void deveInteragirComCombo() {
        ActionUtils.selectByVisibleText(driver,
                By.id("elementosForm:escolaridade"),
                "Superior",
                "Selecionou escolaridade Superior");

        String valorSelecionado = ActionUtils.getSelectedOption(driver,
                By.id("elementosForm:escolaridade"),
                "Validou escolaridade selecionada");

        Assert.assertEquals("Superior", valorSelecionado);
    }

    @Test
    public void deveVerificarValoresCombo() {

        ActionUtils.click(driver,
                By.id("elementosForm:escolaridade"),
                "abre o combo"
        );

        List<String> opcoes = ActionUtils.getAllOptionsFromCombo(
                driver,
                By.id("elementosForm:escolaridade"),
                "Listou opções do combo Escolaridade"
        );

        // Exibe no console (opcional)
        System.out.println(opcoes);

        // Valida tamanho
        Assert.assertEquals(8, opcoes.size());

        // Valida conteúdo
        Assert.assertTrue(opcoes.contains("1o grau incompleto"));
        Assert.assertTrue(opcoes.contains("1o grau completo"));
        Assert.assertTrue(opcoes.contains("2o grau incompleto"));
        Assert.assertTrue(opcoes.contains("2o grau completo"));
        Assert.assertTrue(opcoes.contains("Superior"));
        Assert.assertTrue(opcoes.contains("Especializacao"));
        Assert.assertTrue(opcoes.contains("Mestrado"));
        Assert.assertTrue(opcoes.contains("Doutorado"));
    }
}

