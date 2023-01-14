# 코딩테스트 유형 (simple)

## 1. 정렬

- 정렬 문제 단독으로 나오는 경우 거의 없음.
- 풀이를 위한 사전 과정.
- 버블, 선택, 퀵, 합병, 우선순위 큐 ...

## 2. 탐색

- 주어진 데이터에서 특정 값 찾기 (2차원/3차원 데이터에서 인접한 /가능한 경로 찾기)
- 단순 풀이로 접근 시 대부분 시간초과로 실패
- 완전, 이진, 투 포인터, BFS, DFS ...

## 3. 부분 문제의 합 - 분할정복/DP

- 최대 값 찾기 / 부분 수열의 최대 길이 / 0-1Knapsack 문제 ...
- 단순 반복, 조건문 나열로는 풀기 복잡한 문제
- 해귀함수를 통한 작은 문제의 반복적 해결 구조 또는 계산 결과의 재사용
- 분할정복 , DP

## 4. 최적선택 - 그리디

- Activity Selection / 거스름돈
- 특정 조건 만족 시 빠르게 문제를 해결할 수 있는 방법
- 최적해가 아닌 근사치를 얻을 수도 있으므로 사용 시 주의 필요
- 그리디

## 5. 기타 시뮬레이션

- 조건에 따른 문자열 입력/삭제/수정 문제
- 문제의 요구사항을 잘 읽고 해결하는 문제
- 특정 알고리즘 분류로 매핑되지 않는 경우 많음

# 3-3 학습환경 구성 - Tool 사용

- 디버깅 사용방법
- 중단점,
- Step over: 한줄 씩 이동. 함수를 타고 들어가진 않음.
- Step Into: 하위구조를 타고 들어감.
- Step Out: 들어왔던 하위구조를 나감

# 자바

## 자바 프로그램 작성 실행 과정

- 자바소스코드 - 자바컴파일러 - 바이트 코드 - jvm - 실행

# 변수와 자료형

- 변수 : 데이터를 저장하는 메모리 공간에 붙여준 이름

# 자료형

## 숫자형

- 정수 / 실수 / 2진수, 8진수, 16진수

```java
//2진수 0b~
int numBase2 = 0b1100;
System.out.println("0b" + Integer.toBinaryString(numBase2)); //2진수로출력
//8진수 0~
int numBase8 = 014;
System.out.println("0" + Integer.toOctalString(numBase8));//8진수로출력
//16진수 0x~
int numBase16 = 0xC;
System.out.println("0b" + Integer.toHexString(numBase16));//16진수로출력
```

- 실수

```java
float floatNum = 1.23f; //뒤에 f 붙이기
double doubleNum = 1.23;
```

## 문자열

- equals(), indexOf(), replace(), substring(), toUpperCase()

```java
String s3 = "Hi";
String s4 = "Hi";
String s5 = new String("Hi");
System.out.println(s3.equals(s4)); //true
System.out.println(s3 == s4); //true
System.out.println(s3.equals(s5)); //true
System.out.println(s3 == s5); // false
```

## 자료형: StringBuffer

- 문자열을 자주 추가하거나 변경할 때 사용하는 자료형
- 문자열은 데이터가 변경될 때마다 객체가 변하지만, StringBuffer는 객체 안에서 변경됨 ..?

```java
StringBuffer sb1 = new StringBuffer("HelloWorld!");
sb1.append("1234");
```

- append(), insert(), substring()

## 자료형 : 배열

## 자료형 : 리스트

- add(), get(), size(), remove(), clear(), sort(), contains()

```java
ArrayList l1 = new ArrayList(); //아무 자료형이나 넣을 수 있었네..??
l1.add(1);
l1.add("hello");
l1.add("world!");
System.out.println("l1 == " + l1); // l1 = [1, "hello", "world!"]

l1.add(0, 1); // (index, element)
System.out.println("l1 == " + l1); // l1 = [1, 1, "hello", "world!"]->추가됨

//remove
l1.remove(0); // 인덱스 0번 지우기
l1.remove(Integer.valueOf(2)); // int 2 값 찾아서 지우기

//clear
l1.clear() // 모든 데이터 지우기

//sort
l1.sort(Comparator.naturalOrder()); //오름차순
l1.sort(Comparator.reverseOrder()); //내림차순

//contains(element) //데이터 존재 유무 true || false
```

## 자료형 : 맵

- put(), get(), size(), remove(), containsKey()

```java
map.remove("key") // 값 있었으면 출력 || 없었으면 null 출력
```

## 자료형 : 제네릭스

- 자료형을 명시적으로 지정
- 제한적일 수 있지만 안정성을 높여주고 형변환을 줄여줌.
- ArrayList, Map 등 제네릭 사용안하면 하나의 자료구조에 다양한 타입 저장가능.

# 연산자

- 단항 연산자, 이항 연산자, 삼항 연산자.
- 대입 연산자
- 부호 연산자
- 산술연산자
- 증가/감소 연산자
- 관계 연산자
- 논리 연산자
- 복합 대입 연산자

## 2진법 비트연산자

- 2의 보수 : 2의 제곱수에서 뺴서 얻은 이진수
- 자리 올림이 필요한 만큼의 수.
- ex)2진수 3의 2의 보수 : 11 -> 01
- => 11에서 자리올림(100)이 되려먼 01을 더해야함.
- 2의 보수로 음수 표현을 하기도 함 (자릿수를 올려서 0 비트로 만들기)

## 비트연산자

- 기본연산자 -> && , ||
- 비트연산자 -> & , |
- & : 두 개의 비트가 모두 1인경우에만 1
- | : 두 개의 비트값 중 하나라도 1이면 1
- ^ (XOR 연산자) : 같으면 0 다르면 1
- ~ (반전연산자) : 0을 1으로, 1을 0으로

```java
int num1 = 5;
result = ~num1;
System.out.println("result = " + result); // -6
System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num1)));
// => 0101
System.out.printf("%s\n", Integer.parseInt(Integer.toBinaryString(result)));
// => (앞에 1 28개)1010 ==> 32비트에 나머지 앞의 자리가 1(부호)로 전부 바뀌었음
```

- 비트이동연산자 (\<\<, \>\>, \>\>\>)
- \<\< :비트를 왼쪽으로 이동
- 3\<\<1 => 0011 => 0110 (\*2의 효과)
- \>\> : 비트를 오른쪽으로 이동
- 3\>\>1 => 0011 => 0001 (/2의 효과)
- \>\>\> : 연산자
- 비트를 오른쪽으로 이동(부호비트 상관없이 0으로 채움)

```java
numA = -5;
result = numA >> 1;
System.out.printf("%s\n", Integer.toBinaryString(numA));
// => (1이 28개) 1011
System.out.printf("%s\n", Integer.toBinaryString(result));
// => (1이 28개) 1101 (부호연산 그대로)
result = numA >>> 1;
System.out.printf("%s\n", Integer.toBinaryString(result));
// => (0하나) (1이 27개)1101 (부호연산 0으로)
```

# 조건문

## if, case

## for, while

# 다차원 배열

# 클래스와 객체 1

- 객체를 정의하는 설계도.

## 객체(Object)

- 실체

## 인스턴스

- 클래스와 객체의 관계
- 클래스로부터 객체를 선언.
- 어떤 객체는 어떤 클래스의 인스턴스.

## this, this()

- this => 객체 자신을 의미
- this() => 생성자

# 클래스와 객체 2

## 오버로딩

- 한 클래스 내에서 같은 이름의 메소드를 여러 개 정의

### 오버로딩의 조건

- 메소드의 이름이 같아야함
- 매개변수의 개수 또는 타입이 달라야함.
- 리턴타입의 차이만으로 오버로딩되지 않음.

## 접근제어자

- 클래스의 변수나 메소드의 접근에 제한을 두는 키워드

### 접근제어자 종류

- private : 해당 클래스에서만 접근 가능
- public : 어디서든 접근 가능
- default : 해당 패키지 내에서만 접근 가능
- protected: 해당 패키지 및 상속받은 클래스에서 접근 가능.

## Static

- 변수나 메소드의 특성을 바꾸는 키워드

### Static 특징

- 메모리에 한 번만 할당됨
- 즉, Static 변수나 메소드는 공유되는 특성을 가짐
- 객체가 만들어지기 전에(프로그램 시작 시) 클래스 변수, 클래스 메소드가 메모리에 할당되어 있음.

### Static 클래스 변수

- 해당 클래스의 각 객체들이 값을 공유

### Static 클래스 메소드

- 객체를 생성하지 않아도 호출 가능.

```java
class Car{
	static String name = "None";
	String type;
	Car(String name, String type){
		this.name = name;
		this.type = type;
	}
	public void printCarInfo(){
		System.out.println("name: " + name);
		System.out.println("type: " + type);
	}
	public static void getName(){
		System.out.println("Car name: " + name);
	}
}

public class Main{
	public static void main(String[] args){
		Car.getName(); //static은 객체 생성하지 않아도 이미 메모리에 올려져있음.
		Car myCar1 = new Car("a", "sedan");
		Car myCar2 = new Car("b", "suv");
		myCar1.printCarInfo(); //name:b type:sedan
		myCar2.printCarInfo(); //name:b type:suv ==> name은 static이라 공유됨!!
	}
}
```

# 상속

- 부모 클래스의 필드와 메소드가 상속 됨
- 생성자, 초기화 블록은 상속되지 않음
- 자식클래스는 하나의 부모 클래스만 상속 가능.
- private, default 멤버를 자식 클래스에서 접근 불가.
- default의 경우 내부 패키지의 자식 클래스는 가능.

## super, super()

- super : 부모 클래스와 자식 클래스의 멤버 이름이 같을 때 구분하는 키워드
- super() : 부모 클래스의 생성자 호출

## 오버라이딩

