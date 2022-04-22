### DAY 14(4/22 Fri)

---



##### 데이터 입력

---

\- PK - Primary key, 중복이나 빈값(NULL)이 들어올 수 없음

\- NN - Not Null(빈값) 못들어옴

\- UQ - Unique, 중복 값을 넣을 수 없음

\- B -데이터를 이진 문자열로 저장함(010101 같은)

\- UN - Unsigned data type (- 범위 삭제)

  INT, DOUBLE 등의 경우 UN을 사용해 주면 -값 +값 이던 범위가 -값은 없어지고 +값만 2배로 늘어남

\- ZF - Zero Filled 컬럼 크기보다 작은 값을 넣었을 경우 0으로 채운 뒤 삽입시킴

\- AI - Insert 시마다 값 1씩 늘어남

\- G - 다른 열을 기반으로 한 수식으로 생성된 값

\- Default/Expression - 기본값, 기본값에 수식 설정 



##### MYSQL

---

1. DQL(Data Query Language)

   

