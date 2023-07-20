package greedyProb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import greedyProb.Activity;

public class ActivitySelection {
    
    public static void activitySelection(ArrayList<Activity> activityList){
        Comparator<Activity> finishTimeComparator = new Comparator<>(){
            @Override
            public int compare(Activity o1, Activity o2){
                return o1.finishTime  - o2.finishTime; 
            }
        };
        Collections.sort(activityList, finishTimeComparator); // t.c - NLog(N)

        Activity previousActivity = activityList.get(0);
        System.out.println("\n\nRecommended Schedule:\n" + previousActivity);

        for (int i=1; i<activityList.size(); i++){
            Activity activity = activityList.get(i);
            if (activity.startTime >= previousActivity.finishTime){
                System.out.println(activity); // Activity class "toString"
                previousActivity = activity;
            }
        }
    }
    // t.c - NLog(N) &  s.c - O(1)
}
