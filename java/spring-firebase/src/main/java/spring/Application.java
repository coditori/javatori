package spring;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;

//@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception{

        FileInputStream serviceAccount = new FileInputStream("test-454d0-firebase-adminsdk-ev4q3-03d646b77b.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://test-454d0.firebaseio.com/")
                .build();

        FirebaseApp.initializeApp(options);


//        SpringApplication.run(Application.class, args);
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//        String token = FirebaseAuth.getInstance().createCustomTokenAsync(UUID.randomUUID().toString()).get();
//        System.out.println("token " + token);
    }

}
