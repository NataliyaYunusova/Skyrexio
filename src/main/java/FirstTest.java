import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FirstTest {
    //КРАТНО 3, ВОЗВРАЩАТЬ 'T'
    //КРАТНО 5, ВОЗВРАЩАТЬ 'M'
    //КРАТНО 3 И 5, ВОЗВРАЩАТЬ 'TSM'
    //ВОЗВРВЩАТЬ 'FAIL'

    public String trialCode(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "TSM";
        } else if (number % 3 == 0) {
            return "T";
        } else if (number % 5 == 0) {
            return "M";
        } else return "FAIL";
    }

    @Test
    public void checkTrialNumber() {
        String actualResult = trialCode(9);
        assertEquals(actualResult, "T");
    }

    @Test
    public void checkTrialNumber2() {
        String actualResult = trialCode(10);
        assertEquals(actualResult, "M");
    }

    @Test
    public void checkTrialNumber3() {
        String actualResult = trialCode(15);
        assertEquals(actualResult, "TSM");
    }

    @Test
    public void checkTrialNumber4() {
        String actualResult = trialCode(13);
        assertEquals(actualResult, "FAIL");
    }
}