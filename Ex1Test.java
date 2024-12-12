
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
        @Test
        void computeNumberTest() {
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);
            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

        @Test
        void isBasisNumberTest() {

            String[] good = {"1bA", "1b2", "01b2", "123bA", "ABbG", "0bA"};
            for(int i=0;i<good.length;i=i+1) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }
        @Test
        void int2NumberTest() {
            assertEquals("0b2", Ex1.int2Number(0, 2));
            assertEquals("1011b2", Ex1.int2Number(11, 2));
            assertEquals("7b8", Ex1.int2Number(7, 8));
            assertEquals("10bA", Ex1.int2Number(10, 10));
            assertEquals("FFbG", Ex1.int2Number(255, 16));
            assertEquals("", Ex1.int2Number(-1, 10));
            assertEquals("", Ex1.int2Number(10, 1));
        }
        @Test
        void maxIndexTest() {
            String[] numbers = {"101b2", "77b8", "1FFbG", "255b10"};
            assertEquals(2, Ex1.maxIndex(numbers));

            String[] numbersWithInvalid = {"101b2", "ZZbG", "1FFbG", null};
            assertEquals(2, Ex1.maxIndex(numbersWithInvalid));

            String[] numbersWithTies = {"FFbG", "255b10", "FFbG"};
            assertEquals(0, Ex1.maxIndex(numbersWithTies));
        }
        @Test
        void equalsTest() {
            assertTrue(Ex1.equals("101b2", "5bA"));
            assertTrue(Ex1.equals("FFbG", "255bA"));
            assertFalse(Ex1.equals("101b2", "6bA"));
            assertFalse(Ex1.equals("101b2", null));
            assertFalse(Ex1.equals(null, "5bA"));
            assertFalse(Ex1.equals(null, null));
        }
        @Test
        void extractBaseTest() {
            assertEquals(2, Ex1.extractBase("2"));
            assertEquals(10, Ex1.extractBase("A"));
            assertEquals(16, Ex1.extractBase("G"));
            assertEquals(-1, Ex1.extractBase("H"));
            assertEquals(-1, Ex1.extractBase(""));
            assertEquals(-1, Ex1.extractBase("10"));
        }
        @Test
        void number2IntTest() {
            assertEquals(11, Ex1.number2Int("1011b2"));
            assertEquals(123, Ex1.number2Int("123bA"));
            assertEquals(-1, Ex1.number2Int("123bZ"));
            assertEquals(-1, Ex1.number2Int(""));
            assertEquals(-1, Ex1.number2Int(null));
        }
    }
