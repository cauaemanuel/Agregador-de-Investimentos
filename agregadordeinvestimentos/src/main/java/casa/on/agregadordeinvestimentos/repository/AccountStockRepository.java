package casa.on.agregadordeinvestimentos.repository;

import casa.on.agregadordeinvestimentos.entity.Account;
import casa.on.agregadordeinvestimentos.entity.AccountStock;
import casa.on.agregadordeinvestimentos.entity.AccountStockId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountStockRepository extends JpaRepository<AccountStock, AccountStockId> {
}
