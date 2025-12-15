package com.example.ms_clientes.repository.impl;

import com.example.ms_clientes.dto.ClientAgeStatsDTO;
import com.example.ms_clientes.model.Client;
import com.example.ms_clientes.repository.ClientRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositoryCustomImpl implements ClientRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public ClientAgeStatsDTO getAgeStatistics() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();

        Root<Client> client = cq.from(Client.class);

        Expression<Double> avgAge = cb.avg(client.get("age"));
        Expression<Double> stdDevAge = cb.function(
                "STDDEV",
                Double.class,
                client.get("age")
        );

        cq.multiselect(
                avgAge.alias("averageAge"),
                stdDevAge.alias("standardDeviation")
        );

        Tuple result = em.createQuery(cq).getSingleResult();

        return new ClientAgeStatsDTO(
                result.get("averageAge", Double.class),
                result.get("standardDeviation", Double.class)
        );
    }

}
