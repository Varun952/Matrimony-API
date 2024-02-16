package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Proposals;
import com.appxbuild.matrimony.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProposalRestController {

    private ProposalService proposalService;

    @Autowired
    public ProposalRestController(ProposalService proposalService) {
        this.proposalService = proposalService;
    }


    @GetMapping("/proposals")
    public List<Proposals> findAll()   {
//        System.out.println("--------------------------------------------Error " + proposalService.findAll());
        return proposalService.findAll();
    }

    @GetMapping("/proposals/{proposalId}")
    public Proposals findById(@PathVariable int proposalId ) {

        Proposals proposals = proposalService.findById(proposalId);

        if (proposals == null) {
            throw new RuntimeException("Users id not found - " + proposalId);
        }

        return proposals;
    }

    @PostMapping("/proposals")
    public Proposals save(@RequestBody Proposals proposals) {

        proposals.setId(0);

        LocalDateTime localDateTime = LocalDateTime.now();
        proposals.setCreated(localDateTime);
        proposals.setModified(null);

        Proposals dbproposals = proposalService.save(proposals);

        return dbproposals;
    }

    @PutMapping("/proposals")
    public Proposals updateProposal(@RequestBody Proposals proposals) {

        LocalDateTime localDateTime = LocalDateTime.now();
        proposals.setModified(localDateTime);

        Proposals dbProposals = proposalService.save(proposals);

        return dbProposals;
    }

    @DeleteMapping("/proposals/{proposalId}")
    public String deleteProposal(@PathVariable int proposalId) {

        Proposals proposals = proposalService.findById(proposalId);

        // throw exception if null
        if(proposals == null)
        {
            throw new RuntimeException("Proposal is not found-"+ proposalId );
        }

        proposalService.deleteById(proposalId);

        return "Deleted Proposal id -" + proposalId;

    }

}
