package casa.on.agregadordeinvestimentos.repository;

import casa.on.agregadordeinvestimentos.entity.BillingAddress;
import casa.on.agregadordeinvestimentos.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BillingAddressRepository extends JpaRepository<BillingAddress, UUID> {
}
