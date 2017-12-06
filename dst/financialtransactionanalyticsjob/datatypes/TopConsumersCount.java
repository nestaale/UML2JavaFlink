package financialtransactionanalyticsjob.datatypes;

public class TopConsumersCount {

    private Integer nTopConsumers;

    private Long eventTime;
 
    public TopConsumersCount() {

    }

    public TopConsumersCount(Integer nTopConsumers, Long eventTime) {
        this.nTopConsumers = nTopConsumers;
        this.eventTime = eventTime;
    }

    public Integer getNTopConsumers() {
        return nTopConsumers;
    }

    public void setNTopConsumers(Integer nTopConsumers) {
        this.nTopConsumers = nTopConsumers;
    }

    public Long getEventTime() {
        return eventTime;
    }

    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime;
    }
 
    @Override
    public String toString() {
        return "(" + this.nTopConsumers + "," + this.eventTime + ")";
    }

}
