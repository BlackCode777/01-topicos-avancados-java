package Java_9_sistemademodulos_Jigsaw.interfaceComMetodoPrivado;

public class TesteEventos{

    public static void main(String[] args) {
        LogEventosI logger = new LogEventosI() {};
        logger.logInfo("Este é um log de informação.");
        logger.logErro("Este é um log de erro.");
        logger.logWarn("Este é um log de aviso.");
        logger.logFatal("Este é um log fatal.");
    }

}
