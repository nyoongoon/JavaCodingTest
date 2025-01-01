package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test3 {
    static Map<String, Integer> map = new HashMap<>();
    static String company = "";

    public static void main(String[] args) {
        //'John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker', 'Example'
        String s = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        String c = "Example";

        String solution = solution(s, c);
        System.out.println(solution);
    }


    public static String solution(String S, String C) {
        company = C.toLowerCase();
        ArrayList<Name> nameList = new ArrayList<>();
        String[] names = S.split(", ");
        for (String name : names) {
            String[] splitted = name.split(" ");
//            clean(splitted);
//            for (String s : splitted) {
//                System.out.println("s : " + s);
//            }
            Name newName;
            if (splitted.length > 2) {
                newName = new Name(splitted[0], splitted[1], splitted[2]);
            } else {
                newName = new Name(splitted[0], null, splitted[1]);
            }
            nameList.add(newName);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nameList.size(); i++) {
            Name name = nameList.get(i);
            sb.append(name.getEmail());
            if (i != nameList.size() - 1) {
                sb.append(", ");
            }
        }

        // Implement your solution here
        return sb.toString();
    }


    public static class Name {
        String firstNm;
        String middleNm;
        String lastNm;

        public Name(String firstNm, String middleNm, String lastNm) {
            this.firstNm = firstNm;
            this.middleNm = middleNm;
            this.lastNm = lastNm;
        }

        public String clean(String str) {
            return str.toLowerCase().replaceAll("-", "");

        }

        String getEmail() {
            StringBuilder sb = new StringBuilder();
            sb.append(firstNm + " ");
            if (middleNm != null) {
                sb.append(middleNm + " ");
            }
            sb.append(lastNm + " ");
            String email = makeEmail();
            sb.append(email);
            return sb.toString();
        }

        String makeEmail() {
            StringBuilder sb = new StringBuilder();
//            sb.append("<");
            String fistNmCleaned = clean(firstNm);
            sb.append(fistNmCleaned.charAt(0));
            if (middleNm != null) {
                String middleNmCleand = clean(middleNm);
                sb.append(middleNmCleand.charAt(0));
            }
            String lastNmCleaned = clean(lastNm);
            int lastIdx = 0;
            while (lastIdx < lastNmCleaned.length() && lastIdx < 8) {
                sb.append(lastNmCleaned.charAt(lastIdx++));
            }

            String email = sb.toString();


            if (map.containsKey(email)) {
                Integer count = map.get(email);
                if (count == 0) {
                    map.put(email, count + 2);
                    email += count + 2;
                } else {
                    map.put(email, count + 1);
                    email += count + 1;
                }

            } else {
                map.put(email, 0);
            }

//            System.out.println("email == " + email);

            return "<" + email + "@" + company + ".com>";
        }
    }
}
