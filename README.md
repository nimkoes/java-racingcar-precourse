# 자동차 경주 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)


## 기능 요구사항
  
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.  
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.  
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.  
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.  
- 전진하는 조건은 0에서 9사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.  
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.  
  
  
## 기능 목록
  
- 전진하는 자동차의 이름을 입력 받는다.
  - 입력한 이름이 있는가?
  - 중복값이 있는가? (동명의 자동차는 없다고 가정한다.)
  - 쉼표로 구분한 이름 리스트의 각 요소의 길이가 5자 이하인가?
- 입력받은 자동차 이름을 기준으로 CarCollection 을 만든다.
- 사용자로부터 몇 번의 이동을 할 것인지 입력 받는다.
  - 숫자를 입력 하였는가?
  - 양수를 입력 하였는가?
- 1 ~ 9의 숫자 중 랜덤으로 1개의 숫자를 구한다.
  - 랜덤 값이 4 이상인 경우 : 전진(GO)
  - 랜덤 값이 3 이하인 경우 : 정지(STOP)
- 자동차의 이동 거리를 확인한다.
- 사용자가 입력한 값에 대한 실행 결과를 구한다.
  - 누가 우승했는지 알려준다.
  - 우승자가 둘 이상인가? : 이름 입력한 순서로 출력
