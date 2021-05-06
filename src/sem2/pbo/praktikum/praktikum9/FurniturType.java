package sem2.pbo.praktikum.praktikum9;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FurniturType {
    JenisBarang jenis();
}
