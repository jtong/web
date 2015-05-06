package com.tw.core.dao;

import com.tw.core.Equipment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by twer on 7/17/14.
 */
@Repository
@Transactional(readOnly = true)
public class EquipmentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public EquipmentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Equipment> listEquipment() {
        return sessionFactory.getCurrentSession().createQuery("from Equipment")
                .list();
    }

    public void addEquipment(Equipment equipment) {
        sessionFactory.getCurrentSession().save(equipment);
    }

    public Equipment findEquipmentById(long id) {
        Equipment equipment = (Equipment) sessionFactory.getCurrentSession().get(Equipment.class, id);
        return equipment;
    }

    public void updateEquipment(Equipment equipment) {
        sessionFactory.getCurrentSession().update(equipment);
    }

    public void deleteEquipment(long id) {
        Equipment equipment = findEquipmentById(id);
        if (equipment != null) {
            sessionFactory.getCurrentSession().delete(equipment);
        }
    }

    public void deleteEquipmentList(long[] ids) {
        for (int index = 0; index < ids.length; index++) {
            deleteEquipment(ids[index]);
        }
    }
    public List<Equipment> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Equipment")
                .list();
    }

    public Equipment findOne(long id) {
        Equipment equipment = (Equipment) sessionFactory.getCurrentSession().get(Equipment.class, id);
        return equipment;
    }

    public void create(Equipment equipment) {
        sessionFactory.getCurrentSession().save(equipment);
    }

    public void delete(long id) {
        Equipment equipment = findOne(id);
        if (equipment != null) {
            sessionFactory.getCurrentSession().delete(equipment);
        }
    }

    public void update(Equipment equipment) {
        sessionFactory.getCurrentSession().update(equipment);
    }

    public void deleteAll(long[] idList) {
        for (long id : idList) {
            delete(id);
        }
    }

    public List<Equipment> search(String keyword) {
        String query = "FROM Equipment WHERE name LIKE :keyword or email LIKE :keyword";

        return sessionFactory.getCurrentSession().createQuery(query)
                .setString("keyword", "%" + keyword + "%")
                .list();
    }

}
