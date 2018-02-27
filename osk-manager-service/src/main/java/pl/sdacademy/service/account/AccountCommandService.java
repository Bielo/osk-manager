package pl.sdacademy.service.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.domain.entity.Account;
import pl.sdacademy.repository.AccountRepository;

@Service
@Transactional
public class AccountCommandService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountCommandService.class);

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public AccountCommandService(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void updateEmail(Account account) {
        Account dbAccount = accountRepository.findOne(account.getId());
        if (dbAccount == null) {
            LOGGER.debug("Teacher with id " + account.getId() + " not found.");
        }
        dbAccount.setEmail(account.getEmail());
    }
}
