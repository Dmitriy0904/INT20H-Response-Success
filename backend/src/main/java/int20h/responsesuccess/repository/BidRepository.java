package int20h.responsesuccess.repository;

import int20h.responsesuccess.entity.Auction;
import int20h.responsesuccess.entity.Bid;
import int20h.responsesuccess.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Long> {

    List<Bid> findAllByAuction(Auction auction);
    List<Bid> findAllByUser(User user);
}
