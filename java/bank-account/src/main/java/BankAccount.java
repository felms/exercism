public class BankAccount {

    private int balance;
    private boolean openedAccount;

    public BankAccount() {
        this.balance = 0;
        this.openedAccount = false;
    }

    public void open() {
        this.openedAccount = true;
    }

    public int getBalance() throws BankAccountActionInvalidException {

        if (!this.openedAccount) {
            throw new BankAccountActionInvalidException("Account closed");
        }

        return this.balance;
    }

    public void deposit(int i) throws BankAccountActionInvalidException {

        if (!this.openedAccount) {
            throw new BankAccountActionInvalidException("Account closed");
        }

        if (i < 1) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }

        this.balance += i;
    }

    public void withdraw(int i) throws BankAccountActionInvalidException {

        if (!this.openedAccount) {
            throw new BankAccountActionInvalidException("Account closed");
        }
        
        if (this.balance == 0) {
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        }
        
        if (i < 1) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }

        if (i > this.balance) {
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        }

        this.balance -= i;
    }

    public void close() {
        this.openedAccount = false;
    }

}
