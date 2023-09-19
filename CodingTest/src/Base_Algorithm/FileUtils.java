public class FileUtils {
    public static String readFile(String filePath){
        String fileName = 
        try {
            // FileReader와 BufferedReader를 사용하여 파일을 읽습니다.
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuilder stringBuilder = new StringBuilder();
            String line;

            // 파일의 각 줄을 읽어서 StringBuilder에 추가합니다.
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n"); // 각 줄 사이에 줄 바꿈 문자를 추가합니다.
            }

            // 파일 내용을 하나의 문자열로 변환합니다.
            String fileContents = stringBuilder.toString();

            // 이제 fileContents를 사용하여 필요한 작업을 수행할 수 있습니다.
            System.out.println("파일 내용: \n" + fileContents);

            // 파일을 닫습니다.
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
}
