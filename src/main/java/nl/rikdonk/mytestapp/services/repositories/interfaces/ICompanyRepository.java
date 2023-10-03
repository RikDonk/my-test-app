package nl.rikdonk.mytestapp.services.repositories.interfaces;

import nl.rikdonk.mytestapp.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<Company, Integer> {
}
