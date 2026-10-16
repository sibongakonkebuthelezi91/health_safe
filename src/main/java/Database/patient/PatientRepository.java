package Database.patient;

import Database.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashMap;

public class PatientRepository {
    private static Transaction transaction = null;
    private static final HashMap<String, Session> transactionMap = new HashMap<>();

    public static void savePatient(PatientTable patientTable) {
        Session session = null;
      try{
          if (!transactionMap.containsKey("Session")){
              session =  HibernateUtil.getSessionFactory().openSession();
              transactionMap.put("session", session);
          }else{
              session = transactionMap.get("session");
          }
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

    public static void deletePatient(PatientTable patientTable) {

    }


    public static void updatePatient(PatientTable patientTable) {}

    public static void getPatient(PatientTable patientTable) {}
}
