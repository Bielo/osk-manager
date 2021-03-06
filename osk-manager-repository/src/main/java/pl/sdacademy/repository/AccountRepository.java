package pl.sdacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdacademy.domain.entity.Account;

@Repository
public interface AccountRepository  extends JpaRepository<Account, Long> {

    Account findByEmail(String email);
}
