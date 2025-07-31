// Request Class
class TransferRequest {
    private double amount;
    private String accountNumber;

    public TransferRequest(double amount, String accountNumber) {
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

// Abstract Handler
abstract class Validator {
    protected Validator next;

    public Validator setNext(Validator next) {
        this.next = next;
        return next;
    }

    public boolean validate(TransferRequest request) {
        if (handle(request)) {
            if (next != null) {
                return next.validate(request);
            } else {
                System.out.println("✅ Transfer Approved.");
                return true;
            }
        } else {
            return false;
        }
    }

    protected abstract boolean handle(TransferRequest request);
}

// Concrete Validators
class FormatValidator extends Validator {
    protected boolean handle(TransferRequest request) {
        if (request.getAmount() <= 0 || request.getAccountNumber() == null || request.getAccountNumber().isEmpty()) {
            System.out.println("❌ Format Error: Amount must be > 0 and account number must be present.");
            return false;
        }
        return true;
    }
}

class DailyLimitValidator extends Validator {
    protected boolean handle(TransferRequest request) {
        if (request.getAmount() > 100000) {
            System.out.println("❌ Daily Limit Error: Cannot transfer more than Rs. 100,000.");
            return false;
        }
        return true;
    }
}

class FraudCheckValidator extends Validator {
    protected boolean handle(TransferRequest request) {
        if (request.getAmount() > 50000) {
            System.out.println("❌ Fraud Check Failed: Suspicious transaction over Rs. 50,000.");
            return false;
        }
        return true;
    }
}

// Client
public class BankingApp {
    public static void main(String[] args) {
        TransferRequest request = new TransferRequest(50000, "ACC12345");

        // Set up chain
        Validator chain = new FormatValidator();
        chain.setNext(new DailyLimitValidator())
                .setNext(new FraudCheckValidator());

        // Validate request
        chain.validate(request);
    }
}
