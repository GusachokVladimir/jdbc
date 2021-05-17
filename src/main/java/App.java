import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {

        List<Staff> staffs = CRUDUtils.getStaffData("SELECT * FROM staffs");
        System.out.println(staffs);

        Staff staff = new Staff();
        staff.setName("Ivan");
        staff.setSurname("Ivanov");
        staff.setAge(35);
        staff.setPost("doctor");
        staff.setSpecialty("Surgeon");

        System.out.println(CRUDUtils.saveStaff(staff));

        System.out.println(CRUDUtils.updateStaff(1, "Ophthalmologist"));

        System.out.println(CRUDUtils.deleteStaff(1));


    }
}
