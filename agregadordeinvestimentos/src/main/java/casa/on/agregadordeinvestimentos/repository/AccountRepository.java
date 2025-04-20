package casa.on.agregadordeinvestimentos.repository;

import casa.on.agregadordeinvestimentos.entity.Account;
import casa.on.agregadordeinvestimentos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
}
