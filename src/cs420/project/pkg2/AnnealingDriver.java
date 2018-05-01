package cs420.project.pkg2;

/**
 *
 * @author Josh
 */
public class AnnealingDriver {
    public static Nqueen execute(Nqueen n){
        Nqueen nextState;
        Nqueen currentState = n;
        while (currentState.value() != 0) {
            double temperature;
            double delta;
            double probability;
            double rand;

            
            for (int time = 0; time<1000; time++) {
                nextState = currentState.randomChild();
                delta = currentState.value() - nextState.value();
                probability = Math.exp(delta / schedule(time));
                rand = Math.random();

                if (delta > 0) {
                    currentState = nextState;
                } else if (rand <= probability) {
                    currentState = nextState;
                }
            }
        }
        return currentState;
    }

    private static double schedule(int x) {
        return 1000 -
    }
}
