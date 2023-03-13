package com.example.enoca;

import com.example.enoca.core.utilities.exceptions.BusinessException;
import com.example.enoca.core.utilities.exceptions.ProblemDetails;
import com.example.enoca.core.utilities.exceptions.ValidationProblemDetails;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;


/**
 * Uygulama başlangıç noktasıdır.
 * Spring Boot uygulamaları için gerekli olan Spring IoC container'ı oluşturur.
 * Spring IoC container'ı içerisindeki bean'leri oluşturur, yönetir ve bean'leri kullanarak uygulamayı çalıştırır..
 *
 * @SpringBootApplication annotation'ı Spring IoC container'ı oluşturmak için gerekli olan tüm konfigürasyonları yapar.
 * @RestControllerAdvice annotation'ı tüm controller'lar için ortak hata yakalama işlemlerini yapar.
 */
@SpringBootApplication
@RestControllerAdvice
@OpenAPIDefinition(info = @Info(title = "Enoca API", version = "1.0",
        description = "Enoca API Dokümantasyonu. " +
                "Product ve Category Entity'lerinin CRUD işlemlerini yapar. Aralarında one-to-many ilişki vardır." +
                "Database olarak postgresql kullanılmıştır." +
                "DataAccess katmanında JPA kullanılmıştır." +
                "Business katmanında ise ModelMapper kullanılmıştır." +
                "Validation işlemleri için javax.validation kullanılmıştır."))
public class EnocaApplication {

//    Logger logger = org.slf4j.LoggerFactory.getLogger(EnocaApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(EnocaApplication.class, args);
    }


    @Bean // Spring IoC container'ına bean olarak ekler.
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }


    /**
     * Tüm controller'lar için ortak hata yakalama işlemlerini yapar.
     * @param ex BusinessException tipindeki hata
     * @return ProblemDetails tipinde hata mesajı döner.
     */
    @ExceptionHandler
    @ResponseStatus(code = org.springframework.http.HttpStatus.BAD_REQUEST)
    public ProblemDetails handleException(BusinessException ex) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(ex.getMessage());
//        logger.error(ex.getMessage());
        return problemDetails;
    }

    /**
     * Tüm controller'lar için ortak validasyon hata yakalama işlemlerini yapar.
     *
     * @param ex MethodArgumentNotValidException tipindeki hata
     * @return ValidationProblemDetails tipinde hata mesajı döner.
     */
    @ExceptionHandler
    @ResponseStatus(code = org.springframework.http.HttpStatus.BAD_REQUEST)
    public ProblemDetails handleValidationException(MethodArgumentNotValidException ex) {
        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setMessage("VALIDATITON ERROR");
        validationProblemDetails.setValidationErrors(new HashMap<String, String>());

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
//            logger.error(fieldError.getDefaultMessage());
        }

        return validationProblemDetails;
    }


}
