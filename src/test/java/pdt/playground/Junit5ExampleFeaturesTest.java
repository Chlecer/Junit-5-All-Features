package pdt.playground;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Junit5ExampleFeaturesTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before ALL");
    }

    @BeforeEach
    void beforeEach(TestInfo testInfo) {
        System.out.println("Initialize test data for " + testInfo.getDisplayName());
    }

    @AfterEach
    void afterEach(TestInfo testInfo) {
        System.out.println("Clean up test data for " + testInfo.getDisplayName());
    }

    @Test
    @DisplayName("Test first test")
    void test() {
        //fail("Not yet implemented");
    }

    @Test
    @DisplayName("Testing null point exception")
    void testThrows() {
        String str = null;
        assertThrows(NullPointerException.class, () -> {str.length();});
    }

    @ParameterizedTest
    @ValueSource(strings={"ADF", "sass", "w"})
    void parameterizedTest(String str){
        assertTrue(str.length() > 0);
    }

    @ParameterizedTest(name="Word {0} have {1} letters")
    @CsvSource(value={"ADF, 3", "sass, 4"})
    void parameterizedTestActualExpected(String word, int expectedLength){
        assertEquals(expectedLength, word.length());
    }

    @DisplayName("Testing will be execute n times, great for thread or assync code")
    @RepeatedTest(10)
    void repeatTest() {
        String str = null;
        assertThrows(NullPointerException.class, () -> {str.length();});
    }

    @Test
    void performanceTest(){
        assertTimeout(Duration.ofSeconds(10), () ->{System.out.println("Call the code here");});
    }

    @Test
    @Disabled
    public void exampleOfDisabledTest() {
        fail("Disabled test");
    }

}
