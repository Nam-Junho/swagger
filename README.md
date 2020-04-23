# Swagger Setting

## 소개
- 개발자가 REST 웹 서비스를 설계, 빌드, 문서화, 소비하는 일을 도와주는 대형 도구 생태계의 지원을 받는 오픈 소스 소프트웨어 프레임워크이다. 대부분의 사용자들은 스웨거 UI 도구를 통해 스웨거를 식별하며 스웨거 툴셋에는 자동화된 문서화, 코드 생성, 테스트 케이스 생성 지원이 포함된다. (위키 참조)
- 사내 시스템의 경우 아래 Settin으로 작업하는 것이 편하나 대외 시스템의 경우 Swagger hub를 이용하는 것이 맞다고 판단된다.
- 기타 다른 프레임워크 : Spring rest docs

### 장점
- 테스트가 편리하다.
- API Spec에 대한 Docs 작업이 줄어든다.

### 단점
- Swagger의 경우 기본 설정은 간단하나, 나머지 작업을 하기에는 한글화된 레퍼런스가 없다.
- 운영환경도 테스트 할 수 있을 것 같아 무섭다.

### Swagger
- [개발 환경 참고](https://jojoldu.tistory.com/31)
- [Swagger API Doc](https://github.com/swagger-api)
- [Swagger ApI Annotations](https://github.com/swagger-api/swagger-core/wiki/Annotations)

### 서버 환경
- JDK 11
- Spring Boot 2.2.6
- Swagger 2.9.2
- Mysql 5.7.29
- Spring Data JPA

### 접속 경로
- http://localhost:8080/swagger-ui.html

### DB 설치
- Docker를 통해 Mysql 5.7.29 버전 설치.
- script 아래 database, user, table 순으로 스크립트 실행.