package itis.grp403.TimurSibgatullin;

public class Test2 {
    public static void main(String[] args) {


        int n = 5;
        int[] nums = {131,131,131,131,131};
        String[] strs = {"AB","AB","AB","AB","AB"};
        int cnt = 0;
        for (int i = 0; i < n; i++){
            if (check(strs[i], nums)){
                cnt++;
            }
        }

        if (cnt >= 3){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }


    public static boolean check(String str, int[] nums){
        int sum = 0;
        for (char c: str.toCharArray()){
            if (Character.isLetter(c)){
                sum += c;
            }
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == sum){
                count++;
            }
        }
        if (count >= 2) {
            return true;
        }
        else{
            return false;
        }
    }
}
