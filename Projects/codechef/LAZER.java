package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

class LAZER {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        StringTokenizer st;
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            Integer[] A = new Integer[n];
            st = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            Query[] Q = new Query[q];
            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(reader.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                Q[i] = new Query(x1, x2, y);
            }
            Map<Integer, Event> events = new TreeMap<>();
            for (int i = 0; i < q; i++) {
                Event event = events.getOrDefault(Q[i].y, new Event());
                event.queries.add(Q[i]);
                events.put(Q[i].y, event);
            }
            for (int i = 0; i < n; i++) {
                int y = A[i];
                Event event = events.getOrDefault(y, new Event());
                if (i < n - 1) {
                    (y <= A[i + 1] ? event.xis : event.xos).add(i + 1);
                }
                if (i > 0) {
                    (A[i - 1] <= y ? event.xos : event.xis).add(i);
                }
                events.put(y, event);
            }
            BST<Integer> candidates = new BST<>();
            for (Event event : events.values()) {
                for (Integer x : event.xis) {
                    candidates.add(x);
                }
                for (Query query : event.queries) {
                    query.n = candidates.size(query.x1, query.x2);
                }
                for (Integer x : event.xos) {
                    candidates.remove(x);
                }
            }
            for (int i = 0; i < q; i++) {
                writer.println(Q[i].n);
            }
        }
        reader.close();
        writer.flush();
        writer.close();
    }

    private static class Query {
        protected int x1;
        protected int x2;
        protected int y;
        protected int n;

        Query(int x1, int x2, int y) {
            this.x1 = x1;
            this.x2 = x2;
            this.y = y;
        }
    }

    private static class Event {
        protected List<Integer> xis = new ArrayList<>();
        protected List<Integer> xos = new ArrayList<>();
        protected List<Query> queries = new ArrayList<>();
    }
}
