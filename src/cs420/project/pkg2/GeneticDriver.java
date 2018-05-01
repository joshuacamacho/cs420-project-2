package cs420.project.pkg2;

import java.util.PriorityQueue;
import java.util.Random;

/**
 *
 * @author Josh
 */
public class GeneticDriver {
    
    
    public static Nqueen execute(PriorityQueue<Nqueen> population){
        Random rand = new Random();
        while(true){
            Nqueen x = population.poll();
            Nqueen y = population.poll();
            if(x == null || y == null) return new Nqueen(new int[]{1,2,3});
            if(x.value() == 0) return x;
            if(y.value() == 0) return y;
            Nqueen child = x.reproduce(y);
            if(child.value()==0) return child;
            if(rand.nextInt(100)< 80){
                child.mutate();
            }
            population.add(child);
            population.add(x);
        }
    }
}
