package deliverymsa.domain;

import deliverymsa.domain.*;
import deliverymsa.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class CookedStarted extends AbstractEvent {

    private Long id;
    private String status;
    private String foodId;
    private String orderId;
    private String options;

    public CookedStarted(FoodCooking aggregate){
        super(aggregate);
    }
    public CookedStarted(){
        super();
    }
}
