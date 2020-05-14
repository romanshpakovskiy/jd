package by.it.romanshpakovskiy.tasks.jd01_09;

public class Patterns {
    static final String Operation = "[-+/*]";
    static final String Scalar = "-?[0-9]+\\.?[0-9]*";
    static final String Vector = "\\{((-?[0-9]+\\.?[0-9]*),?)+}";
    static final String Matrix = "\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+},?)+}";
}
