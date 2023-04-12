package comparators;

import organizations.Organization;

import java.util.Comparator;
/**
 * Class-comparator that compares organizations.
 */
public class OrganizationsComparator implements Comparator<Organization> {
    @Override
    public int compare(Organization o1, Organization o2) {
        if(o1.getId()-o2.getId() == 0){
            if(o1.getName().length() == o2.getName().length()){
                if(o1.getAnnualTurnover() - o2.getAnnualTurnover() == 0){
                    if(o1.getEmployeesCount()- o2.getEmployeesCount() == 0){
                        if(o1.getFullName().length() == o2.getFullName().length()){
                            return 0;
                        }
                        return o1.getFullName().length() - o2.getFullName().length();
                    }
                    return Integer.parseInt(String.valueOf(o1.getEmployeesCount() - o2.getEmployeesCount()));
                }
                return o1.getAnnualTurnover() - o2.getAnnualTurnover();
            }
            return o1.getName().length() - o2.getName().length();
        }
        return o1.getId()-o2.getId();
    }
}
