/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs420.project.pkg2;

/**
 *
 * @author Josh
 */
public abstract class Timing {
    protected int size;
    protected long totalCost;
    protected long totalTime;
    protected long temp;
    protected int successCount;
    public Timing(){
        size=0;
        totalCost=0;
        totalTime=0;
        temp=0;
    }
    public long getAveCost(){
        return totalCost/size;
    }
    
    protected void startTime(){
        temp=System.nanoTime();
    }
    
    protected void endTime(){
        totalTime += temp - System.nanoTime();
    }
    
    public long getAveTime(){
        return totalTime/size;
    }
    
    public double successRate(){
        return (double)successCount/(double)size;
    }
    
    public double successCount(){
        return successCount;
    }
}
