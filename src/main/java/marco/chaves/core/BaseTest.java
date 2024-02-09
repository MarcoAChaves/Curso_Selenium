package marco.chaves.core;

import org.junit.After;

import static marco.chaves.core.DriverFactory.killDriver;

public class BaseTest {
    public static class BasePage {
        @After
        public void finaliza(){
            killDriver();
        }
    }
}
