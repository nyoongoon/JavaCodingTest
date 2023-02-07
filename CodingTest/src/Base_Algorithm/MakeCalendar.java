package Base_Algorithm;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class MakeCalendar {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.print("달력의 년도를 입력해주세요.(yyyy):");
        int year = stdIn.nextInt();
        System.out.print("달력의 월을 입력해주세요.(mm):");
        int month = stdIn.nextInt();
        LocalDate date =  LocalDate.of(year, month, 1);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int dayOfWeekNumber = dayOfWeek.getValue();
        //System.out.println(dayOfWeekNumber);

        //해당 달의 마지막 날
        LocalDate lastDate = date.withDayOfMonth(date.lengthOfMonth());
        //System.out.println(lastDate.getDayOfMonth());

        System.out.println("["+year+"년 "+ String.format("%02d", month)+"월]");

        int nowWeekNum = dayOfWeekNumber;
        String line = "";
        String space = "    ";

        char[] days = {'일', '월', '화', '수', '목', '금', '토'};
        String dayCol = "";
        for (int i = 0; i < 7; i++) {
            dayCol +=String.format("%-4s", days[i]);
        }
        System.out.println(dayCol);

        for (int i = 1; i <= lastDate.getDayOfMonth(); i++) {
            if(i == 1){
                for (int j = i; j < dayOfWeekNumber; j++) {
                    space += space;
                }
                line += space + String.format("%-4s", String.format("%02d", i));
            }else{
                line +=  String.format("%-4s", String.format("%02d", i));
            }


            if(nowWeekNum == 6 || i == lastDate.getDayOfMonth() ){
                nowWeekNum = 0;
                System.out.println(line);
                line = "";
            }else{
                nowWeekNum++;
            }

        }
    }
}
