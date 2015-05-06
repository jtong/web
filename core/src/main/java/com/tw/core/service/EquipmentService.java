package com.tw.core.service;

import com.tw.core.Equipment;
import com.tw.core.dao.EquipmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by twer on 7/17/14.
 */
@Service
public class EquipmentService {
    private EquipmentDAO equipmentDAO;

    @Autowired
    public EquipmentService(EquipmentDAO equipmentDAO) {
        this.equipmentDAO = equipmentDAO;
    }

    @Transactional
    public List<Equipment> listEquipment() {
        return equipmentDAO.listEquipment();
    }

    @Transactional
    public void addEquipment(Equipment equipment) {
        equipmentDAO.addEquipment(equipment);
    }

    @Transactional
    public Equipment findEquipmentById(long id) {
        return equipmentDAO.findEquipmentById(id);
    }

    @Transactional
    public void updateEquipment(Equipment equipment) {
        equipmentDAO.updateEquipment(equipment);
    }

    @Transactional
    public void deleteEquipment(long id) {
        equipmentDAO.deleteEquipment(id);
    }

    @Transactional
    public void deleteEquipmentList(long[] ids) {
        equipmentDAO.deleteEquipmentList(ids);
    }
    @Transactional
    public List<Equipment> findAll() {
        return equipmentDAO.findAll();
    }

    @Transactional
    public Equipment findOne(long id) {
        return equipmentDAO.findOne(id);
    }

    @Transactional
    public void create(Equipment equipment) {
        equipmentDAO.create(equipment);
    }

    @Transactional
    public void delete(long id) {
        equipmentDAO.delete(id);
    }

    @Transactional
    public void update(Equipment equipment) {
        equipmentDAO.update(equipment);
    }

    @Transactional
    public void deleteAll(long[] idList) {
        equipmentDAO.deleteAll(idList);
    }

    @Transactional
    public List<Equipment> search(String keyword) {
        return equipmentDAO.search(keyword);
    }
}
