package com.pi.courtierservice.repository;

import org.springframework.stereotype.Repository;

import com.pi.courtierservice.model.Courtier;
import java.util.ArrayList;
import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public class CourtierRepository {
    private List<Courtier> courtiers = new ArrayList<>();

    public Courtier addCourtier(Courtier courtier) {
        courtiers.add(courtier);
        return courtier;
    }

    public Courtier findById(Long id) {
        return courtiers.stream().filter(courtier -> courtier.getCin().equals(id)).findFirst().orElseThrow();
    }

    public List<Courtier> findAll() {
        return courtiers;
    }

    public Courtier editCourtier(Long id, Courtier courtier) {
        Courtier courtierToEdit = findById(id);
        courtierToEdit.edit(courtier);
        return courtierToEdit;
    }

    public Courtier editLocationCourtier(Long id, Courtier courtier) {
        Courtier courtierToEdit = findById(id);
        courtierToEdit.setLocation(courtier.getLocation());
        return courtierToEdit;
    }

    public Courtier deleteCourtier(Long id) {
        Courtier courtierToDelete = findById(id);
        courtiers.remove(courtierToDelete);
        return courtierToDelete;
    }
    
}
