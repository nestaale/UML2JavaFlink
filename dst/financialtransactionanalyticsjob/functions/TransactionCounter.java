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

public class TransactionCounter extends RichWindowFunction<FinancialTransaction, TransactionCount> {

          //FALSE WindowedDataStream
          //.keyBy("dataSubject") TRUE  KeyedDataStream
          //richwindowfunction se e' keyed, richall altrimenti.....

  @Override
  public void open(Configuration parameters) throws Exception {

  }

  @Override
  public void apply (FinancialTransaction value, Collector<TransactionCount> out) throws Exception {
            Integer count = 0;
        for(FinancialTransaction t: iterable){
            count = count + 1;
        }
        collector.collect(new TransactionCount((String) s.getField(0), count, timeWindow.getEnd()));
  }
}
