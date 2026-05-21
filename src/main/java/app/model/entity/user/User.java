package app.model.entity.user;

import app.model.entity.subscription.Subscription;
import app.model.entity.transaction.Transaction;
import app.model.entity.wallet.Wallet;
import app.model.entity.user.Country;
import app.model.entity.user.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String profilePicture;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Enumerated(EnumType.STRING)
    private Country country;

    private Boolean isActive;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    @OneToMany(mappedBy = "owner")
    private List<Wallet> wallets;

    @OneToMany(mappedBy = "owner")
    private List<Subscription> subscriptions;

    @OneToMany(mappedBy = "owner")
    private List<Transaction> transactions;
}
