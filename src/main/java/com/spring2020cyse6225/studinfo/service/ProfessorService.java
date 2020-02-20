package com.spring2020cyse6225.studinfo.service;

import com.spring2020cyse6225.studinfo.dataSource.InMemoryDatabase;
import com.spring2020cyse6225.studinfo.datamodel.Professor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class ProfessorService {

    static HashMap<Long, Professor> prof_Map = InMemoryDatabase.getProfessorDB();

    public ProfessorService() {
    }

    // Getting a list of all professor
    // GET "..webapi/professors"
    public List<Professor> getAllProfessors() {
        //Getting the list
        ArrayList<Professor> list = new ArrayList<>();
        for (Professor prof : prof_Map.values()) {
            list.add(prof);
        }
        return list ;
    }

    // Adding a professor
    public void addProfessor(String firstName, String lastName, String department, Date joiningDate) {
        // Next Id
        long nextAvailableId = prof_Map.size() + 1;

        //Create a Professor Object
        String profId = String.valueOf(nextAvailableId);
        Professor prof = new Professor(profId, firstName , lastName,
                department, profId, joiningDate.toString());

        prof_Map.put(nextAvailableId, prof);
    }


    // Getting One Professor
    public Professor getProfessor(String profId) {

        //Simple HashKey Load
        Professor prof2 = prof_Map.get(Long.parseLong(profId));
        System.out.println("Item retrieved:");
        System.out.println(prof2.toString());

        return prof2;
    }

    // Deleting a professor
    public Professor deleteProfessor(Long profId) {
        Professor deletedProfDetails = prof_Map.get(profId);
        prof_Map.remove(profId);
        return deletedProfDetails;
    }

    // Updating Professor Info
    public Professor updateProfessorInformation(String profId, Professor prof) {
        Professor oldProfObject = prof_Map.get(Long.parseLong(profId));
//        profId = oldProfObject.getProfessorId();
//        prof.setProfessorId(profId);

        oldProfObject.setFirstName(prof.getFirstName());
        oldProfObject.setLastName(prof.getLastName());
        oldProfObject.setDepartment(prof.getDepartment());
        oldProfObject.setJoiningDate(prof.getJoiningDate());
        return oldProfObject;
    }

    // Get professors in a department
    public List<Professor> getProfessorsByDepartment(String department) {
        //Getting the list
        ArrayList<Professor> list = new ArrayList<>();
        for (Professor prof : prof_Map.values()) {
            if (prof.getDepartment().equals(department)) {
                list.add(prof);
            }
        }
        return list ;
    }

    // Get professors for a year with a size limit

}
