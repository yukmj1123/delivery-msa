package deliverymsa.domain;

import deliverymsa.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class Paid extends AbstractEvent {

    private Long id;
    private String order id;
}
