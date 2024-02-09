package int20h.responsesuccess.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import int20h.responsesuccess.model.AuctionRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "auctions")
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String photoUrl;
    private Status status;
    private Double startPrice;
    private Double actualPrice;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="users_id")
    private User user;

    @JsonBackReference
    @OneToMany(mappedBy = "auction")
    private List<Bid> bids;

    public Auction(AuctionRequestDto dto, User user) {
        if (dto.getId() != null) {
            this.id = dto.getId();
        }
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.photoUrl = dto.getPhotoUrl();
        this.status = Optional.ofNullable(dto.getStatus()).orElse(Status.PENDING);
        this.startPrice = dto.getStartPrice();
        this.actualPrice = Optional.ofNullable(dto.getActualPrice()).orElse(dto.getStartPrice());
        this.user = user;
        this.bids = Optional.ofNullable(dto.getBids()).orElse(new ArrayList<>());
    }

    public Auction (AuctionRequestDto dto) {
        if (dto.getId() != null) {
            this.id = dto.getId();
        }
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.photoUrl = dto.getPhotoUrl();
        this.status = Optional.ofNullable(dto.getStatus()).orElse(Status.PENDING);
        this.startPrice = dto.getStartPrice();
        this.actualPrice = Optional.ofNullable(dto.getActualPrice()).orElse(dto.getStartPrice());
        this.user = dto.getUser();
        this.bids = Optional.ofNullable(dto.getBids()).orElse(new ArrayList<>());
    }
}
