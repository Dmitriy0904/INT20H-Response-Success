package int20h.responsesuccess.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import int20h.responsesuccess.model.UserRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //todo add email validation
    private String email;
    private String username;
    //todo add crypt password
    private String password;

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<Bid> bids = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<Auction> auctions = new ArrayList<>();

    public User (UserRequestDto dto) {
        this.id = dto.getId();
        this.email = dto.getEmail();
        this.username = dto.getUsername();
        this.password = dto.getPassword();
    }
}
