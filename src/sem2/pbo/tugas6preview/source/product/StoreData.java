package sem2.pbo.tugas6preview.source.product;

import sem2.pbo.tugas6preview.model.Product;

import java.util.ArrayList;

public class StoreData {
    ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getListOfProducts() {
        return products;
    }

    public class ProductData{
        public void setProducts(int id, int quantity, double price, String productName) {
            products.add(
                    new Product(
                            id,
                            quantity,
                            price,
                            productName
                    )
            );
        }

        public void updateQuantity(int productId, int quantity) {
            for(int index = 0; index < products.size(); index++) {
                if (products.get(index).id() == productId) {
                    int id = products.get(index).id();
                    int oldQuantity = products.get(index).quantity();
                    double price = products.get(index).price();
                    String productName = products.get(index).productName();
                    products.set(index, new sem2.pbo.tugas6preview.model.Product(
                            id,
                            oldQuantity - quantity,
                            price,
                            productName
                    ));
                }
            }
        }
    }
}
