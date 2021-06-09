package SwordToOffer.Easy.offer05replaceSpace;

import org.testng.annotations.Test;

/**
 * Create by LiShuang on 2021/5/31 22:26
 **/

public class replaceSpace {
    //
    public String replaceSpace(String s) {
        int Len=s.length();
        char[] newString=new char[Len*3];
        int tmp=0;
        for(int i=0;i<Len;i++){
            char C=s.charAt(i);
            if(C==' '){
                newString[tmp]='%';
                newString[++tmp]='2';
                newString[++tmp]='0';
            }
            else{
                newString[tmp]=s.charAt(i);
                tmp++;
            }
        }
        return new String(newString).trim();
    }

  @Test
    public void test(){
        String newS=replaceSpace("We are happy.");
      System.out.println(newS);
    }


}
