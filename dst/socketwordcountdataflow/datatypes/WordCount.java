package socketwordcountdataflow.datatypes;

public class WordCount {
    private String word;

    private Integer count;
 
    public WordCount() {

    }

    public WordCount(String word,Integer count) {
        this.word = word;
        this.count = count;
    }

    public String getword() {
        return word;
    }

    public void setword(String word) {
        this.word = word;
    }

    public Integer getcount() {
        return count;
    }

    public void setcount(Integer count) {
        this.count = count;
    }
 
    @Override
    public String toString() {
        return "(" + this.word + this.count + ")";
    }

}
