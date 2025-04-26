package com.citizens.citizensapi.service;
import com.citizens.citizensapi.primary.entity.Citizens;
import com.citizens.citizensapi.primary.entity.User;
import com.citizens.citizensapi.repo.primary.CitizensRepository;
import com.citizens.citizensapi.repo.primary.UserRepositoryPrimary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserCopyService {

    private final UserRepositoryPrimary primaryRepo;

    private final CitizensRepository citizensRepository;


    public UserCopyService(UserRepositoryPrimary primaryRepo, CitizensRepository citizensRepository) {
        this.primaryRepo = primaryRepo;
        //his.secondaryRepo = secondaryRepo;
        this.citizensRepository = citizensRepository;
    }

    public List<User> copyUsers() {
        List<User> users = primaryRepo.findAll();
      //  secondaryRepo.saveAll(users);
        return users;
    }

    public List<Citizens> getCitizens() {
        List<Citizens> users = citizensRepository.findAll();

        return users;
    }

    public Page<Citizens> getCitizens(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("id").ascending());
        return citizensRepository.findAll(pageable);
    }
}
