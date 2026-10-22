package Database.user;

import Database.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashMap;

public class PatientRepository {
    private static Transaction transaction = null;
    private static final HashMap<String, Session> transactionMap = new HashMap<>();

    public static void savePatient(PatientTable patientTable) {
        Session session;
      try{
          if (!transactionMap.containsKey("session")){
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

    public static void deletePatient(String name) {
        Session session;
        boolean startedNewTransaction = false;
        try{
            if (!transactionMap.containsKey("session")){
                session =  HibernateUtil.getSessionFactory().openSession();
                transactionMap.put("session", session);
            }else{
                session = transactionMap.get("session");

            }
//            Checking transaction is active or not begin one when not
            transaction = session.getTransaction();
            if (!transaction.isActive()) {
                transaction = session.beginTransaction();
                startedNewTransaction = true;}

            String hql = "delete from PatientTable p where p.firstName = :firstname";
            session.createMutationQuery(hql)
                    .setParameter("firstname", name)
                    .executeUpdate();

            if(startedNewTransaction) transaction.commit();
        }catch(Exception ex){
            if(transaction != null && transaction.isActive()) transaction.rollback();
            System.out.println("Could not delete patient");
        }
    }


    public static void updatePatient(PatientTable patientTable) {}

    public static void getPatient(PatientTable patientTable) {}
}
