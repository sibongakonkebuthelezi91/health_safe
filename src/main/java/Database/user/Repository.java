package Database.user;

import Database.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashMap;

public class Repository {
    private static Transaction transaction = null;
    private static final HashMap<String, Session> transactionMap = new HashMap<>();
    private static  Session session;

    public static void savePatient(PatientTable patientTable) {
      try{
          if(!isActivated()) {
              session = startSession();
              transaction = session.beginTransaction();}
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

    public static void getPatient(String name) {
//        Check if I have transaction
        try{
        if(isActivated()) {
            transaction = session.getTransaction();
        }else {
            session = startSession();
            transaction = session.beginTransaction();
        }
        String hql = "FROM PatientTable p WHERE p.firstName =  :firstName";
        Query query = session.createQuery(hql).setParameter("firstName", name);

        }catch (HibernateException ex){
            if(transaction != null && isActivated()) transaction.rollback();
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
        return transaction.isActive();
    }
}
