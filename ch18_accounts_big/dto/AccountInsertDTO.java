package gr.aueb.cf.OOProjects.ch18_accounts_big.dto;

public class AccountInsertDTO extends BaseDTO {
    private String iban;
    private UserInsertDTO userInsertDTO;
    private double balance;

    public AccountInsertDTO() {
    }

    public AccountInsertDTO(String iban, UserInsertDTO userInsertDTO, double balance) {
        this.iban = iban;
        this.userInsertDTO = userInsertDTO;
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public UserInsertDTO getUserInsertDTO() {
        return userInsertDTO;
    }

    public void setUserInsertDTO(UserInsertDTO userInsertDTO) {
        this.userInsertDTO = userInsertDTO;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
