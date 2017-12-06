package financialtransactionanalyticsjob.datatypes;

public class FinancialTransaction {

    private String transactionId;

    private String dataSubject;

    private Integer amount;

    private String recipient;

    private Long eventTime;
 
    public FinancialTransaction() {

    }

    public FinancialTransaction(String transactionId, String dataSubject, Integer amount, String recipient, Long eventTime) {
        this.transactionId = transactionId;
        this.dataSubject = dataSubject;
        this.amount = amount;
        this.recipient = recipient;
        this.eventTime = eventTime;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getDataSubject() {
        return dataSubject;
    }

    public void setDataSubject(String dataSubject) {
        this.dataSubject = dataSubject;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Long getEventTime() {
        return eventTime;
    }

    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime;
    }
 
    @Override
    public String toString() {
        return "(" + this.transactionId + "," + this.dataSubject + "," + this.amount + "," + this.recipient + "," + this.eventTime + ")";
    }

}
