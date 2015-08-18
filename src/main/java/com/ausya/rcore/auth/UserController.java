package com.ausya.rcore.auth;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.servlet.account.AccountResolver;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Example Spring MVC Controller that will throw exceptions for specific URLs to show exception handling.
 */
@Controller
@RequestMapping("/api/users")
public class UserController {

    @RequestMapping(value = "/current", method = GET)
    @ResponseBody
    public User getCurrentUser(HttpServletRequest request) {
        Account account = AccountResolver.INSTANCE.getAccount(request);
        return new User(account.getFullName(), account.getUsername());
    }

    @RequestMapping(value = "/{username}", method = GET)
    @ResponseBody
    public User getUser(@PathVariable String username) {
        //simulate Manager/DAO call:
        return findUser(username);
    }

    /**
     * Simulates a Manager or DAO lookup for a stored user account.
     *
     * @param username the username for the user to lookup.  Supports only 'jsmith' and 'djones' for testing.
     * @return the associated user
     * @throws UnknownResourceException if there is no user with the specified username.
     */
    private User findUser(String username) throws UnknownResourceException {
        if (!StringUtils.hasText(username)) {
            throw new IllegalArgumentException("Username is required.");
        }

        //simulate a successful lookup for 2 users:
        if ("jsmith".equals(username)) {
            return new User("Jane Smith", username);
        }
        if ("djones".equals(username)) {
            return new User("Don Jones", username);
        }

        //any other lookup throws an exception (not found):
        throw new UnknownResourceException("Unable to find user with username '" + username + "'");
    }


}
