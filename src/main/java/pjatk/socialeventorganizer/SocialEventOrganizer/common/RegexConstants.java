package pjatk.socialeventorganizer.SocialEventOrganizer.common;

public class RegexConstants {

    public static final String PL_ZIP_REGEX = "^\\d{2}[-]{0,1}\\d{3}$";
    public static final String COUNTRY_REGEX = "^[A-Z][a-z]+( [A-Z][a-z]+)*$";
    public static final String CITY_REGEX = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$";
    public static final String STREET_REGEX = "[\\w\\s]+";
    public static final String FIRST_NAME_REGEX = "^[A-Za-z]+((\\s)?((\\'|\\-|\\.)?([A-Za-z])+))*$";
    public static final String LAST_NAME_REGEX = "([A-Z][a-zA-Z]*)";
    public static final String PRICE_REGEX = "^\\d+(.\\d{1,2})?$";
    public static final String PHONE_NUMBER_REGEX = "^\\d{9}$";
    public static final String NAME_REGEX = "^(?=\\s*\\S).*$";


}
