package marco.chaves.suites;

import marco.chaves.test.DesafioAula;
import marco.chaves.test.TesteRegraDeNegocio;
import marco.chaves.test.TesteRegrasCadastro;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DesafioAula.class,
        TesteRegrasCadastro.class,
        TesteRegraDeNegocio.class
})
public class SuiteTeste {
}
