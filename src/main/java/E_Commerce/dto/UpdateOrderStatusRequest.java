package E_Commerce.dto;

import E_Commerce.entity.OrderStatus;
import lombok.Data;

@Data
public class UpdateOrderStatusRequest {

    private OrderStatus status;

}
