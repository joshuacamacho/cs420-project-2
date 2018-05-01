package cs420.project.pkg2;

import java.util.Random;

/**
 *
 * @author Josh
 */
public class Nqueen {
    private int n;
    private int[] state;
    private int value;
    public Nqueen (int[] state){
        this.state = state;
        this.n = state.length;
        this.value = calcValue();
    }
    
    public Nqueen randomChild(){
        Random rand = new Random();
        int col = rand.nextInt(n);
        int row = rand.nextInt(n);
        int [] newState = state.clone();
        newState[col] = row;

        return new Nqueen(newState);
    }
    
    public int value(){
        return this.value;
    }
    
    public int[] getState(){
        return state;
    }
    
    private int calcValue(){
        int val = 0;
        for(int i=0; i<state.length; i++){
            
            for(int j=0; j<state.length; j++){
                if(i==j) continue;
                if(state[i] == state[j]){
                    val++;
                }else if(Math.abs(j-i) == Math.abs(state[j] - state[i])){
                    val++;
                }
            }
        }
        return val;
    }    
    
    public void print(){
        for(int i=0; i<state.length; i++){
            for(int j=0; j<state.length; j++){
                System.out.print(
                        state[j] == i ? "Q " : "- " 
                );
            }
            System.out.print('\n');
        }
    }
    
    public void mutate(){
        Random rand = new Random();
        int pos = rand.nextInt(n);
        int val = rand.nextInt(n);
        this.state[pos] = val;
    }
    
    public Nqueen reproduce(Nqueen mate){
        Random rand = new Random();
        int roll = rand.nextInt(n);
        int[] mateState = mate.getState();
        int[] child = new int[n];
        for(int i=0; i<n; i++){
            if(i<roll){
                child[i]=state[i];
            }else{
                child[i]=mateState[i];
            }
        }
        
        return new Nqueen(child);
    }
}

