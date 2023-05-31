package fishapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fishapp.models.Fish;
import fishapp.repos.FishRepo;
import fishapp.utils.UUID;

@Service
public class FishService implements IFishService{

    @Autowired
    private FishRepo fishRepo;

    @Autowired
    public FishService(FishRepo fishRepo){
        this.fishRepo = fishRepo;
    }
    
    public List<Fish> getAllFish() {
        return this.fishRepo.findAll();
    }

    public Fish createFish (String name) {
        Fish dto = new Fish(name);
        dto.setId(UUID.getUUID());

        return this.fishRepo.save(dto);
    }
}
