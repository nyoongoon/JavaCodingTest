package Base_Algorithm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.TreeMap;

public class PercentOfAlphabet {
    public static void main(String[] args){
        FileUtils fu = new FileUtils();
        String result = fu.getLoadText("CodingTest/src/Basic/PercentOfAlphabet.txt");
        String upper = result.toUpperCase();
        TreeMap<Character, Integer> map = new TreeMap<>();

        for(int i = 0; i<upper.length(); i++){
            int ascii = upper.charAt(i);

            if(ascii >= 65 && ascii <= 90){
                map.put(upper.charAt(i), map.getOrDefault(upper.charAt(i), 0) + 1);
            }

        }

        for (Character key : map.keySet()){
            double percent = (double)map.get(key) / upper.length() * 100;
            System.out.print(key + " = " +String.format("%10s", map.get(key)+"개, ")+ String.format("%10.2f", percent) +"%" );
            System.out.println();
        }

    }
}

class FileUtils{
    public String getLoadText(String filePath){
        StringBuilder sb = new StringBuilder();

        try{
            Path path = Paths.get(filePath);
            List<String> lines = Files.readAllLines(path);
            for(int i = 0; i<lines.size(); i++){
                if(i > 0){
                    sb.append("\n");
                }
                sb.append(lines.get(i));
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return sb.toString();
    }
}