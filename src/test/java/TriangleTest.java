
import ch.qos.logback.classic.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.*;


public class TriangleTest {

    private static Logger logger = (Logger) LoggerFactory.getLogger(TriangleTest.class);

    @Test
    @DisplayName("Check Exception")
    void testException() {
        logger.debug("INFO");
        assertThatExceptionOfType(ExceptionForMinus.class).isThrownBy(()
                -> AreaTriangle.GetAreaTriangle(0, 0, 0));

    }

    @Test
    @DisplayName("Positive test for GetAreaTriangle")
    void testPositive() throws ExceptionForMinus {
        logger.debug("INFO");
        assertThat(AreaTriangle.GetAreaTriangle(8, 6, 4)).isPositive();
    }

    @Test
    void testForResult() throws ExceptionForMinus {
        logger.debug("INFO");
        int result = AreaTriangle.GetAreaTriangle(4, 7, 2);
        Assertions.assertEquals(result, 48);
    }

    @Test
    @DisplayName("Check Exception for Minus")
    void testExceptionForMinus() throws ExceptionForMinus {
        logger.debug("FAILED TEST");
        assertThat(AreaTriangle.GetAreaTriangle(-8, -6, -4)).isNegative();

    }
}


