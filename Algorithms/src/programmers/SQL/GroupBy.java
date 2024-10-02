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
}