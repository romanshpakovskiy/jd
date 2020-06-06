package by.it.romanshpakovskiy.tasks.jd02_04;

public class CalcException extends Exception {
    public CalcException(){
        super();
    }

    public CalcException(String message){
        super("Exception: " + message);
    }

    public CalcException(Throwable cause){
        super(cause);
    }

    public CalcException(String message, Throwable cause){
        super("Exception: " + message, cause);
    }
}
