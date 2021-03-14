package dev.debride.entities;


import javax.persistence.*;

@Entity
@Table(name="expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="expense_id")
    private int id;

    @Column(name="amount")
    private double amount;

    @Column(name="reason")
    private String reason;

    @Column(name="status")
    private String status;

    @Column(name="date_submitted")
    private long submitted;

    @Column(name="date_approved_or_denied")
    private long approvedordenied;

    @Column(name="e_id")
    @JoinColumn(name="e_id")
    private int employeeId; // foreign key

    public Expense(){}

    public Expense(int id, double amount, String reason, String status, long submitted, long approvedordenied, int employeeId) {
        this.id = id;
        this.amount = amount;
        this.reason = reason;
        this.status = status;
        this.submitted = submitted;
        this.approvedordenied = approvedordenied;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getSubmitted() {
        return submitted;
    }

    public void setSubmitted(long submitted) {
        this.submitted = submitted;
    }

    public long getApprovedordenied() {
        return approvedordenied;
    }

    public void setApprovedordenied(long approvedordenied) {
        this.approvedordenied = approvedordenied;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", amount=" + amount +
                ", reason='" + reason + '\'' +
                ", status='" + status + '\'' +
                ", submitted=" + submitted +
                ", approvedordenied=" + approvedordenied +
                ", employeeId=" + employeeId +
                '}';
    }
}
