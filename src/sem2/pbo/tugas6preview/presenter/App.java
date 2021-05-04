package sem2.pbo.tugas6preview.presenter;

import sem2.pbo.tugas6preview.util.MemberType;
import sem2.pbo.tugas6preview.util.PaymentType;

public class App {

    public static void main(String[] args) {

        ViewApp viewApp = new ViewApp();


        viewApp.setProductsData(111, 4, 400000, "Kursi Kayu");
        viewApp.setProductsData(222, 6, 50000, "Lampu Belajar");
        viewApp.setProductsData(333, 5, 30000, "Bantal");

        viewApp.setMembersData(123, 500000, "Adi", "Jalan Mawar No.3", MemberType.REGULAR, PaymentType.GOPAY);
        viewApp.setMembersData(456, 900000, "Budi", "Jalan Malang No.7", MemberType.PREMIUM, PaymentType.CREDIT);
        viewApp.setMembersData(789, 1000000, "Caca", "Jalan Kenanga No.11", MemberType.PREMIUM, PaymentType.OVO);

        /**
         Adi(123) membeli Kursi Kayu(111) sebanyak 1 buah dan Lampu Belajar(222) sebanayak 1 buah [REGULAR MEMBER]
         */
        viewApp.buy(123, 111, 1);
        viewApp.buy(123, 222, 1);

        /**
         Budi(456) membeli Lampu Belajar(222) sebanyak 5 buah [PREMIUM MEMBER]
         */
        viewApp.buy(456, 222, 5);

        /**
         Caca(789) membeli Kursi Kayu(111) sebanyak 2 buah dan Bantal sebanyak 4 buah [PREMIUM MEMBER]
         */
        viewApp.buy(789, 111, 2);
        viewApp.buy(789, 333, 4);

        viewApp.outputMemberModel();
        viewApp.outputProductModel();
    }
}
