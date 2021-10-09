package crypto.portfolio.entities;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Asset's unique ID", required = true)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "portfolio")
    @ApiModelProperty(notes = "The porfolio owner")
    private User user;
    @ManyToMany
    @ApiModelProperty(notes="List of crypto assets in the portfolio")
    private Set<CryptoAsset> cryptoAssets;
    


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<CryptoAsset> getCryptoAssets() {
        return this.cryptoAssets;
    }

    public void setCryptoAssets(Set<CryptoAsset> cryptoAssets) {
        this.cryptoAssets = cryptoAssets;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Portfolio)) {
            return false;
        }
        Portfolio portfolio = (Portfolio) o;
        return Objects.equals(id, portfolio.id) && Objects.equals(user, portfolio.user) && Objects.equals(cryptoAssets, portfolio.cryptoAssets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, cryptoAssets);
    }
    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", user='" + getUser() + "'" +
            ", cryptoAssets='" + getCryptoAssets() + "'" +
            "}";
    }
    
}
