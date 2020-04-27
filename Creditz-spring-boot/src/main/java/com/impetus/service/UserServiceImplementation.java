package com.impetus.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.dao.UserDAO;
import com.impetus.model.Organization;
import com.impetus.model.Person;
import com.impetus.model.User;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserDAO userdao;
    @Autowired
    private MailService notificationService;

    /** generate the six digit opt and return in string form.
     * 
     * @return OTP, in string form
     * @throws NoSuchAlgorithmException
     */
    public String generateOTP() throws NoSuchAlgorithmException {
        String numbers = "0123456789";
        String o = "";
        Random r = SecureRandom.getInstanceStrong();
        char otp[] = new char[6];
        for (int i = 0; i < otp.length; i++) {
            otp[i] = numbers.charAt(r.nextInt(numbers.length()));
            o = o + otp[i];
        }
        return o;
    }

    /** send OTP.
     * 
     * @param userEmail
     *            the userEmail
     * @return OTP, in string form
     * @throws NoSuchAlgorithmException
     */
    public String sendOTP(String userEmail) throws NoSuchAlgorithmException {

        String otp = this.generateOTP();
        notificationService.sendEmailToUser(userEmail, otp);
        return otp;
    }

    /** Save person.
     *
     * @param user
     *            the user
     * @return true, if successful */
    @Transactional
    @Override
    public boolean savePerson(Person user) {
        User user1 = user.getUser();
        user1.setPassword(hashPassword(user1.getPassword()));
        user.setUser(user1);
        return userdao.savePerson(user);
    }

    /** * @param user the user
     * 
     * @return true, if successful */
    @Override
    public boolean saveOrganization(Organization user) {
        User user1 = user.getUser();
        user1.setPassword(hashPassword(user1.getPassword()));
        user.setUser(user1);
        return userdao.saveOrganization(user);
    }

    /** encrypt the password.
     *
     * @param plainTextPassword
     * @return String */
    private String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    /** Save Analyst.
     *
     * @param user
     *            the user
     * @return true, if successful */
    @Override
    public boolean saveAnalyst(User user) {
        user.setPassword(hashPassword(user.getPassword()));
        return userdao.saveAnalyst(user);
    }

}
