package sem2.pbo.tugas6preview.repository;

import sem2.pbo.tugas6preview.model.Member;
import sem2.pbo.tugas6preview.model.Product;
import sem2.pbo.tugas6preview.source.member.MemberData;
import sem2.pbo.tugas6preview.source.product.StoreData;
import sem2.pbo.tugas6preview.util.MemberType;
import sem2.pbo.tugas6preview.util.PaymentType;

import java.util.ArrayList;

public class IkeyaRepository implements IIkeyaRepository {

    MemberData memberData = new MemberData();
    StoreData storeData = new StoreData();
    StoreData.ProductData productData = storeData.new ProductData();

    @Override
    public ArrayList<Member> getListOfMembers() {
        return memberData.getListOfMembers();
    }

    @Override
    public void setMemberAttribute(int id, double balance, String name, String address, MemberType memberType, PaymentType paymentType) {

    }

    @Override
    public ArrayList<Product> getListOfProducts() {
        return storeData.getListOfProducts();
    }

    @Override
    public void setProductAttribute(int id, int quantity, double price, String productName) {
        productData.setProducts(id, quantity, price, productName);
    }

    @Override
    public void buy(int userId, int productId, int quantity) {
        double price = 0;
        int currentQuantity = 0;
        for (Product obj: storeData.getListOfProducts()) {
            if (obj.id() == productId) {
                price = obj.price();
                currentQuantity = obj.quantity();
            }
        }
        double newBalance = memberData.pay(userId, price, quantity, currentQuantity);


        memberData.updateBalance(userId, newBalance, quantity);
        productData.updateQuantity(productId, quantity);
    }
}