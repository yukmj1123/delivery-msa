package deliverymsa.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;


@FeignClient(name = "App", url = "${api.url.App}")
public interface OrderService {
    @RequestMapping(method= RequestMethod.GET, path="/orders/{id}")
    public Order getOrder(@PathVariable("id") Long id);
}
