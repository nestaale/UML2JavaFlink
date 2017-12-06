package financialtransactionanalyticsjob.functions;

import financialtransactionanalyticsjob.datatypes.TopConsumersCount;
import financialtransactionanalyticsjob.datatypes.TransactionCount;
import financialtransactionanalyticsjob.datatypes.TotalExpense;
import financialtransactionanalyticsjob.datatypes.FinancialTransaction;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.streaming.api.functions.windowing.RichWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;



public class ExpensesCalculator extends RichWindowFunction<FinancialTransaction, TotalExpense, Tuple, TimeWindow> {

  @Override
  public void open(Configuration parameters) throws Exception {

  }

  @Override
  public void apply (Tuple value, TimeWindow timeWindow, Iterable<FinancialTransaction> iterable, Collector<TotalExpense> collector) throws Exception {

            Integer sum = 0;
            for(FinancialTransaction t: iterable){
                sum = sum + t.getAmount();
            }
            collector.collect(new TotalExpense((String) value.getField(0), sum, timeWindow.getEnd()));
       
  }
}
