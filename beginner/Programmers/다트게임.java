class 다트게임 {
    public int solution(String dartResult) {

        int idx = 0;
        int[]temp = new int[3];

        for(int i=0;i<dartResult.length();i++){
            if(dartResult.charAt(i)>=48&&dartResult.charAt(i)<=57){
                temp[idx] = Integer.parseInt(String.valueOf(temp[idx]) + String.valueOf(dartResult.charAt(i)));
            }
            else if(Character.isAlphabetic(dartResult.charAt(i))){
                char c = dartResult.charAt(i);
                switch (c){
                    case 'S':
                        temp[idx] = (int) Math.pow(temp[idx],1);
                        break;
                    case 'D':
                        temp[idx] = (int) Math.pow(temp[idx],2);
                        break;
                    case 'T':
                        int pow = (int) Math.pow(temp[idx], 3);
                        temp[idx] = pow;
                        break;
                }
                idx++;
            }
            else{
                if(dartResult.charAt(i)=='#'){
                    temp[idx-1] *= -1;
                }else{
                    if(idx-2>=0) temp[idx-2] *= 2;
                    if(idx-1>=0) temp[idx-1] *= 2;
                }
            }
        }

        return temp[0] + temp[1] + temp[2];
    }
}