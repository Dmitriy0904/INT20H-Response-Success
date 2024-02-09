package int20h.responsesuccess.controller;

import int20h.responsesuccess.entity.Auction;
import int20h.responsesuccess.entity.User;
import int20h.responsesuccess.exception.EntityNotFoundException;
import int20h.responsesuccess.model.AuctionRequestDto;
import int20h.responsesuccess.service.AuctionService;
import int20h.responsesuccess.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/auctions")
@CrossOrigin(origins = "*")
public class
AuctionController {

    private final AuctionService auctionService;
    private final UserService userService;

    @PostMapping("/user/{userId}")
    public int createAuction(final @RequestBody AuctionRequestDto auctionRequestDto,
                             final @PathVariable Long userId) {
        User user = userService.findById(userId);
        Auction auction = new Auction(auctionRequestDto, user);
        auctionService.create(auction);
        //todo check what we should return
        return Response.SC_CREATED;
    }

    @PutMapping
    public int editAuction(final @RequestBody AuctionRequestDto auctionRequestDto) {
        if (auctionRequestDto != null &&
                auctionRequestDto.getId() != null &&
                auctionService.existsById(auctionRequestDto.getId())) {
            Auction auction = new Auction(auctionRequestDto);
            auctionService.update(auction);
        } else {
            //todo check if user is not null
            throw new EntityNotFoundException(
                    "Auction",
                    auctionRequestDto != null && auctionRequestDto.getId() != null ?
                            auctionRequestDto.getId().toString() :
                            null);
        }
        //todo check what we should return
        return Response.SC_OK;
    }

    @GetMapping("/{id}")
    public Auction getAuctionById(final @PathVariable Long id) {
        return auctionService.findById(id);
    }

    @GetMapping
    public List<Auction> getAllAuctions() {
        return auctionService.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<Auction> getAllAuctionsByUser(final @PathVariable Long userId) {
        User user = userService.findById(userId);
        return auctionService.findAllByUser(user);
    }
}
