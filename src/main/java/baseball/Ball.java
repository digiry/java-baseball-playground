package baseball;

import java.util.Objects;

public class Ball {
    private int number;
    private int position;

    Ball(int ballNumber, int ballPosition) {
        number = ballNumber;
        position = ballPosition;
    }

    public BallStatus evaluate(Ball userBall) {
        if (this.equals(userBall)) {
            return BallStatus.STRIKE;
        }

        if (this.matchNumber(userBall)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    public boolean matchNumber(Ball userBall) {
        if (number == userBall.number) {
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return number == ball.number && position == ball.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
