package by.it.romanshpakovskiy.tasks.jd02_04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTestA {

    @Test
    void parseScalar() throws CalcException {
        Parser parser = new Parser();
        String expression = "2.324";
        String result = parser.calculateExpression(expression).toString();
        String control = "2.324";
        assertEquals(result, control);
    }

    @Test
    void parseScalarAdd() throws CalcException {
        Parser parser = new Parser();
        String expression = "2+3.4";
        String result = parser.calculateExpression(expression).toString();
        String control = "5.4";
        assertEquals(result, control);
    }

    @Test
    void parseScalarSub() throws CalcException {
        Parser parser = new Parser();
        String expression = "2-3.4";
        String result = parser.calculateExpression(expression).toString();
        String control = "-1.4";
        assertEquals(result, control);
    }

    @Test
    void parseScalarMul() throws CalcException {
        Parser parser = new Parser();
        String expression = "2*3.4";
        String result = parser.calculateExpression(expression).toString();
        String control = "6.8";
        assertEquals(result, control);
    }

    @Test
    void parseScalarDiv() throws CalcException {
        Parser parser = new Parser();
        String expression = "24/3";
        String result = parser.calculateExpression(expression).toString();
        String control = "8.0";
        assertEquals(result, control);
    }
}