- 부모클래스의 메소드를 자식클래스에서 재정의
- 메소드 선언부 부모 클래스의 메소드와 동일해야함
- **반환 타입에 한해서**,
- 부모 클래스의 반환타입으로 변환할 수 있는타입으로 변경 가능
- 부모 클래스의 메소드보다 접근제어자를 더 좁은 범위로 변경 불가
- 부모 클래스의 메소드보다 더 큰 범위의 예외 선언 불가

# 다형성

- 하나의 객체가 여러가지 타입을 가질 수 있는 것
- 부모클래스 타입의 참소변수로 자식 클래스 인스턴스 참조

## 타입변환 (업캐스팅, 다운캐스팅)

```java
// 타입 변환 Student extends Person
Person pp1 = null;
Student ss1 = null;

Person pp2 = new Person();
Student ss2 = new Student();
Person pp3 = new Student(); // 업캐스팅(다형성)

pp1 = pp2;
pp1 = ss2;

ss1 = ss2;
// ss1 = pp2; 안됌
// ss1 = pp3; 이대론 안되지만
ss1 = (Student) pp3; // 다운캐스팅 이렇게 하면 가능 (원래 Student였는데 업캐스팅된 상태였음)

```

# 추상 클래스 & 추상 메소드

```java
abstract class Person{
	abstract void printInfo();
}

class Student extends Person{
	public void printInfo(){
		System.out.println("Student.printInfo");
	}
}

public class Main{
	public static void main(String[] args){
		// 추상 클래스 사용
		// Person p1 = new Person();
		Student s1 = new Student();
		s1.printInfo();

		Person p2 = new Person(){ // 추상클래스 익명클래스를 통해 구현가능
			@Override
			void printInfo(){

			}
		};
	}
}
```

# 인터페이스

- 다중상속처럼 사용할 수 있는 기능
- 추상메소드와 상수만으로 이루어짐.

```java
접근제어자 interface 인터페이스 이름{
	public static final 타입 상수입름 = 값;
	public abstract 반환타입 메소드이름(매개변수);
}
```

# 내부클래스

## 특징

- 내부 클래스에서 외부 클래스 멤버에 접근 가능
- 외부에서는 내부 클래스 접근 불가

## 종류

- 인스턴스 클래스
- 정적 클래스
- 지역 클래스
- 익명 클래스

### 익명 클래스

- 이름을 가지지 않는 클래스
- 선언과 동시에 객체 생성
- 일회용 클래스

```java
클래스이름 참조변수이름 = new 클래스이름(){
...
};
```

# 입출력

## 콘솔 입력

```java
System.in.read()
InputStreamReader reader = ...
BufferedReader br = ...
Scanner ...
```

- 예시 코드

```java
//System.in
int a = System.in.read() - '0'; //System.in.read()=>하나의 캐릭터 읽음
System.out.println("a = " + a);
System.in.read(new byte[System.in.available()]); // 입력스트림에 남아있는 개수 만큼 바이트만큼 읽어서 소진 (엔터키값 등)

//InputStreamReader
InputStreamReader reader = new InputStreamReader(System.in); //여러 글자 받음
char[] c = new char[3]; //여러 데이터 받기 때문에 그 만큼의 배열 길이 필요
reader.read(c); // 여기서 받음
System.out.println(c); //출력

//BufferedReader
//위의 2개가 합쳐진 개념.
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String s1 = br.readLine(); // 여기서 받음.
System.out.println("s1 = " + s1);

//Scanner
Scanner sc = new Scanner(System.in);
System.out.println(sc.next()); // 데이터 하나 받기 => 엔터키 소진 필요
sc.nextLine(); //엔터키 소진

System.out.println(sc.nextInt()); //정수 값 받기 - 다른타입 에러

System.out.println(sc.nextLine()); //가장 많이 사용 !

```

## 콘솔 출력

```java
System.out.println(...);
System.out.print(...);
System.out.printf(...);
```

- printf 예시

```java
String s = "자바";
int number = 3;
System.out.println(s+ "는 언어 선호도 " + number +"위 입니다.");
System.out.printf("%는 언어 선호도 %d위 입니다.\n", s, number);

// 서식문자
// %d 정수형
// %o 8진수
// %x 16진수
// %f 실수 System.out.printf("%f\n", 5.2f);
// %c 문자
// %s 문자열

// 여백
System.out.printf("%5d\n", 123); // "  123"
System.out.printf("%-5d\n", 123); // "123  "

// 소숫점 자리수 표현
System.out.printf("%.2f\n", 1.12645f); // 1.13 // 마지막자리 반올림한값 !!
```

# 파일 입출력

## 파일 입력

- 입출력 방식 중 파일로부터 입력 받는 방법

```java
FileInputStream ...
BufferedReader ...
```

```java
// 파일 입력
BufferedReader br = new BufferedReader(new FileReader("./memo.txt"));
//String line = br.readLine(); //한줄 씩 읽기

while(true){
	String line = br.readLine();
	if(line == null){
		break;
	}
	System.out.println(line);
}
br.close();
```

## 파일 출력(파일 쓰기)

- 입출력 방식 중 파일로 출력(쓰기)하는 방법

```java
FileOutputStream ...
FileWriter ...
PrintWriter ...
```

- 예시

```java
// 1. 파일(로) 출력(쓰기)
// FileWriter
FileWriter fw = new FileWriter("./memo.txt");
String memo = "헤드 라인\n";
fw.wirte(memo);

memo = "1월 1일 날씨 맑음\n";
fw.write(memo);

fw.close();

//PritWiter
PrintWriter pw = new PrintWriter("./memo.txt");
memo = "헤드 라인";
pw.println(memo); //ln자동추가
memo = "1월 1일 날씨 맑음";
pw.println(memo); //ln자동추가

pw.close();


// 파일 이어 쓰기
FileWriter fw2 = new FileWriter("./memo.txt", true); //append:  true
memo = "1월 2일 날씨 완전 맑음\n";
fw2.write(memo);
fw2.close();


PrintWriter pw2 = new PrintWriter(new FileWriter("./memo.txt", true));
memo = "1월 3일 날씨 또 맑음!";
pw2.println(memo);
pw2.close();
```

# 예외 처리

## 예외 (Exception)

- 정상적이지 않은 Case;

## throw, throws

- throw : 예외를 발생시킴
- throws : 예외를 전가시킴.

```java
...func(){
	throw new Exception(); // 발생 !!! // @예외 발생시킴(동사원형)
}
...func() throws Exception{ // 전가 !!! //func()가 @예외 발생시킨다.(3인칭단수)
	...
}
```

- 커스텀 예외

```java
//RuntimeException 상속
class CustomException extends RuntimeException{}
```

- 예시

```java
class NotTenException extends RuntimeException{}

public class Main{
	public static boolean checkTenWithException(int ten){ // 예외 발생 예시 !!!
		try{
			if(ten != 10){
				throw new NotTenException(); //예외 이곳에서 처리 !!!
			}
		}catch(NotTenException e){
			System.out.println("e == " + e); //위의 사항 여기서 잡힙
			return false;
		}
		return true;
	}

	public static boolean checkTenWithThrows(int ten) throws NotTenException{ // 예외 전가 예시 !!!
		if(ten != 10){
			throw new NotTenException(); // 예외가 발생하면 일반 밖으로 보냄
		}
		return true;
	}

	public static void main(String[]args){
		// 예외 발생 예제인 경우 예외가 함수 안에서 처리됨 !!!
		Main.checkTenWithException(9); //false 리턴 //e == NotTenException 출력됨.

		//예외 전가 예제인 경우 예외가 밖으로 나와서 호출한 곳에서 처리 해주어야함 !!!

		try{
			checkTenWithThrows(9);	//false !!!
		}catch(NotTenException e){
			System.out.println("e == " + e); //e == NotTenException 출력됨.
		}

	}
}
```

# 컬렉션 프레임워크

- 여러 데이터를 편리하게 관리할 수 있게 만들어 놓은 것.
- 자료구조 및 알고리즘을 구조화

## 대표 인터페이스

- List 인터페이스, Set 인터페이스, Map 인터페이스.

## List 인터페이스

- 순서가 있는 데이터의 집합
- 데이터 중복 허용
- 대표 구현 클래스 : ArrayList, LinkedList, Vector

## Set 인터페이스

- 순서가 없는 데이터의 집합
- 데이터의 중복 허용하지 않음
- 대표 구현 클래스 : HashSet, TreeSet

## Map 인터페이스

- 키와 값의 쌍으로 이루어진 데이터 집합
- 순서 유지하지 않음
- 대표 구현 클래스 : HashMap, TreeMap

### ArrayList

```java
list.size()
list.contains(value) /// 값의 유무
list.indexOf(value) // 값의 인덱스
```

### LinkedList

```java
list.addFirst(value)
list.addLas(value)
list.removeFirst()
list.removeLast()
```

### HashSet

```java
set.add(1);
set.add(2);
set.add(3);
System.out.println(set); // set = [1, 2, 3] //toString()오버라이드 ..?
```

### TreeSet

```java
set.add(10);
set.add(5);
set.add(15);
System.out.println(set); // set = [5, 10, 15] // 정렬되어 출력됨
set.first();
set.last();
set.lower(10); //5
set.higher(10); //15
```

### HashMap

```java
System.out.println(map); // map {1="kiwi", 2="apple", 3="mango"}
```

### TreeMap

```java
map.put(10, "kiwi");
map.put(5, "apple");
map.put(15, "mango");
System.out.println(map); // map = {5=apple, 10=kiwi, 15=mongo} // 정렬되어 출력됨
System.out.println(map.firstEntry()); // 5=appler
System.out.println(map.firstKey()); // 5
System.out.println(map.lastEntry()); //15=mango
System.out.println(map.lastKey()); // 15
System.out.println(map.lowerEntry(10)); //5=apple
System.out.println(map.higherKey(10)) // 15=mango
```

