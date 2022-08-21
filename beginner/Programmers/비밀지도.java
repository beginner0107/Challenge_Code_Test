class 비밀지도 {
 public String[] solution(int n, int[] arr1, int[] arr2) {

        boolean[][]map = new boolean[n][n];

        for(int i=0;i<arr1.length;i++){
            StringBuilder a1 = new StringBuilder(Integer.toBinaryString(arr1[i]));
            StringBuilder a2 = new StringBuilder(Integer.toBinaryString(arr2[i]));

            while(a1.length()!=n){
                a1.insert(0, 0);
            }
            while(a2.length()!=n){
                a2.insert(0, 0);
            }


            for(int j=0;j<a2.length();j++){
                if(a1.charAt(j)=='1'||a2.charAt(j)=='1'){
                    map[i][j] = true; // 벽
                }
            }
        }
        String[] result = new String[n];

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n * n;i++){
            int x = i / n;
            int y = i % n;

            if(map[x][y]){
                sb.append("#");
            }else sb.append(" ");

            if(y!=0&&y%(n-1)==0){
                result[x] = sb.toString();
                sb.setLength(0);
            }
        }
        return result;
    }
}