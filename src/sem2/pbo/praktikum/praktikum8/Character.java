package sem2.pbo.praktikum.praktikum8;

public abstract class Character {
    private int defense;
    private int attack;
    private int HP;

    abstract boolean attack();

    public void receiveDamage(int damage){
        int hp = getHP();
        setHP(hp - damage);

        if (getHP() <= 0)
            setHP(0);
    }

    public void info() {
        System.out.println("================STATUS================");
        System.out.println("Role      :" + this.getClass().getSimpleName());
        System.out.println("HP        :" + getHP());
        System.out.println("Attack    :" + getAttack());
        System.out.println("Defense   :" + getDefense());
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getHP() {
        return HP;
    }
}
