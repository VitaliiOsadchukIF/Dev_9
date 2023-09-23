package org.example.criteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.example.model.Apartment;
import org.example.model.Building;
import org.example.model.Owner;
import org.example.model.Resident;

import java.util.List;

public class CriteriaService {

    private CriteriaService() {
    }

    public static List<ResidentInfo> residentsWithCriteria(EntityManager entityManager) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        jakarta.persistence.criteria.CriteriaQuery<ResidentInfo> criteriaQuery = criteriaBuilder
                .createQuery(ResidentInfo.class);
        Root<Owner> ownerRoot = criteriaQuery.from(Owner.class);

        Join<Owner, Resident> residentJoin = ownerRoot.join("apartment");
        Join<Resident, Apartment> apartmentJoin = residentJoin.join("apartment");
        Join<Apartment, Building> buildingJoin = apartmentJoin.join("idBuildings");

        criteriaQuery.select(criteriaBuilder.construct(
                        ResidentInfo.class,
                        ownerRoot.get("id"),
                        ownerRoot.get("name"),
                        ownerRoot.get("email"),
                        buildingJoin.get("adress"),
                        apartmentJoin.get("number"),
                        apartmentJoin.get("area")
                )
        );

        Predicate carAccess = criteriaBuilder.equal(ownerRoot.get("parking"), false);

        Subquery<Long> subquery = criteriaQuery.subquery(Long.class);
        Root<Owner> subRoot = subquery.from(Owner.class);
        subquery.select(criteriaBuilder.count(subRoot));
        subquery.where(criteriaBuilder.equal(subRoot.get("apartment"), ownerRoot.get("apartment")));

        Predicate ownerCount = criteriaBuilder.lessThan(subquery, 2L);


        criteriaQuery.where(criteriaBuilder.and(carAccess, ownerCount));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
