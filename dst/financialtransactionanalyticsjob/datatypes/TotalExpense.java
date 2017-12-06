package financialtransactionanalyticsjob.datatypes;

public class TotalExpense {

    private String dataSubject;

    private Integer totalExpense;

    private Long eventTime;
 
    public TotalExpense() {

    }

    public TotalExpense(String dataSubject, Integer totalExpense, Long eventTime) {
        this.dataSubject = dataSubject;
        this.totalExpense = totalExpense;
        this.eventTime = eventTime;
    }

    public String getDataSubject() {
        return dataSubject;
    }

    public void setDataSubject(String dataSubject) {
        this.dataSubject = dataSubject;
    }

    public Integer getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(Integer totalExpense) {
        this.totalExpense = totalExpense;
    }

    public Long getEventTime() {
        return eventTime;
    }

    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime;
    }
 
    @Override
    public String toString() {
        return "(" + this.dataSubject + "," + this.totalExpense + "," + this.eventTime + ")";
    }

}
