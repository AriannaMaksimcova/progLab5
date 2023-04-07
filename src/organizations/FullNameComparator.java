package organizations;

import java.util.Arrays;
import java.util.Comparator;

public class FullNameComparator implements Comparator<Organization> {
    @Override
    public int compare(Organization org1, Organization org2) {
        String o1 = org1.getFullName();
        String o2 = org2.getFullName();
        if(o1.length() - o2.length() == 0){
            String[] s = {o1, o2};
            Arrays.sort(s);
            if(s[1] == o1){
                return 1;
            }
            return -1;
        }
        return o1.length() - o2.length();
    }
}
