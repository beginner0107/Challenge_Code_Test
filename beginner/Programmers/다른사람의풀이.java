import java.util.*;
public class 다른사람의풀이 {

    static class Coordinate{
        int left;
        int right;

        public Coordinate(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public String solution(int[] numbers, String hand) {

        LinkedHashMap<String, Coordinate>map = new LinkedHashMap<>();

        int num = 1;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                map.put(String.valueOf(num++), new Coordinate(i, j));
            }
        }

        map.put("*", new Coordinate(3,0));
        map.put("0", new Coordinate(3,1));
        map.put("#", new Coordinate(3,2));

        StringBuilder sb = new StringBuilder();

        Coordinate left = map.get("*"); // 왼쪽 손
        Coordinate right = map.get("#");
        
        for(int n : numbers){
            if(n%3==1){ // 왼쪽 손으로 누르는 경우
                sb.append("L");
                left = map.get(String.valueOf(n)); // 현재 좌표
            }
            else if(n%3==0&&n!=0){ // 오른쪽 손으로 누르는 경우
                sb.append("R");
                right = map.get(String.valueOf(n));
            }
            else{ // 중간 지점에 위치한 값들
                // 거리 비교를 해야 한다. 대각선으로는 X
                Coordinate temp = map.get(String.valueOf(n)); // 목표 좌표를 가져온다.

                // 왼쪽과 목표 좌표 거리를 구한다.
                int leftLength = Math.abs(temp.left - left.left) + Math.abs(temp.right - left.right);
                // 오른쪽과 목표 좌표 거리를 구한다.
                int rightLength = Math.abs(temp.left - right.left) + Math.abs(temp.right - right.right);

                if(leftLength>rightLength){
                    sb.append("R");
                    right = map.get(String.valueOf(n));
                }else if(leftLength<rightLength){
                    sb.append("L");
                    left = map.get(String.valueOf(n));
                }else{
                    if(hand.equals("right")){
                        sb.append("R");
                        right = map.get(String.valueOf(n));
                    }else if(hand.equals("left")){
                        sb.append("L");
                        left = map.get(String.valueOf(n));
                    }
                }
            }
        }

        return sb.toString();
    }


}