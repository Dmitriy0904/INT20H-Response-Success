package int20h.responsesuccess.controller;

import int20h.responsesuccess.entity.Auction;
import int20h.responsesuccess.entity.Bid;
import int20h.responsesuccess.entity.User;
import int20h.responsesuccess.exception.EntityNotFoundException;
import int20h.responsesuccess.model.BidRequestDto;
import int20h.responsesuccess.service.AuctionService;
import int20h.responsesuccess.service.BidService;
import int20h.responsesuccess.service.UserService;
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
    private final UserService userService;

    @PostMapping
    public int createBid(final @RequestBody BidRequestDto dto) {
        Auction auction = getAuctionById(dto.getAuctionId());
        User user = getUserById(dto.getUserId());
        Bid bid = new Bid(dto, user, auction);
        bidService.create(bid);
        return Response.SC_CREATED;
    }

    @PutMapping
    public int editBid(final @RequestBody BidRequestDto dto) {
        if (dto != null &&
                dto.getId() != null &&
                bidService.existsById(dto.getId())) {
            Auction auction = getAuctionById(dto.getAuctionId());
            User user = getUserById(dto.getUserId());
            Bid currentBid = bidService.findById(dto.getId());
            dto.setCreatedDate(currentBid.getCreatedDate());
            Bid bid = new Bid(dto, user, auction);
            bidService.update(bid);
        } else {
            throw new EntityNotFoundException(
                    "Bid",
                    dto != null && dto.getId() != null ?
                            dto.getId().toString() :
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

    private User getUserById(Long id) {
        if (id == null) {
            throw new EntityNotFoundException("User", null);
        }
        return userService.findById(id);
    }

    private Auction getAuctionById(Long id) {
        if (id == null) {
            throw new EntityNotFoundException("Auction", null);
        }
        return auctionService.findById(id);
    }
}
