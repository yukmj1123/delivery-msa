package deliverymsa.domain;

import deliverymsa.domain.Reviewed;
import deliverymsa.CustomerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Review_table")
@Data

public class Review  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String subject;
    
    
    
    
    
    private String review;

    @PostPersist
    public void onPostPersist(){


        Reviewed reviewed = new Reviewed(this);
        reviewed.publishAfterCommit();

    }

    public static ReviewRepository repository(){
        ReviewRepository reviewRepository = CustomerApplication.applicationContext.getBean(ReviewRepository.class);
        return reviewRepository;
    }






}
