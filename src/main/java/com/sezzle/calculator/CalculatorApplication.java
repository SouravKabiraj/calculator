package com.sezzle.calculator;

import com.sezzle.calculator.client.Client;
import com.sezzle.calculator.client.ClientFactory;
import com.sezzle.calculator.handlers.CalculatorCommandHandler;
import com.sezzle.calculator.interaction.CommandFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
public class CalculatorApplication {

    public static void main(String[] args) {
        System.out.println("- WELCOME TO CALCULATOR APP -");
        System.out.println("type help to get `help`");
        CalculatorCommandHandler calculatorCommandHandler = new CalculatorCommandHandler();
        CommandFactory commandFactory = CommandFactory.init(calculatorCommandHandler);

        try {
            Client client = ClientFactory.buildClient(args, commandFactory);
            client.handleInput();
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry! the supplied input file was not found!");
        } catch (IOException ex) {
            System.out.println("Something went wrong. Please try again!");
        }
    }

}
