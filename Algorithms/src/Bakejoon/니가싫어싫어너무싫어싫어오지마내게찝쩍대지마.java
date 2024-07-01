package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 니가싫어싫어너무싫어싫어오지마내게찝쩍대지마 {

    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        // 배열 값을 입력받자
        int N = Integer.parseInt(bReader.readLine());

        HashMap<Integer, Integer> mapMos = new HashMap<>();
        ArrayList<Integer> listTime = new ArrayList<>();


        int nMax = 0;
        int nMinIndex = Integer.MAX_VALUE;

        // Rule 1 : First Time + 1, End Time - 1
        //        : listTime save the time from inputs
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bReader.readLine());
            int nStart = Integer.parseInt(st.nextToken());
            int nEnd = Integer.parseInt(st.nextToken());

            if (!mapMos.containsKey(nStart)) {
                mapMos.put(nStart, 1);
                listTime.add(nStart);
            }
            else
                mapMos.put(nStart, mapMos.get(nStart)+1);

            if(!mapMos.containsKey(nEnd)) {
                mapMos.put(nEnd, -1);
                listTime.add(nEnd);
            }
            else
                mapMos.put(nEnd, mapMos.get(nEnd) - 1);
        }

        int nVal = 0;
        int nIndex = -1;
        int nLastIndex = -1;

        // Sort the time to start from minimum time.
        Collections.sort(listTime);

        // Rule 2 : Update the maps by rule 1, 2, save the maximum value and the index (time)
        for(int i = 0; i < listTime.size(); i++) {
            nVal += mapMos.get(listTime.get(i));
            if(nMax < nVal) {
                nMax = nVal;
                nIndex = i;
            }
            mapMos.put(listTime.get(i), nVal);
        }

        // Rule 3: get the end time which has max mos;
        nVal = nMax;
        nLastIndex = nIndex;
        while(nMax == nVal) {
            if(nLastIndex >= listTime.size()) {
                nLastIndex--;
                break;
            }
            nVal = mapMos.get(listTime.get(nLastIndex));

            if(nVal != nMax)
                break;

            nLastIndex++;
        }


        bWriter.write(nMax + "\n");
        bWriter.write(listTime.get(nIndex) + " " + listTime.get(nLastIndex));

        bWriter.close();
    }

}