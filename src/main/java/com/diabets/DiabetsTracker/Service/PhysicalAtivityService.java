package com.diabets.DiabetsTracker.Service;
import com.diabets.DiabetsTracker.Repository.PhysicalActivityRepository;
import com.diabets.DiabetsTracker.model.PhysicalActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PhysicalAtivityService {

    @Autowired
    private PhysicalActivityRepository physicalActivityRepo;


    public List<PhysicalActivity> getPhysicalActivities() {
        return physicalActivityRepo.findAll();
    }

    public void addPhysicalActivity(PhysicalActivity physicalActivity) {
        physicalActivityRepo.save(physicalActivity);
    }

}
