package programmers.SQL;

public class Select {

//    평균 일일 대여 요금 구하기
//    SELECT Round(AVG(DAILY_FEE))
//    AS CAR_RENTAL_COMPANY_CAR
//    FROM CAR_RENTAL_COMPANY_CAR
//    WHERE CAR_TYPE='SUV';

//    Round 함수
//    자릿수가 N : 소숫점 아래 N째 자리까지 반올림하여 표시
//    자릿수가 0 : 반올림하여 1의 자리까지 표시
//    자릿수가 -N : 반올림하여 10의 N승 자리까지 표시

//    흉부외과 또는 일반외과 의사 목록 출력하기
//    SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, "%Y-%m-%d")
//    FROM DOCTOR
//    WHERE MCDP_CD='CS'
//    OR MCDP_CD='GS'
//    ORDER BY HIRE_YMD DESC, DR_NAME;

//    과일로 만든 아이스크림 고르기
//    SELECT A.FLAVOR
//    FROM FIRST_HALF A
//    LEFT JOIN ICECREAM_INFO B
//    ON A.FLAVOR=B.FLAVOR
//    WHERE A.TOTAL_ORDER > 3000
//    AND B.INGREDIENT_TYPE='fruit_based'
//    ORDER BY A.TOTAL_ORDER DESC;
    
//    3월에 태어난 여성 회원 목록 출력하기
//    SELECT MEMBER_ID,MEMBER_NAME,GENDER,DATE_FORMAT(DATE_OF_BIRTH, "%Y-%m-%d")
//    FROM MEMBER_PROFILE
//    WHERE MONTH(DATE_OF_BIRTH)=3
//    AND GENDER='W'
//    AND TLNO IS NOT NULL
//    ORDER BY MEMBER_ID ASC;

//    조건에 부합하는 중고거래 댓글 조회하기
//    SELECT A.TITLE, A.BOARD_ID, B.REPLY_ID, B.WRITER_ID, B.CONTENTS, DATE_FORMAT(B.CREATED_DATE, "%Y-%m-%d")
//    FROM USED_GOODS_BOARD A
//    INNER JOIN USED_GOODS_REPLY B
//    ON A.BOARD_ID=B.BOARD_ID
//    WHERE DATE_FORMAT(A.CREATED_DATE, "%Y-%m")='2022-10'
//    ORDER BY B.CREATED_DATE ASC, A.TITLE ASC;

//    서울에 위치한 식당 목록 출력하기
//    SELECT A.REST_ID, A.REST_NAME, A.FOOD_TYPE, A.FAVORITES, A.ADDRESS, ROUND(AVG(B.REVIEW_SCORE), 2) AS SCORE
//    FROM REST_INFO A
//    JOIN REST_REVIEW B ON A.REST_ID=B.REST_ID
//    GROUP BY A.REST_ID
//    HAVING A.ADDRESS LIKE '서울%'
//    ORDER BY SCORE DESC, A.FAVORITES DESC;

}


