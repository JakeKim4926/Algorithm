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

}