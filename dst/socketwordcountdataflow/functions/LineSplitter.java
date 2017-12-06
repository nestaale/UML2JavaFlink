package socketwordcountdataflow.functions;

import socketwordcountdataflow.datatypes.WordCount;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;



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
