package crypto.portfolio.entities;

import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "User's unique ID", required = true)
    private Long id;
    @Column(name = "name", nullable = false)
    @ApiModelProperty(notes = "User's name", required = true)
    private String name;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name= "user_portfolio")
    @ApiModelProperty(notes = "All the user's crypto assets")
    private Portfolio portfolio = new Portfolio();
    @Column(name = "email", nullable = false, unique = true)
    @ApiModelProperty(notes = "User's email address", required = true)
    private String email;
    @Column(name = "password", nullable = false)
    @ApiModelProperty(notes = "User's password to access his portefolio", required = true)
    private String password;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Portfolio getPortfolio() {
        return this.portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(portfolio, user.portfolio) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, portfolio, email, password);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", portfolio='" + getPortfolio() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }



}
