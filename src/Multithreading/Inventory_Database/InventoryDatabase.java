package Multithreading.Inventory_Database;

import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class InventoryDatabase {

    private TreeMap<Integer, Integer> priceToCountMap = new TreeMap<>();

    /*
         There is a significant performance improvement when using a ReentrantLock. It
         allows reader threads to run concurrently.

         Keep in mind that ReentrantReadWriteLock is not always better than a conventional lock.

     */

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    public int getNumberOfItemsInPriceRange(int lowerBound, int upperBound) {

        readLock.lock();

        try {

            Integer fromKey = priceToCountMap.ceilingKey(lowerBound);

            Integer toKey = priceToCountMap.floorKey(upperBound);

            if (fromKey == null || toKey == null) {
                return 0;
            }

            NavigableMap<Integer, Integer> rangeOfPrices = priceToCountMap.subMap(fromKey, true, toKey, true);

            return rangeOfPrices.values().stream().mapToInt(v -> v).sum();

        } finally {
            readLock.unlock();
        }
    }

    public void addItem(int price) {

        writeLock.lock();

        try {

            Integer numberOfItemsForPrice = priceToCountMap.get(price);

            if (numberOfItemsForPrice == null) {
                priceToCountMap.put(price, 1);
            } else {
                priceToCountMap.put(price, numberOfItemsForPrice + 1);
            }
        } finally {
            writeLock.unlock();
        }
    }

    public void removeItem(int price) {

        writeLock.lock();

        try {

            Integer numberOfItemsForPrice = priceToCountMap.get(price);

            if (numberOfItemsForPrice == null || numberOfItemsForPrice == 1) {
                priceToCountMap.remove(price);
            } else {
                priceToCountMap.put(price, numberOfItemsForPrice - 1);
            }
        } finally {
            writeLock.unlock();
        }
    }
}
