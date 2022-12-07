package deliverymsa.domain;

import deliverymsa.domain.*;
import deliverymsa.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class Reviewed extends AbstractEvent {

    private Long id;
    private String foodId;
    private String orderId;
    private String storeId;

    public Reviewed(FoodCooking aggregate){
        super(aggregate);
    }
    public Reviewed(){
        super();
    }
}
