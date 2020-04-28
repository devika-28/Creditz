//package com.impetus.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.impetus.model.User;
//import com.impetus.repository.UserRepository;
//
//public class ForgotPassword {
//	
//	@Autowired
//	UserRepository userRepository;
//
//    // Receive the address and send an email
//    @RequestMapping(value="/forgot-password", method=RequestMethod.POST)
//    public ModelAndView forgotUserPassword(ModelAndView modelAndView, User user) {
//        User existingUser = userRepository.findByUserEmail(user.getUserEmail());
//        if (existingUser != null) {
//            // Create token
//            ConfirmationToken confirmationToken = new ConfirmationToken(existingUser);
//
//            // Save it
//            confirmationTokenRepository.save(confirmationToken);
//
//            // Create the email
//            SimpleMailMessage mailMessage = new SimpleMailMessage();
//            mailMessage.setTo(existingUser.getEmailId());
//            mailMessage.setSubject("Complete Password Reset!");
//            mailMessage.setFrom("test-email@gmail.com");
//            mailMessage.setText("To complete the password reset process, please click here: "
//              + "http://localhost:8082/confirm-reset?token="+confirmationToken.getConfirmationToken());
//
//            // Send the email
//            emailSenderService.sendEmail(mailMessage);
//
//            modelAndView.addObject("message", "Request to reset password received. Check your inbox for the reset link.");
//            modelAndView.setViewName("successForgotPassword");
//
//        } else {
//            modelAndView.addObject("message", "This email address does not exist!");
//            modelAndView.setViewName("error");
//        }
//        return modelAndView;
//    }
//
//	
//	
//}
