package racingcar.app;

import racingcar.domain.car.Cars;
import racingcar.domain.car.strategy.CarActionStrategy;
import racingcar.domain.car.strategy.RandomMoveStrategy;
import racingcar.domain.round.Rounds;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    public void start() {
        Cars cars = generateCars(new RandomMoveStrategy());
        Rounds rounds = generateRounds(cars);

        OutputView.printGameResult(rounds.play());
    }

    private Cars generateCars(CarActionStrategy carActionStrategy) {
        return new Cars(InputView.inputCarCounts(), carActionStrategy);
    }

    private Rounds generateRounds(Cars cars) {
        return new Rounds(cars, InputView.inputRounds());
    }
}
