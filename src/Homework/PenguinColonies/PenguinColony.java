package Homework.PenguinColonies;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Iterator;

public class PenguinColony {

    private HashSet<Penguin> penguins;

    public PenguinColony(HashSet<Penguin> penguins) {
        this.penguins = penguins;
    }

    public HashSet<Penguin> getPenguins() {
        return penguins;
    }

    public void setPenguins(HashSet<Penguin> penguins) {
        this.penguins = penguins;
    }

    public void uniteColonies(PenguinColony otherColony) {
        HashSet<Penguin> hset = otherColony.getPenguins();
        Iterator<Penguin> it = hset.iterator();
        
        while(it.hasNext()){
            penguins.add(it.next());
        }
        HashSet<Penguin> p = new HashSet<Penguin>();
        otherColony.setPenguins(p);
    }

    public PenguinColony splitColony(Predicate<? super Penguin> pred) {
        HashSet<Penguin> temp = new HashSet<Penguin>();
        Iterator<Penguin> it = penguins.iterator();
        
        while(it.hasNext()){
            Penguin tmp = it.next();
            if (pred.test(tmp)){
                temp.add(tmp);
            }
        }
        Iterator<Penguin> its = temp.iterator();
        while (its.hasNext()){
            penguins.remove(its.next());
        }
        
        PenguinColony res = new PenguinColony(temp);
        return res;
    }

    public Penguin findFirstFriend(LinkedList<Penguin> penguinFriends) {
        Penguin res = null;
        boolean found = false;
        for (Penguin p : penguinFriends){
            Iterator it = penguins.iterator();
            while (it.hasNext()){
                if (p.equals(it.next())){
                    found = true;
                    res = p;
                    break;
                }
            }
            if (found) break;
        }
        return res;
    }

    public boolean canFeedPenguinsWithProperty(Predicate<? super Penguin> pred, Set<Fish> fishes) {
        Iterator<Penguin> it = penguins.iterator();
        while (it.hasNext()){
            Penguin peng = it.next();
            if (pred.test(peng))
                if (!fishes.contains(peng.getFavoriteFish())) return false;
        }
        
        return true;
    }

    public int computeSum(Function<? super Penguin, Integer> fun) {
        Iterator<Penguin> it = penguins.iterator();
        int res = 0;
        while (it.hasNext()){
            res += fun.apply(it.next());
        }
        return res;
    }

}
