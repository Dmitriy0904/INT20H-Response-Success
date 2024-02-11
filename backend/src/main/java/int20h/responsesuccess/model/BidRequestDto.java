package int20h.responsesuccess.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class BidRequestDto {
    private Long id;
    private Double amount;
    private Long createdDate;
    private Long userId;
    private Long auctionId;
}
