package org.iibdcc.bank_account_service.service;

import org.iibdcc.bank_account_service.dto.BankAccountRequestDTO;
import org.iibdcc.bank_account_service.dto.BankAccountResponseDTO;
import org.iibdcc.bank_account_service.entities.BankAccount;
import org.iibdcc.bank_account_service.enums.AccountType;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
