// SpaceHulkME  Copyright (C) 2008  Adam Gates
// This program comes with ABSOLUTELY NO WARRANTY; for license see COPYING.TXT.

package sh;

import java.util.Random;

import util.dice.Dice6;

public class CommandPoints {
	private int points_;

	CommandPoints() {
		points_ = 0;
	}

	CommandPoints(Random r) {
		reset(r);
	}

	public void reset(Random r) {
		points_ = Dice6.getDice().getDiceRoll();
	}

	public int get() {
		return points_;
	}

	boolean use(int cp) {
		if (points_ >= cp) {
			points_ -= cp;
			return true;
		} else
			return false;
	}
}
