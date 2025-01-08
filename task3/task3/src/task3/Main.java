package task3;

public class Main {
    public static void main(String[] args) {
        // Create handlers for different log levels
        LogHandler infoHandler = new InfoHandler();
        LogHandler debugHandler = new DebugHandler();
        LogHandler errorHandler = new ErrorHandler();
        // Set up the chain of responsibility
        infoHandler.setNextHandler(debugHandler);
        debugHandler.setNextHandler(errorHandler);
        // Create commands for each handler
        Command infoCommand = new LogCommand(infoHandler);
        Command debugCommand = new LogCommand(debugHandler);
        Command errorCommand = new LogCommand(errorHandler);
        // Create logger and add commands
        Logger logger = new Logger();
        logger.addCommand(infoCommand);
        logger.addCommand(debugCommand);
        logger.addCommand(errorCommand);
        // Process commands to demonstrate logging system
        System.out.println("Processing INFO level messages:");
        logger.processCommands();
        System.out.println("\nProcessing DEBUG level messages:");
        logger.processCommands();
        System.out.println("\nProcessing ERROR level messages:");
        logger.processCommands();
    }
 }