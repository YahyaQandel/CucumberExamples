Feature: TicTacToe player winning
  Scenario: validate user wins if he plays in 3 horizontal adjacent cells same character
    Given I visit tictactoe game board site
    When player 'x' plays in cell 1
    And player 'o' plays in cell 4
    And player 'x' plays in cell 2
    And player 'o' plays in cell 7
    And player 'x' plays in cell 3
    Then game board should display winner is 'Winner: X'

