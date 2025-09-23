import java.util.Date;

public class Payment {
    private String paymentId;
    private double amount;
    private Date paymentTime;
    private PaymentStatus status;

    public Payment(String paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentTime = new Date();
        this.status = PaymentStatus.PENDING;
    }

    public boolean processPayment() {
        // Logic to process payment
        this.status = PaymentStatus.COMPLETED;
        return true;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
