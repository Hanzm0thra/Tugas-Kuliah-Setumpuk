package sem1.susulan.no1;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class Solution {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String barangPertama = scanner.nextLine();
        String barangKedua = scanner.nextLine();
        int hargaPertama = scanner.nextInt();
        int hargaKedua = scanner.nextInt();

        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        DecimalFormat indoFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance();

        formatRp.setCurrencySymbol("Rp.");
        indoFormat.setDecimalFormatSymbols(formatRp);
        String firstPrice = indoFormat.format(hargaPertama);
        String secondPrice = indoFormat.format(hargaKedua);

        System.out.println("=================================");
        System.out.printf("%-20s%s\n", "Item", "Harga");
        System.out.println("=================================");
        System.out.printf("%-20s%s\n", barangPertama, firstPrice);
        System.out.printf("%-20s%s\n", barangKedua, secondPrice);
        System.out.println("=================================");
    }
}
