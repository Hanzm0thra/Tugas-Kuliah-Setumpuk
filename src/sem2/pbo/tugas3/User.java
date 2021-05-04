package sem2.pbo.tugas3;

public class User {

    int userId;
    String name;
    String phoneNumber;
    int ovoBalance;

    public void userOrder(double distance) {
        System.out.printf("%s(id: %d | nomorHP:  %s) memesan grab bike dengan jarak %.2f km \n", name , userId, phoneNumber, distance);
    }

    public void userReview(int starsReview) {
        System.out.printf("Anda mereview perjalanan anda dengan bintang %d \n", starsReview);
    }

    public void userPay(int price) {
        if (ovoBalance < price) {
            System.out.println("Saldo ovo anda tidak cukup, silahkan melakukan topup melalui driver atau lakukan pembayaran dengan uang cash \n");
        }
        else {
            System.out.printf("%s(id: %d | nomorHP: %s) membayar sebesar %d (sisa saldo ovo: %d) \n",
                    name, userId, phoneNumber, price, ovoBalance - price);
        }
    }

    public static void main(String[] args) {
        //first object
        var user1 = new User();
        user1.userId = 112233445;
        user1.name = "Kylix Eza Saputra";
        user1.phoneNumber = "+628112233xxx";
        user1.ovoBalance = 50000;

        user1.userOrder(2);
        user1.userReview(5);
        user1.userPay(12000);
        System.out.println();

        //second object
        var user2 = new User();
        user2.userId = 135792468;
        user2.name = "Fajar Sukamto";
        user2.phoneNumber = "+62813579xxxx";
        user2.ovoBalance = 23000;

        user2.userOrder(1.5);
        user2.userReview(4);
        user2.userPay(9000);
        System.out.println();

        //third object
        var user3 = new User();
        user3.userId = 864213579;
        user3.name = "Haikal Baqi";
        user3.phoneNumber = "+62864213xxx";
        user3.ovoBalance = 5000;

        user3.userOrder(4.34);
        user3.userReview(5);
        user3.userPay(26000);
    }
}