### 컬렉션 프레임워크 예제 - 로또 번호 만들기

```java
public static void main(String[] args){
	HashSet set = new HashSet();
	for(int i = 0; set.size() < 6; i++){
		int num = (num)(Math.random() * 45) + 1; //Math.random()
		set.add(num); // 중복되면 사이즈 증가하지 않으므로 분기문없이 for문의 조건문으로 충분함.
	}
	LinkedList list = new LinkedList(set); // set을 그냥 LinkdList에 넣어서 생성했음 !!!
	Collections.sort(list);

}
```

# 람다식

- 메소드 대신 하나의 식으로 표현하는 것
- 익명 함수

```
public int sum(int x, int y){ // 일반 함수
	return x + y;
}
(int x, int y) -> {return x + y;}
```

## 장점

- 코드 간결
- 코드 가독성 높아짐
- 생산성 높아짐

## 단점

- 재사용 불가능(익명)
- 디버깅 어령무
- 재귀함수로는 맞지 않음 (이름이 없기 때문)

## 람다식 예시

```java
interface ComputeTool{
	public abstarct int compute(int x, int y);

	//public abstarct int compute2(int x, int y); // 추상메소드 2개일 경우에 람다 사용 불가 (기본 익명 클래스는 그냥 오버라이딩하면 가능)
}
public class Main{
	public static void main(String[] args){
		ComputeTool cTool1 = new ComputTool(){ // 기본 익명 클래스
			@Override
			public int compute(int x, int y){
				return x + y;
			}
		};
		System.out.println(cTool.compute(1, 2)); //기본 사용

		// 람다식 !!!
		CoumputTool cTool2 = (x, y) -> { x + y}; // 위의 기본 익명 클래스와 같은 기능
		System.out.println(cTool2.compute(1, 2)); // 람다 사용. 람다에서 메소드명 지정 안해줘도 인터페이스의 메소드 명을 사용할 수 있음.
	}
}
```

# 스트림

- 배열, 컬렉션 등의 데이터를 하나씩 참조하여 처리 가능한 기능
- for문의 사용을 중려 코드를 간결하게 함.
- 크게 3가지로 구성
- Stream 생성
- 중개 연산
- 최종 연산
- 데이터소스 객체.Stream생성().중개연산().최종연산();

## 스트림 생성

- 배열 스트림

```java
String[] arr = new String[]{"a", "b", "c"}
Stream stream = Array.Stream(arr);
```

- 컬렉션 스트림

```java
ArrayList list = new ArrayList(Arrays.asList(1,2,3));
Stream stream = list.stream();
```

## 스트림 중개연상

- Filtering
- filter 내부 조건에 참인 요소들을 추출

```java
IntStream intStream = IntStream.range(1, 10).filter(n->n%2==0);
```

- Mapping
- map 안의 연산을 요소별로 수행

```java
IntStream intStream = IntStream.range(1,10).map(n -> n+1);
```

## 스트림 최종연산

- Sum, Average

```java
IntStream.range(1, 5).sum()
IntStream.range(1, 5).average().getAsDouble()
```

- min, max

```java
IntStream.range(1, 5).min().getAsInt();
IntStream.range(1, 5).max().getAsInt();
```

## 예제

- 스트림 생성 예시

```java
// 배열 스트림
Stream stream1 = Arrays.stream(arr);
stream1.forEach(System.out::println);

// 컬렉션 스트림
Stream stream2 = list1.stream();
        //stream2.forEach(System.out::println); -> 스트림 최종 연산 이후에 더 작업할 수 없음 !
stream2.forEach(num -> System.out.println("num = " + num));

// 스트림 builder
Stream StreamBuilder = Stream.builder().add(1).add(2).add(3).build();
streamBuilder.forEach(System.out::println);

// 스트림 generate
Stream streamGenerator = Stream.generate(()->"abc").limit(3); // 3번반복
streaGenerator.forEach(System.out::println);

// 스트림 iterate
Stream streamIterate = Stream.iterate(10, n -> n * 2).limit(3);
streamIterate.forEach(System.out::println);

// 기본타입 스트림
IntStream intStream = IntStream.ranget(1, 5);
intStream.forEach(System.out::println);
```

- 스트림 중개 연산 예시

```java
// Filtering(필터링)
IntStream intSteam2 = IntStream.range(1, 10).filter(n -> n % 2 == 0); //참인경우찾기
intStream2.forEach(System.out::println);

// Mapping(매핑)
IntSrteam intStream3 = IntStream.range(1, 10).map(n -> n+1); // 연산위주
intStream3.forEach(n -> System.out.print(n + " "));
System.out.println();

// Sorting
IntSream intStream4 = IntStream.builder().add(5).add(1).add(3).add(4).add(2).build();
IntSream intStreamSort = intStream4.sorted(); // 정렬
intStreamSort.forEach(System.out::println);
```

- 스트림 최종 연산 예시

```java
// Sum, Average
int sum = IntSream.range(1, 5).sum();
double average = IntStream.range(1, 5).average().getAsDouble();

// Min, Max
int min = IntStream.ranget(1, 5).min().getAsInt();
int max = IntStream.ranget(1, 5).max().getAsInt();

// reduce
Stream<Integer> stream3 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
stream3.reduce((x,y)->x+y).get(); // 연쇄적인 연산 => 1+2. 3+3. 6+4. 10+5.

// forEach
IntSream.range(1, 10).filter(n -> n ==5 ).forEach(System.out::println);
```

- 예제

```java
// 예제: 1~10 숫자 중 짝수 들의 합
int sum2 = IntStream.range(1, 11).filter(x -> x % 2 == 0).sum();
```

# 기초 수학

- 집합
- 경우의 수
- 순열 / 조합
- 점화식과 재귀함수
- 지수와 로그
- 알고리즘 복잡도

# 집합

- 컬렉션 프레임워크 이용한 구현
- 직접 구현

## 집합의 개념

- 집합(Set)
- 특정 조건에 맞는 원소들의 모임

### 집합 표현 방법

- 원소 나열법 => A={1,2,3}, B={2,4,6}
- 조건 제시법 => A={A|A는 정수, 1<=A<=3}, B={2B|B는 정수, 1<=B<=3}
- 벤다이어 그램

#### 교집합

- 두 집합이 공통으로 포함하는 원소로 이루어진 집합

#### 합집합

- 어느 하나에라도 속하는 원소들을 모두 모은 집합

#### 차집합

- A(orB)에만 속하는 원소들의 집합

#### 여집합

- 전체집합(U) 중 A의 원소가 아닌 것들의 집합

## 집합 사용 예시 코드

```java
//1. 자바에서 집합사용 - HashSet
//2. 집합 연산
//2-1. 교집합
HashSet a = new HashSet(Arrays.asList(1,2,3,4,5));
HashSet b = new HashSet(Arrays.asList(2,4,6,8,10));
a.retainAll(b);// a교집합 b //[2, 4]
//2-2. 합집합
a.addAll(b); //a합집합 b[1,2,3,4,5,6,8,10]
//2-3 차집합
a.removeAll(b); //a차집합b[1,3,5]
```

# 경우의 수

- 합의 법칙, 곱의 법칙을 구분하기
- 경우의 수를 자바 프로그래밍으로 구현하기

## 경우의 수 개념

- 어떤 사건에서 일어날 수 있는 경우의 가짓수

```
예시1) 동전을 던지는 사건 : 경우의 수 2
예시2) 주사위를 던지는 사건 : 경우의 수 6
- 사건 A가 일어날 경우의 수 : n(A)
```

## 합의 법칙 곱의 법칙

- 주사위 예시 경우의 수
- 최대공약수, 최소공배수
- 최소공배수공식) lcm = numA \* numB /gcd;

### 합의 법칙 개념

- 사건 A 또는 사건 B가 일어날 경우
- 사건 A와 사건 B의 합의 법칙 : n(A ∪ B)
- n(A ∪ B) = n(A) + n(B) - n(A∩B)

```
예시) 두 개의 주사위를 던졌을 때 합이 3 또는 4의 배수일 경우의 수
```

### 곱의 법칙 개념

- 사건 A와 사건 B가 동시에 일어날 경우의 수
- 사건 A와 사건 B의 곱의 법칙: n(A x B)
- n(A x B) = n(A) x n(B)

```
예시) 두 개의 주사위 a, b를 던졌을 때 a는 3의 배수, b는 4의 배수인 경우의 수
```

# 순열 / 조합

- 팩토리얼 (반복문, Stream)
- m개 숫자를 이용 n자리 자연수

## 순열

- 1. 팩토리얼
- 2. 순열
- 3. 중복 순열
- 4. 원 순열

### 팩토리얼

- 1에서 n까지 모든 자연수의 곱(n!)

### 순열(Permutation)

- 순서를 정해서 나열
- 서로 다른 n개 중에 r개를 선택하는 경우의 수 (순서 O, 중복 X)
- 예시) 5명을 3줄로 세우는 방법
- 예시) 서로 다른 4명 중 반장, 부반장 뽑는 방법.
- n! / (n-r)! ==> n부터 n-r+1까지의 곱.!!!

### 중복 순열

- 서로 다른 n개 중에 r개를 선택하는 경우의 수 (순서O, 중복 O)
- 예시) 서로 다른 4개의 수 중 2개를 뽑는 방법(중복 허용)
- 예시) 후보 2명, 유권자 3명일 때 기명 투표 방법.
- n^r

### 원순열

- 원 모양의 테이블에 n개의 원소를 나열하는 경우의 수
- 예시) 원모양의 테이블에 3명을 앉히는 경우
- n!/n = (n-1)!

## 조합

- 1. 조합
- 2. 중복 조합
- 조합 개념의 이해와 경우의 수 계산
- 프로그래밍으로 조합의 각 case 출력

### 조합(의 개념)

