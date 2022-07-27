public class 거북선 {

    String 소속 = "전라좌수영";
    String 건조년도 ="1592년";
    int 화포의갯수 = 5;
    boolean 참전가능여부 = true;

    public void 발포(화포의 갯수){
        if(참전가능여부 == true){

            this.화포의갯수 = 화포의갯수 - 1;
            System.out.println("발포하였습니다.");

        }else{

            System.out.println("참전할 수 없는 거북선입니다.")
        }
    }
}


