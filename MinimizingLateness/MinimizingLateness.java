package MinimizingLateness;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class MinimizingLateness {

    private static class Schedule { // Schedule 클래스
        int t = 0; // 작업 수행에 필요한 시간
        int d = 0; // 작업이 완료되야 할 시간
        int s = 0; // 작업의 시작 시간
        int f = 0; // 작업이 끝나는 시간

        public Schedule(int t, int d) { //초기 설정
            this.t = t;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer token;

        BufferedReader in = new BufferedReader(new FileReader("MinimizingLateness/lateness_data.txt"));
        String ch = in.readLine();
        if (ch == null || ch.isEmpty()) {
            return;
        }
        int indexCount = Integer.parseInt(ch);
        System.out.println("Input Data : ");
        System.out.println(indexCount); // 작업의 수
        Schedule[] array = new Schedule[indexCount]; // 작업을 저장할 배열을 만든다
        int i = 0;
        while ((ch = in.readLine()) != null) {
            token = new StringTokenizer(ch, " ");
            // 작업에 필요한 시간과 완료되어야 할 시간을 포함한다
            array[i] = new Schedule(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
            i++;
            System.out.println(array[i - 1].t + " " + array[i - 1].d);
        }

        int tryTime = 0; // 총 일한 시간
        int lateness = 0; // Lateness
        for (int j = 0; j < indexCount - 1; j++) {
            array[j].s = tryTime; // 작업을 시작한 시간
            array[j].f = tryTime + array[j].t; // 시간 끝
            tryTime = tryTime + array[j].t; // 작업 시간을 더한다
            // Lateness
            lateness = lateness + Math.max(0, tryTime - array[j].d);
        }
        System.out.println();
        System.out.println("Output Data : ");
        System.out.println(lateness); //지각
    }
}
