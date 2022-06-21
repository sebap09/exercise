package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class BalancedWordsCounter {
    public Integer count(String input){
        if(input==null||!input.chars().allMatch(Character::isLetter))//null or non letter
            throw new RuntimeException();

        Map<String,Integer> map=new HashMap<>();

        for(int j=0;j<input.length();j++){
            for(int i=0;i<input.length()-j;i++){
                String subword=input.substring(i,i+j+1);//generate subwords of 1 char/2 chars/3 chars itd

                if(!isBalanced(subword))
                    continue;//omit unbalanced word

                Integer value=map.get(subword);
                if(value==null)//if key doesn't exists its value is null
                    value=0;

                map.put(subword,++value);
            }
        }
        return map.values().stream().mapToInt(o->o).sum();//sum of values from map
    }


    private boolean isBalanced(String subword){
        Map<String,Integer> map=new HashMap<>();

        for(int i=0;i<subword.length();i++){//iterate over characters
            char ch=subword.charAt(i);
            String sentence=Character.toString(ch);

            Integer value=map.get(sentence);
            if(value==null)//if key doesn't exists its value is null
                value=0;

            map.put(sentence,++value);
        }
        return new HashSet<>(map.values()).size()==1;//there will be only one unrepeated value
    }
}

