package HashCode_Equals.hash_code;

import java.util.HashMap;
import java.util.Map;

public class Basic {
    public static void main(String[] args) {
        Map<Team,String> leaders = new HashMap<>();
        leaders.put(new Team("New York", "development"), "Anne");
        leaders.put(new Team("Boston", "development"), "Brian");
        leaders.put(new Team("Boston", "marketing"), "Charlie");

        Team myTeam = new Team("New York", "development");
        String myTeamLeader = leaders.get(myTeam);
        System.out.println(myTeamLeader);
    }
}

class Team {

    public Team(){}
    public Team(String city, String department){
        this.city = city;
        this.department = department;
    }

    String city;
    String department;

    @Override
    public final boolean equals(Object o) {
        Team t = (Team)o;
        // implementation
        boolean result = city.equals(t.city) && department.equals(t.department);
        System.out.println("city:"+city+"  department: "+department+"  equals:"+result);
        return result;
    }

    @Override
    public final int hashCode() {
        int result = 17;
        if (city != null) {
            result = 31 * result + city.hashCode();
        }
        if (department != null) {
            result = 31 * result + department.hashCode();
        }
        System.out.println("city:"+city+"  department: "+department+"  hashcode:"+result);
        return result;
    }
}