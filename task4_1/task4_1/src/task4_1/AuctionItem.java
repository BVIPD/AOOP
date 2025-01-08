package task4_1;

import java.util.ArrayList;
import java.util.List;
// Concrete subject that maintains a list of observers and notifies them
public class AuctionItem implements Subject {
   private List<Observer> observers = new ArrayList<>();
   private String itemName;
   public AuctionItem(String itemName) {
       this.itemName = itemName;
   }
   @Override
   public void addObserver(Observer observer) {
       observers.add(observer);
   }
   @Override
   public void removeObserver(Observer observer) {
       observers.remove(observer);
   }
   @Override
   public void notifyObservers(String event) {
       for (Observer observer : observers) {
           observer.update(event);
       }
   }
   public void itemAvailable() {
       notifyObservers(itemName + " is now available.");
   }
   public void biddingStart() {
       notifyObservers("Bidding for " + itemName + " has started.");
   }
   public void biddingEnd() {
       notifyObservers("Bidding for " + itemName + " has ended.");
   }
}