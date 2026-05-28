package com.pluralsight.receipt;
import com.pluralsight.Order.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {

    public void saveReceipt(Order order) {
        try {
            LocalDateTime now = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

            String fileName = "receipts-" + now.format(formatter) + ".txt";

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

            bufferedWriter.write("======== The Daily Slice Receipt ======\n");
            bufferedWriter.write(order.displayOrder() + "\n");
            bufferedWriter.write(String.format("Total: $%.2f", order.getTotal()));

            bufferedWriter.close();

        } catch (Exception ex) {
            System.out.println("Error saving.");
        }
    }
}