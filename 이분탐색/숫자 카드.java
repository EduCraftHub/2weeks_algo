// https://www.acmicpc.net/problem/10815

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] inputArray = new int[m];
        int[] answer = new int[m];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++) {
            inputArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        for(int i = 0; i < m; i++) {

            int start = 0;
            int end = n - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                
                if(array[mid] == inputArray[i]) {
                    answer[i] = 1;
                    break;
                }

                if (array[mid] > inputArray[i]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        System.out.println(Arrays.toString(answer).replace("[", "").replace("]", "").replace(",", ""));
    }
}
