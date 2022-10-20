package DZ4;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static DZ4.AreaOfTriangle.isAreaOfTriangle;

public class AreaOfTriangleTest {

    @BeforeAll
    static void beforeAll() {
        logger.info("TEST STARTED");
    }

//    @BeforeEach
//    static void beforeEach() {
//        logger.error("567");
//
//    }

    private static Logger logger = LoggerFactory.getLogger(AreaOfTriangleTest.class);
    @ParameterizedTest
    @CsvSource({"2, 2, 3, 1.9843", "2, 3, 4, 2.90473", "5,6,7,14.69693"})
    void areaOfTriangleTest(double testA, double testB, double testC, double expectedS) throws Exception {
        Assertions.assertEquals(expectedS, new AreaOfTriangle().isAreaOfTriangle(testA, testB, testC), 0.0001);
    }


    @ParameterizedTest
    @CsvSource({"-1,9,9", "1,-2,3", "1,2,-3"})
    void negativeTest1(double testA, double testB, double testC) {
        Assertions.assertThrows(Exception.class, () -> isAreaOfTriangle(testA, testB, testC));
    }

    @ParameterizedTest
    @CsvSource({"1,2,3","4,8,4","5,4,9"})
    void negativeTest2(double testA, double testB, double testC) {
        Assertions.assertThrows(Exception.class, () -> isAreaOfTriangle(testA,testB,testC));
    }
}
