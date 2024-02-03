package gr.aueb.cf.OOProjects.ch18_accounts_big;


import gr.aueb.cf.OOProjects.ch18_accounts_big.dao.AccountDAOImpl;
import gr.aueb.cf.OOProjects.ch18_accounts_big.dao.IAccountDAO;
import gr.aueb.cf.OOProjects.ch18_accounts_big.dao.IOverdraftAccountDAO;
import gr.aueb.cf.OOProjects.ch18_accounts_big.dao.OverdraftAccountDAOImpl;
import gr.aueb.cf.OOProjects.ch18_accounts_big.dto.AccountInsertDTO;
import gr.aueb.cf.OOProjects.ch18_accounts_big.dto.UserInsertDTO;
import gr.aueb.cf.OOProjects.ch18_accounts_big.model.Account;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.AccountServiceImpl;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.IAccountService;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.IOverdraftAccountService;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.OverdraftAccountServiceImpl;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.AccountNotFoundException;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.InsufficientBalanceException;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.NegativeAmountException;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.SsnNotValidException;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        IAccountDAO accountDAO = new AccountDAOImpl();
        IAccountService accountService = new AccountServiceImpl(accountDAO);

        // Κλήση της μεθόδου insert για προσθήκη νέου λογαριασμού
        AccountInsertDTO insertDTO = new AccountInsertDTO("IBAN123", new UserInsertDTO("John", "Doe", "123456789"), 1000.0);
        accountService.insertAccount(insertDTO);

        // Εκτύπωση όλων των λογαριασμών του datasource (λίστα)
        accounts = accountService.getAllAccounts();
        System.out.println(accounts);

        // Κλήση της μεθόδου deposit για κατάθεση ποσού
        try {
            accountService.deposit("IBAN123", 500.0);
            System.out.println("Deposit successful");
        } catch (AccountNotFoundException | NegativeAmountException e) {
            e.printStackTrace();
        }

        // Κλήση της μεθόδου withdraw για ανάληψη ποσού
        try {
            accountService.withdraw("IBAN123", "123456789", 500.0);
            System.out.println("Withdrawal successful");
        } catch (AccountNotFoundException | SsnNotValidException | NegativeAmountException |
                 InsufficientBalanceException e) {
            e.printStackTrace();
        }

        // Δοκιμή ανάληψης με IBAN που δεν υπάρχει στο datasource.
        try {
            accountService.withdraw("IBAN12345", "123456789", 300.0);
            System.out.println("Withdrawal successful");
        } catch (AccountNotFoundException | SsnNotValidException | NegativeAmountException |
                 InsufficientBalanceException e) {
            e.printStackTrace();
        }


        // Δοκιμή ανάληψης ποσού με IBAN που υπάρχει στο datasource αλλά με λάθος ssn.
        try {
            accountService.withdraw("IBAN123", "123456700", 300.0);
            System.out.println("Withdrawal successful");
        } catch (AccountNotFoundException | SsnNotValidException | NegativeAmountException |
                 InsufficientBalanceException e) {
            e.printStackTrace();
        }


        /* Overdraft Account */
        IOverdraftAccountDAO overdraftAccountDAO = new OverdraftAccountDAOImpl();
        IOverdraftAccountService overdraftAccountService = new OverdraftAccountServiceImpl(overdraftAccountDAO);

        // Προσθήκη νέου overdraft λογαριασμού
        AccountInsertDTO insertDTO2 = new AccountInsertDTO("IBAN890", new UserInsertDTO("Mary",
                "bell", "00000000"), 1000.0);
        accountService.insertAccount(insertDTO2);


        // Ανάληψη ποσού μεγαλύτερου από το τρέχον υπόλοιπο του λογαριασμού
        try {
            overdraftAccountService.withdraw("IBAN890", "00000000", 3000.0);
            System.out.println("Withdrawal successful for account " + overdraftAccountService.getAccountByIban("IBAN890"));
        } catch (AccountNotFoundException | SsnNotValidException | NegativeAmountException e) {
            e.printStackTrace();
        }
    }
}
