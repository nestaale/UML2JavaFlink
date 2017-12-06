package financialtransactionanalyticsjob.application;

import financialtransactionanalyticsjob.functions.TransactionParser; 
import financialtransactionanalyticsjob.functions.ExpensesCalculator; 
import financialtransactionanalyticsjob.functions.TransactionCounter; 
import financialtransactionanalyticsjob.functions.TopConsumersCounter; 
import financialtransactionanalyticsjob.datatypes.TopConsumersCount; 
import financialtransactionanalyticsjob.datatypes.TransactionCount; 
import financialtransactionanalyticsjob.datatypes.TotalExpense; 
import financialtransactionanalyticsjob.datatypes.FinancialTransaction; 
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;

public class FinancialTransactionAnalyticsJob {

    public static void main(String[] args) throws Exception {

       final StreamExecutionEnvironment env = StreamExecutionEnvironment
               .getExecutionEnvironment();
       
       //uncomment the below if you want to set the default parallelism for the project.
       //env.setParallelism(1);

       DataStream<String> rawTransactions = env.socketTextStream("127.0.0.1", 9999)
                .setParallelism(1);

       DataStream<FinancialTransaction> transactions = rawTransactions
          .map(new TransactionParser());
          //.setParallelism(1);

       DataStream<TotalExpense> totalExpenses = transactions
          .keyBy("dataSubject")
          .timeWindow(Time.seconds(3))
          .apply(new ExpensesCalculator())
          .setParallelism(1);

       DataStream<TransactionCount> nTransactions = transactions
          .keyBy("dataSubject")
          .timeWindow(Time.seconds(3))
          .apply(new TransactionCounter())
          .setParallelism(1);

       DataStream<TopConsumersCount> topConsumers = totalExpenses
          .timeWindowAll(Time.seconds(9))
          .apply(new TopConsumersCounter())
          .setParallelism(1);

       totalExpenses
          .writeAsText("/home/utente/totalExpenses.txt")
          .setParallelism(1);

       nTransactions
          .writeAsText("/home/utente/nTransactions.txt")
          .setParallelism(1);

       topConsumers
          .writeAsText("/home/utente/topConsumers.txt")
          .setParallelism(1);


       env.execute();

    }
}
