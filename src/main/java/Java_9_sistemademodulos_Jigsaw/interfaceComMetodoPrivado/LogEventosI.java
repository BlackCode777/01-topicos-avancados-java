package Java_9_sistemademodulos_Jigsaw.interfaceComMetodoPrivado;

public interface LogEventosI{

    default void logInfo(String mensagem){
        log(mensagem, "INFO");
    }

    default void logErro(String mensagem){
        log(mensagem, "ERRO");
    }

    default void logWarn(String mensagem){
        log(mensagem, "WARN");
    }

    default void logFatal(String mensagem){
        log(mensagem, "FATAL");
    }

    // new feature in Java 9: private methods in interfaces
    private void log(String mensagem, String tipo){
        System.out.println("Início do log");
        System.out.println("[" + tipo + "] - " + mensagem);
        System.out.println("Fim do log");
    }

}
