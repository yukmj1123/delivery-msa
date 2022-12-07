package deliverymsa.domain;

import deliverymsa.domain.*;
import deliverymsa.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class Paid extends AbstractEvent {

    private Long id;
    private String orderId;

    public Paid(Payment aggregate){
        super(aggregate);
    }
    public Paid(){
        super();
    }
}
