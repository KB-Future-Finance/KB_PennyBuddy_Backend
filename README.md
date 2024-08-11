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

4. 개인 설정에 맞게, Tomcat, Gradle, JDK 버전을 수정합니다. (아래는 프로젝트의 버전입니다.)
   1) Tomcat : 8.5.81
   2) Gradle : 8.7
   3) JDK : corretto11

5. DB 주소 수정
   1) database.properties 수정
        경로 : src/main/webapp/WEB-INF/config/database.properties
    	jdbc.url = jdbc:mysql://localhost:(사용자포트번호)/(mysql dabase명)
    	jdbc.username = mysql_(사용자 Id, ex : root )
    	jdbc.password = mysql_(사용자 pw)

    2) context-datasource.xml 수정
        경로 : src/main/webapp/WEB-INF/spring/context-datasource.xml

       bean id = "dataSource" 안의 property들 수정. 
       <property name="url" value="jdbc:mysql://(사용자포트번호)/(mysql dabase명)?useUnicode=true&amp;characterEncoding=utf8&amp;serverTimezone=UTC" />
       <property name="username"          value="(사용자 Id)"></property>
       <property name="password"          value="(사용자 pw)"></property>


6. Spring 애플리케이션을 실행합니다.

## ERD 다이어그램
![DB_ERD(5)](https://github.com/user-attachments/assets/5fa3286e-2727-408b-8bc2-0351652561d7)

### 설명
## 데이터베이스 테이블 설명

이 프로젝트에서는 6개의 주요 테이블(`Characters`,`Items`,`Avatar`, `Member`, `Category`, `Record`)의 관계와 그 속성을 아래에 설명합니다.


### 1. `Characters` 테이블

- **characterIdx** (INT, PRIMARY KEY): 캐릭터의 고유 식별자.
- **characterName** (VARCHAR(30)): 캐릭터 명
- **avatar_url** (VARCHAR(255)): 캐릭터 이미지의 URL.


### 2. `Items` 테이블

- **itemIdx** (INT, PRIMARY KEY): 아이템의 고유 식별자.
- **itemName** (VARCHAR(30)): 아이템 명 
- **itemType** (VARCHAR(30)): 아이템의 종류(머리, 몸 착용부위 구분).
- **itemColor** (VARCHAR(30)): 아이템의 색상.
- **itemUrl** (VARCHAR(255)): 아바타 이미지의 URL.


### 3. `Avatar` 테이블

- **avatarIdx** (INT, PRIMARY KEY): 아바타의 고유 식별자.
- **characterIdx** (INT, FOREIGN KEY): 캐릭터 테이블과의 외래키 관계
- **itemIdx** (INT, FOREIGN KEY): 아이템 테이블과의 외래키 관계


### 4. `Member` 테이블

- **userIdx** (INT, PRIMARY KEY): 회원의 고유 식별자.
- **memberId** (VARCHAR(30)): 회원의 사용자 아이디.
- **userPw** (VARCHAR(255)): 회원의 비밀번호.
- **userPn** (VARCHAR(15)): 회원의 전화번호.
- **userMail** (VARCHAR(255)): 회원의 이메일 주소.
- **avatarIdx** (INT, FOREIGN KEY): 아바타 테이블과의 외래키 관계.
- **userDate** (DATETIME): 회원 가입 날짜.
- **updateDate** (DATETIME): 회원 정보가 마지막으로 업데이트된 날짜.
- **delYn** (TINYINT(1)): 회원 삭제 여부.

### 5. `Category` 테이블

- **categoryIdx** (INT, PRIMARY KEY): 카테고리의 고유 식별자.
- **categoryName** (VARCHAR(50)): 카테고리 이름.
- **categoryType** (VARCHAR(10)): 카테고리 유형.

### 6. `Record` 테이블

- **recordIdx** (INT, PRIMARY KEY): 기록의 고유 식별자.
- **amount** (DECIMAL(10, 2)): 금액.
- **regDate** (DATETIME): 기록 생성 날짜.
- **updateDate** (DATETIME): 기록이 마지막으로 업데이트된 날짜.
- **memberId** (INT, FOREIGN KEY): 회원 테이블과의 외래키 관계.
- **categoryIdx** (INT, FOREIGN KEY): 카테고리 테이블과의 외래키 관계.
- **recordMemo** (TEXT): 기록에 대한 메모.
- **recordDetails** (TEXT): 기록의 세부 사항.
- **delYn** (TINYINT(1)): 기록 삭제 여부.

### 테이블 간의 관계

- `Avatar` 테이블의 `characterIdx`는 `Characters` 테이블의 `characterIdx`를 참조하여 아바타와 캐릭터 간의 1:N 관계를 형성합니다.
- `Avatar` 테이블의 `itemIdx`는 `Items` 테이블의 `itemIdx`를 참조하여 아바타와 아이템 간의 1:N 관계를 형성합니다.
- `member` 테이블의 `avatar_id`는 `avatar` 테이블의 `avatar_id`를 참조하여 회원과 아바타 간의 1:1 관계를 형성합니다.
- `record` 테이블의 `member_id`는 `member` 테이블의 `member_id`를 참조하여 회원과 기록 간의 1:N 관계를 형성합니다.
- `record` 테이블의 `category_id`는 `category` 테이블의 `category_id`를 참조하여 카테고리와 기록 간의 1:N 관계를 형성합니다.


## **👥 협업 진행 방식**

1. fork후 dev_ljr 로 branch 생성 → dev_ljr 브런치에 merge
2. 이후 각 Page 별main 브런치에 PR 요청 후 합병

**🥄 커밋 규칙**

`태그 : 제목` 의 형태이며, `:`뒤에만 space가 있음에 유의한다.

- `feat` : 새로운 기능 추가
- `fix` : 버그 수정
- `docs` : 문서 수정
- `style` : 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
- `refactor` : 코드 리펙토링
- `test` : 테스트 코드, 리펙토링 테스트 코드 추가
- `chore` : 빌드 업무 수정, 패키지 매니저 수정

**🍴 PR 규칙**

- PR 제목
    
    예시 : `yymmdd {이름} {기능} 구현` (예시 : 240701 이준렬 css 구현)
    

### 데이터 생성

데이터베이스와 테이블을 생성하고 필요한 데이터를 삽입합니다. 자세한 SQL 쿼리는 아래와 같습니다:

[Uploading 쿼리drop database testKb;
create database testKb;
use testKb;
-- Character 종류
CREATE TABLE Characters (
    characterIdx INT AUTO_INCREMENT PRIMARY KEY,
    characterName VARCHAR(30) NOT NULL,
    characterUrl VARCHAR(255) NOT NULL
);
insert into Characters
values(characterIdx,'Ager','url1'),
(characterIdx,'Bibi','url2'),
(characterIdx,'Colli','url3'),
(characterIdx,'Kiki','url4'),
(characterIdx,'Lamu','url5');

CREATE TABLE Items (
    itemIdx INT AUTO_INCREMENT PRIMARY KEY,
    itemName VARCHAR(30) NOT NULL,
    itemType VARCHAR(30) NOT NULL,	 -- 1 : 상의, 2 : 하의
    itemColor VARCHAR(30),					-- 1 ~ 5 색깔 구분
    itemUrl VARCHAR(255) NOT NULL
);

INSERT INTO Items (itemName, itemType, itemColor, itemUrl)
VALUES
    -- 모자와 선글라스
    ('모자', '1', '1', 'url1'),
    ('모자', '1', '2', 'url2'),
    ('모자', '1', '3', 'url3'),
    ('모자', '1', '4', 'url4'),
    ('모자', '1', '5', 'url5'),
    ('선글라스', '1', '1', 'url6'),
    ('선글라스', '1', '2', 'url7'),
    ('선글라스', '1', '3', 'url8'),
    ('선글라스', '1', '4', 'url9'),
    ('선글라스', '1', '5', 'url10'),
    -- 꽃
    ('꽃', '2', '1', 'url11'),
    ('꽃', '2', '2', 'url12'),
    ('꽃', '2', '3', 'url13'),
    ('꽃', '2', '4', 'url14'),
    ('꽃', '2', '5', 'url15'),
    -- 넥타이
    ('넥타이', '2', '1', 'url16'),
    ('넥타이', '2', '2', 'url17'),
    ('넥타이', '2', '3', 'url18'),
    ('넥타이', '2', '4', 'url19'),
    ('넥타이', '2', '5', 'url20'),
    -- 리본
    ('리본', '2', '1', 'url21'),
    ('리본', '2', '2', 'url22'),
    ('리본', '2', '3', 'url23'),
    ('리본', '2', '4', 'url24'),
    ('리본', '2', '5', 'url25'),
    -- 목걸이
    ('목걸이', '2', '1', 'url26'),
    ('목걸이', '2', '2', 'url27'),
    ('목걸이', '2', '3', 'url28'),
    ('목걸이', '2', '4', 'url29'),
    ('목걸이', '2', '5', 'url30'),
    -- 스카프
    ('스카프', '2', '1', 'url31'),
    ('스카프', '2', '2', 'url32'),
    ('스카프', '2', '3', 'url33'),
    ('스카프', '2', '4', 'url34'),
    ('스카프', '2', '5', 'url35'),
    -- 크로스백
    ('크로스백', '2', '1', 'url36'),
    ('크로스백', '2', '2', 'url37'),
    ('크로스백', '2', '3', 'url38'),
    ('크로스백', '2', '4', 'url39'),
    ('크로스백', '2', '5', 'url40');


-- Avatar 테이블
CREATE TABLE Avatar (
    avatarIdx INT AUTO_INCREMENT PRIMARY KEY,
	characterIdx INT,
     itemIdx INT,
    FOREIGN KEY (characterIdx) REFERENCES Characters(characterIdx),
    FOREIGN KEY (itemIdx) REFERENCES Items(itemIdx)
);

-- Avatar 테이블에 데이터를 삽입하는 INSERT 문
INSERT INTO Avatar (characterIdx, itemIdx)
VALUES
    -- Ager의 아이템 할당
    (1, 1), (1, 2), (1, 3), (1, 4), (1, 5),
    (1, 6), (1, 7), (1, 8), (1, 9), (1, 10),
    (1, 11), (1, 12), (1, 13), (1, 14), (1, 15),
    (1, 16), (1, 17), (1, 18), (1, 19), (1, 20),
    (1, 21), (1, 22), (1, 23), (1, 24), (1, 25),
    (1, 26), (1, 27), (1, 28), (1, 29), (1, 30),
    (1, 31), (1, 32), (1, 33), (1, 34), (1, 35),
    (1, 36), (1, 37), (1, 38), (1, 39), (1, 40),

    -- Bibi의 아이템 할당
    (2, 1), (2, 2), (2, 3), (2, 4), (2, 5),
    (2, 6), (2, 7), (2, 8), (2, 9), (2, 10),
    (2, 11), (2, 12), (2, 13), (2, 14), (2, 15),
    (2, 16), (2, 17), (2, 18), (2, 19), (2, 20),
    (2, 21), (2, 22), (2, 23), (2, 24), (2, 25),
    (2, 26), (2, 27), (2, 28), (2, 29), (2, 30),
    (2, 31), (2, 32), (2, 33), (2, 34), (2, 35),
    (2, 36), (2, 37), (2, 38), (2, 39), (2, 40),

    -- Colli의 아이템 할당
    (3, 1), (3, 2), (3, 3), (3, 4), (3, 5),
    (3, 6), (3, 7), (3, 8), (3, 9), (3, 10),
    (3, 11), (3, 12), (3, 13), (3, 14), (3, 15),
    (3, 16), (3, 17), (3, 18), (3, 19), (3, 20),
    (3, 21), (3, 22), (3, 23), (3, 24), (3, 25),
    (3, 26), (3, 27), (3, 28), (3, 29), (3, 30),
    (3, 31), (3, 32), (3, 33), (3, 34), (3, 35),
    (3, 36), (3, 37), (3, 38), (3, 39), (3, 40),

    -- Kiki의 아이템 할당
    (4, 1), (4, 2), (4, 3), (4, 4), (4, 5),
    (4, 6), (4, 7), (4, 8), (4, 9), (4, 10),
    (4, 11), (4, 12), (4, 13), (4, 14), (4, 15),
    (4, 16), (4, 17), (4, 18), (4, 19), (4, 20),
    (4, 21), (4, 22), (4, 23), (4, 24), (4, 25),
    (4, 26), (4, 27), (4, 28), (4, 29), (4, 30),
    (4, 31), (4, 32), (4, 33), (4, 34), (4, 35),
    (4, 36), (4, 37), (4, 38), (4, 39), (4, 40),

    -- Lamu의 아이템 할당
    (5, 1), (5, 2), (5, 3), (5, 4), (5, 5),
    (5, 6), (5, 7), (5, 8), (5, 9), (5, 10),
    (5, 11), (5, 12), (5, 13), (5, 14), (5, 15),
    (5, 16), (5, 17), (5, 18), (5, 19), (5, 20),
    (5, 21), (5, 22), (5, 23), (5, 24), (5, 25),
    (5, 26), (5, 27), (5, 28), (5, 29), (5, 30),
    (5, 31), (5, 32), (5, 33), (5, 34), (5, 35),
    (5, 36), (5, 37), (5, 38), (5, 39), (5, 40);

 -- Member 테이블
CREATE TABLE Member (
    userIdx INT AUTO_INCREMENT PRIMARY KEY,
    memberId VARCHAR(30) UNIQUE NOT NULL ,
    userPw VARCHAR(255) NOT NULL,
    userPn VARCHAR(15) UNIQUE NOT NULL,
    userMail VARCHAR(255) UNIQUE NOT NULL,
    avatarIdx INT,
    userDate DATETIME DEFAULT NOW(),
    updateDate DATETIME DEFAULT NOW() ON UPDATE NOW(),
    delYn BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (avatarIdx) REFERENCES Avatar(avatarIdx)
);
 -- 멤버  data 생성
insert into member
value(userIdx,'1','1234','010-1234-5678','aaa@naver.com',1,now(),now(),false);
 
 -- Category 테이블
CREATE TABLE Category (
  categoryIdx int NOT NULL AUTO_INCREMENT,
  categoryName varchar(50) NOT NULL,
  categoryType varchar(10) NOT NULL,
  PRIMARY KEY (categoryIdx)
) ;

-- 카테고리  data 생성
INSERT INTO Category (categoryName, categoryType)
VALUES 
('소득', '1'),
('저축 출금', '1'),
('차입', '1'),
('기타','1'),
('세금 · 공과금', '2'),
('식비', '2'),
('주거', '2'),
('피복', '2'),
('보건위생', '2'),
('교육', '2'),
('여가 활동', '2'),
('교통', '2'),
('통신', '2'),
('효도', '2'),
('기타', '2'),
('특비', '2'),
('저축', '2'),
('차입금 상환', '2');

drop table record;
 -- Record 테이블
CREATE TABLE Record (
    recordIdx INT AUTO_INCREMENT PRIMARY KEY,
    amount DECIMAL(10) NOT NULL,
    regDate DATETIME DEFAULT NOW(),
    updateDate DATETIME DEFAULT NOW() ON UPDATE NOW(),
    memberId varchar(30),
    categoryIdx INT,
    recordMemo TEXT,
    recordDetails TEXT,
    delYn BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (memberId) REFERENCES Member(memberId),
    FOREIGN KEY (categoryIdx) REFERENCES Category(categoryIdx)
);




-- 2021년 (월급 5,000,000원)
INSERT INTO record (amount, regDate, updateDate, memberId, categoryIdx, recordMemo, recordDetails, delYn) VALUES
(5000000, '2021-01-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5000000, '2021-02-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5000000, '2021-03-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5000000, '2021-04-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5000000, '2021-05-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5000000, '2021-06-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5000000, '2021-07-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5000000, '2021-08-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5000000, '2021-09-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5000000, '2021-10-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5000000, '2021-11-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5000000, '2021-12-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false);

-- 2022년 (월급 5,500,000원)
INSERT INTO record (amount, regDate, updateDate, memberId, categoryIdx, recordMemo, recordDetails, delYn) VALUES
(5500000, '2022-01-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5500000, '2022-02-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5500000, '2022-03-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5500000, '2022-04-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5500000, '2022-05-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5500000, '2022-06-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5500000, '2022-07-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5500000, '2022-08-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5500000, '2022-09-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5500000, '2022-10-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5500000, '2022-11-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(5500000, '2022-12-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false);

-- 2023년 (월급 6,000,000원)
INSERT INTO record (amount, regDate, updateDate, memberId, categoryIdx, recordMemo, recordDetails, delYn) VALUES
(6000000, '2023-01-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(6000000, '2023-02-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(6000000, '2023-03-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(6000000, '2023-04-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(6000000, '2023-05-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(6000000, '2023-06-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(6000000, '2023-07-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(6000000, '2023-08-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(6000000, '2023-09-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(6000000, '2023-10-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(6000000, '2023-11-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(6000000, '2023-12-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false);

-- 2024년 (월급 6,500,000원)
INSERT INTO record (amount, regDate, updateDate, memberId, categoryIdx, recordMemo, recordDetails, delYn) VALUES
(6500000, '2024-01-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(6500000, '2024-02-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(6500000, '2024-03-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(6500000, '2024-04-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(6500000, '2024-05-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(6500000, '2024-06-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(6500000, '2024-07-15', CURRENT_TIMESTAMP, 1, 1, '급여 입금', '월급이 입금되었습니다.', false),
(10240000, '2024-08-27', CURRENT_TIMESTAMP, 1, 4, '대상', '대상 감사합니다.', false);

-- 나머지 데이터들 (240개)
INSERT INTO record (amount, regDate, updateDate, memberId, categoryIdx, recordMemo, recordDetails, delYn) VALUES
(300000, '2021-01-10', CURRENT_TIMESTAMP, 1, 2, '저축 인출', '긴급한 사유로 인해 저축을 인출했습니다.', false),
(450000, '2021-02-14', CURRENT_TIMESTAMP, 1, 7, '주거비 지출', '월세 및 관리비를 납부했습니다.', false),
(200000, '2021-03-11', CURRENT_TIMESTAMP, 1, 14, '부모님 용돈', '부모님께 용돈을 드렸습니다.', false),
(450000, '2021-04-20', CURRENT_TIMESTAMP, 1, 5, '세금 납부', '세금 및 공과금을 납부했습니다.', false),
(120000, '2021-05-25', CURRENT_TIMESTAMP, 1, 13, '통신비 지출', '휴대폰 요금 및 인터넷 비용을 납부했습니다.', false),
(500000, '2021-06-28', CURRENT_TIMESTAMP, 1, 17, '저축 입금', '은행 계좌에 저축했습니다.', false),
(45000, '2021-07-15', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(200000, '2021-08-19', CURRENT_TIMESTAMP, 1, 8, '의류 구매', '새로운 옷을 구매했습니다.', false),
(120000, '2021-09-20', CURRENT_TIMESTAMP, 1, 12, '교통비 지출', '대중교통 및 유류비를 지출했습니다.', false),
(200000, '2021-10-05', CURRENT_TIMESTAMP, 1, 15, '기타 지출', '다른 목적의 지출이 발생했습니다.', false),
(50000, '2021-11-11', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(300000, '2021-12-09', CURRENT_TIMESTAMP, 1, 3, '돈 차입', '친구로부터 돈을 빌렸습니다.', false),
(150000, '2022-01-11', CURRENT_TIMESTAMP, 1, 9, '병원비 지출', '병원비 및 약값을 지출했습니다.', false),
(200000, '2022-02-17', CURRENT_TIMESTAMP, 1, 14, '부모님 용돈', '부모님께 용돈을 드렸습니다.', false),
(450000, '2022-03-21', CURRENT_TIMESTAMP, 1, 7, '주거비 지출', '월세 및 관리비를 납부했습니다.', false),
(120000, '2022-04-28', CURRENT_TIMESTAMP, 1, 13, '통신비 지출', '휴대폰 요금 및 인터넷 비용을 납부했습니다.', false),
(500000, '2022-05-10', CURRENT_TIMESTAMP, 1, 17, '저축 입금', '은행 계좌에 저축했습니다.', false),
(45000, '2022-06-14', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(200000, '2022-07-08', CURRENT_TIMESTAMP, 1, 8, '의류 구매', '새로운 옷을 구매했습니다.', false),
(120000, '2022-08-19', CURRENT_TIMESTAMP, 1, 12, '교통비 지출', '대중교통 및 유류비를 지출했습니다.', false),
(200000, '2022-09-11', CURRENT_TIMESTAMP, 1, 15, '기타 지출', '다른 목적의 지출이 발생했습니다.', false),
(50000, '2022-10-17', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(300000, '2022-11-20', CURRENT_TIMESTAMP, 1, 3, '돈 차입', '친구로부터 돈을 빌렸습니다.', false),
(120000, '2023-01-25', CURRENT_TIMESTAMP, 1, 12, '교통비 지출', '대중교통 및 유류비를 지출했습니다.', false),
(200000, '2023-02-14', CURRENT_TIMESTAMP, 1, 15, '기타 지출', '다른 목적의 지출이 발생했습니다.', false),
(50000, '2023-03-17', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(450000, '2023-04-09', CURRENT_TIMESTAMP, 1, 5, '세금 납부', '세금 및 공과금을 납부했습니다.', false),
(300000, '2023-05-11', CURRENT_TIMESTAMP, 1, 3, '돈 차입', '친구로부터 돈을 빌렸습니다.', false),
(150000, '2023-06-22', CURRENT_TIMESTAMP, 1, 9, '병원비 지출', '병원비 및 약값을 지출했습니다.', false),
(200000, '2023-07-13', CURRENT_TIMESTAMP, 1, 14, '부모님 용돈', '부모님께 용돈을 드렸습니다.', false),
(450000, '2023-08-05', CURRENT_TIMESTAMP, 1, 7, '주거비 지출', '월세 및 관리비를 납부했습니다.', false),
(120000, '2023-09-19', CURRENT_TIMESTAMP, 1, 13, '통신비 지출', '휴대폰 요금 및 인터넷 비용을 납부했습니다.', false),
(500000, '2023-10-10', CURRENT_TIMESTAMP, 1, 17, '저축 입금', '은행 계좌에 저축했습니다.', false),
(45000, '2023-11-14', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(200000, '2023-12-03', CURRENT_TIMESTAMP, 1, 8, '의류 구매', '새로운 옷을 구매했습니다.', false),
(150000, '2024-01-11', CURRENT_TIMESTAMP, 1, 9, '병원비 지출', '병원비 및 약값을 지출했습니다.', false),
(300000, '2024-02-23', CURRENT_TIMESTAMP, 1, 3, '돈 차입', '친구로부터 돈을 빌렸습니다.', false),
(200000, '2024-03-15', CURRENT_TIMESTAMP, 1, 14, '부모님 용돈', '부모님께 용돈을 드렸습니다.', false),
(450000, '2024-04-09', CURRENT_TIMESTAMP, 1, 5, '세금 납부', '세금 및 공과금을 납부했습니다.', false),
(500000, '2024-05-14', CURRENT_TIMESTAMP, 1, 17, '저축 입금', '은행 계좌에 저축했습니다.', false),
(45000, '2024-06-12', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(120000, '2024-07-21', CURRENT_TIMESTAMP, 1, 12, '교통비 지출', '대중교통 및 유류비를 지출했습니다.', false),
(300000, '2024-08-01', CURRENT_TIMESTAMP, 1, 3, '돈 차입', '친구로부터 돈을 빌렸습니다.', false),
(200000, '2021-01-18', CURRENT_TIMESTAMP, 1, 2, '저축 인출', '긴급한 사유로 인해 저축을 인출했습니다.', false),
(450000, '2021-02-21', CURRENT_TIMESTAMP, 1, 7, '주거비 지출', '월세 및 관리비를 납부했습니다.', false),
(200000, '2021-03-17', CURRENT_TIMESTAMP, 1, 14, '부모님 용돈', '부모님께 용돈을 드렸습니다.', false),
(450000, '2021-04-22', CURRENT_TIMESTAMP, 1, 5, '세금 납부', '세금 및 공과금을 납부했습니다.', false),
(120000, '2021-05-27', CURRENT_TIMESTAMP, 1, 13, '통신비 지출', '휴대폰 요금 및 인터넷 비용을 납부했습니다.', false),
(500000, '2021-06-20', CURRENT_TIMESTAMP, 1, 17, '저축 입금', '은행 계좌에 저축했습니다.', false),
(45000, '2021-07-12', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(200000, '2021-08-23', CURRENT_TIMESTAMP, 1, 8, '의류 구매', '새로운 옷을 구매했습니다.', false),
(120000, '2021-09-26', CURRENT_TIMESTAMP, 1, 12, '교통비 지출', '대중교통 및 유류비를 지출했습니다.', false),
(200000, '2021-10-13', CURRENT_TIMESTAMP, 1, 15, '기타 지출', '다른 목적의 지출이 발생했습니다.', false),
(50000, '2021-11-20', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(300000, '2021-12-05', CURRENT_TIMESTAMP, 1, 3, '돈 차입', '친구로부터 돈을 빌렸습니다.', false),
(150000, '2022-01-16', CURRENT_TIMESTAMP, 1, 9, '병원비 지출', '병원비 및 약값을 지출했습니다.', false),
(200000, '2022-02-19', CURRENT_TIMESTAMP, 1, 14, '부모님 용돈', '부모님께 용돈을 드렸습니다.', false),
(450000, '2022-03-21', CURRENT_TIMESTAMP, 1, 7, '주거비 지출', '월세 및 관리비를 납부했습니다.', false),
(120000, '2022-04-18', CURRENT_TIMESTAMP, 1, 13, '통신비 지출', '휴대폰 요금 및 인터넷 비용을 납부했습니다.', false),
(500000, '2022-05-14', CURRENT_TIMESTAMP, 1, 17, '저축 입금', '은행 계좌에 저축했습니다.', false),
(45000, '2022-06-19', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(200000, '2022-07-13', CURRENT_TIMESTAMP, 1, 8, '의류 구매', '새로운 옷을 구매했습니다.', false),
(120000, '2022-08-15', CURRENT_TIMESTAMP, 1, 12, '교통비 지출', '대중교통 및 유류비를 지출했습니다.', false),
(200000, '2022-09-18', CURRENT_TIMESTAMP, 1, 15, '기타 지출', '다른 목적의 지출이 발생했습니다.', false),
(50000, '2022-10-25', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(300000, '2022-11-11', CURRENT_TIMESTAMP, 1, 3, '돈 차입', '친구로부터 돈을 빌렸습니다.', false),
(150000, '2022-12-09', CURRENT_TIMESTAMP, 1, 9, '병원비 지출', '병원비 및 약값을 지출했습니다.', false),
(200000, '2023-01-06', CURRENT_TIMESTAMP, 1, 14, '부모님 용돈', '부모님께 용돈을 드렸습니다.', false),
(450000, '2023-02-03', CURRENT_TIMESTAMP, 1, 7, '주거비 지출', '월세 및 관리비를 납부했습니다.', false),
(120000, '2023-03-12', CURRENT_TIMESTAMP, 1, 13, '통신비 지출', '휴대폰 요금 및 인터넷 비용을 납부했습니다.', false),
(500000, '2023-04-08', CURRENT_TIMESTAMP, 1, 17, '저축 입금', '은행 계좌에 저축했습니다.', false),
(45000, '2023-05-18', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(200000, '2023-06-11', CURRENT_TIMESTAMP, 1, 8, '의류 구매', '새로운 옷을 구매했습니다.', false),
(120000, '2023-07-14', CURRENT_TIMESTAMP, 1, 12, '교통비 지출', '대중교통 및 유류비를 지출했습니다.', false),
(200000, '2023-08-16', CURRENT_TIMESTAMP, 1, 15, '기타 지출', '다른 목적의 지출이 발생했습니다.', false),
(50000, '2023-09-12', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(300000, '2023-10-19', CURRENT_TIMESTAMP, 1, 3, '돈 차입', '친구로부터 돈을 빌렸습니다.', false),
(150000, '2023-11-17', CURRENT_TIMESTAMP, 1, 9, '병원비 지출', '병원비 및 약값을 지출했습니다.', false),
(200000, '2023-12-05', CURRENT_TIMESTAMP, 1, 14, '부모님 용돈', '부모님께 용돈을 드렸습니다.', false),
(450000, '2024-01-21', CURRENT_TIMESTAMP, 1, 7, '주거비 지출', '월세 및 관리비를 납부했습니다.', false),
(120000, '2024-02-20', CURRENT_TIMESTAMP, 1, 13, '통신비 지출', '휴대폰 요금 및 인터넷 비용을 납부했습니다.', false),
(500000, '2024-03-18', CURRENT_TIMESTAMP, 1, 17, '저축 입금', '은행 계좌에 저축했습니다.', false),
(45000, '2024-04-08', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(200000, '2024-05-07', CURRENT_TIMESTAMP, 1, 8, '의류 구매', '새로운 옷을 구매했습니다.', false),
(120000, '2024-06-19', CURRENT_TIMESTAMP, 1, 12, '교통비 지출', '대중교통 및 유류비를 지출했습니다.', false),
(200000, '2024-07-12', CURRENT_TIMESTAMP, 1, 15, '기타 지출', '다른 목적의 지출이 발생했습니다.', false),
(50000, '2024-08-01', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(300000, '2021-02-11', CURRENT_TIMESTAMP, 1, 2, '저축 인출', '긴급한 사유로 인해 저축을 인출했습니다.', false),
(450000, '2021-03-20', CURRENT_TIMESTAMP, 1, 7, '주거비 지출', '월세 및 관리비를 납부했습니다.', false),
(200000, '2021-04-24', CURRENT_TIMESTAMP, 1, 14, '부모님 용돈', '부모님께 용돈을 드렸습니다.', false),
(450000, '2021-05-29', CURRENT_TIMESTAMP, 1, 5, '세금 납부', '세금 및 공과금을 납부했습니다.', false),
(120000, '2021-06-30', CURRENT_TIMESTAMP, 1, 13, '통신비 지출', '휴대폰 요금 및 인터넷 비용을 납부했습니다.', false),
(500000, '2021-07-22', CURRENT_TIMESTAMP, 1, 17, '저축 입금', '은행 계좌에 저축했습니다.', false),
(45000, '2021-08-27', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(200000, '2021-09-28', CURRENT_TIMESTAMP, 1, 8, '의류 구매', '새로운 옷을 구매했습니다.', false),
(120000, '2021-10-17', CURRENT_TIMESTAMP, 1, 12, '교통비 지출', '대중교통 및 유류비를 지출했습니다.', false),
(200000, '2021-11-22', CURRENT_TIMESTAMP, 1, 15, '기타 지출', '다른 목적의 지출이 발생했습니다.', false),
(50000, '2021-12-14', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(300000, '2022-01-08', CURRENT_TIMESTAMP, 1, 3, '돈 차입', '친구로부터 돈을 빌렸습니다.', false),
(150000, '2022-02-06', CURRENT_TIMESTAMP, 1, 9, '병원비 지출', '병원비 및 약값을 지출했습니다.', false),
(200000, '2022-03-17', CURRENT_TIMESTAMP, 1, 14, '부모님 용돈', '부모님께 용돈을 드렸습니다.', false),
(450000, '2022-04-12', CURRENT_TIMESTAMP, 1, 7, '주거비 지출', '월세 및 관리비를 납부했습니다.', false),
(120000, '2022-05-16', CURRENT_TIMESTAMP, 1, 13, '통신비 지출', '휴대폰 요금 및 인터넷 비용을 납부했습니다.', false),
(500000, '2022-06-25', CURRENT_TIMESTAMP, 1, 17, '저축 입금', '은행 계좌에 저축했습니다.', false),
(45000, '2022-07-23', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(200000, '2022-08-30', CURRENT_TIMESTAMP, 1, 8, '의류 구매', '새로운 옷을 구매했습니다.', false),
(120000, '2022-09-12', CURRENT_TIMESTAMP, 1, 12, '교통비 지출', '대중교통 및 유류비를 지출했습니다.', false),
(200000, '2022-10-28', CURRENT_TIMESTAMP, 1, 15, '기타 지출', '다른 목적의 지출이 발생했습니다.', false),
(50000, '2022-11-13', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(300000, '2022-12-15', CURRENT_TIMESTAMP, 1, 3, '돈 차입', '친구로부터 돈을 빌렸습니다.', false),
(150000, '2023-01-20', CURRENT_TIMESTAMP, 1, 9, '병원비 지출', '병원비 및 약값을 지출했습니다.', false),
(200000, '2023-02-22', CURRENT_TIMESTAMP, 1, 14, '부모님 용돈', '부모님께 용돈을 드렸습니다.', false),
(450000, '2023-03-13', CURRENT_TIMESTAMP, 1, 7, '주거비 지출', '월세 및 관리비를 납부했습니다.', false),
(120000, '2023-04-02', CURRENT_TIMESTAMP, 1, 13, '통신비 지출', '휴대폰 요금 및 인터넷 비용을 납부했습니다.', false),
(500000, '2023-05-15', CURRENT_TIMESTAMP, 1, 17, '저축 입금', '은행 계좌에 저축했습니다.', false),
(45000, '2023-06-20', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(200000, '2023-07-27', CURRENT_TIMESTAMP, 1, 8, '의류 구매', '새로운 옷을 구매했습니다.', false),
(120000, '2023-08-19', CURRENT_TIMESTAMP, 1, 12, '교통비 지출', '대중교통 및 유류비를 지출했습니다.', false),
(200000, '2023-09-15', CURRENT_TIMESTAMP, 1, 15, '기타 지출', '다른 목적의 지출이 발생했습니다.', false),
(50000, '2023-10-06', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(300000, '2023-11-08', CURRENT_TIMESTAMP, 1, 3, '돈 차입', '친구로부터 돈을 빌렸습니다.', false),
(150000, '2023-12-12', CURRENT_TIMESTAMP, 1, 9, '병원비 지출', '병원비 및 약값을 지출했습니다.', false),
(200000, '2024-01-17', CURRENT_TIMESTAMP, 1, 14, '부모님 용돈', '부모님께 용돈을 드렸습니다.', false),
(450000, '2024-02-21', CURRENT_TIMESTAMP, 1, 7, '주거비 지출', '월세 및 관리비를 납부했습니다.', false),
(120000, '2024-03-25', CURRENT_TIMESTAMP, 1, 13, '통신비 지출', '휴대폰 요금 및 인터넷 비용을 납부했습니다.', false),
(500000, '2024-04-18', CURRENT_TIMESTAMP, 1, 17, '저축 입금', '은행 계좌에 저축했습니다.', false),
(45000, '2024-05-22', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false),
(200000, '2024-06-17', CURRENT_TIMESTAMP, 1, 8, '의류 구매', '새로운 옷을 구매했습니다.', false),
(120000, '2024-07-27', CURRENT_TIMESTAMP, 1, 12, '교통비 지출', '대중교통 및 유류비를 지출했습니다.', false),
(50000, '2024-08-03', CURRENT_TIMESTAMP, 1, 6, '식비 지출', '식사를 위해 지출하였습니다.', false);

-- 데이터 확인
select * from record;




문.sql…]()


