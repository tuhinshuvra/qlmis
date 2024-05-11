package org.bd.quantum.qlmis.author;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorsServiceImpl implements AuthorsService {

    @Autowired
    private AuthorsRepository authorsRepository;


    @Override
    public String createAuthor(Authors createAuthor) {
        Authors authors= new Authors();
        BeanUtils.copyProperties(createAuthor,authors);
        authorsRepository.save(authors);

        return "Author Saved Successfully";
    }

    @Override
    public List<Authors> showAllAuthor() {
        List<Authors> authorsList= authorsRepository.findAll();
        List<Authors> authorsArrayList=  new ArrayList<>();

        for (Authors authorsEntity: authorsList){
            Authors authors= new Authors();
            BeanUtils.copyProperties(authorsEntity,authors);
            authorsArrayList.add(authors);
        }
        return authorsArrayList;
    }

    @Override
    public Authors showAuthorById(Long id) {
        return authorsRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteAuthor(long id) {
        Authors deleteAuthor=authorsRepository.findById(id).orElse(null);
        if (deleteAuthor !=null){
            authorsRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String updateAuthor(long id, Authors authors) {
        Authors updateAuthor=authorsRepository.findById(id).orElse(null);
        if(updateAuthor != null){
            updateAuthor.setName(authors.getName());
            updateAuthor.setAddress(authors.getAddress());

            authorsRepository.save(updateAuthor);
            return "Author Updated Successfully";
        }else {
            return "Author not found";
        }
    }
}
