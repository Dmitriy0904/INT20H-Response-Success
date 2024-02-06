package int20h.responsesuccess.service;

import int20h.responsesuccess.entity.Auction;
import java.util.List;
import java.util.Optional;

public interface AuctionService {

    void create(Auction auction);
    void update(Auction auction);
    void delete(Long auctionId);
    Auction findById(Long auctionId);
    List<Auction> findAll();
    List<Auction> findAllByUserId(Long userId);

}
