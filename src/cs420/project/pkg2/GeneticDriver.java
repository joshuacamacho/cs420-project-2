package cs420.project.pkg2;

import java.util.PriorityQueue;
import java.util.Random;

/**
 *
 * @author Josh
 */
public class GeneticDriver extends Timing{
    
    
    public Nqueen execute(PriorityQueue<Nqueen> population){
        size++;

        startTime();
        Nqueen current = population.peek();
        PriorityQueue<Nqueen> pop = population;
        int max = 1000000;
        while(current.value()!=0 & max > 0){
                max--;
                totalCost++;
                Nqueen x = pop.poll();
                Nqueen y = pop.poll();

                Nqueen child = x.reproduce(y);
                if(child.value()==0) {
                    current = child;
                    break;
                }
                if(Cs420Project2.rand.nextInt(100)<5){
                    child.mutate();
                }
                if(child.value()==0) {
                    current = child;
                    break;
                }
                pop.add(x);
                pop.add(y);
                pop.add(child);
        }
        endTime();
        if(current.value()==0) successCount++;
        return current;
    }
}
