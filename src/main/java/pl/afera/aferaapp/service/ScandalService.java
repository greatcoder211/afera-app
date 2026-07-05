package pl.afera.aferaapp.service;

import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.afera.aferaapp.model.Politician;
import pl.afera.aferaapp.model.Scandal;
import pl.afera.aferaapp.repository.ScandalRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class ScandalService {
    private ScandalRepository scandalRepository;
    public ScandalService(ScandalRepository scandalRepository) {
        this.scandalRepository = scandalRepository;
    }
    @Transactional
    public void close(Long id) {
        Scandal scandal = scandalRepository.findById(id).orElseThrow();
        scandal.setEndDate(LocalDate.now());
        scandal.setConfirmedEmbezzledAmountOfMoney(scandal.getUnconfirmedEmbezzledAmountOfMoney().add(scandal.getConfirmedEmbezzledAmountOfMoney()));
        scandal.setUnconfirmedEmbezzledAmountOfMoney(BigDecimal.ZERO);
    }

    public static Specification<Scandal> beginAt(Integer year) {
        return (root, query, criteriaBuilder) ->{
            if(year == null){
                return null;
            }
            return criteriaBuilder.gt(criteriaBuilder.function("YEAR", Integer.class, root.get("startDate")), year);
        };
    }

    public static Specification<Scandal> containsNameSnippet(String snippet){
        return(root, query, criteriaBuilder) ->{
            if (snippet == null || snippet.isEmpty()){
                return null;
            }
            return criteriaBuilder.like(root.get("name"),  "%"+snippet+"%");
        };
    }
    public static Specification<Scandal> hasPoliticianLastName(String politicianLastName){
        return(root, query, criteriaBuilder) -> {
            if(politicianLastName == null || politicianLastName.isBlank()){
                return null;
            }
            Join<Scandal, Politician> politiciansJoin = root.join("associatedPoliticians");
            return criteriaBuilder.like(politiciansJoin.get("lastName"), politicianLastName);
        };
    }
}
