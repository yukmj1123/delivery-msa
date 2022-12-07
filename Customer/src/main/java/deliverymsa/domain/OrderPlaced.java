package deliverymsa.domain;

import deliverymsa.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String foodid;
    private String options;
    private String adress;
}
