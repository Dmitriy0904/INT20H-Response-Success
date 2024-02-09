package int20h.responsesuccess.controller;

import static int20h.responsesuccess.entity.Status.PENDING;

import int20h.responsesuccess.entity.Status;
import int20h.responsesuccess.entity.User;
import int20h.responsesuccess.model.AuctionRequestDto;
import int20h.responsesuccess.model.AuctionResponseDto;
import int20h.responsesuccess.service.AuctionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
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
        return getListAuctionResponseDto(57);
    }

    @GetMapping("/user/{userId}")
    public List<AuctionResponseDto> getAllAuctionByUser(final @PathVariable Long userId) {
        return getListAuctionResponseDto(8);
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
                .name("Lot")
                .description("Lorem ipsum dolor sit amet consectetur adipisicing elit. Obcaecati doloribus quod"
                    + "suscipit amet aliquid id officia repellat incidunt culpa consectetur odit deserunt voluptatem,"
                    + "iste veniam, facilis voluptate doloremque necessitatibus assumenda!")
                .photoUrl("https://cdn.townweb.com/cityofmineralpoint.com/wp-content/uploads/2023/09/auction-2.jpg")
                .status(PENDING.name())
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
                .status(PENDING.name())
                .startPrice(auctionRequestDto.getStartPrice())
                .actualPrice(auctionRequestDto.getStartPrice())
                .user(user).build();
    }

    //just for mock data
    private List<AuctionResponseDto> getListAuctionResponseDto(int count) {
        List<AuctionResponseDto> dtoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            AuctionResponseDto dto = getTestAuctionResponseDtoById((long) i);
            dto.setName("Lot " + i);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
