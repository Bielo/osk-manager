package pl.sdacademy.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.domain.entity.Account;
import pl.sdacademy.repository.AccountRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AccountQueryService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountQueryService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }
}
