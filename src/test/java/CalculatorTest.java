import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

@Test
void shouldAddTwoNumbers() {
Calculator calc = new Calculator();
int resulst = calc.add(2, 3);
assertEquals(5, result);

}

}