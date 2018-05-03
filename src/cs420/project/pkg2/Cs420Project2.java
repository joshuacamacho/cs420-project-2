package cs420.project.pkg2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

/**
 *
 * @author Josh
 */
public class Cs420Project2 {
    public static Random rand = new Random();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int n = 21;
        
        
        PriorityQueue<Nqueen> population = new PriorityQueue<Nqueen>(10,(Nqueen a, Nqueen b) 
                ->{return a.value() - b.value();}) ;
        
        
        
        AnnealingDriver d1 = new AnnealingDriver();
        GeneticDriver d2 = new GeneticDriver();
        
        for(int i=0; i<100; i++){
//            Nqueen test = new Nqueen(5);
//            test.print();
//            System.out.println(test.value());
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");  
            System.out.println("Working on Genetic Algorithm");
            System.out.println((float)i/100*100+"% Complete");
            // d1.execute(new Nqueen(n));
            population.clear();
            for(int j=0; j<500; j++){

    //          System.out.println('\n');
                population.add(new Nqueen(n));
            }
            d2.execute(population);
        }
        
//        System.out.println("average cost = "+d1.getAveCost());
        
        
        System.out.println("ave Genetic "+d2.getAveCost());
        System.out.println("successRate "+d2.successRate());
        System.out.println("successCount "+d2.successCount());

    }

}
