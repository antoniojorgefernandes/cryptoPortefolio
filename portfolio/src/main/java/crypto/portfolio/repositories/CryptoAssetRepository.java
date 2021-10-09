package crypto.portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import crypto.portfolio.entities.CryptoAsset;

public interface CryptoAssetRepository extends JpaRepository<CryptoAsset, Long> {

}