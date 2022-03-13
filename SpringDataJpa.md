## 부가 설명
1. 스프링 데이터 JPA가 SpringDataJpaMemberRepository(interface)를 스프링 빈으로 자동 등록 해준다.
proxy를 사용하여 인터페이스를 자동으로 구현해 객체로 생성 한다는 뜻.
   

2. 상속받는 JpaRepository에는 기본적인 CRUD를 포함해 페이징처리까지 해주는 함수 또한 구현되어있다.


3. 메서드 이름만으로 조회 기능 제공


4. 복잡한 동적 쿼리는 Querydsl이라는 라이브러리를 사용한다. 


5. 그게 안된다면 네이티브 쿼리도 사용가능하다.