- 서로 다른 n개 중에서 r개를 선택하는 경우의 수 (순서X, 중복X)
- 예시) 서로 다른 4명 중 주번 2명을 뽑는 방법 (순열은 반장,부반장, <-> 조합은 주번)
- nCr = n! / (n-r)!r! = nPr / r! (0 < r <= n)

### 중복 조합

- 서로 다른 n개 중에서 r개를 선택하는 경우의 수 (순서X, 중복O)
- 예시) 후보 2명, 유권자 3명일 때 무기명 투표 방법
- nHr = n+r-1 C r

# 점화식과 재귀함수

- 점화식과 재귀함수 개념 이해
- 점화식 유형을 파악하고 재귀함수로 구현 가능
- 여러가지 점화식을 재귀함수로 구현
- 최대공약수를 재귀함수로 구현

## 점화식(Recurrence)

- 어떤 수열의 일반항을 그 이전의 항들을 이용하여 정의한 식
- 예시) 피보나치 수열.

## 재귀함수

- 어떤 함수가 자신을 다시 호출하여 작업을 수행하는 방식

```
반환타입 함수이름 (매개변수){
    종료조건
    ...
    함수이름(...)
}
```

# 지수와 로그

- 지수와 로그를 Math 클래스 사용한 구현
- 직접 구현
- 1. 제곱, 제곱근, 지수
- 2. 로그

## 제곱, 제곱근, 지수 개념

- 제곱 : 같은 수를 두 번 곱함
- 거듭 제곱 : 같은 수를 거듭하여(2번 이상) 곱함
- 제곱근 (=root)
- a를 제곱하여 b가 될 때 a를 b의 제곱근이라고 함

```
2^3 = 2 x 2 x 2
4^1/2 = 2^2x1/2 = 2
a^x -> a: 밑, x : 지수
```

- 자바 Math 클래스 활용

```java
// 2^3
Math.pow(2, 3); // 8
Math.pow(2, -3); // 1/2^3 == 1/8
Math.pow(2, 30); // 1.073741824E9 //10의 9승
//루트 16
Math.sqrt(16);	//4
Math.pow(16, 1.0/2); //4

// cf)절대값 구하기
Math.abs(-5) == Math.abs(5)
```

## 로그

- log a b
- a가 b가 되기 위해 제곱해야하는 수

```
log 2 4 = 2
log 10 1000 = 3
log e 2.718281828459... = 1  => (자연상수)
```

- 자바 Math 클래스 활용

```java
Math(E); // 자연상수 == 2.718281828459045
Math.log(2.718281828459045); // 1.0
Math.log10(1000); // 3
//log 2 4 계산하기(밑이 다른 로그)
Math.log(4) / Math.log(2) // 2.0


```

# 알고리즘 복잡도

- 시간복잡도, 공간복잡도 개념 이해
- 빅오 표기법 이해와 코드에 대한 복잡도 산출 가능
- 시간 복잡도 예시 코드
- 공간 복잡도 예시 코드

## 복잡도

- 알고리즘 성능을 나타내는 척도
- 시간 복잡도 : 알고리즘의 필요 연산 횟수
- 공간 복잡도 : 알고리즘의 필요 메모리
- 시간 복잡도와 공간 복잡도는 Trade-off 관계

## 시간 복잡도

- 어떤 분제를 해결하기 위한 알고리즘의 필요 연산 횟수
- 빅오 표기법을 통해 나타냄
- O(1) < O(logN) < O(N) < O(NlogN) < O(N^2) < O(2^n)
- 상수시간<로그시간 < 선형시간 < 로그선형시간< 이차시간 < 지수시간

## 공간 복잡도

- 어떤 문제를 해결하기 위한 알고리즘의 필요 메모리 사용량
- 빅오 표기법을 통해 나타냄
- 일반적으로 메모리 사용량 기준은 MB 단위

```java
int[] a = new int[1000]; //4KB
int[][] a = new int[1000][1000]; //4MB
```

# 선형 자료구조

## 자료구조 개념

- 자료를 효율적으로 관리하기 위한 구조. -> 저장, 삭제, 탐색을 위해
- 목적에 맞게 사용한 좋은 자료구조는 실행 단축 or/and 메모리 용량 절감 효과가 있음.
- 알고리즘과 밀접한 관계

## 자료구조의 분류

### 선형 자료구조 (1:1관계)

- 배열
- 연결리스트
- 스택, 큐, 데크
- 해시 테이블

### 비선형 자료구조 (1:N관계, N:N관계)

- 트리
- 그래프
- 힙/우선순위 큐
- 트라이

# 배열

- 많은 수의 데이터를 다룰때 사용하는 자료구조
- 각 데이터를 인덱스와 1:1 대응하도록 구성
- 데이터가 메모리 상에 연속적으로 저장됨

## 장점

- 인덱스를 이용하여 데이터에 빠르게 접근 가능
- 컴퓨터가 데이터를 가져올 때 덩어리째로 읽어오기 때문에 인접한 메모리는 빠르게 엑세스 가능

## 단점

- 데이터의 추가/삭제가 번거로운 편
- 미리 최대 길이를 정해서 생성해야함
- 가변길이 배열은 배열의 크기 변경할 때마다 새로운 배열을 생성
- 데이터 삭제 시, 인덱스를 유지하기 위해 빈 공간 유지

# 연결 리스트(Linked List)

- 데이터를 링크로 연결해서 관리하는 자료구조
- 자료의 순서는 정해져 있지만, 메모리상 연속성이 보장되지는 않음

## 장점

- 데이터 공간을 미리 할당할 필요 없음
- 즉 리스트의 길이가 가변적이라 데이터 추가/삭제 용이

## 단점

- 연결구조를 위한 별도 데이터 공간 필요
- 연결정보를 찾는 시간이 필요(접근 속도가 상대적으로 느림)
- 데이터 추가, 삭제 시 앞뒤 데이터의 연결을 재구성하는 작업 필요

## 기본구조

- 노드 : 데터 저장단위로, 값과 포인터로 구성
- 포인터 : 다음 노드나 이전 노드의 연결 정보

# 스택

- 후입선출 자료구조 : 마지막에 들어온 데이터가 먼저 나가는 구조
- 데이터가 입력된 순서의 역순으로 처리되어야할 때 사용
- ex) 함수 콜 스택, 수식 계산, 인터럽트 처리 등

# 큐

- 선입선출구조
- 입력순서대로 데이터 처리가 필요할 때 사용
- 프린터 출력 대기열, BFS (Breath_First Search)

# 데크

- 양쪽에서 삽입과 삭제가 모두 가능한 자료구조
- Deque : Doubly-eneded Queue
- Stack과 Queue를 합친 형태

## 입력제한 데크 (Scroll)

- 한 쪽의 입력만 제한한 데크

## 출력제한 데크 (Shelf)

- 한 쪽의 출력을 제한한 데크

# 해시테이블

- 키, 값을 대응시켜 저장하는 데이터 구조 : 키를 통해 해당 데이터에 빠르게 접근 가능
- 해싱 : 키를 특정 계산식에 넣어 나온 결과를 사용하여 값에 접근하는 과정

## 해시 테이블 구조

- 키 : 해시 테이블 접근을 위한 입력 값
- 해시 함수 : 키를 해시 값으로 매핑하는 연산
- 해시 값 : 해시 테이블의 인덱스
- 해시 테이블 : 해시 테이블 : 키-값을 연고나시켜 저장하는 데이터 구조.

## 해시 충돌

- 해시 테이블의 같은 공간에 서로 다른 값을 저장하려는 경우
- 서로 다른 키의 해시 함수를 통한 해시 값이 동일한 경우
- 해시 충돌 해결 방법으로는 크게 개방주소법과 분리 연결법이 있음.

## 해시 충돌 해결법(1)

### 개방 주소법(Open Address)

- 충돌 시, 테이블에서 비어 있는 공간의 hash를 찾아 데이터를 저장.
- hash와 value가 1:1 관계 유지
- 비어있는 공간 탐색방법에 따라 분류
- 선형 탐사법, 제곱 탐사법, 이중 해싱

#### 개방주소법 - 선형 탐사법

- Linear Probing
- 빈 공간을 순차적으로 탐사하는 방법 : 충돌 발생 지점부터 **이후의 빈 공간**을 순서대로 탐사
- 일차 군집화 문제 발생 : 반복된 충돌 발생 시 해당 지점 주변에 데이터가 몰리는 경우 발생

#### 개방주소법 - 제곱 탐사법

- Quadratic Probing
- 빈공간을 n제곱만큼의 간격을 두고 탐사하는 방법 : 충돌 발생 지점부터 이후의 빈 공간을 n 제곱 간격으로 탐사
- 일차 군집화 문제 일부 보완
- 이차 군집화 문제 발생 가능성.

#### 개방주소법 - 이중 해싱

- Double Hashing
- 해싱 함수를 이중으로 사용
- 해시함수 1 :최초 해시를 구할 때 사용
- 해시함수 2 : 충돌 발생 시, 탐사 이동 간격을 구할 때 사용
- 선형 탐사, 제곱 탐사에 비해 데이터가 골고루 분포됨.

#### 해시 충돌 해결 방법(2)

##### 분리 연결법

- 해시테이블을 연결리스트로 구서
- 충돌 발생시, 테이블 내의 다른 위치를 탐색하는것이 연결리스트를 이용하여 해당 테이블에 데이터를 연결

