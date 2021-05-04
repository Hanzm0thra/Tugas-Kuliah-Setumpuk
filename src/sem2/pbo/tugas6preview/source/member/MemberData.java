package sem2.pbo.tugas6preview.source.member;

import sem2.pbo.tugas6preview.model.Member;
import sem2.pbo.tugas6preview.util.MemberType;
import sem2.pbo.tugas6preview.util.PaymentType;

import java.util.ArrayList;

public class MemberData  {

    ArrayList<Member> members = new ArrayList<>();

    public ArrayList<Member> getListOfMembers() {
        return members;
    }

    public void setMembers(int id, double balance, String name, String address, MemberType memberType, PaymentType paymentType){
        members.add(
                new Member(
                        id,
                        balance,
                        name,
                        address,
                        memberType,
                        paymentType,
                        0
                )
        );
    }

    public void updateBalance(int userId, double newBalance, int quantity) {
        for (int index = 0; index < members.size(); index++) {
            if (members.get(index).id() == userId) {
                int id = members.get(index).id();
                String name = members.get(index).name();
                String address = members.get(index).address();
                MemberType memberType = members.get(index).memberType();
                PaymentType paymentType = members.get(index).paymentType();
                int currentTotalProduct = members.get(index).totalProduct();

                members.set(index, new Member(
                        id,
                        newBalance,
                        name,
                        address,
                        memberType,
                        paymentType,
                        currentTotalProduct + quantity
                ));
            }
        }
    }

    public double pay(int userId, double price, int quantity, int currentQuantity) {
        double newBalance = 0;

        double balance;
        String name;
        MemberType memberType;

        for (Member obj: members) {
            if (obj.id() == userId) {
                balance = obj.balance();
                name = obj.name();
                memberType = obj.memberType();
                try {
                    if (balance < price) {
                        throw new ArithmeticException(String.format("Pembayaran %s gagal karena saldo tidak mencukupi", name));
                    } else if (currentQuantity < quantity) {
                        throw new NullPointerException("Stok barang tidak cukup");
                    }  else {
                        if (memberType.equals(MemberType.PREMIUM)) {
                            newBalance = balance - (0.95 * price * quantity);
                        } else {
                            newBalance = balance - (price * quantity);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return newBalance;
    }
}
