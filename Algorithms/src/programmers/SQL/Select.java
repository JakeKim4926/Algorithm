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

}

