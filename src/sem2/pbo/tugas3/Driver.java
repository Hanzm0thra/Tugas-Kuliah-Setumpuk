package sem2.pbo.tugas3;

public class Driver extends User {

    int driverId;
    String name;
    String phoneNumber;
    int incomeBalance;

    public void confirmOrder(double distance) {
        System.out.printf("%s(id: %d | nomorHP: %s) menerima pesanan user dengan jarak %.2f km \n", name, driverId, phoneNumber, distance);
    }

    public void getReviewFromUser(int starsReview) {
        System.out.printf("User mereview perjalanan anda dengan bintang %d \n", starsReview);
    }

    public void getPaymentFromUser(int price) {
        System.out.printf("%s (id: %d | nomorHP: %s) mendapatkan pembayaran dari user sebesar %d (total penghasilan: %d) \n",
                name, driverId, phoneNumber, price, incomeBalance + price);
    }

    public static void main(String[] args) {
        //first object
        var driver1 = new Driver();
        driver1.driverId = 123456789;
        driver1.name = "Budi Hartono";
        driver1.phoneNumber = "+628123456xxx";
        driver1.incomeBalance = 40000;

        driver1.confirmOrder(2);
        driver1.getReviewFromUser(5);
        driver1.getPaymentFromUser(23000);
        System.out.println();

        //second object
        var driver2 = new Driver();
        driver2.driverId = 987654321;
        driver2.name = "Joko Pratomo";
        driver2.phoneNumber = "+628987654xxx";
        driver2.incomeBalance = 21000;

        driver2.confirmOrder(1.5);
        driver2.getReviewFromUser(4);
        driver2.getPaymentFromUser(9000);

        //third object
        var driver3 = new Driver();
        driver3.driverId = 192837465;
        driver3.name = "Bamabang Herlambang";
        driver3.phoneNumber = "+628192837xxx";
        driver3.incomeBalance = 5000;

        driver3.confirmOrder(4.34);
        driver3.getReviewFromUser(5);
        driver3.getPaymentFromUser(26000);
    }
}
