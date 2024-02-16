package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Proposals;

import java.util.List;

public interface ProposalService {

     List<Proposals> findAll();

     Proposals findById(int theId);

     Proposals save(Proposals proposals);

     void deleteById(int theId);
}
