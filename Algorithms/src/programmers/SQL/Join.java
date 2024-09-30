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

//    5월 식품들의 총매출 조회하기
//    SELECT
//        A.PRODUCT_ID, A.PRODUCT_NAME, SUM(A.PRICE * B.AMOUNT) AS TOTAL_SALES
//    FROM
//        FOOD_PRODUCT A
//    RIGHT JOIN
//        FOOD_ORDER B
//        ON A.PRODUCT_ID=B.PRODUCT_ID
//    WHERE
//        DATE_FORMAT(B.PRODUCE_DATE, "%Y-%m")='2022-05'
//    GROUP BY
//        A.PRODUCT_NAME
//    ORDER BY
//        TOTAL_SALES DESC,
//        A.PRODUCT_ID ASC;

//    주문량이 많은 아이스크림들 조회하기
//    SELECT
//        A.FLAVOR
//    FROM
//        FIRST_HALF A
//    JOIN
//        JULY B
//        ON A.FLAVOR=B.FLAVOR
//    GROUP BY
//        A.FLAVOR
//    ORDER BY
//        SUM(A.TOTAL_ORDER + B.TOTAL_ORDER) DESC
//    LIMIT 3;

//    조건에 맞는 도서와 저자 리스트 출력하기
//    SELECT
//        A.BOOK_ID, B    .AUTHOR_NAME, DATE_FORMAT(A.PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
//    FROM
//        BOOK A
//    JOIN
//        AUTHOR B
//        ON A.AUTHOR_ID=B.AUTHOR_ID
//    WHERE
//        A.CATEGORY='경제'
//    ORDER BY
//        A.PUBLISHED_DATE ASC;

//    그룹별 조건에 맞는 식당 목록 출력하기
//    SELECT
//        A.MEMBER_NAME, B.REVIEW_TEXT, DATE_FORMAT(B.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
//    FROM
//        MEMBER_PROFILE A
//    JOIN
//        REST_REVIEW B
//        ON A.MEMBER_ID=B.MEMBER_ID
//    WHERE
//        B.MEMBER_ID = (
//            SELECT MEMBER_ID
//            FROM REST_REVIEW
//            GROUP BY MEMBER_ID
//            ORDER BY COUNT(*) DESC
//            LIMIT 1
//        )
//    ORDER BY
//        B.REVIEW_DATE ASC,
//        B.REVIEW_TEXT ASC;

//    없어진 기록 찾기
//    SELECT
//        B.ANIMAL_ID, B.NAME
//    FROM
//        ANIMAL_INS A
//    RIGHT JOIN
//        ANIMAL_OUTS B
//        ON A.ANIMAL_ID = B.ANIMAL_ID
//    WHERE
//        A.ANIMAL_ID IS NULL
//    ORDER BY
//        B.ANIMAL_ID;
}
