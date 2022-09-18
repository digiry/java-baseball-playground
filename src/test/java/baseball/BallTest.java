package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallTest {

    Ball computer;

    @BeforeEach
    void initialize() {
        computer = new Ball(1, 1);
    }

    BallStatus compareUserBalltoComputerBall(String userBall) {
        int userNumber = Integer.parseInt(String.valueOf(userBall.charAt(0)));
        int userPosition = Integer.parseInt(String.valueOf(userBall.charAt(1)));

        BallStatus status = computer.evaluate(new Ball(userNumber, userPosition));

        return status;
    }

    @ParameterizedTest
    @CsvSource(value = {"11:true", "12:false"}, delimiter = ':')
    void evaluateStrike(String userBall, boolean expected) {
        BallStatus userStatus = compareUserBalltoComputerBall(userBall);

        assertThat(userStatus.isStrike()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"12:true", "11:false"}, delimiter = ':')
    void evaluateBall(String userBall, boolean expected) {
        BallStatus userStatus = compareUserBalltoComputerBall(userBall);

        assertThat(userStatus.isBall()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"41:true", "11:false"}, delimiter = ':')
    void evaluateNothing(String userBall, boolean expected) {
        BallStatus userStatus = compareUserBalltoComputerBall(userBall);

        assertThat(userStatus.isNothing()).isEqualTo(expected);
    }
}
