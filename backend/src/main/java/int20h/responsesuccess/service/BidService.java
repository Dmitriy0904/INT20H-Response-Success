package int20h.responsesuccess.service;

import int20h.responsesuccess.entity.Auction;
import int20h.responsesuccess.entity.Bid;
import int20h.responsesuccess.entity.User;

import java.util.List;

public interface BidService {

    void create(Bid bid);
    void update(Bid bid);
    Bid findById(Long bidId);
    List<Bid> findAll();
    List<Bid> findAllByUser(User user);
    List<Bid> findAllByAuction(Auction auction);
    boolean existsById(Long id);

}
