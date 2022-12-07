package deliverymsa.external;

import lombok.Data;
import java.util.Date;
@Data
public class Order {

    private Long id;
    private String foodid;
    private String options;
    private String adress;
}


