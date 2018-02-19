package ThoughtWorks.WorkEngine;

import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONArray;

public class PermutationSolver implements Solver{

    private void sumUp(ArrayList<Integer> realNumber, ArrayList<Integer> numbers, int target) {
    	JSONArray jsonArr = new JSONArray();
    	this.sum_up_recursive(realNumber, numbers, target, new ArrayList<Integer>(), jsonArr);
    	for(int i =0; i < jsonArr.length(); i++) {
    		System.out.println(jsonArr.get(i));
    	}
    }
    private void sum_up_recursive(ArrayList<Integer> realNumber, ArrayList<Integer> numbers, int target, ArrayList<Integer> partial, JSONArray jsonArr) {
        int s = 0;
        for (int x: partial) {
        	s += x;
        	System.out.println(x);
        }
        if (s == target) 
        	jsonArr.put(Arrays.toString(partial.toArray()));
//             System.out.println("sum("+Arrays.toString(partial.toArray())+")="+target);
        if (s >= target)
             return;
        for(int i=0;i<numbers.size();i++) {
              ArrayList<Integer> remaining = new ArrayList<Integer>();
              int n = numbers.get(i);
              for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
              ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
              partial_rec.add(n);
              sum_up_recursive(realNumber, remaining,target,partial_rec,jsonArr);
        }
     }
	@Override
	public int[] allocate(int[] sessionDurations, int[] talkDuration) {
		Integer[] numbers = Arrays.stream( sessionDurations ).boxed().toArray( Integer[]::new );
		int targetValue = talkDuration[0];
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(numbers));
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(numbers));
        sumUp(list, list1, targetValue);
        return null;
	}

}
