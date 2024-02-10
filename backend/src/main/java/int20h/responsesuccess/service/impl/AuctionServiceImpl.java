package int20h.responsesuccess.service.impl;

import int20h.responsesuccess.entity.Auction;
import int20h.responsesuccess.entity.User;
import int20h.responsesuccess.exception.EntityNotFoundException;
import int20h.responsesuccess.repository.AuctionRepository;
import int20h.responsesuccess.service.AuctionService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AuctionServiceImpl implements AuctionService {

    private final AuctionRepository auctionRepository;

    @Override
    public void create(Auction auction) {
        auctionRepository.save(auction);
    }

    @Override
    public void update(Auction auction) {
        if (!auctionRepository.existsById(auction.getId())) {
            throw new EntityNotFoundException("Auction", auction.getId().toString());
        }
        auctionRepository.save(auction);
    }

    @Override
    public void delete(Long auctionId) {
        auctionRepository.deleteById(auctionId);
    }

    @Override
    public Auction findById(Long auctionId) {
        return auctionRepository.findById(auctionId).orElseThrow(() -> {
            log.warn("Package with id = {} not found", auctionId);
            return new EntityNotFoundException("Auction", auctionId.toString());
        });
    }

    @Override
    public List<Auction> findAll() {
        return auctionRepository.findAll();
    }

    @Override
    public List<Auction> findAllByUser(User user) {
        return auctionRepository.findAllByUser(user);
    }

    @Override
    public boolean existsById(Long id) {
        return auctionRepository.existsById(id);
    }
}
