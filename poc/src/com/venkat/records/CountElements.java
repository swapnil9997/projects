package com.venkat.records;


public class CountElements {
    public static void main(String[] args) {


        int[] numbers = {1, 2, 3, 4, 5, 3, 7, 6};

        Map<Integer, Integer> countEle = countElements(numbers);
        
        for(Map.Entry<Integer,Integer> entry : countEle.entrySet()) {
            System.out.println(entry.getKey()+ "  "+entry.getValue());
        }

    }
      public static  Map<Integer,Ineger> countElements (int[] numbers) {
            Map<Integer, Integer> countEle = new HashMap<>();

            for(int number: numbers) {
                if(countEle.containsKey(number)){
                    countEle.put(number,countEle.get(number) +1);

                }else {
                    countEle.put(number,1);
                }
            }

            return countMap;
        }







}