# 비선형 자료구조 - 트리
## 1. 트리 
- 노드와 링크로 구성된 자료구조(그래프의 일종, Cycle없음)
- 계층적 구조를 나타낼때 사용
- 폴더 구조(디렉토리, 서브 디렉토리)
- 조직도, 가계도 ... 
## 2. 트리의 구조, 특징
- 하나의 노드에서 다른 노드로 이동하는 경로는 유일
- 노드가 N개인 트리의 엣지 수는 N-1개
- 사이클 없음
- 모든 노드는 서로 연결
- 하나의 엣지 끊으면 2개의 sub-tree로 분리됨 
## 3. 이진 트리, 종류, 특징
- 각 노드 최대 2개 자식
- 자식 노드는 좌우를 구분.
- 왼쪽자식 : 부모 노드 왼쪽 아래
- 오른쪽자식 : 부모 노드의 오른쪽 아래
### 이진 트리 종류
#### 포화 이진 트리(perfect binary tree)
- 모든 레벨에서 노드들이 꽉 채워져 있는 트리
#### 완전 이진 트리(complete ..)
- 마지막 레벨 제외하고 노드들이 모두 채워져 있는 트리 
#### 정 이진 트리(full ..)
- 모든 노드가 0개 또는 2개의 자식 노드를 갖는 트리
#### 편향 트리 = 사향트리(skewed ..)
- 한쪽으로 기울어진 트리
#### 균형 이진 트리(Balanced ..)
- 모든 노드의 좌우 서브 트리 높이가 1이상 차이나지 않는 트리 (탐색 속도가 빠르다.)
### 이진 트리 특징
- 포화 이진트리 높이가 h일때, 노드의 수는 2^h+1 - 1개 
- 포화(or 완전) 이진 트리의 노드가 N개 일 때, 높이는 logN
- 이진 트리의 노드가 N개일 때, 최대 가능 높이는 N-1 (사향트리)
## 4. 이진 트리 순회(Traversal)
- 모든 노드를 빠뜨리거나 중복하기 않고 방문하는 연산
- 순회 종류는 4가지
- 전위 순회, 중위 순회, 후위 순회 -> DFS
- 레벨 순회 -> BFS

### 순회 - 전위 순회
- 현재 -> 왼쪽 -> 오른쪽 
### 순회 - 중위 순회
- 왼쪽 -> 현재 -> 오른쪽 
### 순회 - 후위 순회
- 왼쪽 -> 오른쪽 -> 현재 
### 순회 - 레벨 순회
- 위쪽 레벨부터 왼쪽 -> 오른쪽 

## 5. 이진 트리 구현
- 배열 : 레벨 순회 순으로 배열에 구성
- -> 부모노드: /2 , 왼쪽노드 : x2+0, 오른쪽노드: x2+1
- 연결리스트 : 값과 간선을 관리하기 위한 노드로 연결리스트 구성 
 

## 이진 탐색트리_1 (기초)
- 아래의 규칙으로 구성된 이진트리
- 왼쪽 자식 노드의 키는 부모 노드의 키보다 작음
- 오른쪽 자식 노드의 키는 부모 노드의 키보다 큼
- 각각의 서브 트리도 이진 탐색 트리를 유지
- 중복된 키를 허용하지 않음.

### 이진 탐색 트리의 특징 
- 이진 탐색 트리 규칙에 의해 데이터가 정렬됨
- 이진 트리에 비해서 탐색 빠름(균형 유지 필요)
- 균형 상태: O(logN)
- 불균형 상태: O(N)

### 이진 탐색 트리 - 탐색
- 찾고자 하는 데이터를 루트 노드부터 비교 시작
- 대소 비교하여 찾는 데이터가 작으면 왼쪽, 크면 오른쪽 노드로 이동
- 찾는 데이터 없으면 null 반환
- 어떤 데이터를 찾더라도 최대 트리 높이 이하의 탐색이 이루어짐

### 이진 탐색 트리 - 삽입
- Root 부터 비교시작 (중복 키 발견 시 노드 추가하지 않고 종료)
- 삽입할 키가 현재 노드의 키보다 작으면 왼쪽 이동
- 삽입할 키가 현재 노드의 키보다 크면 오른쪽으로 이동
- Leaf 노드에 도달 후 키 비교하여 작으면 왼쪽, 크면 오른쪽에 삽입 (결국 맨 마지막으로 추가 됨!! - 기존 트리 구조 수정 없음)

### 이진 탐색 트리 - 삭제
#### 1. 삭제 대상 노드가 Leaf 노드인 경우
- 삭제 대상 노드 삭제
- 부모 노드의 해당 자식 링크 null로 변경 

#### 2. 삭제 대상 노드에 자식 노드가 하나 있는 경우
- 자식 노드를 삭제 대상 노드의 부모노드에 연결
- 삭제 대상 노드 삭제 

#### 3. 삭제 대상 노드에 자식 노드가 둘인 경우
1. 삭제 대상 노드의 왼쪽 서브트리에서 가장 큰 노드 선택
2. 삭제 대상 노드의 오른쪽 서브트리에서 가장 작은 노드 선택
3. 1, 또는 2에서 선택한 노드를 삭제 대상 노드 위치로 올림 (둘 중 아무나 하나 선택 !)
4. 위로 올리는 과정에서 다른 자식노드들의 링크 연결 작업 진행
5. 삭제 대상 노드 삭제 


## 이진 탐색트리 2 (심화 - 균형 이진트리, AVL 트리) - 일단 생략하기. 
- 일단 생략


# 비선형 자료구조 - 그래프
## 학습 목표
- 그래프 기본 개념
- 그래프의 종류 구분
- 그래프 탐색 방법의 이해와 구현
- 인접 행렬과 인접 리스트를 이용한 그래프 구현

## 그래프 기초 
- 정점과 간선으로 이루어진 자료구조(Cyclic)
- 연결된 정점간의 관계를 표현할 수 있는 자료구조
- 그래프의 용도 - 지하철 노선도, 통신 네트워크... 

## 그래프의 구조
- 정점(Vertex) : 각 노드
- 간선(Edge) : 노드와 노드를 연결하는 선(link, branch)
- 인접 정점(Adjacent vertex) : 간선 하나를 두고 바로 연결된 정점
- 정점의 차수(Degree) : 무방향 그래프에서 하나의 정점에 인접한 정점의 수. 
- 무방향 그래프 모든 정점 차수의 합 = 그래프 간선의 수 2배
- 진입 차수(In-degree) : 방향 그래프에서 외부에서 오는 간선의 수
- 진출 차수(Out-degree) : 방향 그래프에서 외부로 나가는 간선의 수
- 경로 길이(Path length) : 경로를 구성하는데 사용된 간선의 수
- 단순 경로(Simple path) : 경로 중에서 반복되는 정점이 없는 경우
- 사이클(Cycle) : 단순 경로의 시작 정점과 끝 정점이 동일한 경우

## 그래프와 트리의 차이
### 개요
- 그래프 : 노드와 간선으로 이루어진 구조
- 트리 : 그래프의 한 종류
### 방향성
- 그래프 : 방향 그래프, 무방향 그래프
- 트리 : 방향 그래프
### 사이클 
- 그래프 : Cyclic
- 트리 : Acyclic
### 모델
- 그래프 : 네트워크 모델
- 트리 : 계층 모델
### 루트 노드
- 그래프 : 루트 노드 X
- 트리 : 최상위 노드
### 부모-자식
- 그래프 : 부모-자식 관계 X
- 트리 : 인접한 상하위 노드
### 간선 수
- 그래프 : 그래프에 따라 간선 개수 다름
- 트리 : N개의 노드로 구성된 트리의 간선 수는 N-1개
### 순회
- 그래프 : DFS, BFS
- 트리 : Pre-, In-, Post-order (DFS에 속함)/ Level-order (BFS에 속함)
### 경로
- 그래프 : 2개 이상의 경로 가능
- 트리 : 두 노드 간의 경로는 1개

## 그래프의 종류 (1)
### 무방향 그래프
- 간선에 방향이 없는 그래프(양방향 이동 가능)
- 정점 A-B 간선의 표현: (A, B) or (B, A)
### 방향 그래프
- 간선에 방향이 있는 그래프(해당 방향으로만 이동 가능)
- 정점 A -> B 간선의 표현: <A, B> != <B, A>

## 그래프의 종류(2)
### 가중치 그래프
- 간선에 값이 있는 그래프(이동 비용)
### 완전 그래프
- 모든 정점이 서로 연결되어 있는 그래프
- 정점이 N개인 경우, 간선의 수는 n(n-1)/2 개

## 그래프 탐색 - DFS
- 깊이 우선 탐색
- 각 노드에 방문했는지 여부를 체크할 배열과 스택 이용하여 구현 

## 그래프 탐색 - BFS
- 너비 우선 탐색
- 각 노드에 방문했는지 여부를 체크할 배열과 큐 이용하여 구현 

## 그래프의 구현 (1)
### 인접 행렬(Adjacency Matrix)
- 2차원 배열 이용
### 인접 행렬의 장단점
- 간선 정보의 확인과 업데이트가 빠름 O(1)
- 인접 행렬을 위한 메모리 공간 차지. 

## 그래프의 구현 (2)
### 인접 리스트(Adjacentcy List)
- 연결리스트 이용
### 인접 행렬의 장단점
- 메모리 사용량이 상대적으로 적고, 노드의 추가 삭제 빠름
- 간선 정보 확인이 상대적으로 오래 걸

## 인접 행렬 VS 인접 리스트
### 인접 행렬
- 노드의 개수가 적고 간선의 수가 많을 때 유리
### 인접 리스트
- 노드의 개수가 많고 간선의 수가 적을 때 유리
### 비교 
- N(전체 정점 개수), E(전체 간선 개수) 
#### 특정 간선 검색
- 인접 행렬 : O(1)
- 인접 리스트 : O(degree(V))
#### 정점의 차수 계산
- 인접 행렬 : O(N)
- 인접 리스트 : O(degree(V))
#### 전체 노드 탐색
- 인접 행렬 : O(N^2) 
- 인접 리스트 : O(E)
#### 메모리
- 인접 행렬 : N x N 
- 인접 리스트 : N + E


# 비선형 자료구조 - 힙
## 학습목표 
- 힙 자료구조의 이해
- 최소 힙과 최대 힙의 삽입, 삭제 과정의 이해와 구현

