
package int20h.responsesuccess.service.impl;

import int20h.responsesuccess.repository.BidRepository;
import int20h.responsesuccess.service.BidService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class BidServiceImpl implements BidService {

    private final BidRepository bidRepository;
}
