package gr.aueb.cf.OOProjects.ch18.dto;

public class AccountUpdateDTO extends BaseDTO {
    private String iban;
    private UserUpdateDTO userUpdateDTO;
    private double balance;

    public AccountUpdateDTO() {
    }

    public AccountUpdateDTO(String iban, UserUpdateDTO userUpdateDTO, double balance) {
        this.iban = iban;
        this.userUpdateDTO = userUpdateDTO;
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public UserUpdateDTO getUserUpdateDTO() {
        return userUpdateDTO;
    }

    public void setUserUpdateDTO(UserUpdateDTO userUpdateDTO) {
        this.userUpdateDTO = userUpdateDTO;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
