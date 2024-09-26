package programmers.SQL;

public class Join {
//    특정 기간동안 대여 가능한 자동차들의 대여비용 구하기
//    SELECT
//        A.CAR_ID,
//        A.CAR_TYPE,
//        A.DAILY_FEE * (1-REPLACE(C.DISCOUNT_RATE, '%', '') / 100) * 30 AS FEE
//    FROM
//        CAR_RENTAL_COMPANY_CAR A
//    LEFT JOIN
//        CAR_RENTAL_COMPANY_RENTAL_HISTORY B
//        ON A.CAR_ID=B.CAR_ID
//        AND (B.START_DATE <= '2022-11-30' AND B.END_DATE >= '2022-11-01')
//    INNER JOIN
//        CAR_RENTAL_COMPANY_DISCOUNT_PLAN C
//        ON A.CAR_TYPE=C.CAR_TYPE
//        AND C.DURATION_TYPE = '30일 이상'
//    WHERE
//        (A.CAR_TYPE='세단' OR A.CAR_TYPE='SUV')
//        AND B.CAR_ID IS NULL
//        AND (A.DAILY_FEE * (1 - REPLACE(C.DISCOUNT_RATE, '%', '') / 100) * 30) BETWEEN 500000 AND 2000000
//    ORDER BY
//        FEE DESC,
//        A.CAR_TYPE ASC,
//        A.CAR_ID DESC;
}
