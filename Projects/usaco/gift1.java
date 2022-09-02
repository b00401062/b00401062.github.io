package usaco;

import java.io.*;
import java.util.*;

public class gift1 {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("gift1.in"));
        PrintWriter stdout = new PrintWriter(new File("gift1.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        int name_cnt = stdin.nextInt();
        List<String> names = new ArrayList<String>(name_cnt);
        Map<String, Integer> table = new HashMap<String, Integer>(name_cnt);
        for (int i = 0; i < name_cnt; i++) {
            String name = stdin.next();
            names.add(name);
            table.put(name, 0);
        }
        for (int i = 0; i < name_cnt; i++) {
            String gvr_name = stdin.next();
            int money = stdin.nextInt();
            int rcv_cnt = stdin.nextInt();
            if (rcv_cnt == 0)
                continue;
            table.put(gvr_name, table.get(gvr_name) - money / rcv_cnt * rcv_cnt);
            for (int j = 0; j < rcv_cnt; j++) {
                String rcv_name = stdin.next();
                table.put(rcv_name, table.get(rcv_name) + money / rcv_cnt);
            }
        }
        for (String name : names)
            stdout.println(name + " " + table.get(name));
        stdin.close();
    }
}
