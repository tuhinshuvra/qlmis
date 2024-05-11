package org.bd.quantum.qlmis.publisher;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public String createPublisher(Publishers publishers1) {
        Publishers publishers = new Publishers();
        BeanUtils.copyProperties(publishers1, publishers);
        publisherRepository.save(publishers);
        return "Publisher Saved Successfully";
    }

    @Override
    public List<Publishers> showAllPublisher() {
        List<Publishers> publishersList= publisherRepository.findAll();
        List<Publishers> publishersArrayList = new ArrayList<>();

        for(Publishers publisherEntity : publishersList ){
            Publishers publishers = new Publishers();
            BeanUtils.copyProperties(publisherEntity, publishers);
            publishersArrayList.add(publishers);
        }
        return publishersArrayList;
    }

    @Override
    public Publishers showPublisherById(Long id) {
        return publisherRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deletePublisher(long id) {
        Publishers deletePublisher = publisherRepository.findById(id).orElse(null);
        if (deletePublisher != null){
            publisherRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String updatePublisher(long id, Publishers publishers) {
        Publishers updatePublisher = publisherRepository.findById(id).orElse(null);

        if(updatePublisher != null){
            updatePublisher.setName(publishers.getName());
            updatePublisher.setAddress(publishers.getAddress());

            publisherRepository.save(updatePublisher);
            return "Publisher Updated Successfully";
        } else {
            return "Publisher not found";
        }
    }
}