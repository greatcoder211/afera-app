package pl.afera.aferaapp.repository.criteriaTraining;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import pl.afera.aferaapp.model.Party;
import pl.afera.aferaapp.model.Scandal;

import java.util.ArrayList;
import java.util.List;
public class AdvancedScandalSpecifications {

    public static Specification<Scandal> descriptionOrParty(String keyword, String partyName) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(keyword != null && !keyword.isBlank()){
                Predicate like = criteriaBuilder.like(root.get("description"), "%"+keyword+"%");
                predicates.add(like);
            }
            Join<Scandal, Party> partyJoin = root.join("associatedPoliticalParties");
            if(partyName != null && !partyName.isBlank()){
                Predicate party = criteriaBuilder.equal(partyJoin.get("name"), partyName.trim());
                predicates.add(party);
            }
            if(!predicates.isEmpty()){
                return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
            }
            else return null;
        };
    }
}