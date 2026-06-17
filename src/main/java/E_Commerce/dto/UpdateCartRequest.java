package E_Commerce.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UpdateCartRequest {

    private Long cartItemId;
    private Integer quantity;

}
