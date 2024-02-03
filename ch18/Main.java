package gr.aueb.cf.OOProjects.ch18;

import gr.aueb.cf.OOProjects.ch18.dao.AccountDAOImpl;
import gr.aueb.cf.OOProjects.ch18.dao.IAccountDAO;
import gr.aueb.cf.OOProjects.ch18.service.IAccountService;
import gr.aueb.cf.OOProjects.ch18.dto.AccountInsertDTO;
import gr.aueb.cf.OOProjects.ch18.dto.UserInsertDTO;
import gr.aueb.cf.OOProjects.ch18.service.AccountServiceImpl;
import gr.aueb.cf.OOProjects.ch18.service.exceptions.AccountNotFoundException;
import gr.aueb.cf.OOProjects.ch18.service.exceptions.InsufficientBalanceException;
import gr.aueb.cf.OOProjects.ch18.service.exceptions.NegativeAmountException;
import gr.aueb.cf.OOProjects.ch18.service.exceptions.SsnNotValidException;

public class Main {

    public static void main(String[] args) {
        IAccountDAO accountDAO = new AccountDAOImpl();
        IAccountService accountService = new AccountServiceImpl(accountDAO);

        // Εισαγωγή νέου λογαριασμού
        AccountInsertDTO insertDTO = new AccountInsertDTO("IBAN123", new UserInsertDTO("John", "Doe", "123456789"), 1000.0);
        accountService.insertAccount(insertDTO);

        // Κατάθεση ποσού
        try {
            accountService.deposit("IBAN123", 500.0);
            System.out.println("Deposit successful");
        } catch (AccountNotFoundException | NegativeAmountException e) {
            e.printStackTrace();
        }

        // Κατάθεση αρνητικού ποσού
        try {
            accountService.deposit("IBAN123", -500.0);
            System.out.println("Deposit successful");
        } catch (AccountNotFoundException | NegativeAmountException e) {
            e.printStackTrace();
        }

        // Ανάληψη ποσού με ssn που δεν αντιστοιχεί στον κάτοχο του λογαριασμού.
        try {
            accountService.withdraw("IBAN123", "00000000", 200.0);
            System.out.println("Withdrawal successful");
        } catch (AccountNotFoundException | SsnNotValidException | NegativeAmountException |
                 InsufficientBalanceException e) {
            e.printStackTrace();
        }
    }
}
