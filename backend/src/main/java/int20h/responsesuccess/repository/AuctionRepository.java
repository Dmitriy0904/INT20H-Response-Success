package int20h.responsesuccess.repository;

import int20h.responsesuccess.entity.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<Auction, Long> {

}