## 힙 개념
- 완전 이진 트리 형태 -> 중복 값 허용, 반 정렬 상태 
- 최소값 또는 최대값을 빠르게 찾아내는데 유용한 자료구조 -> 최소힙, 최대힙
- 최대값이나 최소값을 빠르게 찾아내기 위해 사용하는 완전 이진트리 형태의 자료구조


### 최소 힙
- 부모 노드의 키가 자식 노드의 키보다 **작거나 같은** 형태
### 최대 힙
- 부모 노드의 키가 자식 보드의 키보다 **크거나 같은** 형태

## 예시 (최소 힙)
### 최소 힙 - 삽입
- 트리의 가장 끝 위치에 데이터 삽입
- 부모 노드와 키 비교한 후 작을 경우 부모 자리와 교체 (반복)

### 최소 힙 - 삭제
- 최상위 노드 반환 및 삭제
- 가장 마지막 위치의 노드를 최상위 노드로 위치 시킴
- 자식 노드 중 더 작은 값과 비교 후 부모 노드가 더 크면 자리 교체 (반복)

# 비선형 자료구조 - 우선순위 큐

## 우선 순위 큐 - 개념
- 우선순위가 높은 데이터가 먼저 나옴
- 모든 데이터에 우선순위가 있음
- Dequeue 시, 우선 순위가 높은 순으로 나감
- 우선 순위가 같은 경우는 FIFO

## 우선 순위 큐 - enqueue, dequeue
- 최소 힙 및 최대 힙의 삽입 삭제와 같음

## 우선 순위 큐 - 구현
- 정렬된 배열 : 엔큐 - O(N) / 디큐 - O(1)
- 정렬된 연결 리스트 : 엔큐 - O(N) / 디큐 - O(1)
- 힙 : 엔큐 - O(logN) / 디큐 - O(logN)  // <- 자바 내부 힙으로 구현됨

# 비선형 자료구조 - 트라이
## 트라이 개념 
- 문자열을 저장하고 빠르게 탐색하기 위한 트리 형태의 자료구조
- 정렬된 트리구조
- 문자열 저장을 위한 메모리가 필요하지만 탐색이 빠름
- 길이가 N인 문자열 탐색의 시간 복잡도 : O(N)
- 생성 복잡도 : O(MN), M : 문자열 개수
## 트라이 구현
- Key, Value로 이루어진 노드로 구성
- Key : 알파벳
- Value : 자식노드
```java
class Node{
    HashMap <Chacter, Node> child;
    boolean isTerminal;
}
```


# 알고리즘 
- 

# 정렬 알고리즘 - 기초 (생략)
# 정렬 알고리즘 - 심화 (기수, 계수, 셸 - 생략 )

# 정렬 알고리즘  
- 합병 정렬
- 힙 정렬
- 퀵 정렬
- 트리 정렬

## 합병 정렬(Merge Sort)
- 배열을 계속 분할해서 길이가 1이 되도록 만들고, 인접한 부분끼리 정렬하면서 합병하는 방식
- 알고리즘 복잡도 : O(nlogn)

## 힙정렬(Heap Sort)
- 힙 자료구조 형태의 정렬 방식
- 기존 배열을 최대 힙으로 구조 변경 후 정렬 진행
- 알고리즘 복잡도 : O(nlogn)

## 퀵정렬(Quick Sort)
- 임의의 기준 값을 정하고 그 값을 기준으로 좌우로 분할하며 정렬하는 방식
- 알고리즘 복잡도 : O(n^2)

## 트리 정렬(Tree Sort)
- 이진 탐색 트리(BST)를 만들어 정렬하는 방식
- 알고리즘 복잡도 O(nlogn)

# 이진탐색 알고리즘
- 정렬된 상태의 데이터에서 특정 값을 빠르게 탐색하는 방법
- 찾고자 하는 값과 데이터 중앙에 있는 값을 비교
- 찾고자 하는 값이 더 작으면 데이터 왼쪽 부분에서 이진 탐색
- 찾고자 하는 값이 더 크면 데이터 오른쪽 부분에서 이진 탐색
- 시간 복잡도 : O(logn)

# 투 포인터 알고리즘
- 배열에서 두 개의 포인터를 사용하여 원하는 결과를 얻는 방법
- 두 개 포인터의 배치 방법
- 같은 방향에서 시작 : 첫 번쨰 원소에 둘 다 배치
- 서로 다른 방향에서 시작 : 첫번쨰 원소와 마지막 원소에 배치
- 다중 for 문의 복잡도를 좀 더 선형적으로 풀 수 있음. 

# 그리디 알고리즘
- 매 순간 현재 기준으로 최선의 답을 선택해 나가는 기법
- 빠르게 근사치를 계산할 수 있다.
- 결과적으로 최적해가 아닐 수도 있다.  

## 그리디 알고리즘 예시
### 예시 1
- Activity Selection Problem
- N 개의 활동과 각 활동의 시작/종료 시간이 주어졌을 때, 한 사람이 최대한 많이 할 수 있는 활동의 수 구하기.
- -> 종료 시간 기준을 정렬 -> 먼저 종료되는 활동 순, 겹치지 않는 순으로 선택 
### 예시 2
- 거스름돈(동전의 개수 가장 적게)
- 잔돈:890
- 동전 종류 : 10, 50, 100, 500 -> 큰 동전부터 계산
### 그리디 안되는 예시 (거스름돈 안되는 경우)
- 잔돈 :890
- 동전 종류 : 10, 50, 100, 400, 500

## 그리디 알고리즘 적용 조건
- 그리디 알고리즘은 빠르지만 최적해를 보장하지는 못함
- 하기 두 가지 조건에 해당하는 경우 적용 가능
1. 탐욕적 선택 특성 : 지금 선택이 다음 선택에 영향을 주지 않음
2. 최적 부분 구조 : 전체 문제의 최적해는 부분 문제의 최적해로 이루어짐


# 분할 정복 알고리즘
## 분할 정복 개념
- 큰 문제를 작은 부분 문제로 나누어 해결하는 방법
- 합병 정렬, 퀵 정렬, 이진 검색 ...

## 분할 정복 과정
- 문제를 하나 이상의 작은 부분들로 분할
- 부분들을 각각 정복
- 부분들의 해답을 통하여 원래 문제의 답을 구함. 

## 분할 정복의 장/단점
### 장점 
- 문제를 나누어 처리하며 어려운 문제 해결 가능
- 병렬처리에 이점이 있음
### 단점
- 메모리를 많이 사용(재귀 호출 구조)


# DP 알고리즘
- 다이나믹 프로그래밍(동적 계획법)
- 큰 문제를 부분 문제로 나눈 후 답을 찾아가는 과정에서, 계산된 결과를 기록하고 재활용하며 문제의 답을 구하는 방식
- 중간 계산 결과를 기록하기 위한 메모리가 필요
- 한 번 계산한 부분을 다시 계산하지 않아 속도가 빠름.

## 다른 알고리즘과의 차이점
### 분할 정복과의 차이
- 분할 정복은 부분 문제가 중복되지 않음
- DP는 부분 문제가 중복되어 재활용에 사용
### 그리디 알고리즘과의 차이
- 그리디 알고리즘은 순간의 최선을 구하는 방식(근사치)
- DP는 모든 방법을 확인 후 최적해 구하는 방식

### 다이나믹 프로그래밍 방법
#### 타뷸레이션
- 상향식 접근 방법
- 작은 하위 문제부터 풀면서 올라감
- 모두 계산하면서 차례대로 진행
#### 메모이제이션
- 하향식 접근 방법
- 큰 문제에서 하위 문제를 확인해가며 진행
- 계산이 필요한 순간 계산하며 진행



# 테코톡 정리


# 싱글턴 패턴과 정적 클래스
- **프로그램 전역**에서 사용되는 유일한 클래스 두가지 방법. 1. 싱글턴 패턴. 2. 정적 클래스

## 디자인패턴 개념
- "바퀴를 재발명 하지마라"
- 소프트웨어 개발 과정에서 자주 쓰이는 설계의 노하우들을 정리한 방법들.

## 싱글턴 패턴
- 객체의 인스턴스가 오로지 한개만 생성되도록 설계하는 것.
- when? -> 로그기록, 캐싱, 사용자 설정 등
- why? -> 1. 유일성 2. 글로벌 

## 정적클래스
- 사실 자바에는 정적 클래스가 따로 존재하지 않음.
- 편의상 정적 메소드만을 갖고 있는 클래스를 정적 클래스라고 함.
- 정적 메소드들은 클래스 초기화 시에 메서드 영역에 등록되어 프로그램이 끝날 때 해지됨. 
- 애플리케이션 내에서 싱글턴 패턴과 마찬가지로 전역적으로 사용, 인스턴스를 따로 사용하지 않기 때문에 유일성을 보장 받음.
- 차이점은  인스턴스를 생성할 수 없기 때문에 클래스메서드를 이용. '

## 싱글턴 패턴 VS 정적 클래스 사용 경우
### 싱글턴 패턴
- 1. 상속 받아서 사용 가능.
- 2. 메서드 파라미터로 사용 가능.
- -> 완벽한 객체지향을 필요로 할 때, 레이지 로딩이 필요할 때 사용. 
### 정적 클래스
- 1. 객체 생성을 하지 않는다. (효율성)
- -> 유틸 메서드를 보관하는 용도로 사용할 때, 다형성이나 상속이 필요없는 클래스. 

# 전략 패턴.
- 객체가 할 수 있는 행위들을 각각 전략으로 만들어 놓고 사용하며, 동적으로 전략 수정이 가능한 패턴.
- -> 동일 계열 알고리즘 군을 정의하고, 각 알고리즘을 캡슐화하며, 이들을 상호교환이 가능하도록 만듬. 
- 코드 수정이 용이(전략 수정). 새로운 기능 추가가 용이(전략 추가)
- 예시) -> Comparator -> 개발 상황에 맞게 비교 전략을 구현하여 기존 코드의 수정없이 확장 가능. 


