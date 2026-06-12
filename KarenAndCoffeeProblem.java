import java.io.*;
import java.util.*;

public class Main {
    private static final int M = 200005;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s == null) return;
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] d = new int[M];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            d[l]++;
            d[r + 1]--;
        }
        int[] p = new int[M];
        int c = 0;
        for (int i = 1; i < M; i++) {
            c += d[i];
            p[i] = (c >= k) ? 1 : 0;
        }
        for (int i = 1; i < M; i++) {
            p[i] += p[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(p[b] - p[a - 1]).append("\n");
        }
        System.out.print(sb);
    }
}
