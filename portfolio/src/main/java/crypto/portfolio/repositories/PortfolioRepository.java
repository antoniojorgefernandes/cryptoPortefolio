package crypto.portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import crypto.portfolio.entities.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    
}
