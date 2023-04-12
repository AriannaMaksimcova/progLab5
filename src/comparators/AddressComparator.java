package comparators;

import organizations.Address;

import java.util.Comparator;
/**
 * Class-comparator that compares organization's field postalAddress.
 */
public class AddressComparator implements Comparator<Address> {
    @Override
    public int compare(Address o1, Address o2) {
        if(Integer.parseInt(o1.getZipCode()) == Integer.parseInt(o2.getZipCode())){
            if(o1.getTown().getX() == o2.getTown().getX()){
                if(o1.getTown().getY() == o2.getTown().getY()){
                    if(o1.getTown().getZ() == o2.getTown().getZ()){
                        return 0;
                    }
                    return (int) (o1.getTown().getZ() - o2.getTown().getZ());
                }
                return o1.getTown().getY() - o2.getTown().getY();
            }
            return (int) (o1.getTown().getX() - o2.getTown().getX());
        }
        return Integer.parseInt(o1.getZipCode()) - Integer.parseInt(o2.getZipCode());
    }
}
