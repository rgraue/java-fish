package fishapp.services;

import java.util.List;

import fishapp.models.Fish;

public interface IFishService {
    List<Fish> getAllFish();
    Fish createFish(String name);
}