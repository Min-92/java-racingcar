package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.round.Round;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String NAME_POSITION_DELIMITER = " : ";
    private static final String CAR_POSITION = "-";
    private static final String NAME_DELIMITER = ", ";

    private static void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(CAR_POSITION);
        }
        System.out.println();
    }

    private static void printName(String name) {
        System.out.print(name);
    }

    public static void printGameResult(List<Round> rounds) {
        System.out.println("실행 결과");

        for (Round round : rounds) {
            printRoundResult(round);
        }

        printWinner(rounds.get(rounds.size() - 1).getCars().getWinnerCars());
    }

    private static void printWinner(List<Car> cars) {
        System.out.printf("%s이(가) 최종 우승 했습니다.%n", getNames(cars));
    }

    private static String getNames(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(NAME_DELIMITER));
    }

    private static void printRoundResult(Round round) {
        for (Car car : round.getCars().getCars()) {
            printCarResult(car);
        }
        System.out.println();
    }

    private static void printCarResult(Car car) {
        printName(car.getName());
        System.out.print(NAME_POSITION_DELIMITER);
        printPosition(car.getPosition());
    }
}
