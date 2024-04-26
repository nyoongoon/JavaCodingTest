package Base_Algorithm;

import java.io.File;

public class ScoringTest {
    // /Base_Algorithm/answer/test2/problem1/acc_test/2_i.txt
//    private String testCasePath = "Base_Algorithm/answer";
    private String dirPath;

    ScoringTest(String testNum, String probNum){
        this.dirPath = "Base_Algorithm/answer/test"+testNum+"/problem"+probNum;
    }

    public File getFile(String dirPath, String checkType, String ord, String inOutType){
        return new File(dirPath+"/"+checkType+"/"+ord+"_"+inOutType+".txt");
    }

}
