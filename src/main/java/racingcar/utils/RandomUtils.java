package racingcar.utils;

import java.util.Random;

public class RandomUtils {
    public static int random(int randomBound) {
        Random random = new Random();
        return random.nextInt(randomBound);
    }
}