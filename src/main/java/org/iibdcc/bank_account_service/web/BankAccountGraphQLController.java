package org.iibdcc.bank_account_service.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iibdcc.bank_account_service.dto.BankAccountRequestDTO;
import org.iibdcc.bank_account_service.dto.BankAccountResponseDTO;
import org.iibdcc.bank_account_service.entities.BankAccount;
import org.iibdcc.bank_account_service.entities.Customer;
import org.iibdcc.bank_account_service.repositories.BankAccountRepository;
import org.iibdcc.bank_account_service.repositories.CustomerRepository;
import org.iibdcc.bank_account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;

    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("Account %s Not Found",id)));
    }

    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id,bankAccount);
    }

    @MutationMapping
    public void deleteAccount(@Argument String id){
        bankAccountRepository.deleteById(id);
    }


}

/* ******* A partir de java 14 on peut utiliser le syntaxe suivant
record BankAccountDTO(Double balance, String type, String currency){
}*/

/* on a deja cree un objet BankAccountRequestDTO
@Data @NoArgsConstructor @AllArgsConstructor
class BankAccountDTO{
    private String type;
    private Double balance;
    private String currency;
}*/
