package sem2.pbo.praktikum.praktikum8;

import java.util.Random;

public class Magician extends Character{
    @Override
    boolean attack() {
        Random random = new Random();
        int chance = random.nextInt(100) + 1;
        //success (1 - 35 | 35%), fail (36 - 100 | 65%)
        return chance <= 35;
    }
}
