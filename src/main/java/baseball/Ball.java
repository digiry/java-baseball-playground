package baseball;

public class Ball {
    private int number;
    private int position;

    Ball(int ballNumber, int ballPosition) {
        number = ballNumber;
        position = ballPosition;
    }

    public BallStatus evaluate(Ball userBall) {
        if (number == userBall.number && position == userBall.position) {
            return BallStatus.STRIKE;
        }

        if (number == userBall.number) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }
}
