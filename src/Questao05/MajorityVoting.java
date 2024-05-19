package Questao05;

public class MajorityVoting {
    public static int bruteForceSolution(int[] votes) {
        for (int i = 0; i < votes.length; i++) {
            int count = 0;
            int candidate = votes[i];

            for (int j = 0; j < votes.length; j++) {
                if (votes[j] == candidate) {
                    count++;
                }
            }

            if (count > votes.length / 2) {
                return candidate;
            }
        }

        return -1;
    }

    public static int divideAndConquerSolution(int[] votes) {
        int count = 0;
        int candidate = -1;

        for (int i = 0; i < votes.length; i++) {
            if (count == 0) {
                candidate = votes[i];
                count = 1;
            } else {
                if (votes[i] == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        count = 0;
        for (int i = 0; i < votes.length; i++) {
            if (votes[i] == candidate) {
                count++;
            }
        }

        if (count > votes.length / 2) {
            return candidate;
        }

        return -1;
    }
}
