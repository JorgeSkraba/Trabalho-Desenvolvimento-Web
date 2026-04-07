package _Bimestre.demo.model.service;

import _Bimestre.demo.model.entity.Papel;
import _Bimestre.demo.model.repository.PapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PapelService {
    private PapelRepository papelRepository;

    @Autowired
    public PapelService(PapelRepository papelRepository){
        this.papelRepository = papelRepository;
    }

    public void save(Papel papel) {
        papelRepository.save(papel);
    }

}
