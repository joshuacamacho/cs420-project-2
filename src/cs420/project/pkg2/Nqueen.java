package cs420.project.pkg2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Josh
 */
public class Nqueen{

    private int n;
    private int[] state;
    private int value;
    public int staleCount=0;
    public Nqueen (int[] state){
        this.state = state;
        this.n = state.length;
        this.value = calcValue();
    }
    
    public Nqueen(int size){
        this.state = new int[size];
        this.n = size;
        
        ArrayList<Integer> test = new ArrayList<Integer>();
        for(int i=0; i<n; i++){
            test.add(i);
        }
        Collections.shuffle(test, Cs420Project2.rand);
        for(int j=0; j<test.size(); j++){
                state[j] = test.get(j);
            }
        this.value = calcValue();
    }
    
    public Nqueen randomChild(){
        int col = Cs420Project2.rand.nextInt(n);
        int row = Cs420Project2.rand.nextInt(n);
        while(row==state[col]){
            row = Cs420Project2.rand.nextInt(n);
        }
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
                    break;
                }else if(Math.abs(j-i) == Math.abs(state[j] - state[i])){
                    val++;
                    break;
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
        int pos = Cs420Project2.rand.nextInt(n);
        int val = Cs420Project2.rand.nextInt(n);
        while(state[pos]==val){
            val = Cs420Project2.rand.nextInt(n);
        }
        state[pos]=val;
    }
    
    public Nqueen reproduce(Nqueen mate){

        int roll = Cs420Project2.rand.nextInt(n);
        
        int[] mateState = mate.getState();
        int[] child = new int[n];
        for(int i=0; i<n; i++){
            if( i < roll ){
                child[i]=state[i];
            }else{
                child[i]=mateState[i];
            }
        }
        
        return new Nqueen(child);
    }
}

