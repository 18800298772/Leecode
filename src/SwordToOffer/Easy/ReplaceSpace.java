package SwordToOffer.Easy;

public class ReplaceSpace {
    public String replaceSpace(String S){
        String re=S.replace(" ","%20");
        return re;
    }

    public static void main(String[] args) {
        ReplaceSpace R=new ReplaceSpace();
        System.out.println(R.replaceSpace("We are happy."));
    }
}
