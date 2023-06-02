package fishapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fishapp.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
    
}
