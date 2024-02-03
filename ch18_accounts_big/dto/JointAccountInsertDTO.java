package gr.aueb.cf.OOProjects.ch18_accounts_big.dto;

public class JointAccountInsertDTO extends BaseDTO {
    private AccountInsertDTO accountInsertDTO;
    private UserInsertDTO secondUserInsertDTO;

    public JointAccountInsertDTO() {
    }


    public JointAccountInsertDTO(AccountInsertDTO accountInsertDTO, UserInsertDTO secondUserInsertDTO) {
        this.accountInsertDTO = accountInsertDTO;
        this.secondUserInsertDTO = secondUserInsertDTO;
    }


    public AccountInsertDTO getAccountInsertDTO() {
        return accountInsertDTO;
    }


    public void setAccountInsertDTO(AccountInsertDTO accountInsertDTO) {
        this.accountInsertDTO = accountInsertDTO;
    }


    public UserInsertDTO getSecondUserInsertDTO() {
        return secondUserInsertDTO;
    }


    public void setSecondUserInsertDTO(UserInsertDTO secondUserInsertDTO) {
        this.secondUserInsertDTO = secondUserInsertDTO;
    }
}
