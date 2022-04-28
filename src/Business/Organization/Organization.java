package Business.Organization;
import Business.Account.AccountDirectory;

/**
 *
 * @author Ching-Fong Chen
 */
public abstract class Organization {
    private String name;
    private AccountDirectory accountDirectory;
    private int organizationID;
    private static int counter = 1;

    public Organization(String name) {
        this.name = name;
        accountDirectory = new AccountDirectory();
        organizationID = counter;
        ++counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountDirectory getAccountDirectory() {
        return accountDirectory;
    }

    public void setAccountDirectory(AccountDirectory accountDirectory) {
        this.accountDirectory = accountDirectory;
    }

    @Override
    public String toString() {
        return name;
    }
}

