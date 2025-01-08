package task4_1;

public class Main {
    public static void main(String[] args) {
        // Create auction items
 AuctionItem auctionItem1 = new AuctionItem("Vintage Car");
 AuctionItem auctionItem2 = new AuctionItem("Antique Vase");
        // Create bidders
        Bidder bidder1 = new Bidder("Alice");
        Bidder bidder2 = new Bidder("Bob");
        Bidder bidder3 = new Bidder("Charlie");
        // Subscribe bidders to auction items
        auctionItem1.addObserver(bidder1);
        auctionItem1.addObserver(bidder2);
        auctionItem2.addObserver(bidder2);
        auctionItem2.addObserver(bidder3);
        // Notify bidders about auction events
        auctionItem1.itemAvailable();
        auctionItem1.biddingStart();
        auctionItem1.biddingEnd();
        auctionItem2.itemAvailable();
        auctionItem2.biddingStart();
        auctionItem2.biddingEnd();
        // Unsubscribe a bidder and notify again
        auctionItem1.removeObserver(bidder2);
        System.out.println("\nAfter unsubscribing Bob from Vintage Car auction:\n");
        auctionItem1.itemAvailable();
    }
 }