package financialtransactionanalyticsjob.datatypes;

public class TransactionCount {

    private String dataSubject;

    private Integer nTransactions;

    private ELong eventTime;
 
    public TransactionCount() {

    }

    public TransactionCount(String dataSubject, Integer nTransactions, ELong eventTime) {
        this.dataSubject = dataSubject;
        this.nTransactions = nTransactions;
        this.eventTime = eventTime;
    }

    public String getdataSubject() {
        return dataSubject;
    }

    public void setdataSubject(String dataSubject) {
        this.dataSubject = dataSubject;
    }

    public Integer getnTransactions() {
        return nTransactions;
    }

    public void setnTransactions(Integer nTransactions) {
        this.nTransactions = nTransactions;
    }

    public ELong geteventTime() {
        return eventTime;
    }

    public void seteventTime(ELong eventTime) {
        this.eventTime = eventTime;
    }
 
    @Override
    public String toString() {
        return "(" + this.dataSubject + "," + this.nTransactions + "," + this.eventTime + ")";
    }

}
