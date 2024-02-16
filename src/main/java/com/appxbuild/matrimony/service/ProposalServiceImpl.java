package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.ProposalDAO;
import com.appxbuild.matrimony.entity.Proposals;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProposalServiceImpl implements ProposalService {

    private ProposalDAO proposalDAO;

    // constructor


    public ProposalServiceImpl(ProposalDAO proposalDAO) {
        this.proposalDAO = proposalDAO;
    }

    @Override
    public List<Proposals> findAll() {
        return proposalDAO.findAll();
    }

    @Override
    public Proposals findById(int theId) {
        Optional<Proposals> result = proposalDAO.findById(theId);

        Proposals proposals = null;

        if(result.isPresent()) {
            proposals = result.get();
        }
        else {
             throw  new RuntimeException("Proposal id not found "+ theId);
        }

        return proposals;
    }

    @Override
    public Proposals save(Proposals proposals) {
        return proposalDAO.save(proposals);
    }

    @Override
    public void deleteById(int theId) {
         proposalDAO.deleteById(theId);
    }
}
