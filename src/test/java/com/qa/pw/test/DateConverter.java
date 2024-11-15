package com.qa.pw.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateConverter {
    public static void main(String[] args) {
        // Input date string
        String inputDate = "Oct 18, 2024";

        // Define the formatter for the input format
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH);

        // Parse the input date string to LocalDate
        LocalDate date = LocalDate.parse(inputDate, inputFormatter);

        // Define the formatter for the desired output format
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        // Format the LocalDate to the desired output format
        String formattedDate = date.format(outputFormatter);

        // Print the result
        System.out.println("Formatted Date: " + formattedDate);
    }
}
