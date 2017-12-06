package financialtransactionanalyticsjob.datatypes;

public class TransactionCount {

    private String dataSubject;

    private Integer nTransactions;

    private Long eventTime;
 
    public TransactionCount() {

    }

    public TransactionCount(String dataSubject, Integer nTransactions, Long eventTime) {
        this.dataSubject = dataSubject;
        this.nTransactions = nTransactions;
        this.eventTime = eventTime;
    }

    public String getDataSubject() {
        return dataSubject;
    }

    public void setDataSubject(String dataSubject) {
        this.dataSubject = dataSubject;
    }

    public Integer getNTransactions() {
        return nTransactions;
    }

    public void setNTransactions(Integer nTransactions) {
        this.nTransactions = nTransactions;
    }

    public Long getEventTime() {
        return eventTime;
    }

    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime;
    }
 
    @Override
    public String toString() {
        return "(" + this.dataSubject + "," + this.nTransactions + "," + this.eventTime + ")";
    }

}
