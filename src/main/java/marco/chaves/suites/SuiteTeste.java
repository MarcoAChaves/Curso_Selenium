package marco.chaves.suites;

import marco.chaves.core.DriverFactory;
import marco.chaves.test.java.BaseTest;
import marco.chaves.test.java.DesafioAula;
import marco.chaves.test.java.TesteCampoTreinamento;
import marco.chaves.test.java.TesteRegrasCadastro;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DesafioAula.class,
        TesteRegrasCadastro.class,
        TesteRegrasCadastro.class,
        TesteCampoTreinamento.class
})
public class SuiteTeste extends BaseTest {

    @AfterClass
    public static void finalizaTudo() {
        DriverFactory.killDriver();

    }
}
