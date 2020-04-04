
/*********************************************************************************
* Lab5b: Github
*
* Description:
* This program is a repository on github
* 
*
* Author: Junjie Wang
* Date: <April 4, 2020>
*
* Input: N/A
* Output: N/A
*
* I pledge that I have completed the programming assignment independently.
* I have not copied the code from a student or any source.
* I have not given my code to any student.
*
* Sign here: Junjie Wang
********************************************************************************/
/*Clone from https://github.com/exercism/java/blob/master/exercises
  /perfect-numbers/src/test/java/NaturalNumberTest.java*/

//Hello from Junjie//

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.stream.IntStream;
import static org.junit.Assert.assertEquals;


enum Classification {

    DEFICIENT, PERFECT, ABUNDANT

}


class NaturalNumber {
	private final int naturalNumber;

    NaturalNumber(int naturalNumber) {
        if (naturalNumber <= 0) throw new IllegalStateException("Natural numbers are all positive.");
        this.naturalNumber = naturalNumber;
    }

    Classification getClassification() {
    	final int aliquotSum = computeAliquotSum();
        
    	if (aliquotSum == naturalNumber) {
            return Classification.PERFECT;
        } else if (aliquotSum > naturalNumber) {
            return Classification.ABUNDANT;
        } else {
            return Classification.DEFICIENT;
        }
    }

    private int computeAliquotSum() {
        return IntStream.range(1, naturalNumber)
                .filter(it -> naturalNumber % it == 0)
                .sum();
    }


}

public class NaturalNumberTest {
	
	
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testSmallPerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, new NaturalNumber(6).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    public void testMediumPerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, new NaturalNumber(28).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    public void testLargePerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, new NaturalNumber(33550336).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    public void testSmallAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, new NaturalNumber(12).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    public void testMediumAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, new NaturalNumber(30).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    public void testLargeAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, new NaturalNumber(33550335).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    public void testSmallestPrimeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(2).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    public void testSmallestNonPrimeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(4).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    public void testMediumDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(32).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    public void testLargeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(33550337).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    /*
     * The number 1 has no proper divisors (https://en.wikipedia.org/wiki/Divisor#Further_notions_and_facts), and the
     * additive identity is 0, so the aliquot sum of 1 should be 0. Hence 1 should be classified as deficient.
     */
    public void testThatOneIsCorrectlyClassifiedAsDeficient() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(1).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    public void testThatNonNegativeIntegerIsRejected() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("You must supply a natural number (positive integer)");

        new NaturalNumber(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testThatNegativeIntegerIsRejected() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("You must supply a natural number (positive integer)");

        new NaturalNumber(-1);
    }
}