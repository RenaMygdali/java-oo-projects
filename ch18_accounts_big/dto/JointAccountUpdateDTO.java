package gr.aueb.cf.OOProjects.ch18_accounts_big.dto;

public class JointAccountUpdateDTO extends BaseDTO {
    private AccountUpdateDTO accountUpdateDTO;
    private UserUpdateDTO secondUserUpdateDTO;

    public JointAccountUpdateDTO() {
    }

    public JointAccountUpdateDTO(AccountUpdateDTO accountUpdateDTO, UserUpdateDTO userUpdateDTO) {
        this.accountUpdateDTO = accountUpdateDTO;
        this.secondUserUpdateDTO = userUpdateDTO;
    }

    public AccountUpdateDTO getAccountUpdateDTO() {
        return accountUpdateDTO;
    }


    public void setAccountUpdateDTO(AccountUpdateDTO accountUpdateDTO) {
        this.accountUpdateDTO = accountUpdateDTO;
    }


    public UserUpdateDTO getSecondUserUpdateDTO() {
        return secondUserUpdateDTO;
    }


    public void setSecondUserUpdateDTO(UserUpdateDTO secondUserUpdateDTO) {
        this.secondUserUpdateDTO = secondUserUpdateDTO;
    }
}
