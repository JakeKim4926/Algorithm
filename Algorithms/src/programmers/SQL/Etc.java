package programmers.SQL;

public class Etc {

//    멸종위기의 대장균 찾기
//    WITH RECURSIVE CTE AS (
//        SELECT
//            ID,
//            PARENT_ID,
//            1 AS GENERATION
//        FROM
//            ECOLI_DATA
//        WHERE
//            PARENT_ID IS NULL
//
//        UNION ALL
//
//        SELECT
//            E.ID,
//            E.PARENT_ID,
//            GENERATION+1
//        FROM
//            ECOLI_DATA E
//        JOIN
//            CTE C
//            ON E.PARENT_ID=C.ID
//    )
//
//    SELECT
//        COUNT(*) AS COUNT,
//        GENERATION
//    FROM
//        CTE
//    WHERE
//        ID NOT IN (
//            SELECT
//                DISTINCT PARENT_ID
//                FROM
//                ECOLI_DATA
//                WHERE
//                PARENT_ID IS NOT NULL
//        )
//    GROUP BY
//        GENERATION
//    ORDER BY
//        GENERATION;
}
