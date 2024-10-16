package programmers.SQL;

public class StringDate {

//    자동차 평균 대여 기간 구하기
//    SELECT
//        CAR_ID,
//        ROUND(AVG(DATEDIFF(END_DATE, START_DATE) + 1), 1) AS AVERAGE_DURATION
//    FROM
//        CAR_RENTAL_COMPANY_RENTAL_HISTORY
//    GROUP BY
//        CAR_ID
//    HAVING
//        AVERAGE_DURATION > 6.9
//    ORDER BY
//        AVERAGE_DURATION DESC,
//        CAR_ID DESC;

//    조회수가 가장 많은 중고거래 게시판의 첨부파일 조회하기
//    SELECT
//        CONCAT('/home/grep/src/', BOARD_ID, '/', FILE_ID, FILE_NAME, FILE_EXT)
//        AS FILE_PATH
//    FROM
//        USED_GOODS_FILE
//    WHERE
//        BOARD_ID=(
//            SELECT
//                BOARD_ID
//            FROM
//                USED_GOODS_BOARD
//            ORDER BY
//                VIEWS DESC
//            LIMIT 1
//            )
//    ORDER BY
//        FILE_ID DESC;


//    자동차 대여 기록 별 대여 금액 구하기
//    SELECT
//        B.HISTORY_ID AS HISTORY_ID,
//    CASE
//        WHEN (DATEDIFF(B.END_DATE, B.START_DATE) + 1 >= 90)
//        THEN (A.DAILY_FEE - (
//                A.DAILY_FEE *
//                (
//                SELECT REPLACE(DISCOUNT_RATE, '%', '') FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
//                 WHERE CAR_TYPE='트럭' AND DURATION_TYPE LIKE '90%'
//                )
//                / 100)) * (DATEDIFF(B.END_DATE, B.START_DATE) + 1)
//        WHEN (DATEDIFF(B.END_DATE, B.START_DATE) + 1 >= 30)
//        THEN (A.DAILY_FEE - (
//                A.DAILY_FEE *
//                (
//                SELECT REPLACE(DISCOUNT_RATE, '%', '') FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
//                WHERE CAR_TYPE='트럭' AND DURATION_TYPE LIKE '30%'
//                )
//                / 100)) * (DATEDIFF(B.END_DATE, B.START_DATE) + 1)
//        WHEN (DATEDIFF(B.END_DATE, B.START_DATE) + 1 >= 7)
//        THEN (A.DAILY_FEE - (
//                A.DAILY_FEE *
//                (
//                SELECT REPLACE(DISCOUNT_RATE, '%', '') FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
//                WHERE CAR_TYPE='트럭' AND DURATION_TYPE LIKE '7%'
//                )
//                / 100)) * (DATEDIFF(B.END_DATE, B.START_DATE) + 1)
//        ELSE A.DAILY_FEE * (DATEDIFF(B.END_DATE, B.START_DATE) + 1)
//    END AS FEE
//    FROM
//        CAR_RENTAL_COMPANY_CAR A
//    JOIN
//        CAR_RENTAL_COMPANY_RENTAL_HISTORY B
//        ON A.CAR_ID=B.CAR_ID
//    WHERE
//        A.CAR_TYPE='트럭'
//    ORDER BY
//        FEE DESC,
//        HISTORY_ID DESC;

//    조건에 부합하는 중고거래 상태 조회하기
//    SELECT
//        BOARD_ID,
//        WRITER_ID,
//        TITLE,
//        PRICE,
//        CASE
//            WHEN STATUS='SALE' THEN '판매중'
//            WHEN STATUS='RESERVED' THEN '예약중'
//            WHEN STATUS='DONE' THEN '거래완료'
//        END AS STATUS
//    FROM
//        USED_GOODS_BOARD
//    WHERE
//        DATE_FORMAT(CREATED_DATE, '%Y-%m-%d')='2022-10-05'
//    ORDER BY
//        BOARD_ID DESC;

//    특정 옵션이 포함된 자동차 리스트 구하기
//    SELECT
//        *
//    FROM
//        CAR_RENTAL_COMPANY_CAR
//    WHERE
//        OPTIONS LIKE '%네비게이션%'
//    ORDER BY
//        CAR_ID DESC;

//    자동차 대여 기록에서 장기/단기 대여 구분하기
//    SELECT
//        HISTORY_ID,
//        CAR_ID,
//        DATE_FORMAT(START_DATE, '%Y-%m-%d'),
//        DATE_FORMAT(END_DATE, '%Y-%m-%d'),
//        CASE
//            WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 30 THEN '장기 대여'
//            ELSE '단기 대여'
//        END AS RENT_TYPE
//    FROM
//        CAR_RENTAL_COMPANY_RENTAL_HISTORY
//    WHERE
//        DATE_FORMAT(START_DATE, '%Y-%m')='2022-09'
//    ORDER BY
//        HISTORY_ID DESC;


//    조건별로 분류하여 주문상태 출력하기
//    SELECT
//        ORDER_ID,
//        PRODUCT_ID,
//        DATE_FORMAT(OUT_DATE, '%Y-%m-%d'),
//        CASE
//            WHEN OUT_DATE < '2022-05-02' THEN '출고완료'
//            WHEN OUT_DATE IS NULL THEN '출고미정'
//            ELSE '출고대기'
//        END AS 출고여부
//    FROM
//        FOOD_ORDER
//    ORDER BY
//        ORDER_ID;

}
