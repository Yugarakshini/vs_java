import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SnakeAndLadders extends JFrame {
    private static final int SIZE = 10;
    private static final int TILE_SIZE = 60;
    private static final Map<Integer, Integer> snakesAndLadders = new HashMap<>();
    private int playerPosition = 0;
    private int computerPosition = 0;
    private final JLabel playerLabel = new JLabel("Player Position: 0");
    private final JLabel computerLabel = new JLabel("Computer Position: 0");
    private final JButton rollButton = new JButton("Roll Dice");
    private final Timer animationTimer = new Timer(50, new AnimationListener());
    private int currentAnimationStep = 0;
    private int[] animationPath;
    private boolean isPlayerTurn = true;
    private final Random random = new Random();

    static {
        // Snakes
        snakesAndLadders.put(16, 6);
        snakesAndLadders.put(47, 26);
        snakesAndLadders.put(49, 11);
        snakesAndLadders.put(56, 53);
        snakesAndLadders.put(62, 19);
        snakesAndLadders.put(64, 60);
        snakesAndLadders.put(87, 24);
        snakesAndLadders.put(93, 73);
        snakesAndLadders.put(95, 75);
        snakesAndLadders.put(98, 78);
        // Ladders
        snakesAndLadders.put(1, 38);
        snakesAndLadders.put(4, 14);
        snakesAndLadders.put(9, 31);
        snakesAndLadders.put(21, 42);
        snakesAndLadders.put(28, 84);
        snakesAndLadders.put(36, 44);
        snakesAndLadders.put(51, 67);
        snakesAndLadders.put(71, 91);
        snakesAndLadders.put(80, 100);
    }

    public SnakeAndLadders() {
        setTitle("Snake and Ladders Game");
        setSize(SIZE * TILE_SIZE, SIZE * TILE_SIZE + 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel board = new JPanel();
        board.setLayout(new GridLayout(SIZE, SIZE));
        board.setPreferredSize(new Dimension(SIZE * TILE_SIZE, SIZE * TILE_SIZE));

        for (int i = 0; i < SIZE * SIZE; i++) {
            JPanel tile = new JPanel();
            tile.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            board.add(tile);
        }

        add(board, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.add(rollButton);
        controlPanel.add(playerLabel);
        controlPanel.add(computerLabel);

        add(controlPanel, BorderLayout.SOUTH);

        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isPlayerTurn) {
                    rollDice(true);
                } else {
                    rollDice(false);
                }
            }
        });

        animationTimer.setRepeats(false); // Ensure animation runs once per action
    }

    private void rollDice(boolean isPlayer) {
        int diceRoll = random.nextInt(6) + 1;

        if (isPlayer) {
            animateMove(playerPosition, playerPosition + diceRoll, true);
        } else {
            animateMove(computerPosition, computerPosition + diceRoll, false);
        }

        isPlayerTurn = !isPlayerTurn;
    }

    private void animateMove(int start, int end, boolean isPlayer) {
        currentAnimationStep = 0;
        animationPath = generateAnimationPath(start, end);

        // Start animation
        animationTimer.start();

        if (isPlayer) {
            playerPosition = end;
            if (snakesAndLadders.containsKey(playerPosition)) {
                playerPosition = snakesAndLadders.get(playerPosition);
            }
            playerLabel.setText("Player Position: " + playerPosition);
        } else {
            computerPosition = end;
            if (snakesAndLadders.containsKey(computerPosition)) {
                computerPosition = snakesAndLadders.get(computerPosition);
            }
            computerLabel.setText("Computer Position: " + computerPosition);
        }

        updateBoard();
    }

    private int[] generateAnimationPath(int start, int end) {
        int length = Math.abs(end - start) + 1;
        int[] path = new int[length];
        for (int i = 0; i < length; i++) {
            path[i] = start + (end > start ? i : -i);
        }
        return path;
    }

    private class AnimationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentAnimationStep < animationPath.length) {
                updateBoard();
                currentAnimationStep++;
                animationTimer.start();
            }
        }
    }

    private void updateBoard() {
        JPanel board = (JPanel) getContentPane().getComponent(0);
        board.removeAll();
        for (int i = 0; i < SIZE * SIZE; i++) {
            JPanel tile = new JPanel();
            tile.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            if (i == playerPosition - 1) {
                tile.setBackground(Color.RED);
            }
            if (i == computerPosition - 1) {
                tile.setBackground(Color.BLUE);
            }
            board.add(tile);
        }
        board.revalidate();
        board.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SnakeAndLadders().setVisible(true);
        });
    }
}
