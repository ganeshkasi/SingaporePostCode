import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddressDAO {
    private static SessionFactory factory;

    public boolean saveMemberInfo(String do_no, String addressInfo, String mobile_number, String name, String remarks, String unit_number, String postal_code) {
        try {


            factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            Transaction tx = null;
            Integer employeeID = null;

            try {
                tx = session.beginTransaction();
            /*    Employee employee = new Employee(fname, lname, salary);
                employeeID = (Integer) session.save(employee);
            */
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }

        }catch (Exception e){
        }

        System.out.println("Successfully saved .....");
        return true;
}
}
