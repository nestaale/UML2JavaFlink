package financialtransactionanalyticsjob.functions;

import financialtransactionanalyticsjob.datatypes.TopConsumersCount;
import financialtransactionanalyticsjob.datatypes.TransactionCount;
import financialtransactionanalyticsjob.datatypes.TotalExpense;
import financialtransactionanalyticsjob.datatypes.FinancialTransaction;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.windowing.RichAllWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;


import java.util.HashMap;
import java.util.Map;

public class TopConsumersCounter extends RichAllWindowFunction<TotalExpense, TopConsumersCount, TimeWindow> {

  @Override
  public void open(Configuration parameters) throws Exception {

  }

  @Override
  public void apply (TimeWindow timeWindow, Iterable<TotalExpense> iterable, Collector<TopConsumersCount> collector) throws Exception {

                Map<String, Integer> partialSum = new HashMap<String, Integer>();
                Integer count = 0;
        
                for(TotalExpense t: iterable){
                    if(partialSum.containsKey(t.getDataSubject())){
                        partialSum.put(t.getDataSubject(), partialSum.get(t.getDataSubject()) + t.getTotalExpense());
                    } else {
                        partialSum.put(t.getDataSubject(), t.getTotalExpense());
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
