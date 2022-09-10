import java.util.*;
class  주차요금계산 {
    public int[] solution(int[] fees, String[] records){
        LinkedHashMap<Integer, Parking> map = new LinkedHashMap<>();
        for(String str : records){
            String [] tmp = str.split(" ");
            Integer carNumber = Integer.parseInt(tmp[1]);
            if(!map.containsKey(carNumber)){
                map.put(carNumber, new Parking(tmp[0], tmp[2]));
            }else{
                Parking parking = map.get(carNumber);
                parking.time.add(tmp[0]);
                parking.status.add(tmp[2]);
                map.put(carNumber, parking);
            }
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        for(int key : keySet){
            Parking parking = map.get(key);
            if(parking.time.size()%2!=0){
                parking.time.add("23:59");
                parking.status.add("OUT");
                map.put(key,parking);
            }
        }

        int[]result = new int[map.size()];
        int cnt = 0;
        for(int key : keySet){
            Parking parking = map.get(key);
            int cumulativeTime = 0;
            int r = 0;
            for(int i=0;i<parking.time.size();i+=2){
                cumulativeTime += (Integer.parseInt(parking.time.get(i+1).substring(0, 2)) * 60 + Integer.parseInt(parking.time.get(i+1).substring(3)) )
                          -(Integer.parseInt(parking.time.get(i).substring(0, 2)) * 60 + Integer.parseInt(parking.time.get(i).substring(3)) );
            }
            parking.cumulativeTime = cumulativeTime;
            if(cumulativeTime-fees[0]>0){ // 누적 시간이 기본 시간을 넘어가면
                r += fees[1];
                int remainTime = cumulativeTime-fees[0];
                if(remainTime<=fees[2]){
                    r += fees[3];
                }
                else {
                    int tmp;
                    if(remainTime%fees[2]!=0){
                        tmp = remainTime / fees[2] + 1;
                    }else{
                        tmp = remainTime / fees[2];
                    }
                    r += tmp * fees[3];
                }
            }else{ // 누적 시간이 기본 시간 안에 있는 경우
                r += fees[1];
            }
            result[cnt++] = r;
            map.put(key, parking);
        }

        return result;
    }

    static class Parking{

        ArrayList<String> time = new ArrayList<>();
        ArrayList<String> status = new ArrayList<>();
        // 누적 시간
        int cumulativeTime = 0;
        public Parking(String time, String status) {
            this.time.add(time);
            this.status.add(status);
        }
    }
}