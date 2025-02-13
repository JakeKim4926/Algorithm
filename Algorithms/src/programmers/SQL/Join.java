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

//    있었는데요 없었습니다.
//    SELECT
//        A.ANIMAL_ID, A.NAME
//    FROM
//        ANIMAL_INS A
//    JOIN
//        ANIMAL_OUTS B
//        ON A.ANIMAL_ID=B.ANIMAL_ID
//    WHERE
//        A.DATETIME >= B.DATETIME
//    ORDER BY
//        A.DATETIME ASC;

//    오랜 기간 보호한 동물(1)
//    SELECT
//        A.NAME, A.DATETIME
//    FROM
//        ANIMAL_INS A
//    LEFT JOIN
//        ANIMAL_OUTS B
//        ON A.ANIMAL_ID=B.ANIMAL_ID
//    WHERE
//        B.ANIMAL_ID IS NULL
//    ORDER BY
//        A.DATETIME
//    LIMIT 3;

//    보호소에서 중성화한 동물
//    SELECT
//        A.ANIMAL_ID,
//        A.ANIMAL_TYPE,
//        A.NAME
//    FROM
//        ANIMAL_INS A
//    JOIN
//        ANIMAL_OUTS B
//        ON A.ANIMAL_ID=B.ANIMAL_ID
//    WHERE
//        A.SEX_UPON_INTAKE LIKE 'Intact%'
//        AND (B.SEX_UPON_OUTCOME LIKE 'Spayed%' OR B.SEX_UPON_OUTCOME LIKE 'Neutered%')
//    ORDER BY
//        A.ANIMAL_ID;

//    상품 별 오프라인 매출 구하기
//    SELECT
//        A.PRODUCT_CODE AS PRODUCT_CODE,
//        SUM(B.SALES_AMOUNT) * A.PRICE AS SALES
//    FROM
//        PRODUCT A
//    JOIN
//        OFFLINE_SALE B
//        ON A.PRODUCT_ID=B.PRODUCT_ID
//    GROUP BY
//        A.PRODUCT_CODE, B.PRODUCT_ID
//    ORDER BY
//        SALES DESC,
//        PRODUCT_CODE;

//    상품을 구매한 회원 비율 구하기
//    SELECT
//        YEAR(B.SALES_DATE) AS YEAR,
//        MONTH(B.SALES_DATE) AS MONTH,
//        COUNT(DISTINCT B.USER_ID) AS PURCHASED_USERS,
//        ROUND(COUNT(DISTINCT B.USER_ID) /
//                (
//                    SELECT
//                    COUNT(*)
//                    FROM
//                            USER_INFO
//                    WHERE
//                    YEAR(JOINED)='2021'
//                ), 1) AS PUCHASED_RATIO
//    FROM
//        USER_INFO A
//    JOIN
//        ONLINE_SALE B
//        ON A.USER_ID=B.USER_ID
//    WHERE
//        YEAR(A.JOINED)='2021'
//    GROUP BY
//        YEAR(B.SALES_DATE),
//        MONTH(B.SALES_DATE)
//    ORDER BY
//        YEAR,
//        MONTH;

//    FrontEnd 개발자 찾기
//    SELECT
//        ID,
//        EMAIL,
//        FIRST_NAME,
//        LAST_NAME
//    FROM
//        DEVELOPERS
//    WHERE
//        SKILL_CODE & (
//            SELECT
//            SUM(CODE)
//            FROM
//                    SKILLCODES
//            GROUP BY
//            CATEGORY
//                    HAVING
//            CATEGORY='Front End'
//        )
//    ORDER BY
//        ID;
}
