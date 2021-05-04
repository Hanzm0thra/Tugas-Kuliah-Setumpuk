package sem2.pbo.praktikum.praktikum8;

import java.util.Random;

public class Warrior extends Character{
    @Override
    boolean attack() {
        Random random = new Random();
        int chance = random.nextInt(100) + 1;
        //success (1 - 60 | 60%), fail (61 - 100 | 40%)
        return chance <= 60;
    }
}