# 깃 브랜치 전략
## 브랜치 전략이란?
- 브랜치 전략이란 여러명의 개발자가 1개의 저장소를 사용하는 환경에서 효과적으로 사용을 하기 위해 나온 개념. 
## Github flow란?
- Github에서만든 단순한 구조의 브랜치 전략
- Master 브랜치를 중심으로 운영되며, 기능 개발 버그 수정 등의 작업용 브랜치를 구분하지 않는 단순한 구조.
- 수시로 배포가 일어나는 프로젝트에 유용.
### 1. 브랜치 생성
- Master로부터 기능 추가, 버그 수정 작업을 위한 새로운 브랜치를 생성.
- 이때, commit 메시지와 브랜치 이름은 정확하고 간결하게 작성.
- 기능 추가, 버그 수정 작업을 하는 모든 브랜치는 master로부터 나온다. 
### 2. 기능 개발, 버그 수정
- 작업을 하며 기능별로 commit을 한다.
- commit 메시지는 정확하고 간결하게 작성해야 한다.
- Commit은 서버에서 동일한 브랜치에 push 해줘야 함 (git flow와 차이점.)
### 3. Pull Request 생성
- 기능 또는 오류 수정이 완료되었으면 PR을 보낸다. 
### 4. 리뷰와 논의
- PR읠 통해 팀원과 작성한 코드에 대한 리뷰와 논의를 함. 
### 5. 공개 및 테스트.  
- Github에서는 Master에 합치기 전에 브랜치에서 코드를 공개 및 테스트할 수 있음.
- PR상의 테스트가 끝난경우 (테스트 버전으로) 공개할 수 있음.
- 오류가 발생할 경우 원래의 master 브랜치를 다시 배포하여 roll back 한다. 
### 6. 합치기(Merge)
- Branch의 검증이 완료되면 메인 브랜치에 합친다. 


## Git flow란?
- 크게 다섯개의 브랜치를 운영
- 메인 브랜치 : master, develop
- 보조 브랜치 : feature, release, hotfix 
- 배포주기가 길고 팀의 여력이 있는 경우 적합. 
### 메인 브랜치들 측징
- Master와 Develop 브랜치가 있따.
- 두개의 브랜치는 항상 남아 있다.
- Master 브랜치는 제품으로 배포할 수 있는 브랜치.
- Develop 브랜치는 개발자들이 개발하는 브랜치. 
### 보조 브랜치 특징
- feature, release, hotfix 브랜치가 있다.
- 보조 브랜치들은 메인 브랜치와 다르게 사용을 마치면 브랜치를 삭제함. 


# Merge, Reabse, Cherry-pick
## Merge 개념
- git은 서로 다른 작업을 하기 위한 별도의 공간을 생성할 때 브랜치를 생성할 수 있다.
- 기능 구현을 위해서 해당하는 기능을 구현하기 위한 브랜치를 생성한다. 
- 기능 구현이 되는 경우 해당 기능을 main 브랜치에 merge 한다. 
### fast-forward
- 현재 브랜치가 머지할 브랜치로 최신 정보들을 모두 따라감. (베이스가 같을 떄)
### 3-way-merge
- 깃이 별도의 최적 공통 조상을 자동으로 찾는 오토 머지로 커밋을 하나 생성하고, 해당 커밋을 가리키도록 이동하는 것.(베이스가 달라졌을 때)
### conflict
-  오토 머지를 시도 했지만, 충돌이 발생. 
### Non fast foward : (github Pull Request)  fast-foward 이외 3가지 머지 방법 제공
#### Create a merge commit 
- 베이스 브랜치가 같더라도 fast-foward진행x -> 하나의 머지 커멋을 생성하여 머지를 진행. 
- 기능구현을 할 때, 사용했던 커밋들이 하나 하나살아 있어, 이를 사용할 여지를 남김과 동시에, 만든 기능에 대해서 머지 분기점이 생기므로, 어떤 기능을 만들어 메인에 머지했는지 가독성이 좋아짐. 
#### Squash and Merge
- create a merge 와 같이 하나의 머지 커밋을 생성해서, 해당 커밋을 바라보게 하는데, 피처에서 작업했던 모든 커밋을, 하나의 커밋으로 통합해서 머지. 커밋이 너무 길어 알아보기 힘들 경우 방지 
#### Rebase and Merge
- rebase는 베이스를 다시 조정하는, 즉, 피쳐에서 작업했던 커밋들을 모두 현재 메인 브랜치에서 최상단에 복사붙여넣기 하는 작업.  -> 커밋이 많을 때 한 줄로 모든 커밋이 저장되어 오히려 가독성이 떨어질 수도 있음. 


### Merge 요약
- 1. Merge 할 때 base가 같으면 Fast-Forward한다. 
- 2. Merge 할 때 base가 다르면 merge commit을 생성하여 auto merge한다. - 단, confilct가 발생할 경우 개발자가 직접 처리.
- 3. GitHub Pull Request에서 merge할 수 있는 3가지 방법인 create a merge commit, squash and merge, rebase and merge가 있음. 

## Rebase 개념
### Merge와의 비교
- 공통점 : 브랜치를 합친다.
- 차이점 : Merge보다 꺠끗한 commit history를 만든다. 

### Rebase란?
- 현재 branch의 Base를 재설정하여 합치는 것!
- Base가 바뀔 commit들을 복사하여 연이어 붙이는 것!
- Rebase 전의 commit 들은 Rebase 후의 commit 들과 id 가 다름 !

### Rebase 요약
- 1. Rebase는 브랜치를 합치려는 목적으로 사용된다! - Commit History과 Merge와는 다르게 선형적으로 그려진다.
- 2. Rebase는 현재 브랜치의 base를 바꾸겠다는 것. - 생성된 커밋들은 새롭게 복사되어 base가 변경됨!
- 3. Merge를 한 코드 결과, Rebase를 한 코드 결과는 같아야함!

## Cherry-pick 개념
### Cherry-pick 이란?
- 다른 브랜치에 있는 커밋을 선택적으로 내 브랜치에 적용시키는 것.  
### Cherry-pick - Confilct 해결하기
- 1. Conflict를 해결하기 위해 코드를 수정
- 2. Git add 명령으로 수정된 코드를 add한다.
- 3. Git cherry-pick --continue 명령을 수행함. 

### 요약
- 1. Cherry-pick으로 다른 브랜치 커밋을 내 브랜치로 가져올 수 있다. (한개, 여러개 , 연속된 구간 커밋 가져올 수 있음)
- 2. Cherry-pick이 된 커밋들은 복사됨
- 3. Cherry-pick 진행 시 충돌이 발생할 수 있으며, git add, continue 명령어로 해결. 


# 제네릭
- 제네릭은 **컴파일 타임에 타입을 체크**함으로써 코드의 안전성을 높여주는 기능. 
```java
List<T> // T는 타입 매개변수

List<String> stringList = new ArrayList<>();
// 매개변수화 된 타입 
```

## 제네릭 사용 이유
- 1. 컴파일 타임에 강력한 타입 검사

```java
// 제네릭 미사용
List stringList = new ArrayList<>();
stringList.add("abcd");
stringList.add(1); //int
String result = (String)stringList.get(0) + (String)stringList.get(1); //Runtime Error!

// 제네릭 사용
List<String> stringList = new ArrayList<>();
stringList.add("abcd");
stringList.add(1); //Compile Error 발생 !!!
```

- 2. 캐스팅(타입 변환) 제거
```java
// 제네릭 미사용
List stringList = new ArrayList<>();
stringList.add("abcd");
String result = (String) stringList.get(0); //일일히 캐스팅 (코드 추가작성 & 성능 저하)
// 제네릭 사용
List<String> stringList = new ArrayList<>();
stringList.add("abcd");
String result = stringList.get(0);
```

## List<Object> objectList = new ArrayList<Integer>(); 가능할까? -> 되지 않음!!
- 이유 : 변성 - 무공변이기 때문임.
### 변성(variance)
#### 무공변(Invariance) - <T>
- 타입 B가 타입 A의 하위 타입일 때. Category<B>가 Category<A>의 하위 타입이 아닌 경우. 즉, 아무런 관계가 없다. 
#### 공변(Covariance) - <? extends T>
- 타입 B가 타입 A의 하위 타입일 때. Category<B>가 Category<A>의 하위 타입인 경우 ok.
#### 반공변(Contravaiance) - <? super T>
- 타입 B가 타입 A의 하위 타입일 때, Category<B>가 Category<A>의 상위 타입인 경우 ok.

### 배열 vs 제네릭 타입
- 배열일 경우 (공변)
```java
Object[] objectArray = new Integer[1]; //성립됨 !
```
- 제네릭 타입 (하위 타입 상관없이 다르면 안됨. - 무공변)
```java
List<Object> objectList = new ArrayList<Integer>(); // 컴파일 에러 !!
```

## 제네릭 타입(Generic Types)
- Class<T>. interface<T>
- 제네틱타입은 **타입을 파라미터로 가지는** 클래스와 인터페이스를 말함. 
```java
// 비제네릭
class Category{
	private Object object;
	public void set(Object object){
		this.object = object;
	}
	public Object get(){
		return object;
	}
}
// 제네릭
class Category<T>{
	private T t;
	public void set(T t){
		this.t = t;
	}
	public T get(){
		return t;
	}
}
```

## 제네릭 메서드 
- 메서드의 선언부에 제네릭타입이 선언된 형식. 
- 타입 매개변수의 범위가 메서드내로 한정됨. 

## 제네릭 타입 제한의 필요성
- <T extends Noodle> 
- 누들과, 누들을 상속한 타입만 제네릭 매개변수로 들어갈 수 있음 ! 

