package exceptions;

// borramos el 'Runtime' para hacer la excepción verificada
public class CalcBasicaException extends Exception {
    public CalcBasicaException(String message) {
        super(message);
    }
}
