package Database.user;

import Database.util.HibernateUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.NoResultException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashMap;

public class Repository {
    private static Transaction transaction = null;
    private static final HashMap<String, Session> transactionMap = new HashMap<>();
    private static  Session session;

    public static void savePatient(Patient patient) {
      try{
          if(transaction == null && !isActivated()) {
              session = startSession();
              transaction = session.beginTransaction();}
          session.persist(patient);
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

            String hql = "delete from Patient p where p.firstName = :firstname";
            session.createMutationQuery(hql)
                    .setParameter("firstname", name)
                    .executeUpdate();

            if(startedNewTransaction) transaction.commit();
        }catch(Exception ex){
            if(transaction != null && transaction.isActive()) transaction.rollback();
            System.out.println("Could not delete patient");
        }
    }


    public static void updatePatient(Patient patient) {}

    public static void getPatient(String name) {
//        Check if I have transaction
        try{
        if(transaction != null && isActivated()) {
            transaction = session.getTransaction();
        }else {
            session = startSession();
            transaction = session.beginTransaction();
        }
        String hql = "FROM Patient p WHERE p.firstName = :firstName";
        Query<Patient> query = session.createQuery(hql).setParameter("firstName", name);
        Patient patient = query.getSingleResultOrNull();
            System.out.println(patient.getFirstName());
        }catch (HibernateException | NoResultException ex){
            rollback();
        }
    }

    private static Session getSession() {
        return session;
    }

    private static Session startSession() throws HibernateException {
            session = HibernateUtil.getSessionFactory().openSession();
            return session;
    }

    private static boolean isActivated(){
        if(transaction == null) return false;
        return transaction.isActive();
    }

    private static void rollback(){
        if(transaction != null && transaction.isActive()) transaction.rollback();
    }
}
