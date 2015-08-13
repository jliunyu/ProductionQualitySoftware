package edu.nyu.cs.pqs.simon;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class SimonModelTest {
	private SimonModel model;

	int userID0 = 0;
	int userID1 = 1;

	private SimonListener listener0;
	private SimonListener listener1;

	private List<Integer> registeredUserIdsTest = new LinkedList<Integer>();

	@Before
	public void setUp() {
		model = new SimonModel();

		listener0 = new SimonView(userID0, model);
		listener1 = new SimonView(userID1, model);

		registeredUserIdsTest.add(userID0);
		model.userRegistered(userID0, listener0);
		registeredUserIdsTest.add(userID1);
		model.userRegistered(userID1, listener1);

		model.sequence.add(SimonColor.RED);
		model.sequence.add(SimonColor.BLUE);
		model.sequence.add(SimonColor.GREEN);
		model.sequence.add(SimonColor.YELLOW);
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testuserRegisterandStartGame() {
		assertEquals(registeredUserIdsTest, model.registeredUserIds);

		model.startGame(userID0);
		model.startGame(userID1);

		assertEquals(1, model.sequence.size());
	}

	@Test
	public void testChooseColor() {
		model.currentGuessSequenceIndex = 1;
		assertEquals(4, model.sequence.size());

		model.chooseColor(userID0, SimonColor.BLUE);
		assertEquals(2, model.currentGuessSequenceIndex);
	}

	@Test
	public void testChooseColor_lastElement() {
		model.currentGuessSequenceIndex = 3;
		model.chooseColor(userID0, SimonColor.YELLOW);

		assertEquals(0, model.currentGuessSequenceIndex);
		assertEquals(5, model.sequence.size());
	}

	@Test
	public void testuserUnRegistered() {
		model.userUnRegistered(listener0);
		assertEquals(listener1, model.listeners.get(0));
	}
}