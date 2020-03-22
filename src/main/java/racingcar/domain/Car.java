package racingcar.domain;

import lombok.Getter;
import racingcar.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Car {
    private String name;
    private int position;

    private Car(String name) {
        this.name = name;
    }

    public void move(int moveCount) {
        position += moveCount;
    }

    public void printPosition() {
        ResultView.printPosition(name, position);
    }

    public static List<Car> listOf(List<String> names) {
        return names.stream().map(it -> new Car(it))
                .collect(Collectors.toList());
    }
}