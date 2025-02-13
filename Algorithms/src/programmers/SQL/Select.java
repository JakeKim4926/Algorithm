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
    
//    3월에 태어난 여성 회원 목록 출력하기
//    SELECT MEMBER_ID,MEMBER_NAME,GENDER,DATE_FORMAT(DATE_OF_BIRTH, "%Y-%m-%d")
//    FROM MEMBER_PROFILE
//    WHERE MONTH(DATE_OF_BIRTH)=3
//    AND GENDER='W'
//    AND TLNO IS NOT NULL
//    ORDER BY MEMBER_ID ASC;

//    조건에 부합하는 중고거래 댓글 조회하기
//    SELECT A.TITLE, A.BOARD_ID, B.REPLY_ID, B.WRITER_ID, B.CONTENTS, DATE_FORMAT(B.CREATED_DATE, "%Y-%m-%d")
//    FROM USED_GOODS_BOARD A
//    INNER JOIN USED_GOODS_REPLY B
//    ON A.BOARD_ID=B.BOARD_ID
//    WHERE DATE_FORMAT(A.CREATED_DATE, "%Y-%m")='2022-10'
//    ORDER BY B.CREATED_DATE ASC, A.TITLE ASC;

//    서울에 위치한 식당 목록 출력하기
//    SELECT
//    	A.REST_ID AS REST_ID,
//    	A.REST_NAME AS REST_NAME,
//    	A.FOOD_TYPE AS FOOD_TYPE,
//    	A.FAVORITES AS FAVORITES,
//    	A.ADDRESS AS ADDRESS,
//    	ROUND(AVG(B.REVIEW_SCORE), 2) AS SCORE
//    FROM
//    	REST_INFO A
//    JOIN
//    	REST_REVIEW B
//    ON
//    	A.REST_ID = B.REST_ID
//    GROUP BY
//    	B.REST_ID
//    HAVING
//    	ADDRESS LIKE '서울%'
//    ORDER BY
//    	AVG(B.REVIEW_SCORE) DESC,
//    	A.FAVORITES DESC
//    ;

//    인기있는 아이스크림
//    SELECT FLAVOR
//    FROM FIRST_HALF
//    ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID ASC;

//    강원도에 위치한 생산공장 목록 출력하기
//    SELECT FACTORY_ID, FACTORY_NAME, ADDRESS
//    FROM FOOD_FACTORY
//    HAVING ADDRESS LIKE '강원도%'
//    ORDER BY FACTORY_ID ASC;//    GROUP BY A.REST_ID

//    12세 이하인 여자 환자 목록 출력하기
//    SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, "NONE")
//    FROM PATIENT
//    WHERE (AGE <= 12 AND GEND_CD='W')
//    ORDER BY AGE DESC, PT_NAME ASC;

//    조건에 맞는 도서 리스트 출력하기
//    SELECT
//        BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
//    FROM
//            BOOK
//    WHERE
//        DATE_FORMAT(PUBLISHED_DATE, '%Y')='2021'
//        AND CATEGORY='인문'
//    ORDER BY
//        PUBLISHED_DATE ASC;

//    재구매가 일어난 상품과 회원 리스트 구하기
//    SELECT
//            USER_ID, PRODUCT_ID
//    FROM
//            ONLINE_SALE
//    GROUP BY
//    USER_ID, PRODUCT_ID
//            HAVING
//    COUNT(*) > 1
//    ORDER BY
//    USER_ID ASC,
//    PRODUCT_ID DESC;

//    오프라인/온라인 판매 데이터 통합하기
//        SELECT
//            DATE_FORMAT(SALES_DATE, "%Y-%m-%d") AS SALES_DATE,
//            PRODUCT_ID,
//            USER_ID,
//            SALES_AMOUNT
//        FROM
//            ONLINE_SALE
//        WHERE
//            SALES_DATE BETWEEN '2022-03-01' AND '2022-03-31'
//    UNION
//        SELECT
//            DATE_FORMAT(SALES_DATE, "%Y-%m-%d") AS SALES_DATE,
//            PRODUCT_ID,
//            NULL AS USER_ID,
//            SALES_AMOUNT
//        FROM
//            OFFLINE_SALE
//        WHERE
//            SALES_DATE BETWEEN '2022-03-01' AND '2022-03-31'
//    ORDER BY
//        SALES_DATE,
//        PRODUCT_ID,
//        USER_ID;

