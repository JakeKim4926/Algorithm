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
}
