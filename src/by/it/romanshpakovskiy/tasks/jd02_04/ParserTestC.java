package by.it.romanshpakovskiy.tasks.jd02_04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTestC {
    @Test
    void parseExpression() throws CalcException {
        Parser parser = new Parser();
        String expression = "a={{1.4,2.3,9.8},{1,2,3}}";
        String result = parser.calculateExpression(expression).toString();
        String control = "{{1.4, 2.3, 9.8}, {1.0, 2.0, 3.0}}";
        assertEquals(control, result);

        parser = new Parser();
        expression = "{{1.4,2.3,9.8},{1.0,2.0,3.0}}";
        result = parser.calculateExpression(expression).toString();
        control = "{{1.4, 2.3, 9.8}, {1.0, 2.0, 3.0}}";
        assertEquals(control, result);
    }

    @Test
    void testAddMatrix() throws CalcException {
        Parser parser = new Parser();
        String expression = "{{1.4,2.3,9.8},{1,2,3}}+{{1,2,3},{5,6,7}}";
        String result = parser.calculateExpression(expression).toString();
        String control = "{{2.4, 4.3, 12.8}, {6.0, 8.0, 10.0}}";
        assertEquals(control, result);

        parser = new Parser();
        expression = "{{1.4,2.3,9.8},{1.0,2.0,3.0}}+10";
        result = parser.calculateExpression(expression).toString();
        control = "{{11.4, 12.3, 19.8}, {11.0, 12.0, 13.0}}";
        assertEquals(control, result);
    }

    @Test
    void testSubMatrix() throws CalcException {
        Parser parser = new Parser();
        String expression = "{{2.4,2.6,9.8},{1,2,3}}-2";
        String result = parser.calculateExpression(expression).toString();
        String control = "{{0.4, 0.6, 7.8}, {-1.0, 0.0, 8.0}}";
        assertEquals(control, result);

        parser = new Parser();
        expression = "{{11.6,12.6,19.5},{11.4,12.7,13.2}}-{{2.4,5.3,3.8},{2.0,4.0,6.0}}";
        result = parser.calculateExpression(expression).toString();
        control = "{{9.2, 7.3, 16.5}, {9.4, 8.7, 7.2}}";
        assertEquals(control, result);
    }

    @Test
    void testMulMatrix() throws CalcException {
        Parser parser = new Parser();
        String expression = "{{2,3},{5,6}}*{{5,5},{6,6}}";
        String result = parser.calculateExpression(expression).toString();
        String control = "{{35.0, 45.0}, {42.0, 54.0}}";
        assertEquals(control, result);

        parser = new Parser();
        expression = "{{11,12,19},{8,4,3}}*{2,4,6}";
        result = parser.calculateExpression(expression).toString();
        control = "{184.0, 50.0}";
        assertEquals(control, result);
    }

    @Test
    void testDivMatrix() throws CalcException {
        Parser parser = new Parser();
        String expression = "{{2.4,2.6},{2,4}}/2";
        String result = parser.calculateExpression(expression).toString();
        String control = "{{1.2, 1.3}, {1.0, 2.0}}";
        assertEquals(control, result);
    }
}
