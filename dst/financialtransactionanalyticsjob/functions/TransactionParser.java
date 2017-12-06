package financialtransactionanalyticsjob.functions;

import financialtransactionanalyticsjob.datatypes.TopConsumersCount;
import financialtransactionanalyticsjob.datatypes.TransactionCount;
import financialtransactionanalyticsjob.datatypes.TotalExpense;
import financialtransactionanalyticsjob.datatypes.FinancialTransaction;

import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;



public class TransactionParser extends RichMapFunction<String, FinancialTransaction> {

  @Override
  public void open(Configuration parameters) throws Exception {

  }

  @Override
  public FinancialTransaction map (String value) throws Exception {
                String[] fields = value.split(",");
                return new FinancialTransaction(
                        fields[0],
                        fields[1],
                        Integer.parseInt(fields[2]),
                        fields[3],
                        Long.parseLong(fields[4])
                        );
  }
}
