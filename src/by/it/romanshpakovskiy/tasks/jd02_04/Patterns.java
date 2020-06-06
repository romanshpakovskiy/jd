package by.it.romanshpakovskiy.tasks.jd02_04;

public class Patterns {
    static final String Operation = "[-+/*=]";
    static final String Scalar = "-?[0-9]+\\.?[0-9]*";
    static final String Vector = "\\{((" + Scalar + "),?)+}";
    static final String Matrix = "\\{(" + Vector + ",?)+}";
}
