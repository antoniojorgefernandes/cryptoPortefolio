package crypto.portfolio.entities;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CryptoAsset")
public class CryptoAsset {
    
    @Id
    @Column(name = "name", nullable = false)
    @ApiModelProperty(notes = "Crypto asset's name", required = true)
    private String name;
    @Column(name = "symbol", nullable = false)
    @ApiModelProperty(notes = "Crypto asset's symbol", required = true)
    private String symbol;
    @ManyToMany(mappedBy = "cryptoAssets")
    @ApiModelProperty(notes="List of crypto assets in the portfolio")
    private Set<Portfolio> portfolios;
    @Transient
    @ApiModelProperty(notes = "Crypto asset's value in USD", required = true)
    private double value;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Set<Portfolio> getPortfolios() {
        return this.portfolios;
    }

    public void setPortfolios(Set<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CryptoAsset)) {
            return false;
        }
        CryptoAsset cryptoAsset = (CryptoAsset) o;
        return Objects.equals(name, cryptoAsset.name) && Objects.equals(symbol, cryptoAsset.symbol) && Objects.equals(portfolios, cryptoAsset.portfolios) && value == cryptoAsset.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, symbol, portfolios, value);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", symbol='" + getSymbol() + "'" +
            ", portfolios='" + getPortfolios() + "'" +
            ", value='" + getValue() + "'" +
            "}";
    }

}
