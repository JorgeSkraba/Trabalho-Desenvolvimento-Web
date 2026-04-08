package _Bimestre.demo.model.service;

import _Bimestre.demo.model.entity.Papel;
import _Bimestre.demo.model.repository.PapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PapelService {

    @Autowired
    private PapelRepository papelRepository;

    @Autowired
    public Papel salvarPapel(Papel papel){
        return papelRepository.save(papel);
    }

    public List<Papel> getPapeis() {
        return papelRepository.findAll();
    }

}
