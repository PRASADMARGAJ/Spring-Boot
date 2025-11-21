package repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CRUD.model.Avenger;


public interface AvengerRepo extends JpaRepository<Avenger, Long> {
    
}
