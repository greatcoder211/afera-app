package pl.afera.aferaapp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.afera.aferaapp.model.Scandal;
public interface ScandalRepository extends CrudRepository<Scandal, Long> { }