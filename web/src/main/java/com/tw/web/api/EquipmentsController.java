package com.tw.web.api;

import com.tw.core.Equipment;
import com.tw.core.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by twer on 7/24/14.
 */
@RestController
@RequestMapping("/api/v1/equipments")
public class EquipmentsController {
    private EquipmentService equipmentService;

    @Autowired
    public EquipmentsController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Equipment> findAll() {
        return equipmentService.findAll();
    }

    @RequestMapping(value = "/{equipmentId}", method = RequestMethod.GET)
    public ResponseEntity<Equipment> findOne(@PathVariable("equipmentId") long id) {
        Equipment equipment = equipmentService.findOne(id);

        if (equipment == null) {
            return new ResponseEntity<Equipment>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Equipment>(equipment, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Equipment equipment, HttpServletRequest request, HttpServletResponse response) {
        equipmentService.create(equipment);
        response.setHeader("Location", request.getRequestURL().append("/").append(equipment.getId()).toString());
    }

    @RequestMapping(value = "/{equipmentId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("equipmentId") long id, @RequestBody Equipment equipment) {
        equipmentService.update(equipment);
    }


    @RequestMapping(value = "/{equipmentId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("equipmentId") long id) {
        equipmentService.delete(id);
    }

    @RequestMapping(value = "/:batch", method = RequestMethod.DELETE )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll(@RequestBody long[] ids) {
        equipmentService.deleteAll(ids);
    }

    @RequestMapping(value = "/:search", method = RequestMethod.GET)
    public List<Equipment> search( @RequestParam(value = "keyword") String keyword) {
        return equipmentService.search(keyword);
    }

}
