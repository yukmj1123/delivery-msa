package deliverymsa.domain;

import deliverymsa.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderRejected extends AbstractEvent {

    private Long id;
    private String status;
    private String food id;
    private String order id;
    private String options;
}
