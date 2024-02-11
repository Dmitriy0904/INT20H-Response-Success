package int20h.responsesuccess.service;

import int20h.responsesuccess.entity.Auction;
import int20h.responsesuccess.entity.User;

import java.util.List;

public interface AuctionService {

    void create(Auction auction);
    void update(Auction auction);
    void delete(Long auctionId);
    Auction findById(Long auctionId);
    List<Auction> findAll();
    List<Auction> findAllByUser(User user);
    boolean existsById(Long id);
}
