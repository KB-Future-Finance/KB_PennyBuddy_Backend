<div align="center">
<h1>Penny Buddy - BackEnd Project</h1>
</div>

---

**주요 기능**

Penny Buddy 프로젝트의 BackEnd 부분에서는 두가지 기능이 포함되어 있습니다.

- MySQL 서버에 데이터를 구축합니다.
- InteliJ와 Spring 연동을 완료하고, Vue를 활용하여 MySQL 데이터를 받아 화면에 출력하는 작업을 합니다.

## 사용된 모듈 리스트

이 프로젝트에는 다음과 같은 모듈들이 사용되었습니다:

- Spring Framework
- MyBatis
- MySQL

## 실행 방법

1. 프로젝트를 클론합니다:
    
    ```bash
    
    git clone https://github.com/KB-Future-Finance/KB_PennyBuddy_Backend
    ```
    
2. MySQL 데이터베이스를 생성하고 필요한 테이블을 만듭니다. 아래의 SQL 쿼리를 사용합니다:
    
    ```sql
    create database testKb;
    use testKb;
    
    -- Table and data creation queries here...
    ```
    
3. InteliJ에서 프로젝트를 열고, 필요한 의존성을 설치합니다.
4. Spring 애플리케이션을 실행합니다.

## ERD 다이어그램
![image](https://github.com/user-attachments/assets/9fa74a82-e0e9-491c-a47e-4f923a58b260)

### 설명
## 데이터베이스 테이블 설명

이 프로젝트에서는 4개의 주요 테이블(`avatar`, `member`, `category`, `record`)의 관계와 그 속성을 아래에 설명합니다.

### 1. `avatar` 테이블

- **avatar_id** (INT, PRIMARY KEY): 아바타의 고유 식별자.
- **avatar_url** (VARCHAR(255)): 아바타 이미지의 URL.

### 2. `member` 테이블

- **member_id** (INT, PRIMARY KEY): 회원의 고유 식별자.
- **username** (VARCHAR(30)): 회원의 사용자 이름.
- **userPw** (VARCHAR(255)): 회원의 비밀번호.
- **userPn** (VARCHAR(15)): 회원의 전화번호.
- **userMail** (VARCHAR(255)): 회원의 이메일 주소.
- **avatar_id** (INT, FOREIGN KEY): 아바타 테이블과의 외래키 관계.
- **userDate** (DATETIME): 회원 가입 날짜.
- **update_date** (DATETIME): 회원 정보가 마지막으로 업데이트된 날짜.
- **delYn** (TINYINT(1)): 회원 삭제 여부.

### 3. `category` 테이블

- **category_id** (INT, PRIMARY KEY): 카테고리의 고유 식별자.
- **category_name** (VARCHAR(50)): 카테고리 이름.
- **category_type** (VARCHAR(10)): 카테고리 유형.

### 4. `record` 테이블

- **record_id** (INT, PRIMARY KEY): 기록의 고유 식별자.
- **amount** (DECIMAL(10, 2)): 금액.
- **reg_date** (DATETIME): 기록 생성 날짜.
- **update_date** (DATETIME): 기록이 마지막으로 업데이트된 날짜.
- **member_id** (INT, FOREIGN KEY): 회원 테이블과의 외래키 관계.
- **category_id** (INT, FOREIGN KEY): 카테고리 테이블과의 외래키 관계.
- **category_type** (VARCHAR(10)): 카테고리 유형.
- **record_memo** (TEXT): 기록에 대한 메모.
- **record_details** (TEXT): 기록의 세부 사항.
- **delYn** (TINYINT(1)): 기록 삭제 여부.

### 테이블 간의 관계

- `member` 테이블의 `avatar_id`는 `avatar` 테이블의 `avatar_id`를 참조하여 회원과 아바타 간의 1:1 관계를 형성합니다.
- `record` 테이블의 `member_id`는 `member` 테이블의 `member_id`를 참조하여 회원과 기록 간의 1:N 관계를 형성합니다.
- `record` 테이블의 `category_id`는 `category` 테이블의 `category_id`를 참조하여 카테고리와 기록 간의 1:N 관계를 형성합니다.


## **👥 협업 진행 방식**

1. fork후 dev_ljr 로 branch 생성 → dev_ljr 브런치에 merge
2. 이후 각 Page 별main 브런치에 PR 요청 후 합병

**🥄 커밋 규칙**

`태그 : 제목` 의 형태이며, `:`뒤에만 space가 있음에 유의한다.

- `feat` : 새로운 기능 추가
- `fix` : 버그 수정
- `docs` : 문서 수정
- `style` : 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
- `refactor` : 코드 리펙토링
- `test` : 테스트 코드, 리펙토링 테스트 코드 추가
- `chore` : 빌드 업무 수정, 패키지 매니저 수정

**🍴 PR 규칙**

- PR 제목
    
    예시 : `yymmdd {이름} {기능} 구현` (예시 : 240701 이준렬 css 구현)
    

### 데이터 생성

데이터베이스와 테이블을 생성하고 필요한 데이터를 삽입합니다. 자세한 SQL 쿼리는 아래와 같습니다:
