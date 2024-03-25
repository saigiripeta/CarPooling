package com.nit.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nit.Entity.ShareVehicle;

@Repository
public class ShareRepoimpl implements ShareRepo {

    @Autowired
    private EntityManager em;

    @Override
    public List<ShareVehicle> get() {
        Session currentSession = em.unwrap(Session.class);
        Query<ShareVehicle> query = currentSession.createQuery("from ShareVehicle", ShareVehicle.class);
        List<ShareVehicle> list = query.getResultList();
        return list;
    }

    @Override
    public ShareVehicle get(String Name) {
        Session currentSession = em.unwrap(Session.class);
        ShareVehicle Obj = currentSession.get(ShareVehicle.class, Name);
        return Obj;
    }

    @Override
    public void save(ShareVehicle sv) {
        Session currentSession = em.unwrap(Session.class);
        currentSession.saveOrUpdate(sv);

    }

    @Transactional
    public void delete(int id) {
        Session currentSession = em.unwrap(Session.class);
        ShareVehicle Obj = currentSession.get(ShareVehicle.class, id);
        currentSession.delete(Obj);

    }

    @Override
    public List<ShareVehicle> getUsingDestination(String Destination) {
        Session currentSession = em.unwrap(Session.class);
        Query<ShareVehicle> query =
                currentSession.createQuery("select s from ShareVehicle s WHERE s.Destination = :Destination", ShareVehicle.class)
                        .setParameter("Destination", Destination);
        List<ShareVehicle> list = query.getResultList();

        if (list.size() == 0) {
            ShareVehicle dummyObj = new ShareVehicle();
            list.add(dummyObj);
        }

        System.out.println("getUsingDestination : " + list);
        return list;
    }


}
