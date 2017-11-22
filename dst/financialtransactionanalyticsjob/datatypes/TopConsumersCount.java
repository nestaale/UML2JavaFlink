package financialtransactionanalyticsjob.datatypes;

public class TopConsumersCount {

    private Integer nTopConsumers;

    private ELong eventTime;
 
    public TopConsumersCount() {

    }

    public TopConsumersCount(Integer nTopConsumers, ELong eventTime) {
        this.nTopConsumers = nTopConsumers;
        this.eventTime = eventTime;
    }

    public Integer getnTopConsumers() {
        return nTopConsumers;
    }

    public void setnTopConsumers(Integer nTopConsumers) {
        this.nTopConsumers = nTopConsumers;
    }

    public ELong geteventTime() {
        return eventTime;
    }

    public void seteventTime(ELong eventTime) {
        this.eventTime = eventTime;
    }
 
    @Override
    public String toString() {
        return "(" + this.nTopConsumers + "," + this.eventTime + ")";
    }

}
