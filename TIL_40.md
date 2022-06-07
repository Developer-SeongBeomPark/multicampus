### DAY 40(6/7 Tue)

---

[Spring Framework](#spring-framework)

- [Spring Framework의 특징](#spring-framework의-특징)



[Spring Boot](#spring-boot)



#### Spring Framework

##### Spring Framework의 특징

1. 경량(Lightweight)
   - 일반적인 J2EE 프레임워크 등 다른 프레임워크와 달리 객체간의 관계를 구성할 때 별도의 API를 등을 사용하지 않고 기존에 존재하는 라이브러리 등을 사용하기에 객체가 가볍다.
2. 제어 역행(IOC : Inversion Of Control)
   - 기존에 자바 애플리케이션을 개발할 때 자바 객체를 생성하고 서로간 의존
       관계를 연결작업에 대한 제어권은 보통 개발되는 어플리케이션에 있었다.
   - Servlet, EJB 등을 사용하는 경우 Servlet Container, EJB Container에게 제어권이 넘어가서 객체의 생명주기(Life Cycle)를 Container들이 전담하게 된다.
   - IoC의 제어 역행이란 객체의 생성에서부터 생명주기의 관리까지 모든 객체에 대한 제어권이 바뀌었다는 것을 의미한다.
3.  의존성 관리(DI : Dependency Injection)
   - 의존성(Dependency)이라는 것은 하나의 객체가 다른 객체 없이 제대로 된 역할을 할 수 없다는 의미이다. 
   - 각각의 계층이나 서비스들 간에 의존성이 존재할 경우 프레임워크가 자동으로 관리한다.
4. 관점 지향 프로그래밍(AOP : Aspect-Oriented Programming)
   - 트랜잭션이나 로깅, 보안과 같이 여러 모듈에서 공통적으로 사용하는 기능의 경우 해당 기능을 분리하여 관리할 수 있다.
   - 공통모듈의 반복적인 코드를 줄이고, 핵심 비즈니스 로직에만 집중할 수 있는 방법을 제공한다.
5. 컨테이너
   - 컨테이너는 특정 객체의 생성과 관리를 담당하며 객체 운용에 필요한 기능 제공
   - 컨테이너는 일반적으로 서버안에 포함되어 배포 및 구동된다.
   - 대표적인 컨테이너로는 Servlet 객체를 생성하고 관리하는 Servlet 컨테이너와 EJB객체를 생성하고 관리하는 EJB 컨테이너가 있다.
   - Servlet 컨테이너는 톰캣서버에도 포함되어 있다.
   - 애플리케이션 운용에 필요한 객체를 생성하고 객체 간의 의존관계를 관리한다는 점에서 스프링도 일종의 컨테이너라 할 수 있다.









#### Spring boot

###### 프로젝트의 주요 파일 및 구조

■ src/main/java 
 - 자바소스 폴더

 ■ SampleApplication 
 - 애플리케이션을 시작할 수 있는 main메소드가 존재하는 스프링 구성
    메인 클래스

 ■ src/main/resources/static
 - HTML, 스타일 시트, 자바스크립트, 이미지 등의 정적 리소스 폴더

 ■ application.properties 
 - 애플리케이션 및 스프링의 설정 등에서 사용할 여러 가지 프로퍼티(property)정의

 ■ Project and External Dependencies :
 - Gradle에 명시된 프로젝트의 필수 라이브러리 모음  


 ■ src 
 - JSP등 리소스 디렉토리

 ■ build.gradle  
 - Gradle 빌드 명세, 프로젝트에 필요한 라이브러리 관리, 빌드 배포 설정
 - 스프링 부트의 버전을 명시

 - 자바 버전 명시

 - 의존성 옵션

  implementation: 의존 라이브러리 수정시 본 모듈까지만 재빌드(재컴파일)

  api: 의존 라이브러리 수정시 본 모듈을 의존하는 모듈들도 재빌드(재컴파일)

  compileOnly: compile 시에만 빌드하고 빌드 결과물에는 포함하지 않음

  runtime(실행)시 필요없는 라이브러리인 경우 

  runtimeOnly: runtime 시에만 필요한 라이브러리인 경우

  providedRuntime: 실행시 제공되는 library

  testImplementation: 테스트시 관련 library 제공



SampleApplication 클래스

 - 스프링 부트 애플리케이션의 구성과 실행을 담당하는 중요한 클래스이다.
 - 스프링 부트의 장점 중 하나는 자동구성으로 기존의 복잡하고 다양한 스프링 설정을 제거하고 최소한의 설정으로 바로 실행할 수 있는 애플리케이션을 만들어 준다는 점이다.