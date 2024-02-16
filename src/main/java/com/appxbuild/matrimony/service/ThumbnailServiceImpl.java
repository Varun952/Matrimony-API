package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.ThumbnailsDAO;
import com.appxbuild.matrimony.entity.Thumbnails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThumbnailServiceImpl implements ThumbnailService{

    private ThumbnailsDAO thumbnailsDAO;

    // constructor
    public ThumbnailServiceImpl(ThumbnailsDAO thumbnailsDAO) {
        this.thumbnailsDAO = thumbnailsDAO;
    }

    @Override
    public List<Thumbnails> findAll() {
        return thumbnailsDAO.findAll();
    }

    @Override
    public Thumbnails findById(int theId) {
        Optional<Thumbnails> result = thumbnailsDAO.findById(theId);

        Thumbnails thumbnails = null;

        if(result.isPresent())
        {
            thumbnails = result.get();
        }
        else {
            // we didn't find the thumbnail
            throw new RuntimeException("Did not find thumbnail id -" + theId);
        }

        return thumbnails;
    }
}
