package by.it.romanshpakovskiy.tasks.jd02_04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTestB {

    @Test
    void parseExpression() throws CalcException {
        Parser parser = new Parser();
        String expression = "a={1.4,2.3,9.8}";
        String result = parser.calculateExpression(expression).toString();
        String control = "{1.4, 2.3, 9.8}";
        assertEquals(control, result);

        parser = new Parser();
        expression = "{1.4,2.3,9.8}";
        result = parser.calculateExpression(expression).toString();
        control = "{1.4, 2.3, 9.8}";
        assertEquals(control, result);

    }

    @Test
    void testVectorAdd() throws CalcException {
        Parser parser = new Parser();
        String expression = "{1.4,2.3,9.8}+1";
        String result = parser.calculateExpression(expression).toString();
        String control = "{2.4, 3.3, 10.8}";
        assertEquals(control, result);

        parser = new Parser();
        expression = "{1.4,2.3,9.8}+{1,2,3} ";
        result = parser.calculateExpression(expression).toString();
        control = "{2.4, 4.3, 12.8}";
        assertEquals(control, result);
    }

    @Test
    void testVectorSub() throws CalcException {
        Parser parser = new Parser();
        String expression = "{31.4,9.6,6.8}-3";
        String result = parser.calculateExpression(expression).toString();
        String control = "{28.4, 6.6, 3.8}";
        assertEquals(control, result);

        parser = new Parser();
        expression = "{1.5,2.5,9.9}-{1,2,3}";
        result = parser.calculateExpression(expression).toString();
        control = "{0.5, 0.5, 6.9}";
        assertEquals(control, result);
    }

    @Test
    void testVectorMul() throws CalcException {
        Parser parser = new Parser();
        String expression = "{1,2,9}*3";
        String result = parser.calculateExpression(expression).toString();
        String control = "{3.0, 6.0, 27.0}";
        assertEquals(result, control);

        parser = new Parser();
        expression = "{1,2,9}*{1,2,3}";
        result = parser.calculateExpression(expression).toString();
        control = "32.0";
        assertEquals(control, result);
    }

    @Test
    void testVectorDiv() throws CalcException {
        Parser parser = new Parser();
        String expression = "{6,15,9}/3";
        String result = parser.calculateExpression(expression).toString();
        String control = "{2.0, 5.0, 3.0}";
        assertEquals(result, control);
    }
}
