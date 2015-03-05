package lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
	
	private Deck deck = new Deck();
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	protected Hand() {
		for(int i = 0; i < 5; i++) {
			hand.add(deck.draw());
			this.hand = hand;
		}
	}
	public ArrayList<Card> sort(ArrayList<Card> myHand) {
		int i = 0;
		while(i < 4) {
			Card c1 = myHand.get(i);
			Card c2 = myHand.get(i+1);
			eCardValue v1 = c1.getValue();
			eCardValue v2 = c2.getValue();
			Card temp = c1;
			if(v1.getCardValue() > v2.getCardValue()) {
				c1 = c2;
				c2 = temp;
			}
			i++;
		}
		return myHand;
	}
	public int isStraight(ArrayList<Card> myHand) {
		ArrayList<Card> hand = sort(myHand);
		int i = 0;
		while(i < 4) {
			Card c1 = hand.get(i);
			Card c2 = hand.get(i+1);
			if(c1.getValue() == c2.getValue()) {
				i++;
			}
			else {
				return 0;
			}
		}
		return 9;
	}
	
	//checks the hand to see if it is a Royal Flush
	public int isRoyalFlush (ArrayList<Card> myHand) {
		ArrayList<Card> hand = sort(myHand);
		int i = 0;
		Card c0 = hand.get(0);
		eCardValue jack = eCardValue.values()[9];
		if(c0.getValue() == jack) {
			while(i < 4) {
				Card c1 = hand.get(i);
				Card c2 = hand.get(i+1);
				if(c1.getSuit() == c2.getSuit()) 
					continue;
			}	
		}
		else 
			return 0;
		
		return 10;
	}
	
	
	public int isFlush(ArrayList<Card> myHand) {
		ArrayList<Card> hand = sort(myHand);
		int i = 0;
		while(i < 4) {
			Card c1 = hand.get(i);
			Card c2 = hand.get(i+1);
			if(c1.getSuit() == c2.getSuit()) {
				i++;
			}
			else {
				return 0;
			}
		}
		return 6;
	}
	
	public String judgeHand(ArrayList<Card> myHand) {
		if(isStraight(myHand) == 9) {
			String result = new String("It is a straight");
			return result;
		}
		else if(isFlush(myHand) == 6) {
			String result = new String("It is a flush");
			return result;
		}
		else {
			String result = new String("It is not a straight or a flush");
			return result;
		}
	}
	
	public int isFourofaKind (ArrayList<Card> myHand) {
		ArrayList<Card> hand = sort(myHand);
		int i = 0;
		Card c1 = hand.get(0);
		Card c2 = hand.get(1);
		Card c4 = hand.get(3);
		Card c5 = hand.get(4);
		
		if((c1.getValue() == c4.getValue()) || (c2.getValue() == c5.getValue()) ){
			System.out.println("4 of a kind!");
			}	
		
		else 
			return 0;
		
		return 8;
	} 
	
	public int isThreeofaKind (ArrayList<Card> myHand) {
		ArrayList<Card> hand = sort(myHand);
		int i = 0;
		Card c1 = hand.get(0);
		Card c2 = hand.get(1);
		Card c3 = hand.get(2);
		Card c4 = hand.get(3);
		Card c5 = hand.get(4);
		
		if((c1.getValue() == c3.getValue()) || (c2.getValue() == c4.getValue()) || (c3.getValue() == c5.getValue())){
			System.out.println("3 of a kind!");
			}	
		
		else 
			return 0;
		
		return 4;
	} 
	
	

}
