package fishapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fishapp.models.Fish;

@Repository
public interface FishRepo extends JpaRepository<Fish, Integer> {
    Fish findBySpecies(String name);
    Fish findById(String userId);
}
