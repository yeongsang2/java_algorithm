package programmers;

import java.util.HashSet;
import java.util.Set;

public class phoneNumberList {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"12","123","1235","567","88"}));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet();
        for(int i =0; i <phone_book.length; i ++) {
            set.add(phone_book[i]);
        }
        for(String phone : phone_book){
            for(int i = 1; i < phone.length(); i++){
                if(set.contains(phone.substring(0, i))){
                    return false;
                }
            }
        }

        return true;
    }
}
