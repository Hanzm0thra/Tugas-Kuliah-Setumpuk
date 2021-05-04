package sem2.pbo.tugas6preview.repository;

import sem2.pbo.tugas6preview.model.Member;
import sem2.pbo.tugas6preview.model.Product;
import sem2.pbo.tugas6preview.util.MemberType;
import sem2.pbo.tugas6preview.util.PaymentType;

import java.util.ArrayList;

public interface IIkeyaRepository {

    int x = 10;
    ArrayList<Member> getListOfMembers();
    void setMemberAttribute(int id, double balance, String name, String address, MemberType memberType, PaymentType paymentType);
    ArrayList<Product> getListOfProducts();
    void setProductAttribute(int id, int quantity, double price, String productName);
    void buy(int userId, int productId, int quantity);

}
