package org.example.Main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Write.WriteFile;
import org.example.criteria.CriteriaService;
import org.example.criteria.ResidentInfo;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("osbb10");
        EntityManager em = emf.createEntityManager();

        List<ResidentInfo> residents = CriteriaService.residentsWithCriteria(em);
        WriteFile.write(residents.toString());
        System.out.println(residents);

        em.close();
        emf.close();
    }
}
