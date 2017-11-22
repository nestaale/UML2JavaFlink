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

public class FinancialTransactionAnalyticsJob {

    public static void main(String[] args) throws Exception {

       final StreamExecutionEnvironment env = StreamExecutionEnvironment
               .getExecutionEnvironment();

       env.setParallelism(1);

//MapOperation object
//TransactionParser c.name
       DataStream<FinancialTransaction> transactions = rawTransactions
          .map(new TransactionParser);
          //.setParallelism(4);
          .assignTimestampsAndWatermarks();
//to be asked...

//WindowFunction object
//ExpensesCalculator c.name
       DataStream<TotalExpense> totalExpenses = transactions
//WindowedDataStream
//isSliding=false
          .timeWindow(Time.minutes(5))
          .apply(new ExpensesCalculator())
          .keyBy("dataSubject")
          .setParallelism(0);
//WindowFunction object
//TransactionCounter c.name
       DataStream<TransactionCount> nTransactions = transactions
//WindowedDataStream
//isSliding=false
          .timeWindow(Time.minutes(5))
          .apply(new TransactionCounter())
          .keyBy("dataSubject")
          .setParallelism(0);
//WindowFunction object
//TopConsumersCounter c.name
       DataStream<TopConsumersCount> topConsumers = totalExpenses
//NonParallelDataStream
//isSliding=false
          .timeWindow(Time.minutes(30))
          .apply(new TopConsumersCounter())
          .setParallelism(0);
//TextFileDataSink object
//TotalExpensesSink c.name
       totalExpenses
          .keyBy("dataSubject")
          AsText("/home/utente/totalExpenses.txt")
          .setParallelism(1);

//TextFileDataSink object
//NumberOfTransactionsSink c.name
       nTransactions
          .keyBy("dataSubject")
          AsText("/home/utente/nTransactions.txt")
          .setParallelism(1);

//TextFileDataSink object
//TopConsumersSink c.name
       topConsumers
          AsText("/home/utente/topConsumers.txt")
          .setParallelism(1);

//DataflowDataTypes object
//Example1Datatypes c.name
//SocketTextDataSource object
//TransactionDataSource c.name
       DataStream<String> rawTransactions = env.socketTextStream("127.0.0.1", 9999)
                .setParallelism(1);


       env.execute();

    }
}
