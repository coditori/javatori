package ir.amnafzar.spl.config;

import org.springframework.boot.actuate.security.AbstractAuthorizationAuditListener;
import org.springframework.security.access.event.AbstractAuthorizationEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationAuditListener extends AbstractAuthorizationAuditListener {

    @Override
    public void onApplicationEvent(AbstractAuthorizationEvent abstractAuthorizationEvent) {
        System.out.println("Authorization granted to user: " + abstractAuthorizationEvent);
    }
}
