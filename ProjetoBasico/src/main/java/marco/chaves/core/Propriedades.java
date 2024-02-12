package marco.chaves.core;

public class Propriedades {

    public static boolean FECHAR_BROWSER = false;
    // true - abre e fecha o browser a cada execução, almentando o tempo de teste.
    // false - abre o browser apenas uma vez, otimizando o tempo de execução

    public static Browsers browser = Browsers.CHROME;

    public enum Browsers {
        CHROME,
        FIREFOX
    }
}
