package programmers.SQL;

public class GroupBy {
//    카테고리 별 도서 판매량 집계하기
//    SELECT
//        A.CATEGORY, SUM(B.SALES) AS TOTAL_SALES
//    FROM
//        BOOK A
//    JOIN
//        BOOK_SALES B
//        ON A.BOOK_ID=B.BOOK_ID
//    WHERE
//        DATE_FORMAT(B.SALES_DATE, '%Y-%m')='2022-01'
//    GROUP BY
//        A.CATEGORY
//    ORDER BY
//        A.CATEGORY ASC;

//    저자 별 카테고리 별 매출액 집계하기
//    SELECT
//        B.AUTHOR_ID, B.AUTHOR_NAME, A.CATEGORY, SUM(A.PRICE * C.SALES) AS TOTAL_SALES
//    FROM
//        BOOK A
//    JOIN
//        AUTHOR B
//        ON A.AUTHOR_ID=B.AUTHOR_ID
//    JOIN
//        BOOK_SALES C
//        ON A.BOOK_ID=C.BOOK_ID
//    WHERE
//        DATE_FORMAT(C.SALES_DATE, '%Y-%m')='2022-01'
//    GROUP BY
//        B.AUTHOR_NAME, A.CATEGORY
//    ORDER BY
//        B.AUTHOR_ID,
//        A.CATEGORY DESC;

//    대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기
//    SELECT
//        DATE_FORMAT(START_DATE, '%m') AS MONTH,
//    CAR_ID,
//        COUNT(CAR_ID) AS RECORDS
//    FROM
//            CAR_RENTAL_COMPANY_RENTAL_HISTORY
//    WHERE
//        DATE_FORMAT(START_DATE,'%Y-%m') >='2022-08'
//        AND DATE_FORMAT(START_DATE,'%Y-%m') <= '2022-10'
//        AND CAR_ID IN (
//            SELECT
//                CAR_ID
//            FROM
//                CAR_RENTAL_COMPANY_RENTAL_HISTORY
//            WHERE
//                DATE_FORMAT(START_DATE,'%Y-%m') >='2022-08'
//                AND DATE_FORMAT(START_DATE,'%Y-%m') <= '2022-10'
//            GROUP BY
//                CAR_ID
//            HAVING
//                COUNT(CAR_ID) > 4
//            )
//    GROUP BY
//        MONTH, CAR_ID
//    HAVING
//        RECORDS > 0
//    ORDER BY
//        MONTH,
//        CAR_ID DESC;


//    식품분류별 가장 비싼 식품의 정보 조회하기
//    SELECT
//        CATEGORY,
//        PRICE AS MAX_PRICE,
//        PRODUCT_NAME
//    FROM
//        FOOD_PRODUCT
//            WHERE
//        CATEGORY IN ('과자', '국', '김치', '식용유')
//        AND PRICE IN (
//            SELECT
//                MAX(PRICE)
//            FROM
//                    FOOD_PRODUCT
//            GROUP BY
//                CATEGORY
//        )
//    ORDER BY
//        MAX_PRICE DESC;

//    즐겨찾기가 가장 많은 식당 정보 출력하기
//    SELECT
//        FOOD_TYPE,
//        REST_ID,
//        REST_NAME,
//        FAVORITES
//    FROM
//        REST_INFO A
//    WHERE
//        (FOOD_TYPE,FAVORITES) IN (
//            SELECT
//                FOOD_TYPE,
//                MAX(FAVORITES)
//            FROM
//                REST_INFO
//            GROUP BY
//                FOOD_TYPE
//            )
//    ORDER BY
//        FOOD_TYPE DESC;

//    자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기
//    SELECT
//        CAR_ID,
//        CASE
//    WHEN CAR_ID IN (
//        SELECT
//                CAR_ID
//        FROM
//                CAR_RENTAL_COMPANY_RENTAL_HISTORY
//                WHERE
//                '2022-10-16' BETWEEN START_DATE AND END_DATE
//      ) THEN '대여중'
//      ELSE '대여 가능'
//    END AS AVAILABILITY
//    FROM
//        CAR_RENTAL_COMPANY_RENTAL_HISTORY
//    GROUP BY
//        CAR_ID
//    ORDER BY
//        CAR_ID DESC;

//    자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기
//    SELECT
//        CAR_TYPE,
//        COUNT(CAR_TYPE) AS CARS
//    FROM
//        CAR_RENTAL_COMPANY_CAR
//    WHERE
//        OPTIONS LIKE '%통풍시트%' OR
//        OPTIONS LIKE '%열선시트%' OR
//        OPTIONS LIKE '%가죽시트%'
//    GROUP BY
//        CAR_TYPE
//    ORDER BY
//        CAR_TYPE;
//

//    성분으로 구분한 아이스크림 총 주문량
//    SELECT
//        B.INGREDIENT_TYPE,
//        SUM(A.TOTAL_ORDER) AS TOTAL_ORDER
//    FROM
//        FIRST_HALF A
//    JOIN
//        ICECREAM_INFO B
//        ON A.FLAVOR=B.FLAVOR
//    GROUP BY
//        B.INGREDIENT_TYPE
//    ORDER BY
//        TOTAL_ORDER;

//    진료과별 총 예약 횟수 출력하기
//    SELECT
//        MCDP_CD AS 진료과코드,
//        COUNT(*) AS 5월예약건수
//    FROM
//        APPOINTMENT
//    WHERE
//        DATE_FORMAT(APNT_YMD, '%Y-%m')='2022-05'
//    GROUP BY
//        MCDP_CD
//    ORDER BY
//        5월예약건수,
//        진료과코드;

//    조건에 맞는 사용자와 총 거래금액 조회하기
//    SELECT
//        A.WRITER_ID,
//        B.NICKNAME,
//        SUM(A.PRICE) AS TOTAL_SALES
//    FROM
//        USED_GOODS_BOARD A
//    JOIN
//        USED_GOODS_USER B
//        ON A.WRITER_ID=B.USER_ID
//    WHERE
//        A.STATUS='DONE'
//    GROUP BY
//        WRITER_ID
//    HAVING
//        SUM(PRICE) >= 700000
//    ORDER BY
//        TOTAL_SALES;

//    고양이와 개는 몇 마리 있을까
//    SELECT
//        ANIMAL_TYPE,
//        COUNT(*) AS count
//    FROM
//        ANIMAL_INS
//    GROUP BY
//        ANIMAL_TYPE
//    ORDER BY
//        ANIMAL_TYPE;

//    동명 동물 수 찾기
//    SELECT
//        NAME,
//        COUNT(*) AS COUNT
//    FROM
//        ANIMAL_INS
//    WHERE
//        NAME IS NOT NULL
//    GROUP BY
//        NAME
//    HAVING
//        COUNT >= 2
//    ORDER BY
//        NAME;
}

