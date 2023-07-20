package greedyProb;

public class KnapsackItem {
    public int index, value, weight;
    public double ratio; //Documents and Settings

    public KnapsackItem(int index, int value, int weight){
        this.index = index;
        this.value = value;
        this.weight = weight;
        this.ratio = value * 1.0/weight;
    }

    @Override
    public String toString(){
        return "Item index: " + index + ", value: " + value + ", weight: " + weight + ", ratio: " + ratio;
    }
}
