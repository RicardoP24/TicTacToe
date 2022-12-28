package TicTacToe.Jogo;

public class RandomVez implements IvezDe{

    @Override
    public boolean isVezDe() {
        return Math.random() < 0.5;
    }

}
