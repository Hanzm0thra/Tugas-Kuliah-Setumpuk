package sem2.pbo.praktikum.praktikum8;

import java.util.Random;

public class Titan extends Character{

    @Override
    boolean attack() {
        Random random = new Random();
        int chance = random.nextInt(100) + 1;
        //success (1 - 40 | 40%), fail (41 - 100 | 60%)
        return chance <= 40;
    }
}
