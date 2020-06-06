package by.it.romanshpakovskiy.tasks.jd02_04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTestB {

    @Test
    void parseExpression() throws CalcException {
        Parser parser = new Parser();
        String expression = "{1.4,2.3,9.8}";
        String result = parser.parseExpression(expression).toString();
        String control = "{1.4, 2.3, 9.8}";
        assertEquals(result, control);
    }
}