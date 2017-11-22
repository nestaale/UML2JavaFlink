package financialtransactionanalyticsjob.datatypes;

public class FinancialTransaction {

    private String transactionId;

    private String dataSubject;

    private Integer amount;

    private String recipient;

    private ELong eventTime;
 
    public FinancialTransaction() {

    }

    public FinancialTransaction(String transactionId, String dataSubject, Integer amount, String recipient, ELong eventTime) {
        this.transactionId = transactionId;
        this.dataSubject = dataSubject;
        this.amount = amount;
        this.recipient = recipient;
        this.eventTime = eventTime;
    }

    public String gettransactionId() {
        return transactionId;
    }

    public void settransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getdataSubject() {
        return dataSubject;
    }

    public void setdataSubject(String dataSubject) {
        this.dataSubject = dataSubject;
    }

    public Integer getamount() {
        return amount;
    }

    public void setamount(Integer amount) {
        this.amount = amount;
    }

    public String getrecipient() {
        return recipient;
    }

    public void setrecipient(String recipient) {
        this.recipient = recipient;
    }

    public ELong geteventTime() {
        return eventTime;
    }

    public void seteventTime(ELong eventTime) {
        this.eventTime = eventTime;
    }
 
    @Override
    public String toString() {
        return "(" + this.transactionId + "," + this.dataSubject + "," + this.amount + "," + this.recipient + "," + this.eventTime + ")";
    }

}
