package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class problem3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] s = input.split(" ");
        String str1 = input.substring(0,6);
        String str2 = input.substring(7);
        if(str2.charAt(0) == ' '){
            String[] split = str2.split(" ");
            str2= split[1];
        }
        String answer = solution(str1, Integer.parseInt(str2));
        System.out.println(answer);
    }

    public static class Car{
        String name;
        boolean isFinished;
        String type;
        Integer number;
        String[] length;
        public Car(String name, boolean isFinished, String type, Integer number, String[] length){
            this.name = name;
            this.isFinished = isFinished;
            this.type = type;
            this.number = number;
            this.length = length;
        }
    }
    public static String solution(String param0, int param1) throws ParseException {
        String[] Cortina = {"196801", "198004" };
        String[] Pony = {"197512", "198201"};
        String[] Porter = {"197702","200405"};
        String[] Grandeur = {"198607", "202305"};
        String[] Elantra = {"199019", "199512"};
        String[] Aerotown = {"188406", "202305"};
        String[] Equas = {"199904", "200912"};
        String[] Tuscani = {"200109", "200810"};
        String[] SantaFe = {"200006", "202305"};
        String[] Universe = {"200612", "202305"};
        List<Car> carList = new LinkedList<>();
        carList.add(new Car("Tuscani", true,"Coupe", 2 , new String[]{"200109", "200810"}));
        carList.add(new Car("Porter", true,"Truck", 3 , new String[]{"197702","200405"}));
        carList.add(new Car("Cortina", true,"Sedan", 5 , new String[]{"196801", "198004" }));
        carList.add(new Car("Elantra", true,"Sedan", 5 , new String[]{"199019", "199512"}));
        carList.add(new Car("Equas", true,"Sedan", 5 , new String[]{"199904", "200912"}));
        carList.add(new Car("Grandeur", false,"Sedan", 5 , new String[]{"198607", "202305"}));
        carList.add(new Car("Pony", true,"Sedan", 5 , new String[]{"197512", "198201"}));
        carList.add(new Car("Santafe", false,"RV", 7 , new String[]{"200006", "202305"}));
        carList.add(new Car("Aerotown", false,"Bus", 30 , new String[]{"199406", "202305"}));
        carList.add(new Car("Universe", false,"Bus", 45 , new String[]{"200612", "202305"}));

        List<String> anserList = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int temp = 0;
        for(Car c : carList){
            SimpleDateFormat sdf  = new SimpleDateFormat("yyyyMM");
            Date paramLength = sdf.parse(param0);
            Date start = sdf.parse(c.length[0]);
            Date end = sdf.parse(c.length[1]);
            if( paramLength.after(start) && paramLength.before(end)){
                if(sb.length() != 0){
                    sb.append(",");
                }
                if(c.number >= param1){
                    temp = 1;
                    sb.append(c.name);
                    if(c.isFinished){
                        sb.append("*");
                    }
                    sb.append("("+ c.type+ ")");
                }
            }
        }
        if(temp == 0){
            String st = "!";
            return st;
        }
        return sb.toString();
    }
}
