package Database.patient;

import Database.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PatientRepository {

    public static void savePatient(PatientTable patientTable) {
        Transaction transaction = null;
      try(Session session =  HibernateUtil.getSessionFactory().openSession()){
          transaction = session.beginTransaction();
          session.persist(patientTable);

          transaction.commit();

      }catch(Exception ex){
          if(transaction != null && transaction.isActive()){
              transaction.rollback();
          }
          throw new PatientException("Could not save patient");
      }

    }
}
