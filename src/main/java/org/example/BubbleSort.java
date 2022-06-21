package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
    public List<Comparable> sort(List<Comparable> input){
        if(input==null) throw new RuntimeException();

        List<BigDecimal> arr = new ArrayList<>();

        for (Comparable comparable : input) {//converting input array to bigdecimals so that the comparing is possible
            BigDecimal result = null;

            if (comparable == null)
                continue;
            if (comparable instanceof Double)
                result = BigDecimal.valueOf((Double) comparable);
            if (comparable instanceof Integer)
                result = BigDecimal.valueOf((Integer) comparable);

            arr.add(result);
        }

        //BubbleSort
        int length=arr.size();
        int wsk1;
        int wsk2;
        int numberOfSwaps=-1;
        while (numberOfSwaps!=0){
            numberOfSwaps=0;

            for(int i=length-1;i>0;i--){
                wsk2=i;
                wsk1=i-1;
                int value=arr.get(wsk1).compareTo(arr.get(wsk2));
                if(value>0){
                BigDecimal temp= arr.get(wsk1);
                arr.set(wsk1,arr.get(wsk2));
                arr.set(wsk2, temp);
                numberOfSwaps++;
                }
            }
        }

        List<Comparable> returnList=new ArrayList<>();

        for (BigDecimal value : arr) {
            if (isIntegerValue(value)) {//if it's only int ->convert to int
                returnList.add(value.intValue());
                continue;
            }
            returnList.add(value.doubleValue());

        }


        return returnList;
    }

    private boolean isIntegerValue(BigDecimal bd) {
        return bd.stripTrailingZeros().scale() <= 0;
    }
}
