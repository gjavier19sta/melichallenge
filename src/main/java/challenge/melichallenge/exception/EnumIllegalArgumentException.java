package challenge.melichallenge.exception;

public class EnumIllegalArgumentException extends RuntimeException{
    public EnumIllegalArgumentException(String message){
        super(message);
        System.out.println("""
    ────────────────────────────────────────────────
                OPCIONES DISPONIBLES
    ────────────────────────────────────────────────
    
    Solo se permiten las siguientes fuentes de datos:
    
        - JSON
        - CSV
        - DATABASE
    
    Por favor, seleccione una de las opciones válidas.
    ────────────────────────────────────────────────
    """);
    }
}
