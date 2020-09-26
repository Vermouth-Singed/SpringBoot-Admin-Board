# Spring Boot Admin Board
## 사용언어
### - Spring Boot + MySQL + VueJS (Vuetify, Vuex, Vue-Router)

##데이터베이스 구조 및 데이터
### - resources/mysql_query/query.sql
### - 접속정보 변경은 application.yml 파일 수정

## 빌드방법
### 1. Project update from git repository
### 2. Run SpringBootAdminBoardApplication (a.k.a Shift+F10)
### 3. Voila!
![image](https://user-images.githubusercontent.com/24692694/91194559-3b274880-e733-11ea-865e-043d85fcac12.png)

## 화면설명
### 1. 아이디 및 비밀번호는 동일 (예시: `admin/admin`)
### 2. 로그인 완료 후 사용자 리스트 화면으로 리다이렉트
### 3. 우측상단 아이콘 클릭하면 로그아웃
### 4. 로그아웃 완료 후 로그인 화면으로 리다이렉트
### 5. 페이지 전환할 때마다 로그인 체크
### 6. 로그인 유효기간은 10분(default:10m)으로 설정