package codechef;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class UCL {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner stdin = new Scanner(System.in);
        int t = Integer.parseInt(stdin.nextLine());
        while (t-- > 0) {
            Map<String, Team> teams = new HashMap<>();
            for (int i = 0; i < 12; i++) {
                String[] tokens = stdin.nextLine().split(" ");
                if (!teams.containsKey(tokens[0]))
                    teams.put(tokens[0], new Team());
                if (!teams.containsKey(tokens[4]))
                    teams.put(tokens[4], new Team());
                int diff = Integer.parseInt(tokens[1]) - Integer.parseInt(tokens[3]);
                if (diff > 0)
                    teams.get(tokens[0]).plus(3, 0);
                else if (diff < 0)
                    teams.get(tokens[4]).plus(3, 0);
                else {
                    teams.get(tokens[0]).plus(1, 0);
                    teams.get(tokens[4]).plus(1, 0);
                }
                teams.get(tokens[0]).plus(0, diff);
                teams.get(tokens[4]).plus(0, -diff);
            }
            System.out.println(
                    teams.entrySet()
                            .stream()
                            .sorted(
                                    Map.Entry.comparingByValue(
                                            Comparator.comparingInt(Team::getPoint)
                                                    .thenComparingInt(Team::getGoal)
                                                    .reversed()
                                    )
                            )
                            .limit(2)
                            .map(Map.Entry::getKey)
                            .collect(Collectors.joining(" "))
            );
        }
    }

    private static class Team {
        private int point = 0;
        private int goal = 0;

        public void plus(int point, int goal) {
            this.point += point;
            this.goal += goal;
        }

        public int getPoint() {
            return this.point;
        }

        public int getGoal() {
            return this.goal;
        }
    }
}
