package financialtransactionanalyticsjob.functions;

import financialtransactionanalyticsjob.datatypes.TopConsumersCount;
import financialtransactionanalyticsjob.datatypes.TransactionCount;
import financialtransactionanalyticsjob.datatypes.TotalExpense;
import financialtransactionanalyticsjob.datatypes.FinancialTransaction;

import org.apache.flink.api.common.functions.ApplyFunction;
import org.apache.flink.api.java.tuple.Tuple; //only for Windowfunction
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.windowing.RichAllWindowFunction;
import org.apache.flink.streaming.api.functions.windowing.RichWindowFunction; //only for Windowfunction
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

public class TopConsumersCounter extends RichWindowFunction<TotalExpense, TopConsumersCount> {

          //FALSE NonParallelDataStream
          //FALSE WindowedDataStream
          //richwindowfunction se e' keyed, richall altrimenti.....

  @Override
  public void open(Configuration parameters) throws Exception {

  }

  @Override
  public void apply (TotalExpense value, Collector<TopConsumersCount> out) throws Exception {
            Map<String, Integer> partialSum = new HashMap<String, Integer>();
        Integer count = 0;

        for(TotalExpense t: iterable){
            if(partialSum.containsKey(t.getDataSubject())){
                partialSum.put(t.getDataSubject(), partialSum.get(t.getDataSubject()) + t.getAmount());
            } else {
                partialSum.put(t.getDataSubject(), t.getAmount());
            }
        }

        for(String ds: partialSum.keySet()) {
            if(partialSum.get(ds) > 1000) {
                count = count + 1;
            }
        }

        collector.collect(new TopConsumersCount(count, timeWindow.getEnd()));
  }
}
