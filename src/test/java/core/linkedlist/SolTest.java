package core.linkedlist;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.function.Predicate;

/**
 * @author sugamagarwal
 */

class User {
    String userName;

    User(String name) {
        userName = name;
    }

    public String getUsername() {
        return userName;
    }
}

class Validator implements Predicate<User> {


    /**
     * Evaluates this predicate on the given argument.
     *
     * @param user the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
    @Override
    public boolean test(User user) {
        return false;
    }
}

public class SolTest {

    @Test
    public void test() {

        Flux<String> flux1 = Flux.just("foo", "bar");
        Flux<User> flux  = Flux.just(new User("swhite"), new User("jpinkman"));
        StepVerifier.create(flux1).expectNext("foo", "bar").expectError(RuntimeException.class).verify();
       // StepVerifier.create(flux).expectNextMatches(user -> user.getUsername().equalsIgnoreCase("swhite")).assertNext(user -> Assertions.assertThat(user.getUsername()).isEqualToIgnoringCase("jpinkman")).verifyComplete();
        StepVerifier.create(flux).expectNextCount(10).verifyComplete();
//        Flux.merge(flux1, flux);Mono.fi



    }
}
