package br.com.systemmembercontrol.excepion.handler;

import br.com.systemmembercontrol.excepion.*;
import br.com.systemmembercontrol.utils.MensagemException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ValidationAdviceHandler {

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<Error> memberNotFound(MemberNotFoundException exception, HttpServletRequest request){
        Error error = new Error(LocalDateTime.now(),HttpStatus.NOT_FOUND.value(),MensagemException.MEMBER_NOT_FOUND,request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(EmailIsBeingUsedException.class)
    public ResponseEntity<Error> emailUsed(EmailIsBeingUsedException exception, HttpServletRequest request){
        Error error = new Error(LocalDateTime.now(),HttpStatus.BAD_REQUEST.value(),MensagemException.EMAIL_IS_BEIGN,request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(PersonIsNotMemberException.class)
    public ResponseEntity<Error> personNotMember(PersonIsNotMemberException exception, HttpServletRequest request){
        Error error = new Error(LocalDateTime.now(),HttpStatus.INTERNAL_SERVER_ERROR.value(),MensagemException.PERSON_NOT_A_MEMBER,request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Error> userNotFound(UserNotFoundException exception, HttpServletRequest request){
        Error error = new Error(LocalDateTime.now(),HttpStatus.NOT_FOUND.value(),MensagemException.USER_NOT_FOUND,request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @ExceptionHandler(CpfIsNullException.class)
    public ResponseEntity<Error> cpfIsNull(CpfIsNullException exception, HttpServletRequest request){
        Error error = new Error(LocalDateTime.now(),HttpStatus.BAD_REQUEST.value(),MensagemException.CPF_IS_NULL,request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(NotMemberRegisteredException.class)
    public ResponseEntity<Error> notMemberRegistered(NotMemberRegisteredException exception, HttpServletRequest request){
        Error error = new Error(LocalDateTime.now(),HttpStatus.BAD_REQUEST.value(),MensagemException.NO_REGISTERED_MEMBERS,request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(EmailIsNullException.class)
    public ResponseEntity<Error> emailIsNull(EmailIsNullException exception, HttpServletRequest request){
        Error error = new Error(LocalDateTime.now(),HttpStatus.BAD_REQUEST.value(),MensagemException.EMAIL_IS_NULL,request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
