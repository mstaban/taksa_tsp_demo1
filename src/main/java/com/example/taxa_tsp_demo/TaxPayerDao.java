package com.example.taxa_tsp_demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;
@Repository
public class TaxPayerDao {
    EntityManager em;
    List<TaxPayer> findTaxPayersByTPCodeAndName(String tpCode, String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TaxPayer> cq = cb.createQuery(TaxPayer.class);
        Root<TaxPayer> taxPayer = cq.from(TaxPayer.class);
        Predicate tpCodePredicate = cb.equal(taxPayer.get("tpCode"), tpCode);
        Predicate namePredicate = cb.like(taxPayer.get("name"), "%" + name + "%");
        cq.where(tpCodePredicate, namePredicate);

        TypedQuery<TaxPayer> query = em.createQuery(cq);
        return query.getResultList();
    }
}
