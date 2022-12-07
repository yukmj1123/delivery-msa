package deliverymsa.domain;

import deliverymsa.domain.*;
import deliverymsa.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class Reviewed extends AbstractEvent {

    private Long id;
    private String subject;
    private String reviewed;

    public Reviewed(Review aggregate){
        super(aggregate);
    }
    public Reviewed(){
        super();
    }
}
