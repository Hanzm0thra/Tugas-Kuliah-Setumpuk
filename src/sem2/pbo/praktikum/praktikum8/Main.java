package sem2.pbo.praktikum.praktikum8;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character[] characters = new Character[4];
        Character playerRole = null;
        charactersInit(characters);

        System.out.print("Masukkan nama pemain: ");
        String playerName = scanner.nextLine();

        boolean isValid;
        int role = 0;
        do {
            System.out.println("Daftar role karakter yang tersedia: " + "\n" +
                    """
                            1. Magician
                            2. Healer
                            3. Warrior
                            """);
            System.out.print("Masukkan pilihan anda: ");
            String _role = scanner.nextLine();
            try {
                role = Integer.parseInt(_role);
                if (role != 1 && role != 2 && role != 3) {
                    System.out.println("Role tidak ditemukan!");
                    isValid = false;
                } else {
                    isValid = true;
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid!");
                isValid = false;
            }

        }while (!isValid);

        switch (role) {
            case 1 -> playerRole = characters[1];
            case 2 -> playerRole = characters[2];
            case 3 -> playerRole = characters[3];
        }

        assert playerRole != null;
        play(playerRole, characters[0], playerName);
    }

    private static void play(Character player, Character enemy, String playerName) {
        int round = 1;
        player.info();
        do {
            System.out.printf("========ROUND %d========\n", round);

            if (player.attack()) {
                int playerAttack = player.getAttack();
                int enemyDefense = enemy.getDefense();

                if (enemyDefense >= playerAttack)
                    enemy.receiveDamage(0);
                else {
                    int damage = playerAttack - enemyDefense;
                    enemy.receiveDamage(damage);
                }
            }

            if (enemy.attack() && enemy.getHP() > 0){
                int enemyAttack = enemy.getAttack();
                int playerDefense = player.getDefense();

                if (playerDefense >= enemyAttack)
                    player.receiveDamage(0);
                else {
                    int damage = enemyAttack - playerDefense;
                    player.receiveDamage(damage);
                }
            }

            if (player instanceof Healer) {
                if (round % 2 == 0) {
                    System.out.println("Healing Skill Activate");
                    ((Healer) player).heal();
                }
            }

            System.out.printf("%-15s : %d\n", "Enemy's HP", enemy.getHP());
            System.out.printf("%-15s : %d\n", playerName + "'s HP", player.getHP());

            round++;
        }while (player.getHP() > 0 && enemy.getHP() > 0);

        if (player.getHP() == 0)
            System.out.println("Enemy Win");
        else
            System.out.println(playerName + " Win");

        System.out.println("\n=============== ENEMY ================");
        enemy.info();
        System.out.println("\n=============== PLAYER ===============");
        player.info();
    }

    private static void charactersInit(Character[] characters) {
        characters[0] = new Titan();
        characters[1] = new Magician();
        characters[2] = new Healer();
        characters[3] = new Warrior();

        characters[0].setHP(200);
        characters[0].setAttack(45);
        characters[0].setDefense(0);

        characters[1].setHP(100);
        characters[1].setAttack(60);
        characters[1].setDefense(10);

        characters[2].setHP(70);
        characters[2].setAttack(10);
        characters[2].setDefense(10);

        characters[3].setHP(80);
        characters[3].setAttack(25);
        characters[3].setDefense(30);

    }
}
