package SwordToOffer.Easy.offer50;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Create by LiShuang on 2020/12/4 21:53
 **/

public class firstUniqChar {
    public static char firstUniqChar(String s) {
        char re =' ';
        if (s.equals("")){
            return re;
        }
        int len=s.length();
        HashMap<Character, Integer> map=new LinkedHashMap<>();
        for(int i=0;i<len;i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),len);
            }
            else map.put(s.charAt(i),i);
        }
        Set set = map.keySet();
        for(Object tem:set){
            Integer get=map.get(tem);
            if(!(get.equals(len))){
                re= (char) tem;
                break;
            };
        }
        return re;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leecode"));
    }
}
