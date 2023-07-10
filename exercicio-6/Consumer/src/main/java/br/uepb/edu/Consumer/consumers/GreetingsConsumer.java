package br.uepb.edu.Consumer.consumers;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.uepb.edu.Consumer.dto.EmailDTO;
import br.uepb.edu.Consumer.services.EmailService;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GreetingsConsumer {

    private final EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void consumer(@Payload EmailDTO emailDTO) {
        emailService.sendEmail(emailDTO);
        System.out.println("Email Status: SENT");
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void consumer(Message message) {
        try {
            EmailDTO emailDTO = new ObjectMapper().readValue(message.getBody(), EmailDTO.class);
            emailService.sendEmail(emailDTO);
            System.out.println("Email Status: SENT");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}