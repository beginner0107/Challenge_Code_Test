import java.util.*;
class 교점에별만들기 {
    public static String[]solution(int[][]line){
        ArrayList<long[]>list = new ArrayList<>();

        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        for(int i=0;i<line.length;i++){
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];
            for(int j=i+1; j<line.length;j++){
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                long xUp = b * f - e * d;
                long xDown = a * d - b * c;

                long yUp = e * c - a * f;
                long yDown = a * d - b * c;

                if(xDown!=0){
                    double x = xUp / (double)xDown;
                    double y = yUp / (double)yDown;

                    if(x == Math.ceil(x) && y == Math.ceil(y)){
                        list.add(new long[]{(long)x, (long)y});
                        minX = Math.min(minX, (long)x);
                        maxX = Math.max(maxX, (long)x);
                        minY = Math.min(minY, (long)y);
                        maxY = Math.max(maxY, (long)y);
                    }
                }
            }
        }

        boolean[][] answerTemp = new boolean[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];

        for (long[] ints : list) {
            int x = (int) (ints[0] - minX);
            int y = (int) (ints[1] - maxY);

            answerTemp[Math.abs(y)][Math.abs(x)] = true;
        }

        String[] result = new String[answerTemp.length];

        for(int i=0;i<answerTemp.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<answerTemp[i].length;j++){
                if(answerTemp[i][j]){
                    sb.append('*');
                }else sb.append('.');
            }
            result[i] = sb.toString();
        }


        return result;
    }
}