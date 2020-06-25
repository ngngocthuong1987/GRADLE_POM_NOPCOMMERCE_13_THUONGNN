package actions.commons;

import java.util.Random;

public class Function {

    /*
     * Random the number from 0 to 999999
     */
    public static int randomNumber() {
        Random random = new Random();
        return random.nextInt(999999);
    }
}
