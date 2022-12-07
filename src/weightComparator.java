/**
 * Comparator that will sort animals by smallest to biggest based on weight. Used in PriorityQueueDemo.
 */
import java.util.Comparator;

public class weightComparator implements Comparator <Animal>
{
    @Override
    public int compare(Animal o1, Animal o2) {
        if (o1.getWeight() != o2.getWeight())
            return o1.getWeight() - o2.getWeight();
        else
            return o1.getSpecies().compareTo(o2.getSpecies());
    }
}