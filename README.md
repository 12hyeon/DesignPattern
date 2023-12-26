# DesignPattern
- 디자인 패턴을 활용한 report 생성기
  <br>

## 1. 적용할 디자인 패턴

1) Strategy
2) Factory Method
3) Decorator
4) Adapter
5) Abstract Factory
   <br>

## 2. 선정 이유
1) Strategy
- 표지가 앞과 뒤가 존재하며 각 구성이 다양하게 존재할 수 있고, 해당 표지들이 서로 교체될 수 있는 구조가 필요했는데
  각 알고리즘을 캡슐화하여 상호 교환할 수 있는 상태로 만드는 패턴이므로 Strategy가 적합하다고 판단하였습니다.

2) Factory Method
- report 생성부터 출력 과정이 있고 여러 report의 종류가 존재하며, Dan과 Kook 지점마다 다른 report 가격의 내용을 처리하는
  과정에서 Factory Method가 기존 코드의 수정 없이 확장에 유연하여 추가적인 지점과 report 종류 확장이 가능하기에 사용하기로 하였습니다.

3) Decorator
- date와 title이 추가됨에 따라 기존 가격에 추가된 가격을 불러올 수 있도록 구성하는 방식이 필요하여
  기존 report에 추가적인 기능을 부여할 수 있도록 만드는 decorator를 선택하였습니다.

4) Adapter
- User 정보를 기반으로 report를 꾸미게 되는 구조에서 user 말고 team으로 작성하는 경우에도 호환된 형식으로 출력을 진행하기 위해서
  team에서 여러 개를 가지게 되는 name과 email를 같은 함수로 처리할 수 있게 하는 Adapter를 사용하기로 하였습니다.

5) Abstract Factory
- 여러 지점의 factory에서 지점마다 프린터에서 선택한 report 종류의 형식을 다르게 처리될 수 있다고 생각하였으며,
  대소문자와 빈칸에 따른 형식을 정의하고 해당 내용을 factory에서 이용할 수 있도록 구성하는 과정에서 Abstract Factory가
  객체 생성을 캡슐화하여 쉽게 의존성 주입을 할 수 있기에 적합하다고 생각하였습니다.
  <br>

## 3. 설계 클래스 다이어그램
![image](https://github.com/12hyeon/DesignPattern/assets/67951802/94a9b6b6-ec8f-45af-b32e-fc065e8ffac5)

<br>

## 4. 실제 사용 예

리포트 종류 중 circle_type 및, Detailed 앞표지, Simple 뒤표지 선택 + date와 title 모두 추가
<br>
=> 각 date와 title이 본문 1장이 추가될 때마다 10, 30원씩 추가됨에 따라 예시 1번에 비해서 80이 많은 390원의 결과를 가져오게 됩니다.

![image](https://github.com/12hyeon/DesignPattern/assets/67951802/5ce642d3-08f5-4019-b413-f8a644ea8442)


