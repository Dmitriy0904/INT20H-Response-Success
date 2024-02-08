package int20h.responsesuccess.controller;

import int20h.responsesuccess.service.AuctionService;
import int20h.responsesuccess.service.BidService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/bids")
public class BidController {

    private final BidService bidService;

    //TODO: ADD ENDPOINTS

}
