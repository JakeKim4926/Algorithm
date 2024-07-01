package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Competition {

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bReader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> mapProbs = new HashMap<>();
        // Alice 만 가능하면 1
        // Bob 만 가능하면 2
        // 둘다 되면 3

        // Alice first
        st = new StringTokenizer(bReader.readLine());
        for (int i = 0; i < A; i++) {
            int nNum = Integer.parseInt(st.nextToken());
            mapProbs.put(nNum, 1);
        }

        // BOB
        st = new StringTokenizer(bReader.readLine());
        for (int i = 0; i < B; i++) {
            int nNum = Integer.parseInt(st.nextToken());
            if (mapProbs.get(nNum) == null)
                mapProbs.put(nNum, 2);
            else
                mapProbs.put(nNum, 3);
        }

        // Map의 Key들을 리스트로 모아
        List<Integer> keyList = new ArrayList<>(mapProbs.keySet());
        Collections.sort(keyList);

        int nOld = 0;
        int nSwitch = 0;

        // Old값을 처음으로 정의
        int nIndex = 0;
        nOld = mapProbs.get(keyList.get(nIndex));
        while (nOld == 3 && nIndex < keyList.size()) {
            nOld = mapProbs.get(keyList.get(nIndex++));
        }

        // 사용자의 값이 3이 아니고 이전 Key값과 다르다
        for (int i = nIndex; i < keyList.size(); i++) {
            if (nOld != mapProbs.get(keyList.get(i)) && mapProbs.get(keyList.get(i)) != 3) {
                nOld = mapProbs.get(keyList.get(i));
                nSwitch++;
            }
        }

        bWriter.write(String.valueOf(nSwitch));
        bWriter.close();
    }

}