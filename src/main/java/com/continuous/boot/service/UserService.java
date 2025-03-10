package com.continuous.boot.service;

import com.continuous.boot.dao.UserRepository;
import com.continuous.boot.models.Users;
import com.continuous.boot.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Async
    public CompletableFuture<List<Users>> saveUsers(MultipartFile file) throws Exception {
        long start = System.currentTimeMillis();
        List<Users> users = parseCSVFile(file);
        logger.info("saving list of users of size {}", users.size(), "" + Thread.currentThread().getName());
        System.out.println("threadName " + Thread.currentThread().getName());
        users = repository.saveAll(users);
        long end = System.currentTimeMillis();
        logger.info("Total time {}", (end - start));
        return CompletableFuture.completedFuture(users);
    }

    @Async
    public CompletableFuture<List<Users>> findAllUsers() {
        logger.info("get list of user by " + Thread.currentThread().getName());
        List<Users> users = repository.findAll();
        return CompletableFuture.completedFuture(users);
    }


    private List<Users> parseCSVFile(final MultipartFile file) throws Exception {
        final List<Users> users = new ArrayList<>();
        try {
            try (final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    final String[] data = line.split(",");
                    if (line.contains("email") || line.contains("name")) {
                        continue;
                    }
                    final Users user = new Users();
                    user.setName(data[0]);
                    user.setEmail(data[1]);
                    users.add(user);
                }
                return users;
            }
        } catch (final IOException e) {
            logger.error("Failed to parse CSV file {}", e);
            throw new Exception("Failed to parse CSV file {}", e);
        }
    }

    public UtilsResponse staticMockTest(Users users) {

        String response = UserUtils.isSuccess(users.getEmail());
        System.out.println("response" + response);

        return new UtilsResponse(response, 200);
    }
}
