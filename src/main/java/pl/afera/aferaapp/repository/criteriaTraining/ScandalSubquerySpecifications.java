package pl.afera.aferaapp.repository.criteriaTraining;

import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import lombok.NonNull;
import org.springframework.data.jpa.domain.Specification;
import pl.afera.aferaapp.model.Scandal;

public class ScandalSubquerySpecifications {
    public static Specification<@NonNull Scandal> aboveAverageConfirmedAmount() {
        return (root, query, criteriaBuilder) -> {
            Subquery<Double> subquery = query.subquery(Double.class);
            Root<Scandal> subRoot = subquery.from(Scandal.class);
            subquery.select(criteriaBuilder.avg(subRoot.get("confirmedEmbezzledAmountOfMoney")));
            return criteriaBuilder.gt(root.get("confirmedEmbezzledAmountOfMoney"), subquery);
        };
    }
}
