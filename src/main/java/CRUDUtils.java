import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {
    private static final String INSERT_STAFF = "INSERT INTO staffs(name, surname, age, post, specialty) " +
            "VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_STAFF = "UPDATE staffs SET specialty = ? WHERE id = ?";
    private static final String DELETE_STAFF = "DELETE FROM staffs WHERE id = ?";

    public static List<Staff> getStaffData(String query) throws SQLException {
        List<Staff> staffs = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             ResultSet rs = preparedStatement.executeQuery();

             while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                String post = rs.getString("post");
                String specialty = rs.getString("specialty");

                staffs.add(new Staff(id, name, surname, age, post, specialty));
             }

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    return staffs;
    }

    public static List<Staff> saveStaff(Staff staff){
        List<Staff> staffs = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STAFF)) {

            preparedStatement.setString(1, staff.getName());
            preparedStatement.setString(2, staff.getSurname());
            preparedStatement.setInt(3, staff.getAge());
            preparedStatement.setString(4, staff.getPost());
            preparedStatement.setString(5, staff.getSpecialty());

            preparedStatement.executeUpdate();
            PreparedStatement allStaffs = connection.prepareStatement("SELECT * FROM staffs");
            ResultSet rs = allStaffs.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                String post = rs.getString("post");
                String specialty = rs.getString("specialty");

                staffs.add(new Staff(id, name, surname, age, post, specialty));
            }

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

        return staffs;
    }

    public static List<Staff> updateStaff (int staffId, String specialtyName){
        List<Staff> updateStaff = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STAFF)) {

            preparedStatement.setString(1, specialtyName);
            preparedStatement.setInt(2, staffId);

            preparedStatement.executeUpdate();

            PreparedStatement allStaffs = connection.prepareStatement("SELECT * FROM staffs");
            ResultSet rs = allStaffs.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                String post = rs.getString("post");
                String specialty = rs.getString("specialty");

                updateStaff.add(new Staff(id, name, surname, age, post, specialty));
            }

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return updateStaff;
    }

    public static List<Staff> deleteStaff(int staffId){
        List<Staff> deleteStaff = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STAFF)) {

            preparedStatement.setInt(1, staffId);

            preparedStatement.executeUpdate();

            PreparedStatement allStaffs = connection.prepareStatement("SELECT * FROM staffs");
            ResultSet rs = allStaffs.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                String post = rs.getString("post");
                String specialty = rs.getString("specialty");

                deleteStaff.add(new Staff(id, name, surname, age, post, specialty));
            }

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return deleteStaff;
    }

}
