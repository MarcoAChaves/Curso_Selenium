package marco.chaves.suites;

import marco.chaves.core.DriverFactory;
import marco.chaves.test.DesafioAula;
import marco.chaves.test.TesteRegrasCadastro;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DesafioAula.class,
        TesteRegrasCadastro.class
})
public class SuiteTeste {

    @AfterClass
    public static void finalizaTudo() {
        DriverFactory.killDriver();

    }
}
