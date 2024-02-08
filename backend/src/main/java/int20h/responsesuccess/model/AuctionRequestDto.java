package int20h.responsesuccess.model;

import int20h.responsesuccess.entity.Status;
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
    private Status status;
    private Double startPrice;
}
