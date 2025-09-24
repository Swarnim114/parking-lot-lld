import java.util.Date;

public class Payment {
    private String paymentId;
    private double amount;
    private Date paymentTime;
    private PaymentStatus status;

    public Payment(String paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentTime = new Date(); // Current time
        this.status = PaymentStatus.PENDING;
    }

    public boolean process() {
        // Simulate payment processing
        // In real implementation, this would involve payment gateway
        try {
            Thread.sleep(100); // Simulate processing time
            this.status = PaymentStatus.COMPLETED;
            return true;
        } catch (InterruptedException e) {
            this.status = PaymentStatus.FAILED;
            return false;
        }
    }

    // Getters
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

    // Setters
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", paymentTime=" + paymentTime +
                ", status=" + status +
                '}';
    }
}