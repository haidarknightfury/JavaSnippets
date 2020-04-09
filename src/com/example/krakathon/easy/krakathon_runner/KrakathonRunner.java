package com.example.krakathon.easy.krakathon_runner;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class KrakathonRunner {

	private List<List<String>> game = new ArrayList<List<String>>();
	private List<List<String>> obstacleList = obstacleList();
	private Integer userPosition;
	private Integer userLineNumber;
	private Integer newLineAddition = 0;
	private final Integer OBSTACLE_LINE_NUMBER = 3;

	private int score = 0;
	private Random random = new Random();

	private enum MOVELIST {
		RIGHT, LEFT, STILL
	}
	
	private int getScore() {
		return score;
	}

	public List<List<String>> obstacleList() {
		List<String> obstacleList1 = Arrays.asList("*", ".", ".");
		List<String> obstacleList2 = Arrays.asList("*", "*", ".");
		List<String> obstacleList3 = Arrays.asList(".", "*", "*");

		List<String> obstacleList4 = Arrays.asList("=", ".", ".");
		List<String> obstacleList5 = Arrays.asList("=", "=", ".");
		List<String> obstacleList6 = Arrays.asList(".", "=", "=");

		List<List<String>> obstacleList = Arrays.asList(obstacleList1, obstacleList2, obstacleList3, obstacleList4,
				obstacleList5, obstacleList6);
		return obstacleList;

	}

	public List<String> noObstacleLine() {
		List<String> userLine = new ArrayList<String>();
		userLine.add(".");
		userLine.add(".");
		userLine.add(".");
		return userLine;
	}

	public Boolean hasObstacle(List<String> line) {
		String found = line.stream().filter(pos -> pos.equalsIgnoreCase("*") || pos.equalsIgnoreCase("=")).findFirst()
				.orElse(null);
		return found != null;
	}

	public Integer getUserPosition(List<String> userLine) {
		for (int i = 0; i < userLine.size(); i++) {
			if (userLine.get(i).equals("X")) {
				return i;
			}
		}
		return -1;
	}

	public Boolean canMove(List<String> userLine, List<String> nextLine) {
		int userPosition = getUserPosition(userLine);
		if (nextLine.get(userPosition).equals(".")) {
			return true;
		}
		return false;
	}

	public void initializeGame() {
		game.add(noObstacleLine());
		game.add(noObstacleLine());
		game.add(noObstacleLine());
		game.add(getInitialUserLine());
	}

	public List<String> getInitialUserLine() {
		List<String> userLine = new ArrayList<String>();
		userPosition = 1;
		userLine.add(".");
		userLine.add("X");
		userLine.add(".");
		return userLine;
	}

	public void printGame() {
		game.stream().forEach(line -> {
			System.out.print("|");
			line.forEach(System.out::print);
			System.out.print("|");
			System.out.println();
		});
	}

	public List<String> getCombinedLine(List<String> userLine, List<String> lineBeforeUser) {
		List<String> combined = new ArrayList<String>();
		for (int i = 0; i < userLine.size(); i++) {
			if (!userLine.get(i).equals("X")) {
				combined.add(lineBeforeUser.get(i));
			} else {
				combined.add(userLine.get(i));
			}
		}
		return combined;
	}

	public void gameMove() {
		newLineAddition += 1;
		List<String> userLine = game.get(game.size() - 1);
		List<String> lineBeforeUser = game.get(game.size() - 2);

		if (canMove(userLine, lineBeforeUser)) {
			game.set(game.size() - 2, getCombinedLine(userLine, lineBeforeUser));

			if (hasObstacle(lineBeforeUser)) {
				score += 5;
			} else {
				score += 1;
			}

			List<String> newLine = new ArrayList<String>();
			if (newLineAddition % OBSTACLE_LINE_NUMBER == 0) {
				newLine = obstacleList.get(random.nextInt(obstacleList.size()));
			} else {
				newLine = noObstacleLine();
			}

			game.add(0, newLine);
			game.remove(game.size() - 1);
		} else {
			throw new RuntimeException("CANNOT MOVE");
		}
	}

	public void movePlayer(MOVELIST moveList) {

		game.set(game.size() - 1, getPlayerLineWithPosition(getNewPlayerPosition(moveList)));
	}

	public Integer getNewPlayerPosition(MOVELIST moveList) {
		List<String> userLine = game.get(game.size() - 1);
		int userPosition = getUserPosition(userLine);
		if (moveList.equals(MOVELIST.LEFT)) {
			userPosition -= 1;
		} else if (moveList.equals(MOVELIST.RIGHT)) {
			userPosition += 1;
		}
		if (userPosition < 0) {
			return 0;
		}
		if (userPosition > userLine.size() - 1) {
			return userLine.size() - 1;
		}
		return userPosition;
	}

	public List<String> getPlayerLineWithPosition(Integer pos) {
		List<String> userLine = game.get(game.size() - 1);
		if (userLine.get(pos).equals(".") || userLine.get(pos).equals("X")) {
			userLine.set(getUserPosition(userLine), ".");
			userLine.set(pos, "X");
		} else {
			throw new RuntimeException("YOU HIT A TAGET");
		}
		return userLine;
	}

	public static void main(String[] args) throws InterruptedException {
		KrakathonRunner krakathonRunner = new KrakathonRunner();
		krakathonRunner.initializeGame();
		krakathonRunner.printGame();

		Scanner scanner = new Scanner(System.in);

		while(true) {
//			System.out.print("ENTER COMMAND :");
//			String INPUT = scanner.next();
//			MOVELIST command = MOVELIST.valueOf(INPUT.toUpperCase());
//			
			Thread.sleep(1000);

			krakathonRunner.movePlayer(MOVELIST.RIGHT);
			krakathonRunner.gameMove();
			krakathonRunner.printGame();
			System.out.println("SCORE IS : "+ krakathonRunner.getScore());
			
		}

	}



}
