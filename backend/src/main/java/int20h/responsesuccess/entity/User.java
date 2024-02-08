package int20h.responsesuccess.entity;

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

    @OneToMany(mappedBy = "user")
    private List<Bid> bids = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Auction> auctions = new ArrayList<>();
}
