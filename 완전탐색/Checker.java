class Checker {

    // TODO 다시 풀어보기 : 현재 메모리 초과 오류
  
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int checkerNumber = sc.nextInt();
        int[][] checkers = new int[checkerNumber][2];
        StringBuilder answer = new StringBuilder();

        sc.nextLine();

        // 체커 저장
        for (int i = 0; i < checkerNumber; i++) {
            String[] checkerString = sc.nextLine().split(" ");
            checkers[i][0] = Integer.parseInt(checkerString[0]);
            checkers[i][1] = Integer.parseInt(checkerString[1]);
        }

        // 모든 체커의 인덱스를 배열로 저장
        int[] indices = new int[checkerNumber];
        for (int i = 0; i < checkerNumber; i++) {
            indices[i] = i;
        }

        // 정답 계산
        for (int i = 0; i < checkerNumber; i++) {
            int step = Integer.MAX_VALUE;

            if (i == 0) {
                answer.append("0 ");
                continue;
            }

            // 가능한 모든 조합 생성
            List<List<Integer>> combinations = new ArrayList<>();
            generateCombinations(indices, i + 1, 0, new ArrayList<>(), combinations);

            // 각 조합에 대해 최소 스텝 계산
            for (List<Integer> combination : combinations) {
                int[] selectedX = new int[combination.size()];
                int[] selectedY = new int[combination.size()];

                for (int j = 0; j < combination.size(); j++) {
                    selectedX[j] = checkers[combination.get(j)][0];
                    selectedY[j] = checkers[combination.get(j)][1];
                }

                Arrays.sort(selectedX);
                Arrays.sort(selectedY);

                int medianX = selectedX[selectedX.length / 2];
                int medianY = selectedY[selectedY.length / 2];

                int currentStep = 0;
                for (int j = 0; j < combination.size(); j++) {
                    currentStep += Math.abs(selectedX[j] - medianX) + Math.abs(selectedY[j] - medianY);
                }

                step = Math.min(step, currentStep);
            }

            answer.append(step).append(" ");
        }

        System.out.println(answer.toString().trim());
    }

    private static void generateCombinations(int[] elements, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < elements.length; i++) {
            current.add(elements[i]);
            generateCombinations(elements, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
