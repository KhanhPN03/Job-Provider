/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author User
 */
public class hashByMD5 {

    public String hash(String password) {
        try {
            // Create an instance of MessageDigest with MD5 algorithm
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Convert the password string to bytes
            byte[] passwordBytes = password.getBytes();

            // Generate the hash value
            byte[] hashedBytes = md.digest(passwordBytes);

            // Convert the hashed bytes to hexadecimal representation
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            // Return the hashed password as a string
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null; // Return null if an exception occurred
    }

}
