package sem2.pbo.tugas6preview.presenter;

import sem2.pbo.tugas6preview.model.Member;
import sem2.pbo.tugas6preview.model.Product;
import sem2.pbo.tugas6preview.repository.IkeyaRepository;
import sem2.pbo.tugas6preview.source.member.MemberData;
import sem2.pbo.tugas6preview.source.product.StoreData;
import sem2.pbo.tugas6preview.util.MemberType;
import sem2.pbo.tugas6preview.util.PaymentType;

public class ViewApp {

    IkeyaRepository ikeyaRepository = new IkeyaRepository();


    void setMembersData(int id, double balance, String name, String address, MemberType memberType, PaymentType paymentType) {
        ikeyaRepository.setMemberAttribute(id, balance, name, address, memberType, paymentType);
    }

    void setProductsData(int id, int quantity, double price, String productName) {
        ikeyaRepository.setProductAttribute(id, quantity, price, productName);
    }

    void buy(int userId, int productId, int quantity) {
        ikeyaRepository.buy(userId, productId, quantity);
    }

    public void outputMemberModel() {
        System.out.println("=================================");
        System.out.println("Status member saat ini");
        for (Member obj: ikeyaRepository.getListOfMembers()) {
            System.out.println("" +
                    "\nId member                 : " + obj.id() +
                    "\nNama member               : " + obj.name() +
                    "\nSaldo member              : " + obj.balance() +
                    "\nAlamat member             : " + obj.address() +
                    "\nTipe member               : " + obj.memberType() +
                    "\nTipe pembayaran           : " + obj.paymentType() +
                    "\nJumlah produk yang dibeli : " + obj.totalProduct()
            );
            System.out.println();
        }
        System.out.println("=================================\n");
    }

    public void outputProductModel() {
        System.out.println("=================================");
        System.out.println("Status barang saat ini");
        for (Product obj: ikeyaRepository.getListOfProducts()) {
            System.out.println("" +
                            "\nId barang    \t: " + obj.id() +
                            "\nNama barang  \t: " + obj.productName() +
                            "\nJumlah barang\t: " + obj.quantity() +
                            "\nHarga barang \t: " + obj.price()
            );
            System.out.println();
        }
        System.out.println("=================================\n");
    }
}
