package fr.diginamic;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HexFormat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NoSuchAlgorithmException {
//        System.out.println(getHash("bonjour"));
//
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String bonjour = encoder.encode("bonjour");
//        String newbonjour = encoder.encode("bonjour");
//        System.out.println(encoder.encode("bonjour"));
//        System.out.println(encoder.encode("bonjour"));
//        System.out.println(encoder.matches("bonjour", bonjour));
//        System.out.println(encoder.matches("bonjour", newbonjour));
//        String[] prenoms = {"Pierre", "Paul", "Jacques"};
//        for (String prenom : prenoms) {
//            int nonce = 1;
//            String hexHash;
//
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//
//            while (true) {
//                String neoPrenom = prenom + nonce;
//                byte[] hash = md.digest(neoPrenom.getBytes(StandardCharsets.UTF_8));
//                hexHash = HexFormat.of().formatHex(hash);
//
//                if (hexHash.startsWith("0000000")) {
//                    System.out.println(prenom + " -> nonce=" + nonce + ", hash=" + hexHash);
//                    break;
//                }
//                nonce++;
//            }
//        }


        String message = "maSuperCleSecrete123maSuperCleSecrete123";
        SecretKey key =  Keys.hmacShaKeyFor(message.getBytes(StandardCharsets.UTF_8));

        String jwt = Jwts.builder()
                .setSubject(message)
                .claim("message", message)
                .setIssuedAt(new Date())
                .signWith(key)
                .compact();

        System.out.println(jwt);

        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(jwt)
                .getPayload();

        System.out.println("Message extrait : " + claims.get("message") + ".");
    }

    public static String getHash(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));
        String hex = HexFormat.of().formatHex(hash);
        return hex;
    }
}
