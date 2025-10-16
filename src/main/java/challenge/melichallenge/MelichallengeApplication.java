package challenge.melichallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class MelichallengeApplication {
 private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";

    private static final String[] VALID_SOURCES = {"JSON", "CSV", "DATABASE"};

    public static void main(String[] args) {

        // Creamos el contexto parcialmente para leer application.properties
    	ConfigurableApplicationContext builder = new SpringApplicationBuilder(MelichallengeApplication.class)
                .properties("spring.main.web-application-type=none") // no arranca web todavía
                .run(args);

        ConfigurableEnvironment env = builder.getEnvironment();
        String datasourceType = env.getProperty("datasource.type", "").trim().toUpperCase();

        if (datasourceType.isEmpty()) {
            printError("No se especificó el tipo de fuente de datos (datasource.type)");
            printValidOptions();
            System.exit(1);
        }

        boolean valid = false;
        for (String option : VALID_SOURCES) {
            if (option.equals(datasourceType)) {
                valid = true;
                break;
            }
        }

        if (!valid) {
            printError("Tipo de datasource inválido: '" + datasourceType + "'");
            printValidOptions();
            System.exit(1);
        }

        // Cerramos el contexto temporal
        builder.close();

        System.out.println(GREEN + "\n───────────────────────────────────────────────");
        System.out.println("   Iniciando aplicación con datasource: " + CYAN + datasourceType);
        System.out.println(GREEN + "───────────────────────────────────────────────" + RESET);

        // Ahora sí arrancamos normalmente
        SpringApplication.run(MelichallengeApplication.class, args);
    }

    private static void printError(String message) {
        System.out.println(RED + "\n✖ ERROR: " + message + RESET);
    }

    private static void printValidOptions() {
        System.out.println(YELLOW + "\n────────────────────────────────────────────────");
        System.out.println("           OPCIONES DISPONIBLES");
        System.out.println("────────────────────────────────────────────────");
        System.out.println("Solo se permiten las siguientes fuentes de datos:\n");
        System.out.println("    - JSON");
        System.out.println("    - CSV");
        System.out.println("    - DATABASE");
        System.out.println("\nPor favor, seleccione una de las opciones válidas.");
        System.out.println("────────────────────────────────────────────────\n" + RESET);
    }
}