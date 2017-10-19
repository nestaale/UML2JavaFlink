package socketwordcountdataflow.application;

import socketwordcountdataflow.datatypes.WordCount;
      
      
import socketwordcountdataflow.functions.LineSplitter;
            

public class SocketWordCountDataflow {

    public static void main(String[] args) throws Exception {

       final StreamExcecutionEnvironment env = StreamExcecutionEnvironment
               .getExcecutionEnvironment();

       env.setParallelism(1);

       DataStream<String> text = env.socketTextStream("localhost", 9999)
                .setParallelism(1);

       DataStream<WordCount> tokens = text
          .flatMap(new LineSplitter())
          .setParallelism(1);

       DataStream<WordCount> counts = tokens
          .keyBy("word")
          .sum("count")
          .setParallelism(1);

       counts
          .keyBy("word")
          .writeAsText("/home/utente/word-count-output.txt")
          .setParallelism(1);
    }

    env.execute();
}
