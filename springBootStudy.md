# 도메인 모델링
- 해결할 문제들에 쓰이는 개념들을 정리하고 그에 필요한 것들을 알아보는 것

# 멀티 티어 아키텍쳐
- 여러 계층으로 아키텍쳐를 생성하는 것 (3 티어 아키텍쳐가 가장 흔하게 쓰임)

# 3-tier Architecture
- Presentation / Business / Data Source 로 구성됨
- Front-end  / Back-end  / Database 로 볼 수 있다.

# Business 부분을 다시 보면..
- Layered Architecture 가 쓰임. 
- 이건 크게 4가지의 레이어로 시스템을 만드는 것을 뜻함.
- UI Layer
- Application Layer
- Domain Layer
- Infrastructure Layer
- 각 레이어는 바로 아래 혹은 그보다 아래에 있는 레이어에 의존하고,
  아래에 있는 레이어는 위에 있는 레이어를 쓸 수 없다.
- 이렇게 나누는 이유는 '프로그램의 복잡도' 를 낮추기 위함.