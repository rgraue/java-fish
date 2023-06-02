package fishapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fishapp.models.Fish;
import fishapp.repos.FishRepo;

@Service
public class FishService implements IDataService<Fish>{

    private FishRepo fishRepo;

    @Autowired
    public FishService(FishRepo fishRepo){
        this.fishRepo = fishRepo;
    }
    
    public List<Fish> findAll() {
        return this.fishRepo.findAll();
    }

    public Fish save (Fish dto) {
        return this.fishRepo.save(dto);
    }

    public Optional<Fish> findByID(int id) {
        return fishRepo.findById(id);
    }

    public Fish findByName(String name) {
        return fishRepo.findBySpecies(name);
    }
}
