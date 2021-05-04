package sem2.pbo.praktikum.praktikum8;

import java.util.Random;

public class Healer extends Character{
    @Override
    boolean attack() {
        Random random = new Random();
        int chance = random.nextInt(100) + 1;
        //success (1 - 85 | 85%), fail (86 - 100 | 15%)
        return chance <= 85;
    }

    public void heal() {
        /*
        to avoid a scenario after enemy attacks and healer HP becomes 0
        but healing skill still active (so it looks like a revive skill)
         */
        if (getHP() > 0)
            setHP(getHP() + 25);
    }
}
