package cs420.project.pkg2;

/**
 *
 * @author Josh
 */
public class AnnealingDriver extends Timing {
    public Nqueen execute(Nqueen n){
        Nqueen nextState;
        Nqueen currentState = n;
        int count = 0;
        startTime();
        while (currentState.value() != 0) {
            double delta;
            double probability;
            double rand;
            
            
            for (double time = 1.0; time<1000.0; time++) {
                nextState = currentState.randomChild();
                delta = currentState.value() - nextState.value();
//                System.out.println("delta is" + delta);
                probability = Math.exp(delta / schedule(time));
//                System.out.println(time+","+probability);
                rand = Math.random();
                
                if (delta > 0) {
                    currentState = nextState;
                } else if (rand <= probability) {
                    currentState = nextState;
                }
                count++;
            }
        }
//        System.out.println("Cost - " + count);
        totalCost+=count;
        endTime();
        size++;
        return currentState;
    }

    private static double schedule(double x) {
        return 1.0/x;
    }
}
