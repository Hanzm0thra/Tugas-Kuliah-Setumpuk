package sem2.asd.praktikum.array;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        int slideToLeft = scanner.nextInt();
        String delete = scanner.next();

        char[] messageChar = new char[message.length()];
        char[] temp = new char[1];
        char[] holder = new char[1];


        for (int index = 0; index < message.length(); index++) {
            messageChar[index] = message.charAt(index);
        }

        for (int count = 1; count <= slideToLeft; count++) {
            for (int index = messageChar.length - 1; index >= 0; index--) {
                if (index == 0) {
                    messageChar[messageChar.length - 1] = temp[0];
                } else if (index == messageChar.length - 1) {
                    temp[0] = messageChar[index - 1];
                    messageChar[index - 1] = messageChar[index];
                } else {
                    holder[0] = temp[0];
                    temp[0] = messageChar[index - 1];
                    messageChar[index - 1] = holder[0];
                }
            }
        }

        String beforeEncryption = String.valueOf(messageChar);
        String messageEncrypted = beforeEncryption.replace(delete, "");

        System.out.println(messageEncrypted);
    }
}
