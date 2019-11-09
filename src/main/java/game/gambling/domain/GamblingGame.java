package game.gambling.domain;

import game.core.domain.Game;
import game.core.domain.ResultEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Created by yusik on 2019/10/29.
 */
public class GamblingGame implements Game<GamblingResult> {

    private final String[] userNames;
    private final int numberOfRound;
    private GamblingResult result;

    public GamblingGame(String[] userNames, int numberOfRound) {
        this.userNames = userNames;
        this.numberOfRound = numberOfRound;
        result = new GamblingResult();
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfRound; i++) {
            String winner = createGamblers().stream()
                    .max(Comparator.comparingInt(Gambler::getCard))
                    .map(Gambler::getName).get();
            result.addWinner(winner);
        }
    }

    private List<Gambler> createGamblers() {
        List<Gambler> gamblers = new ArrayList<>();
        for (String userName : userNames) {
            gamblers.add(new Gambler(userName, getRandomCard()));
        }
        return gamblers;
    }

    @Override
    public ResultEntity<GamblingResult> getResultEntity() {
        return new ResultEntity<>(result);
    }

    private int getRandomCard() {
        return new Random().nextInt(100);
    }
}