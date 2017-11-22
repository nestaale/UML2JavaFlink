package financialtransactionanalyticsjob.functions;

import financialtransactionanalyticsjob.datatypes.TopConsumersCount;
import financialtransactionanalyticsjob.datatypes.TransactionCount;
import financialtransactionanalyticsjob.datatypes.TotalExpense;
import financialtransactionanalyticsjob.datatypes.FinancialTransaction;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.util.Collector;

public class TransactionParser extends RichMapFunction<String, FinancialTransaction> {

  @Override
  public void open(Configuration parameters) throws Exception {

  }

  @Override
  public FinancialTransactionFinancialTransaction map (String value) throws Exception {
            String[] fields = s.split(",");
        return new FinancialTransaction(
                fields[0],
                fields[1],
                fields[2],
                Long.parseLong(fields[3]),
                Integer.parseInt(fields[4]));
  }
}
