package Base_Algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileUtils {
    public final static String ANSWER_PATH = "CodingTest/src/Base_Algorithm/answer/";

    public static String[] readFile(String fileName) {

        try {
            // FileReader와 BufferedReader를 사용하여 파일을 읽습니다.
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuilder stringBuilder = new StringBuilder();
            String line;

            // 파일의 각 줄을 읽어서 StringBuilder에 추가합니다.
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(" "); // 각 줄 사이에 줄 바꿈 문자를 추가합니다.
            }

            // 파일 내용을 하나의 문자열로 변환합니다.
            // 이제 fileContents를 사용하여 필요한 작업을 수행할 수 있습니다.
            String[] arrayStrings = stringBuilder.toString().split("\\],\\[");

// 문자열에서 [와 ]를 제거하고 새로운 배열에 저장
            String[] result = new String[arrayStrings.length];
            for (int i = 0; i < arrayStrings.length; i++) {
                result[i] = arrayStrings[i].replaceAll("\\[|\\]", "");
            }
            // 파일을 닫습니다.
            bufferedReader.close();

            return arrayStrings;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String removeBrackets(String input) {
        // '['와 ']'를 제거하고 공백도 제거한 문자열 반환
        return input.replaceAll("[\\[\\]]", "").trim();
    }

    public static int[] returnIntArray(String filePath) {

        return Arrays.stream(removeBrackets(readFile(filePath)[0]).split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int[][] parseTwoIntArrays(String filePath) {

        String[] arrayStrings = readFile(filePath);

        int[][] result = new int[arrayStrings.length][];

        for (int i = 0; i < arrayStrings.length; i++) {
            String[] values = arrayStrings[i].replaceAll("\\[|\\]", "").split(",");

            for (String s : values) {
                System.out.print(s); //TODO ㅂㅣㄴ경우 0리턴
            }
            System.out.println();
            int[] intArray = new int[values.length];

            for (int j = 0; j < values.length; j++) {
                if(values[j].equals("")) {
                    break;
                }
                intArray[j] = Integer.parseInt(values[j].trim());
            }

            result[i] = intArray;
        }
        return result;
    }

    public static int[] parseStringToIntArray(String input) {
        String trimmedInput = input.replaceAll("\\[|\\]", ""); // '['와 ']' 제거
        String[] parts = trimmedInput.split(",\\s*");
        int[] numbers = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i].trim());
        }

        return numbers;
    }
}
