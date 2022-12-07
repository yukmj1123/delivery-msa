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




    public static void notify(CookedStarted cookedStarted){

        /** Example 1:  new item 
        Review review = new Review();
        repository().save(review);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookedStarted.get???()).ifPresent(review->{
            
            review // do something
            repository().save(review);


         });
        */

        
    }
    public static void notify(CookFinished cookFinished){

        /** Example 1:  new item 
        Review review = new Review();
        repository().save(review);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookFinished.get???()).ifPresent(review->{
            
            review // do something
            repository().save(review);


         });
        */

        
    }
    public static void notify(OrderRejected orderRejected){

        /** Example 1:  new item 
        Review review = new Review();
        repository().save(review);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderRejected.get???()).ifPresent(review->{
            
            review // do something
            repository().save(review);


         });
        */

        
    }
    public static void notify(OrderAccepted orderAccepted){

        /** Example 1:  new item 
        Review review = new Review();
        repository().save(review);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderAccepted.get???()).ifPresent(review->{
            
            review // do something
            repository().save(review);


         });
        */

        
    }
    public static void notify(Picked picked){

        /** Example 1:  new item 
        Review review = new Review();
        repository().save(review);

        */

        /** Example 2:  finding and process
        
        repository().findById(picked.get???()).ifPresent(review->{
            
            review // do something
            repository().save(review);


         });
        */

        
    }


}
