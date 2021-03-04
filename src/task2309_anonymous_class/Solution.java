package task2309_anonymous_class;

import task2309_anonymous_class.vo.*;

import java.util.List;

/*
Sometimes anonymity is so nice!

*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.printf((format) + "%n", item.getId(), item.getName(), item.getDescription());
        }
    }
    public List<User> getUsers() {
        return new AbstractDbSelectExecutor<User>(){
            @Override
            public String getQuery() {
                return "SELECT * FROM USER";
            }
        }.execute();
    }
    public List<Location> getLocations() {
        return new AbstractDbSelectExecutor<Location>(){
            @Override
            public String getQuery() {
                return "SELECT * FROM LOCATION";
            }
        }.execute();
    }
    public List<Server> getServers() {
        return new AbstractDbSelectExecutor<Server>(){
            @Override
            public String getQuery() {
                return "SELECT * FROM SERVER";
            }
        }.execute();
    }
    public List<Subject> getSubjects() {
        return new AbstractDbSelectExecutor<Subject>(){
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBJECT";
            }
        }.execute();
    }
    public List<Subscription> getSubscriptions() {
        return new AbstractDbSelectExecutor<Subscription>(){
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBSCRIPTION";
            }
        }.execute();
    }
}