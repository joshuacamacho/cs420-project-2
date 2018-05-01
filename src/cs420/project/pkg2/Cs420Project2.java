package cs420.project.pkg2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * @author Josh
 */
public class Cs420Project2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 15;
        ArrayList test = new ArrayList();
        
        PriorityQueue<Nqueen> population = new PriorityQueue<Nqueen>(10,(Nqueen a, Nqueen b) 
                ->{return a.value() - b.value();}) ;
        
        
        
        
        for(int i=0; i<n; i++){
            test.add(i);
        }
        int[] test2 = new int[n];
        
        
        for(int i=0; i<400; i++){
            Collections.shuffle(test);
            for(int j=0; j<test2.length; j++){
                test2[j] = (int)test.get(j);
            }
            population.add(new Nqueen(test2));
        }
        
        GeneticDriver.execute(population).print();
//        AnnealingDriver.execute(new Nqueen(test2)).print();

    }

}
