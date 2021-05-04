package sem2.pbo.tugas6preview.model;

import sem2.pbo.tugas6preview.util.MemberType;
import sem2.pbo.tugas6preview.util.PaymentType;

import java.util.ArrayList;

public record Member(
        int id,
        double balance,
        String name,
        String address,
        MemberType memberType,
        PaymentType paymentType,
        int totalProduct
){

}