//    조건에 맞는 회원수 구하기
//    SELECT
//        COUNT(USER_ID) AS USERS
//    FROM
//            USER_INFO
//    WHERE
//        YEAR(JOINED)='2021'
//        AND AGE BETWEEN 20 AND 29;

//    업그레이드 된 아이템 구하기
//    SELECT
//        ITEM_ID,
//        ITEM_NAME,
//        RARITY
//    FROM
//        ITEM_INFO
//    WHERE
//        ITEM_ID IN (
//                SELECT
//                    B.ITEM_ID
//                FROM
//                    ITEM_INFO A
//                JOIN
//                    ITEM_TREE B
//                    ON A.ITEM_ID=B.PARENT_ITEM_ID
//                WHERE
//                    A.RARITY='RARE'
//        )
//    ORDER BY
//        ITEM_ID DESC;


//    조건에 맞는 개발자 찾기
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
//                CODE
//            FROM
//                SKILLCODES
//            WHERE
//                NAME='Python'
//        )
//        OR
//        SKILL_CODE & (
//            SELECT
//                CODE
//            FROM
//                SKILLCODES
//            WHERE
//                NAME='C#'
//        )
//    ORDER BY
//    ID;

//    Python 개발자 찾기
//    SELECT
//        ID,
//        EMAIL,
//        FIRST_NAME,
//        LAST_NAME
//    FROM
//        DEVELOPER_INFOS
//    WHERE
//        SKILL_1='Python'
//        OR SKILL_2='Python'
//        OR SKILL_3='Python'
//    ORDER BY
//        ID;


//    잔챙이 잡은 수 구하기
//    SELECT
//        COUNT(*) AS FISH_COUNT
//    FROM
//        FISH_INFO
//    WHERE
//        LENGTH IS NULL;

//    가장 큰 물고기 10마리 구하기
//    SELECT
//        ID,
//        LENGTH
//    FROM
//        FISH_INFO
//    ORDER BY
//        LENGTH DESC,
//        ID
//    LIMIT 10;

//    특정 물고기를 잡은 총 수 구하기
//    SELECT
//        COUNT(*) AS FISH_COUNT
//    FROM
//        FISH_INFO A
//    JOIN
//        FISH_NAME_INFO B
//        ON A.FISH_TYPE=B.FISH_TYPE
//    WHERE
//        B.FISH_NAME='BASS'
//        OR B.FISH_NAME='SNAPPER';

//    대장균들의 자식의 수 구하기
//    SELECT
//        A.ID AS ID,
//        IFNULL(B.C, 0) AS CHILD_COUNT
//    FROM
//        ECOLI_DATA A
//    LEFT JOIN
//        (
//            SELECT
//                PARENT_ID,
//                COUNT(*) AS C
//            FROM
//                ECOLI_DATA
//            GROUP BY
//                PARENT_ID
//        ) B
//        ON A.ID=B.PARENT_ID
//    ORDER BY
//        ID;

//    특정 형질을 가지는 대장균 찾기
//    SELECT
//        COUNT(*) AS COUNT
//    FROM
//        ECOLI_DATA
//    WHERE
//        (5 & GENOTYPE) > 0
//        AND (2 & GENOTYPE) < 1 ;

//    대장균의 크기에 따라 분류하기 1
//    SELECT
//        ID,
//        CASE
//            WHEN SIZE_OF_COLONY <= 100 THEN 'LOW'
//            WHEN SIZE_OF_COLONY <= 1000 THEN 'MEDIUM'
//            ELSE 'HIGH'
//        END AS SIZE
//    FROM
//        ECOLI_DATA
//    ORDER BY
//        ID;
}


