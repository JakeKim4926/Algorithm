package programmers.SQL;

public class SumMaxMin {

//    가장 비싼 상품 구하기
//    SELECT
//        MAX(PRICE) AS MAX_PRICE
//    FROM
//        PRODUCT;

//    가격이 제일 비싼 식품의 정보 출력하기
//    SELECT
//        *
//    FROM
//        FOOD_PRODUCT
//    ORDER BY
//        PRICE DESC
//    LIMIT 1;

//    최댓값 구하기
//    SELECT
//        MAX(DATETIME)
//    FROM
//        ANIMAL_INS;

//    최솟값 구하기
//    SELECT
//        MIN(DATETIME)
//    FROM
//        ANIMAL_INS;

//    동물 수 구하기
//    SELECT
//        COUNT(*)
//    FROM
//        ANIMAL_INS;

//    중복 제거하기
//    SELECT
//        COUNT(DISTINCT NAME)
//    FROM
//        ANIMAL_INS
//    WHERE
//        NAME IS NOT NULL;

//    조건에 맞는 아이템들의 가격의 총합 구하기
//    SELECT
//        SUM(PRICE) AS TOTAL_PRICE
//    FROM
//        ITEM_INFO
//    WHERE
//        RARITY='LEGEND';

//    물고기 종류 별 대어 찾기
//    SELECT
//        A.ID,
//        B.FISH_NAME AS FISH_NAME,
//        A.LENGTH AS LENGTH
//    FROM
//        FISH_INFO A
//    JOIN
//        FISH_NAME_INFO B
//        ON A.FISH_TYPE=B.FISH_TYPE
//    WHERE
//        (A.FISH_TYPE, A.LENGTH) IN (
//            SELECT
//                FISH_TYPE,
//                MAX(LENGTH)
//            FROM
//                FISH_INFO
//            WHERE
//                LENGTH IS NOT NULL
//            GROUP BY
//                FISH_TYPE
//            )
//    ORDER BY
//        A.ID;

//    잡은 물고기 중 가장 큰 물고기의 길이 구하기
//    SELECT
//        CONCAT(MAX(LENGTH),'cm') AS MAX_LENGTH
//    FROM
//        FISH_INFO;

    
}
