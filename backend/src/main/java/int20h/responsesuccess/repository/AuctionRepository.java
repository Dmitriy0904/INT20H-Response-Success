package int20h.responsesuccess.repository;

import int20h.responsesuccess.entity.Auction;
import int20h.responsesuccess.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    List<Auction> findAllByUser(User user);
}
