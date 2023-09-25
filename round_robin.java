import java.util.*;

class RoundRobinSchedular {
    private Queue<Task> taskQueue;
    private int timeQuantum;
    
    public  RoundRobinSchedular(int timeQuantum){
        this.taskQueue = new LinkedList<>();
        this.timeQuantum = timeQuantum;
    }
    
    public void enqueueTask(Task task){
        taskQueue.add(task);
    }
    
    public void executeTask(){
        while(!taskQueue.isEmpty()){
            Task currentTask = taskQueue.poll();
            int executionTime = Math.min(timeQuantum,currentTask.getRemainingTime());
            System.out.println("Executing task : "+currentTask.getId()+" for "+executionTime);
            currentTask.setRemainingTime(currentTask.getRemainingTime()- executionTime);
            
            if(currentTask.getRemainingTime()>0){
                taskQueue.add(currentTask);
            }
        }
    }
}


class Task {
    private String id;
    private int remainingTime;
    private int arrivalTime;
    
    public Task(String id,int remainingTime,int arrivalTime){
        this.id=id;
        this.remainingTime=remainingTime;
        this.arrivalTime = arrivalTime;
    }
    
    public String getId(){
        return id;
    }
    public int getRemainingTime(){
        return remainingTime;
    }
    
    public void setRemainingTime(int remainingTime){
        this.remainingTime = remainingTime;
    }
    
    public int getArrivalTime(){
        return arrivalTime;
    }
}



public class Main {
    public static void main(String args[]){
        RoundRobinSchedular schedular = new RoundRobinSchedular(5);
        Task task1 = new Task("task 1",5,0);
        Task task2 = new Task("task 2",10,10);
        Task task3= new Task("task 3",15,20);

        schedular.enqueueTask(task1);
        schedular.enqueueTask(task2);
        schedular.enqueueTask(task3);
        
        schedular.executeTask();
    }
}