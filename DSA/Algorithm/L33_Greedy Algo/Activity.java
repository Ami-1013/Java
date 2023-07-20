package greedyProb;


public class Activity {
    public String name;
    public int startTime, finishTime;

    public Activity(String name, int startTime, int finishTime){
        this.name = name;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    @Override
    public String toString(){
        return "Activity: " + name + ", startTime: " + startTime + ", finishTime: " + finishTime;
    }

}
