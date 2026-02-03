package marco.chaves.test.java;

import marco.chaves.test.java.BaseTest;
import marco.chaves.core.DSL;
import marco.chaves.core.DriverFactory;
import marco.chaves.page.CampoTreinamentoPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)

public class TesteRegrasCadastro extends BaseTest {

    private DSL dsl;
    private CampoTreinamentoPage page;

    @Parameterized.Parameter
    public String nome;

    @Parameterized.Parameter(value = 1)
    public String sobrenome;

    @Parameterized.Parameter(value = 2)
    public String sexo;

    @Parameterized.Parameter(value = 3)
    public List<String> comidas;

    @Parameterized.Parameter(value = 4)
    public String[] esportes;

    @Parameterized.Parameter(value = 5)
    public String msg;

    @Before
    public void inicializa() {
        DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL();
        page = new CampoTreinamentoPage();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getCollection() {
        return Arrays.asList(new Object[][] {
                {"", "", "", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
                {"Wagner", "", "", Arrays.asList(), new String[]{}, "Sobrenome eh obrigatorio"},
                {"Wagner", "Costa", "", Arrays.asList(), new String[]{}, "Sexo eh obrigatorio"},
                {"Wagner", "Costa", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String[]{}, "Tem certeza que voce eh vegetariano?"},
                {"Wagner", "Costa", "Masculino", Arrays.asList("Carne"), new String[]{"Karate", "O que eh esporte?"}, "Voce faz esporte ou nao?"}});
    }

    @Test
    public void deveValidarRegras() {
        page.setNome(nome);
        page.setSobrenome(sobrenome);
        if(sexo.equals("Masculino")) {
            page.setSexoMasculino();
        }
        if(sexo.equals("Feminino")) {
            page.setSexoFeminino();
        }
        if(comidas.contains("Carne")) page.setComidaCarne();
        if(comidas.contains("Pizza")) page.setComidaPizza();
        if(comidas.contains("Vegetariano")) page.setComidaVegetariano();
        page.setEsporte(esportes);
        page.cadastrar();
        System.out.println(msg);
        Assert.assertEquals(msg, dsl.alertaObterTextoEAceita());
    }
}
