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
    }

    @Test
    void testVectorAdd() throws CalcException {
        Parser parser = new Parser();
        String expression = "{1.4,2.3,9.8} + 1";
        String result = parser.calculateExpression(expression).toString();
        String control = "{2.4, 3.3, 10.8}";
        assertEquals(control, result);
    }

    @Test
    void parseExpress() throws CalcException {
        Parser parser = new Parser();
        String expression = "{1.4,2.3,9.8}";
        String result = parser.calculateExpression(expression).toString();
        String control = "{1.4, 2.3, 9.8}";
        assertEquals(result, control);
    }

    @Test
    void parseExpressio() throws CalcException {
        Parser parser = new Parser();
        String expression = "{1.4,2.3,9.8}";
        String result = parser.calculateExpression(expression).toString();
        String control = "{1.4, 2.3, 9.8}";
        assertEquals(result, control);
    }
}
