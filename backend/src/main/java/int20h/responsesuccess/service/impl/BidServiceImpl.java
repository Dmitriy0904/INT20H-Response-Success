
package int20h.responsesuccess.service.impl;

import int20h.responsesuccess.entity.Auction;
import int20h.responsesuccess.entity.Bid;
import int20h.responsesuccess.entity.User;
import int20h.responsesuccess.exception.EntityNotFoundException;
import int20h.responsesuccess.repository.BidRepository;
import int20h.responsesuccess.service.BidService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class BidServiceImpl implements BidService {

    private final BidRepository bidRepository;

    @Override
    public void create(Bid bid) {
        bidRepository.save(bid);
    }

    @Override
    public void update(Bid bid) {
        if (!bidRepository.existsById(bid.getId())) {
            throw new EntityNotFoundException("Bid", bid.getId().toString());
        }
        bidRepository.save(bid);
    }

    @Override
    public Bid findById(Long bidId) {
        return bidRepository.findById(bidId).orElseThrow(() -> {
            log.warn("Package with id = {} not found", bidId);
            return new EntityNotFoundException("Bid", bidId.toString());
        });
    }

    @Override
    public List<Bid> findAll() {
        return bidRepository.findAll();
    }

    @Override
    public List<Bid> findAllByUser(User user) {
        //todo check user exist
        return bidRepository.findAllByUser(user);
    }

    @Override
    public List<Bid> findAllByAuction(Auction auction) {
        //todo check auction exist
        return bidRepository.findAllByAuction(auction);
    }
}
