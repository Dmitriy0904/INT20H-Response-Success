package int20h.responsesuccess.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AuctionRequestDto {
    private Long id;
    private String name;
    private String description;
    private String photoUrl;
    private String status;
    private Double startPrice;
    private Double actualPrice;
    private Long userId;
}
