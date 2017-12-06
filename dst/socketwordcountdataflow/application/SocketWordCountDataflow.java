package socketwordcountdataflow.application;

import socketwordcountdataflow.datatypes.WordCount; 
import socketwordcountdataflow.functions.LineSplitter; 
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;

public class SocketWordCountDataflow {

    public static void main(String[] args) throws Exception {

       final StreamExecutionEnvironment env = StreamExecutionEnvironment
               .getExecutionEnvironment();
       
       //uncomment the below if you want to set the default parallelism for the project.
       //env.setParallelism(1);

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
          AsText("/home/utente/word-count-output.txt")
          .setParallelism(1);


       env.execute();

    }
}
