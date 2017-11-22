package financialtransactionanalyticsjob.datatypes;

public class TotalExpense {

    private String dataSubject;

    private Integer totalExpense;

    private ELong eventTime;
 
    public TotalExpense() {

    }

    public TotalExpense(String dataSubject, Integer totalExpense, ELong eventTime) {
        this.dataSubject = dataSubject;
        this.totalExpense = totalExpense;
        this.eventTime = eventTime;
    }

    public String getdataSubject() {
        return dataSubject;
    }

    public void setdataSubject(String dataSubject) {
        this.dataSubject = dataSubject;
    }

    public Integer gettotalExpense() {
        return totalExpense;
    }

    public void settotalExpense(Integer totalExpense) {
        this.totalExpense = totalExpense;
    }

    public ELong geteventTime() {
        return eventTime;
    }

    public void seteventTime(ELong eventTime) {
        this.eventTime = eventTime;
    }
 
    @Override
    public String toString() {
        return "(" + this.dataSubject + "," + this.totalExpense + "," + this.eventTime + ")";
    }

}