## 와일드 카드
- 1. <?> Unbounded Wildcards : 모든 타입이 가능
- 2. <? extends Noodle> Upper Bounded Wildcards(상한 경계) : Noodle과 Noodle의 하위 타입.
- 3. <? super Noodle> Lower Bounded Wildcards(하한 경계) : Noodle과 Noddle의 상위 타입.

### 와일드 카드 - 제한
```java
class Category<T>{
	private T t;
	public void set(T t){
		this.t = t;
	}
	public T get(){
		return t;
	}
}

class CategoryHelper{
	public void popNoodle(Category<? extends Noodle> category){
		Noodle noodle = category.get(); // 꺼내는건 OK!
		
		category.set(new Noodle()); // 저장 NO! // 누들이 들어올지, 파스터가 들어올지 모름. (상위 타입에 하위 타입을 대입할 위험)
	}
	public void pushNoodle(Category<? super Noodle> category){
		category.set(new Noodle()); // 저장 OK

		Noodle noodle = category.get(); // 꺼내는건 NO! //누들보다 상위타입이 꺼내질 수 도 있기 때문에 컴파일 오류
	}
}
```
## 언제 써야할까 ?
- 이펙티브 자바에서 말하는 "PECS"
- producer - extends.
- consumer - super.

## 제네릭 타입 소거 
- 제네릭 이전 버전 사용을 위한 기능 
- 1. 타입 매개변수의 경계가 없는 경우에는 Object로, 경계가 있는 경우에는 경계 타입으로 타입 파라미터를 변경
- 2. 타입 안정성을 유지하기 위해. 필요한 경우 타입 변환 추가. 
- 3. 제네릭 타입을 상속받은 클래스의 다형성을 유지하기 위해 Bride method 생성. 

# DI 와 IoC 
## IoC (Inversion Of Control - 제어의 역전)
- 제어란? : 객체 생명주기나, 메서드 호출을 관리 하는 것.  
- 제어의 역전 : 프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것.
```java
public class A{
	private B b;
	public A(B b){ // 외부에서 관리
		this.b = b;
	}
}
```
### IoC 필요 이유
- 외부에서 제어를 받으면 코드 수정이 용이. 
- -> 객체지향 원칙을 잘 지키기 위함. -> 역할과 관심을 분리해 응집도를 높이고, 결합도를 낮춰, 변경에 유연한 코드를 작성 가능. 
- 할리우드 법칙과 비슷 (don't call us, we'll call you)

## DIP(Dependency Inversion Principal) - 의존 역전 원칙
- 상위 레벨의 모듈은 절대 하위 레벨 모듈에 의존하지 않는다.
- 둘 다 추상화에 의존해야 한다. 
- ex) 이탈리안 비엠티 (고수준 모듈) ->의존-> 파마산오레가노(저수준 모듈)  => 빵이 변경되면 이탈리안 비엠비도 변경해야함
- -> 이탈리안 비엠티 -> Bread(추상화 인터페이스) <- 여러가지 빵 => Bread만 변경할 수 있음. 
- -> 고수준 모듈과 저수준 모듈이 모두 추상화에 의존하는 것. 

## IoC 와 DIP 의 목적
- 클래스 간 결합을 느슨하게 하기 위함 -> 한 클래스의 변경에 따른 다른 클래스의 영향을 최소화 -> 앱을 지속가능하고 확장성 있게 

## IoC와 DIP 비교
- 공통점 : 둘다 원칙임. -> 같은 목적을 가졌지만, IoC는 제어(역전), DIP는 의존(역전)에 관심 
- IoC의 주체 : 객체일 수도, 프레임 워크 등 일수도 있는 외부의 미지의 존재. 
- DIP의 적용 : 필드가 인터페이스로 구현됨! 

## DI - IoC 구현 패턴 중 대표가 DI (의존성 주입)
- 의존성 : 클래스간에 의존 관계가 있다는 것. = 한 클래스가 바뀔 때 다른 클래스가 영향을 받는다는 것.
- DI : 의존성을 주입 시켜 주는 것.
- DI 방법 (의존성을 주입시켜 주는 방법) : 생성자 주입, setter 주입, Interface 주입 
- Interface 주입 -> 인터페이스에서 구현 클래스가 inject()를 오버라이드하도록 강제. 

### 의존성 분리
- DIP를 이용해 의존 관계를 분리시킨다.
- 상위 계층이 하위계층에 의존하는 상황을 Interface를 이용해 반전시켜 하위게층의 구현으로부터 독립시킨다. 

### DI는 패턴임
- IoC, DIP는 원칙.
- DI는 패턴. - IoC를 달성하는 디자인 패턴 중 하나.  
- IoC는 누가 어떤 방식으로 의존성을 역전하는 건지는 중요하지 않음 !!! (역전만 되면 됨)
- DI는 의존성을 외부에서 주입해줘서 역전을 시킨다는 구체적인 행위 ! (방법론) 

 
## Spring DI - 자동 주입
- 스프링 빈으로 등록되면 스프링이 자동으로 객체 생성 해줌. -> 이 때 필요한 의존성도 자동 주입 해줌. 
### 스프링 의존성 주입 방법 - @Autowired
```java
@Controller
public class MemberController{
	@Autowired // 자동 주입! (MemberService도 스프링 빈이어야함.)
	private MemberService memberService;
}
```
#### 1. @Autowired - 필드 주입 (권장 X)
- 의존성이 프레임워크에 강하게 종속되어 테스트 등(수동 주입해야하는 상황)이 어려움 !
```java
@Controller
public class MemberController{
	@Autowired 
	private MemberService memberService;
}
```

#### 2. @Autowired - setter 주입 <- 의존성의 불변을 보장할 수 없다 !
- bean 객체를 만들고, setter 로 의존성을 주입해주기 때문에, bean생성자 또는 bean 정적 팩토리 메서드가 필요. 
- 따라서 final 필드를 만들 수 없고, 의존성의 불변을 보장할 수 없는 특징이 있음 !!
- 의존성을 변경해야하는 상황에서 사용 -> 런타임의 의존성을 수정해줘야 하거나, 의존성을 선택적으로 주입할 때 사용. 
- -> setter 주입은 주로 클래스 내에서 합리적인 기본 값을 할당할 수 있는 선택적 의존성에만 사용해야한다 !!
```java
@Controller
public class MemberController{
	private MemberService memberService;

	@Autowired
	public void setMemberService(MemberService memberService){
		this.memberService = memberService;
	}
}
```

#### 3. @Autowired - 생성자 주입  <- 의존관계 불변!!!(스프링 권장)
- 객체 최초 생성 시점에 스프링이 의존성을 주입해줌. 
- 스프링에서 공식 추천. -> 4.3버전 이후부터 생성자가 하나일 때, @Autowired를 붙이지 않아도 자동 주입됨. 
- 생성자 주입된 컴포넌트들은 완전히 초기화된 상태로 클라이언트에 반환된다. 
- -> 필드를 final로 만들 수 있으며, 의존성 주입이 생성자 호출 시, 최초 1회만 이루어짐. -> 의존관계 불변!
- -> final이 가능하기 때문에 NullPointerException을 방지할 수 있음.
- -> 필드 주입이나 setter 주입인 경우 스프링의 빈 관리 기능을 빌리지 않고 new 키워드로 객체를 생성해줄 경우 NullPointerException이 발생할 수 있지만
- -> 생성자 주입은 객체 생성시점에 모든 의존성을 주입해주므로 널포인터예외 발생x.(완전한 생성자라는 가정하에)
- -> 순환 참조 문제를 방지 가능. -> 2.6버전 이후로는 필드, 세터 주입도 순환참조 방지 기본설정됨
```java
@Controller
public class MemberController{
	private final MemberService memberService; //final 가능
	public MemberController(MemberService memberService){
		this.memberService = memberService;
	}
}
```

##### 생성자가 여러개라면?
- 의존성을 자동으로 주입하는데 사용할 생성자에 @Autowired
- @Autowired가 여러 개 있을 경우 -> 가장 많은 의존성을 주입할 수 있는 생성자를 사용
- @Autowired가 붙은 모든 생성자가 사용 불가능한 경우 또는 어떤 생성자에도 @Autowired가 없을 경우 -> 기본 생성자를 호출
- 기본 생성자 조차 없는 경우 -> 컴파일 에러

### 스프링 의존성 주입 순서
- 모두 사용했을 경우 스프링이 - 생성자 -> 필드 -> 세터 순으로 주입해줌. 
- 주입 대상 찾을때 -> 1. 타입으로 -> 2. 빈의 이름으로 
```java
@Controller
public class PayController{
	private final PayService payService;

	public PayController(PayService naverPayService){
		this.payService = naverPayService;
	}
}
@Service
public class NaverPayService implement PayService{	 // 스프링이 매개변수 이름으로 이것을 주입시킴 ! 
}
@Service
public class KaKaoPayService implement PayService{	
}
```
- 이름으로만 안되는 경우 -> @Qualifier (@Primary보다 우선권을 갖는다 !!! )

```java
@Controller
public class PayController{
	private final PayService payService;

	public PayController(@Qualifier("mainPaySevice") PayService payService){
		this.payService = naverPayService;
	}
}
@Service @Qualifier("mainPaySevice") // 스프링이 애노테이션 밸류로 이것을 주입시킴 ! 
public class NaverPayService implement PayService{	 
}
```

- 또는 @Primary
```java
@Controller
public class PayController{
	private final PayService payService;

	public PayController(PayService payService){
		this.payService = naverPayService;
	}
}
@Service @Primary // 스프링이 우선적으로 주입함 !!!
public class NaverPayService implement PayService{	 
}
```

### 스프링 의존성 주입 순서 정리
- 타입 -> @Qualifier -> @Primary -> 변수명 