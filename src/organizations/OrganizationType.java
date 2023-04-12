package organizations;
/**
 * Enum that contains list of organization's types.
 */
public enum OrganizationType {
    COMMERCIAL,
    PUBLIC,
    GOVERNMENT,
    PRIVATE_LIMITED_COMPANY,
    OPEN_JOINT_STOCK_COMPANY;
    /**
     * Method that checks whether the passed value is present in the enum.
     */
    public static boolean isPresent(String data) {

        try {
            Enum.valueOf(OrganizationType.class, data.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
