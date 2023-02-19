#  Faigle's Mathematical Game Theory

## Mathematical Models of the Real World

### Mathematical modelling

- A game involves *players* that perform actions which make a given system go through a sequence of states.
- There exists no practically feasible test for the continuity or the differentiability of a function!

### Mathematical preliminaries

-  Mathematical game theory can be developed in Hiblert spaces.
-  In a game-theoretic context, a probability is often a *subjective* evaluation of the likelihood for an event to occur.

### Systems

- A *system* is a physical, economic, or other entity that is in a certain state at any given moment.
- In a general *decision system* $G$, we are given a finite set of agents each of which is assumed to make a decision of a given type.

### Games

- A game $Γ$ involves a set $N$ of agents (or players) and a system $S$ relative to which the game is played.
- The stage of $Γ$ at time $t$ is referred to as the associated sequence $γ_t = σ_0 σ_1 ··· σ_{t–1} σ_t$.
- The set of all possible stages after $t$ steps is denoted by $Γ_t$.
- A finite state sequences $γ$ in $S$ may not be feasible according to the rules of $Γ$ and, therefore, are not stages of $Γ$.
- When a game starts in a state $σ_0$ at time $t = 0$, it is often not clear in what stage $γ$ it will end (or whether it ends at all).
- A typical example of objectives is a family $U$ of utility functions.
- Utility functions which represent a gain are typically "concave".
- In a *profit* game the players are assumed to aim at maximizing their utility. In a *cost* game one tries to minimize one's utility to the best possible.
- A profit game with the utilities $u_i$ is formally equivalent to a cost game with utilities $c_i = –u_i$.
- A game with a set $n$ of players is a so-called $n$-person game.
- In the prisoner's dilemma, no matter what decisions are taken, at least one of the prisoners will feel that he has taken the wrong decision in the end.

## Combinatorial Games

### Alternating players

- The game stops if the player which would be next to move cannot find a feasible extension $γ_{t+1} ∈ Γ$ of the current stage $γ_t$.

### Recursiveness

- An alternating 2-person game $G$ as above has a recursive structure: A feasible move $G → G'$ of a player reduces the current game to a new alternating 2-player game with initial element $G'$.
- The players $L$ ("left") and $R$ ("right") relative to $G$ is denoted as $G = \{G_1^L,G_2^L,...|G_1^R,G_2^R,...\}$.

### Combinatorial games

- $G$ is a combinatorial game if $|G| < \infty$, i.e., if $G$ is guaranteed to stop after a finite number of moves (no matter which player starts).
- A *nim* game $G = G(N_1,...,N_k)$ has two alternating players and starts with the initial configuration of a collection of k finite and pairwise disjoint sets $N_1,...,N_k$. A move of a player is to select one of these sets, say $N_j$, and remove one or more of the elements from $N_j$. Because $G(N_1,...,N_k) < \infty$, nim is a combinatorial game.
- The class of all combinatorial games can be created systematically.
- There is exactly one combinatorial game $G$ with $|G| = 0$, namely the game $G = \{.|.\}$ in which no player has an option to move.
- The number of combinatorial games grows super-exponentially fast.

### Winning strategies

- If a player $i ∈ \{L, R\}$ cannot move, player $i$ has lost and the other player is declared the winner.
- The *misère* rule declares the player with no move to be the winner of the game.
- A *winning strategy* for player $i$ is a move (option) selection rule for $i$ that ensures $i$ to end as the winner.
- In any combinatorial game $G$, an overall winning strategy exists for either the first or the second player.
- For player $i$, suppose a quality estimate $υ(G^i) ∈ ℝ$ is assigned to all the options $G^i$, a $υ$-greedy strategy is a move to an option with a highest $υ$-value.
- A quality estimate $υ$ is not necessarily completely pre-defined by the game in absolute terms.
