package pl.sdacademy.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.domain.entity.Account;
import pl.sdacademy.repository.AccountRepository;
import pl.sdacademy.service.security.UserDetails;

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

    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    public Account findAccountByID(Long id){
        return accountRepository.findOne(id);
    }

    public Account findCurrentAccount() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) loggedInUser.getPrincipal();
        Account account = findAccountByID(userDetails.getAccountId());

        return account;
    }
}
