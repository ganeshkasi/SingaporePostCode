import org.apache.poi.ss.formula.functions.Address;

public class AddressService {


    public boolean addMemberInfo(String do_no, String addressInfo, String mobile_number, String name, String remarks, String unit_number, String postal_code) {
        AddressDAO addressDAO = new AddressDAO();
        return addressDAO.saveMemberInfo(do_no, addressInfo, mobile_number, name, remarks, unit_number, postal_code);
    }
}
