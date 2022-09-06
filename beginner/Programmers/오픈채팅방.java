import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
class 오픈채팅방 {
    public static List<String> solution(String[] record) {
        List<String>list = new ArrayList<>();

        LinkedHashMap<String, User>map = new LinkedHashMap<>();

        for (String s : record) {
            String[] st = s.split(" ");
            User user1 = map.get(st[1]);
            User user = new User();
            if (user1 == null) {
                user.setStatus(st[0]);
                user.setUserId(st[1]);
                user.setUserName(st[2]);
                map.put(st[1], user);
            } else {
                if (st[0].equals("Enter")) {
                    user1.setUserName(st[2]);
                    map.put(st[1], user1);
                } else if (st[0].equals("Change")) {
                    user1.setStatus("Change");
                    user1.setUserName(st[2]);
                    map.put(st[1], user1);
                } else {
                    user1.setStatus("Leave");
                    map.put(st[1], user1);
                }
            }
        }

        for (String s : record) {
            String[] str = s.split(" ");
            if (str[0].equals("Change")) continue;
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(str[1]).getUserName()).append("님이 ");
            if (str[0].equals("Enter")) sb.append("들어왔습니다.");
            else sb.append("나갔습니다.");
            list.add(sb.toString());
        }
        return list;
    }
        static class User{
        private String status;
        private String userId;
        private String userName;

        @Override
        public String toString() {
            return "User{" +
                    "status='" + status + '\'' +
                    ", userId='" + userId + '\'' +
                    ", userName='" + userName + '\'' +
                    '}';
        }

        public User(){}

        public String getStatus() {
            return status;
        }

        public String getUserId() {
            return userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
