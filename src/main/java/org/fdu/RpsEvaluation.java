package org.fdu;

/**
 * Evaluation class - static, stateless - evaluates player and npc throw according to the game logic
 * Returns the result of the game play (e.g. player won, npc won, tie)
 */
public class RpsEvaluation {

    /**
     * Enum describing game outcomes
     */
    public enum GameOutcomeEnum {
        PLAYER_WINS,
        NPC_WINS,
        TIE
    }

    /**
     * Evaluates winner based on player and npc throws (player wins, npc wins, tie)
     * @param playerThrow - enum of Players choice - rock, paper or scissors
     * @param npcThrow - enum of NPC's choice - rock, paper or scissors
     * @return - returns enum with the game outcome (Player wins, npc wins or it's a tie
     */
    public static GameOutcomeEnum evaluateThrows(Throw.RpsEnum playerThrow, Throw.RpsEnum npcThrow) {
        if ((playerThrow == Throw.RpsEnum.INVALID) || (npcThrow == Throw.RpsEnum.INVALID))
            return null;
        if (playerThrow == npcThrow) {
            return GameOutcomeEnum.TIE;
        }
        switch (playerThrow) {
            case ROCK:
                switch (npcThrow) {
                    case SCISSORS: return GameOutcomeEnum.PLAYER_WINS;
                    case PAPER: return GameOutcomeEnum.NPC_WINS;
                }
            case SCISSORS:
                switch (npcThrow) {
                    case ROCK: return GameOutcomeEnum.NPC_WINS;
                    case PAPER: return GameOutcomeEnum.PLAYER_WINS;
                }
            case PAPER:
                switch (npcThrow) {
                    case ROCK: return GameOutcomeEnum.PLAYER_WINS;
                    case SCISSORS: return GameOutcomeEnum.NPC_WINS;
                }
        }
        return null;
    }
}  // end RpsEvaluation class
