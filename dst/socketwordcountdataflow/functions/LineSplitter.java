package socketwordcountdataflow.functions;

public class LineSplitter implements FlatMapFunction<String, WordCount> {

  @Override
  public void flatMap (String value, Collector<WordCount> out) {
    String[] tokens = value.toLowerCase().split("\\W+");

for (String token : tokens) {
    if (token.length() > 0) {
        out.collect(new WordCount(token, 1));

    }
}
  }
}
