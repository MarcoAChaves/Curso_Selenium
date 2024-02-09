package marco.chaves.core;

import org.junit.After;

import static marco.chaves.core.DriverFactory.killDriver;

public class BaseTest {

        @After
        public void finaliza(){
            if (Propriedades.FECHAR_BROWSER){
                killDriver();
            }
        }
    }

