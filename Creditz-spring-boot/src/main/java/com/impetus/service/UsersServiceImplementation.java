package com.impetus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.impetus.model.User;
import com.impetus.repository.UserRepository;

@Service
public class UsersServiceImplementation implements UsersService {
    private static final Logger LOG = LoggerFactory.getLogger(UsersServiceImplementation.class);
    @Autowired
    private UserRepository user;

    @Autowired
    private MailService notificationService;

    /** get Details of all Analyst.
     *
     * @param pageNo
     * @param pageSize
     * @return List of all Analyst */
    @Override
    public List<User> getAllAnalyst(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        String role = "Analyst";
        Page<User> pagedResult = user.findByRole(role, paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    /** delete Analyst details corresponding to particular userEmail.
     *
     * @param userEmail
     */
    @Override
    public void deleteAnalyst(String userEmail) {
        LOG.info("userEmail : {}", userEmail);
        user.delete(user.findByUserEmail(userEmail));
        LOG.info("Delete method runs successfully.");
    }

    /** check is there any User corresponding to particular email Address.
     *
     * @param userEmail
     * @return User */
    public User uniqueCheckEmail(String userEmail) {
        try {
            return user.findByUserEmail(userEmail);
        } catch (NullPointerException e) {
            User user1 = new User();
            user1.setUserEmail(null);
            user1.setPassword(null);
            return user1;
        }

    }

    /** generate One Time Password.
     *
     * @return String */
    @Override
    public String generateOtp() {
        String numbers = "0123456789";
        Random r = new Random();
        char otp[] = new char[6];
        for (int i = 0; i < otp.length; i++) {
            otp[i] = numbers.charAt(r.nextInt(numbers.length()));
        }
        return new String(otp);
    }

    /** send one time password to userEmail.
     *
     * @param userEmail
     *            the user
     * @return true, if successful */
    @Override
    public String sendOtp(String userEmail) {
        String otp = this.generateOtp();
        notificationService.sendOtpToUser(userEmail, otp);
        return otp;
    }

    /** update the user password of particular user.
     *
     * @param users
     *            the user
     * @return true, if successful */
    @Override
    public boolean updateUserPassword(User users) {
        boolean ans = false;
        try {
            user.updatePassword(users.getUserEmail(), hashPassword(users.getPassword()));
            ans = true;
            return ans;
        } catch (Exception e) {
            return ans;
        }
    }

    private String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    /** Find User on the basis of userEmail and password.
     *
     * @param userEmail
     * @param password
     * @return true, if successful */
    @Override
    public User findUserByEmailPassword(String userEmail, String password) {
        User dummyuser = new User();
        User user1 = user.findByUserEmail(userEmail);
        if (BCrypt.checkpw(password, user1.getPassword())) {
            return user1;
        }
        return dummyuser;
    }

}
