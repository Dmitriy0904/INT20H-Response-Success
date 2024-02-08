package int20h.responsesuccess.controller;

import int20h.responsesuccess.entity.Status;
import int20h.responsesuccess.entity.User;
import int20h.responsesuccess.model.AuctionRequestDto;
import int20h.responsesuccess.model.AuctionResponseDto;
import int20h.responsesuccess.service.AuctionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auctions")
public class
AuctionController {

    private final AuctionService auctionService;

    @PostMapping
    public AuctionResponseDto createAuction(final @RequestBody AuctionRequestDto auctionRequestDto) {
        User user = getCurrentUser();
        return createAuctionResponseDto(auctionRequestDto, user);
    }

    @PutMapping
    public AuctionResponseDto editAuction(final @RequestBody AuctionRequestDto auctionRequestDto) {
        AuctionResponseDto auctionResponseDto = getTestAuctionResponseDtoById(auctionRequestDto.getId());
        //todo if exist
        return auctionResponseDto;
    }

    @GetMapping("/{id}")
    public AuctionResponseDto getAuctionById(final @PathVariable Long id) {
        return getTestAuctionResponseDtoById(id);
    }

    @GetMapping
    public List<AuctionResponseDto> getAllAuction() {
        return getListAuctionResponseDto();
    }

    //just for mock data
    private User getCurrentUser() {
        return User.builder()
                .id(100L)
                .email("user100@gmail.com")
                .username("user100")
                .password("user100")
                .build();
    }

    //just for mock data
    private AuctionResponseDto getTestAuctionResponseDtoById(Long auctionId) {
        return AuctionResponseDto.builder()
                .id(auctionId)
                .name("car")
                .description("blablabla")
                .photoUrl("myUrl")
                .status(Status.PENDING.name())
                .startPrice(7000D)
                .actualPrice(7000D)
                .user(getCurrentUser())
                .build();
    }

    //just for mock data
    private AuctionResponseDto createAuctionResponseDto(AuctionRequestDto auctionRequestDto, User user) {
        return AuctionResponseDto.builder()
                .name(auctionRequestDto.getName())
                .description(auctionRequestDto.getDescription())
                .photoUrl(auctionRequestDto.getPhotoUrl())
                .status(auctionRequestDto.getStatus().name())
                .startPrice(auctionRequestDto.getStartPrice())
                .actualPrice(auctionRequestDto.getStartPrice())
                .user(user).build();
    }

    //just for mock data
    private List<AuctionResponseDto> getListAuctionResponseDto() {
        List<AuctionResponseDto> dtoList = new ArrayList<>();
        for (int i = 0; i < 19; i++) {
            AuctionResponseDto dto = getTestAuctionResponseDtoById((long) i);
            dto.setName("car" + i);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
