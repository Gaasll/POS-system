package se.kth.iv1350.amazingpos.model;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class TotalRevenueFiileOutput {
    public class TotalRevenueFileOutput implements Observer{
        String fileLoc = "";
        double amount;
        public TotalRevenueFileOutput(){
            amount = 0;
            fileLoc = "se/kth/iv1350/amazingpos/model/";
    
        }
    
        /**
         * Updates the observer with the amount of money
         * @param amount amount of money 
         */
        @Override
        public void update(double amount) {
            this.amount += amount;
            try {
                PrintWriter logger = new PrintWriter(fileLoc);
                logger.println(totalToString());
                logger.close();
            } catch (FileNotFoundException e) {
                System.out.println("Not found!");
                e.printStackTrace();
            }
        }
    
        /**
         * Returns a string of what the observer observs
         * @return
         */
        @Override
        public String totalToString(){
            return "OBSERVER: "+ amount + " SEK since start.";
        }
    } 
}