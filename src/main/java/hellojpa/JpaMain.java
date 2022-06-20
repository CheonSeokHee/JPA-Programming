package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //만드는 순간 데이터베이스 연결 성공완료

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //EntityManagerFactory 를 받아와서, EntityManager를 받아 온 뒤, 거기에서 Transaction을 받음
        //트랜잭션 안에서 Member를 생성 해서 em.persisst로 저장.
        tx.begin();


        //persist를 쓰지 않는다는 부분
        //Member member = em.find(Member.class, 150L);
        //member.setName("ZZZZ");
        //System.out.println("===============================");;

        //Member member = new Member(200L, "member200");
       // em.persist(member);
        //em.flush(); //db에 즉시 쿼리가 전송됨

        //System.out.println("==================");
        try {

            Team team = new Team();
            team.setName("내가만든 TeamA");
            em.persist(team);


            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            Member findMember = em.find(Member.class, member.getId());




            tx.commit();

        } catch (Exception e){

            tx.rollback();
        } finally {
            em.close();
        }
            emf.close();

       // Member member = new Member();
        //member.setId(2L);
       // member.setName("cheon");
        //em.persist(member);

        //Member findMember = em.find(Member.class, 1L);
        //findMember.setName("바뀐 cheon");

       // Member findMember1 = em.find(Member.class, 2L);
        //Member findMember2 = em.find(Member.class, 2L);

        //System.out.println("result== " + (findMember1 == findMember2));


    }
}
