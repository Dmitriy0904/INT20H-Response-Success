package int20h.responsesuccess.controller;

import int20h.responsesuccess.entity.Auction;
import int20h.responsesuccess.entity.Bid;
import int20h.responsesuccess.entity.User;
import int20h.responsesuccess.exception.EntityNotFoundException;
import int20h.responsesuccess.model.AuctionRequestDto;
import int20h.responsesuccess.service.AuctionService;
import int20h.responsesuccess.service.BidService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/bids")
public class BidController {

    private final BidService bidService;
    private final AuctionService auctionService;

    @PostMapping("/auction/{auctionId}")
    public int createBid(final @RequestBody Bid bid,
                         final @PathVariable Long auctionId) {
        Auction auction = auctionService.findById(auctionId);
        bid.setAuction(auction);
        bidService.create(bid);
        return Response.SC_CREATED;
    }

    @PutMapping
    public int editBid(final @RequestBody Bid bid) {
        if (bid != null &&
                bid.getId() != null &&
                bidService.existsById(bid.getId())) {
            bidService.update(bid);
        } else {
            throw new EntityNotFoundException(
                    "Bid",
                    bid != null && bid.getId() != null ?
                            bid.getId().toString() :
                            null);
        }
        return Response.SC_OK;
    }

    @GetMapping("/{id}")
    public Bid getBidById(final @PathVariable Long id) {
        return bidService.findById(id);
    }

    @GetMapping
    public List<Bid> getAllBids() {
        return bidService.findAll();
    }
}
