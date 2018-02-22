package pl.sdacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.domain.entity.Account;

public interface AccountRepository  extends JpaRepository<Account, Long> {

}
