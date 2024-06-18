

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

    public static void main(String[] args) {

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);

            String[] numbers = br.readLine().split(" ");
            int[] addNum = new int[N+1];

            for (int i=0 ; i<N ; i++) {
                if (i==0) addNum[0] = Integer.parseInt(numbers[0]);
                else addNum[i] = addNum[i-1] + Integer.parseInt(numbers[i]);
            }

            int cnt = 0;
            StringBuffer sb = new StringBuffer();
            while (cnt < M) {
                String[] s1 = br.readLine().split(" ");
                int i = Integer.parseInt(s1[0]);
                int j = Integer.parseInt(s1[1]);
                if (i == 1) sb.append( addNum[j - 1] + "\n");
                else sb.append((addNum[j - 1] - addNum[i - 2])+"\n");
                cnt++;
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
