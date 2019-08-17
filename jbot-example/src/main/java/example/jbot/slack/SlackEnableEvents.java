package example.jbot.slack;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sample Slash Command Handler.
 *
 * @author ramswaroop
 * @version 1.0.0, 20/06/2016
 */
@RestController
@Profile("slack")
public class SlackEnableEvents {

    private static final Logger logger = LoggerFactory.getLogger(SlackEnableEvents.class);

    /**
     * The token you get while creating a new Slash Command. You
     * should paste the token in application.properties file.
     */
    @Value("${slashCommandToken}")
    private String slackToken;

    @RequestMapping(value = "/enable-events",
            		method = RequestMethod.POST,
        			consumes = { "application/json" },
        			produces = { "text/plain" })
    public @ResponseBody ResponseEntity<String> onReceiveChallenge(@RequestBody Map<String, String> map) {
    	logger.debug("Map from slack: {}", map);
        return ResponseEntity.ok(map.get("challenge"));
    }    
}
