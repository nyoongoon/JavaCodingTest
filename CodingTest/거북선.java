public class 거북선 {

    String 소속 = "전라좌수영";
    String 건조년도 ="1592년";
    int 포탄의개수 = 5;
    boolean 참전가능여부 = true;

    public void 발포(){
        if(this.참전가능여부 == true){

            this.포탄의개수 = this.포탄의개수 - 1;
            System.out.println("발포하였습니다.");

        }else{

            System.out.println("참전할 수 없는 거북선입니다.")
        }
    }
}


