package gr.aueb.cf.OOProjects.bankapp;

import gr.aueb.cf.ch12.Holder;
import gr.aueb.cf.OOProjects.bankapp.model.JointAccount;
import gr.aueb.cf.OOProjects.bankapp.model.OverdraftAccount;

import java.util.Locale;

/**
 * Driver class.
 * Creates an instance/object of {@link JointAccount}
 * and {@link OverdraftAccount}.
 */
public class MainJointAccount {

    public static void main(String[] args) {
        JointAccount jointAcc1 = new JointAccount(
                                        new Holder(1L, "Alice", "W.", "ssn12345"),
                                        new Holder(15L, "Bob", "R.", "ssn5678"),
                                        "GR123098");
        OverdraftAccount account = new OverdraftAccount(jointAcc1, 3.500);

        try {
            account.withdraw(5.000, "ssn5678");
            System.out.println("Your IBAN account is: " + jointAcc1.getIban());
            System.out.printf(Locale.ENGLISH, "Successful withdrawal!\nThe new balance account is: %" +
                    ".3f", account.getAccountBalance());
            System.out.println();
        } catch (Exception e) {
            System.out.println("Sorry, you don' t have permission to this account!");
        }

    }
}
