package dians.atmlocator.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import dians.atmlocator.model.enumerations.UserRole;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String email;
    @Enumerated(EnumType.STRING)
    UserRole role;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Review> reviews;
    boolean accountExpired;
    boolean accountLocked;
    boolean credentialsExpired;
    boolean enabled;
    @ManyToMany
    List<Atm> savedAtms;

    public ApplicationUser() {
    }

    public ApplicationUser(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = UserRole.USER;
        this.reviews = new LinkedList<>();
        this.accountExpired = false;
        this.accountLocked = false;
        this.credentialsExpired = false;
        this.enabled = true;
        this.savedAtms = new LinkedList<>();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !accountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !credentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @JsonManagedReference
    public List<Review> getReviews() {
        return reviews;
    }
}
